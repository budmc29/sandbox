<?php

namespace App\Controller\Api;

use App\Entity\BlogPost;
use App\Repository\BlogPostRepository;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\JsonResponse;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Attribute\Route;
use Symfony\Component\Serializer\SerializerInterface;
use Symfony\Component\Validator\Validator\ValidatorInterface;

#[Route('/api/blog-posts', name: 'api_blog_post_')]
class BlogPostController extends AbstractController
{
    public function __construct(
        private BlogPostRepository $repository,
        private EntityManagerInterface $entityManager,
        private SerializerInterface $serializer,
        private ValidatorInterface $validator
    ) {
    }

    #[Route('', name: 'list', methods: ['GET'])]
    public function list(): JsonResponse
    {
        $posts = $this->repository->findAll();
        $data = $this->serializer->serialize($posts, 'json', [
            'groups' => ['blog_post:read'],
            'datetime_format' => 'Y-m-d H:i:s',
        ]);

        return JsonResponse::fromJsonString($data, Response::HTTP_OK);
    }

    #[Route('/{id}', name: 'show', methods: ['GET'])]
    public function show(int $id): JsonResponse
    {
        $post = $this->repository->find($id);

        if (!$post) {
            return new JsonResponse(['error' => 'Blog post not found'], Response::HTTP_NOT_FOUND);
        }

        $data = $this->serializer->serialize($post, 'json', [
            'groups' => ['blog_post:read'],
            'datetime_format' => 'Y-m-d H:i:s',
        ]);

        return JsonResponse::fromJsonString($data, Response::HTTP_OK);
    }

    #[Route('', name: 'create', methods: ['POST'])]
    public function create(Request $request): JsonResponse
    {
        $data = json_decode($request->getContent(), true);

        $post = new BlogPost();
        $post->setTitle($data['title'] ?? '');
        $post->setContent($data['content'] ?? '');
        $post->setAuthor($data['author'] ?? null);

        $errors = $this->validator->validate($post);
        if (count($errors) > 0) {
            $errorMessages = [];
            foreach ($errors as $error) {
                $errorMessages[$error->getPropertyPath()] = $error->getMessage();
            }
            return new JsonResponse(['errors' => $errorMessages], Response::HTTP_BAD_REQUEST);
        }

        $this->entityManager->persist($post);
        $this->entityManager->flush();

        $responseData = $this->serializer->serialize($post, 'json', [
            'groups' => ['blog_post:read'],
            'datetime_format' => 'Y-m-d H:i:s',
        ]);

        return JsonResponse::fromJsonString($responseData, Response::HTTP_CREATED);
    }

    #[Route('/{id}', name: 'update', methods: ['PUT'])]
    public function update(int $id, Request $request): JsonResponse
    {
        $post = $this->repository->find($id);

        if (!$post) {
            return new JsonResponse(['error' => 'Blog post not found'], Response::HTTP_NOT_FOUND);
        }

        $data = json_decode($request->getContent(), true);

        if (isset($data['title'])) {
            $post->setTitle($data['title']);
        }
        if (isset($data['content'])) {
            $post->setContent($data['content']);
        }
        if (isset($data['author'])) {
            $post->setAuthor($data['author']);
        }

        $errors = $this->validator->validate($post);
        if (count($errors) > 0) {
            $errorMessages = [];
            foreach ($errors as $error) {
                $errorMessages[$error->getPropertyPath()] = $error->getMessage();
            }
            return new JsonResponse(['errors' => $errorMessages], Response::HTTP_BAD_REQUEST);
        }

        $this->entityManager->flush();

        $responseData = $this->serializer->serialize($post, 'json', [
            'groups' => ['blog_post:read'],
            'datetime_format' => 'Y-m-d H:i:s',
        ]);

        return JsonResponse::fromJsonString($responseData, Response::HTTP_OK);
    }

    #[Route('/{id}', name: 'delete', methods: ['DELETE'])]
    public function delete(int $id): JsonResponse
    {
        $post = $this->repository->find($id);

        if (!$post) {
            return new JsonResponse(['error' => 'Blog post not found'], Response::HTTP_NOT_FOUND);
        }

        $this->entityManager->remove($post);
        $this->entityManager->flush();

        return new JsonResponse(null, Response::HTTP_NO_CONTENT);
    }
}

