<?php

namespace App\Tests\Controller\Api;

use App\Entity\BlogPost;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Test\WebTestCase;

class BlogPostControllerTest extends WebTestCase
{
    private $client;
    private EntityManagerInterface $entityManager;

    protected function setUp(): void
    {
        $this->client = static::createClient();
        $this->entityManager = static::getContainer()->get(EntityManagerInterface::class);
    }

    protected function tearDown(): void
    {
        $this->entityManager->createQuery('DELETE FROM App\Entity\BlogPost')->execute();
        parent::tearDown();
    }

    public function testListBlogPosts(): void
    {
        $post = new BlogPost();
        $post->setTitle('Test Post');
        $post->setContent('Test Content');
        $post->setAuthor('Test Author');
        $this->entityManager->persist($post);
        $this->entityManager->flush();

        $this->client->request('GET', '/api/blog-posts');
        $this->assertResponseIsSuccessful();
        $this->assertResponseHeaderSame('content-type', 'application/json');

        $response = json_decode($this->client->getResponse()->getContent(), true);
        $this->assertIsArray($response);
        $this->assertCount(1, $response);
        $this->assertEquals('Test Post', $response[0]['title']);
    }

    public function testShowBlogPost(): void
    {
        $post = new BlogPost();
        $post->setTitle('Test Post');
        $post->setContent('Test Content');
        $this->entityManager->persist($post);
        $this->entityManager->flush();
        $id = $post->getId();

        $this->client->request('GET', "/api/blog-posts/{$id}");
        $this->assertResponseIsSuccessful();

        $response = json_decode($this->client->getResponse()->getContent(), true);
        $this->assertEquals('Test Post', $response['title']);
        $this->assertEquals('Test Content', $response['content']);
    }

    public function testShowNonExistentBlogPost(): void
    {
        $this->client->request('GET', '/api/blog-posts/99999');
        $this->assertResponseStatusCodeSame(404);
    }

    public function testCreateBlogPost(): void
    {
        $data = [
            'title' => 'New Post',
            'content' => 'New Content',
            'author' => 'New Author',
        ];

        $this->client->request(
            'POST',
            '/api/blog-posts',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            json_encode($data)
        );

        $this->assertResponseStatusCodeSame(201);
        $response = json_decode($this->client->getResponse()->getContent(), true);
        $this->assertEquals('New Post', $response['title']);
        $this->assertEquals('New Content', $response['content']);
        $this->assertEquals('New Author', $response['author']);
    }

    public function testCreateBlogPostWithValidationErrors(): void
    {
        $data = [
            'title' => 'AB',
            'content' => '',
        ];

        $this->client->request(
            'POST',
            '/api/blog-posts',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            json_encode($data)
        );

        $this->assertResponseStatusCodeSame(400);
        $response = json_decode($this->client->getResponse()->getContent(), true);
        $this->assertArrayHasKey('errors', $response);
    }

    public function testUpdateBlogPost(): void
    {
        $post = new BlogPost();
        $post->setTitle('Original Title');
        $post->setContent('Original Content');
        $this->entityManager->persist($post);
        $this->entityManager->flush();
        $id = $post->getId();

        $data = [
            'title' => 'Updated Title',
            'content' => 'Updated Content',
        ];

        $this->client->request(
            'PUT',
            "/api/blog-posts/{$id}",
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            json_encode($data)
        );

        $this->assertResponseIsSuccessful();
        $response = json_decode($this->client->getResponse()->getContent(), true);
        $this->assertEquals('Updated Title', $response['title']);
        $this->assertEquals('Updated Content', $response['content']);
    }

    public function testUpdateNonExistentBlogPost(): void
    {
        $data = ['title' => 'Updated Title', 'content' => 'Updated Content'];
        $this->client->request(
            'PUT',
            '/api/blog-posts/99999',
            [],
            [],
            ['CONTENT_TYPE' => 'application/json'],
            json_encode($data)
        );

        $this->assertResponseStatusCodeSame(404);
    }

    public function testDeleteBlogPost(): void
    {
        $post = new BlogPost();
        $post->setTitle('To Delete');
        $post->setContent('Content');
        $this->entityManager->persist($post);
        $this->entityManager->flush();
        $id = $post->getId();

        $this->client->request('DELETE', "/api/blog-posts/{$id}");
        $this->assertResponseStatusCodeSame(204);

        $this->entityManager->clear();
        $deletedPost = $this->entityManager->find(BlogPost::class, $id);
        $this->assertNull($deletedPost);
    }

    public function testDeleteNonExistentBlogPost(): void
    {
        $this->client->request('DELETE', '/api/blog-posts/99999');
        $this->assertResponseStatusCodeSame(404);
    }
}

