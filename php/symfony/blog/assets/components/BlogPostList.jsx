import React from 'react';
import BlogPostCard from './BlogPostCard';

function BlogPostList({ posts, onEdit, onDelete }) {
  if (posts.length === 0) {
    return (
      <div className="text-center py-12 bg-white rounded-lg shadow-sm">
        <p className="text-gray-500 text-lg">No blog posts yet. Create your first post!</p>
      </div>
    );
  }

  return (
    <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">
      {posts.map((post) => (
        <BlogPostCard
          key={post.id}
          post={post}
          onEdit={onEdit}
          onDelete={onDelete}
        />
      ))}
    </div>
  );
}

export default BlogPostList;

