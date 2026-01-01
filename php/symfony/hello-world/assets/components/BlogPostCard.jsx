import React from 'react';

function BlogPostCard({ post, onEdit, onDelete }) {
  const formatDate = (dateString) => {
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit',
    });
  };

  const truncateContent = (content, maxLength = 150) => {
    if (content.length <= maxLength) return content;
    return content.substring(0, maxLength) + '...';
  };

  return (
    <div className="bg-white rounded-lg shadow-md hover:shadow-lg transition-shadow duration-200 overflow-hidden">
      <div className="p-6">
        <h2 className="text-xl font-bold text-gray-900 mb-2 line-clamp-2">
          {post.title}
        </h2>
        
        {post.author && (
          <p className="text-sm text-gray-600 mb-2">
            By <span className="font-semibold">{post.author}</span>
          </p>
        )}

        <p className="text-gray-700 mb-4 line-clamp-3">
          {truncateContent(post.content)}
        </p>

        <div className="text-xs text-gray-500 mb-4">
          <p>Created: {formatDate(post.createdAt)}</p>
          {post.updatedAt !== post.createdAt && (
            <p>Updated: {formatDate(post.updatedAt)}</p>
          )}
        </div>

        <div className="flex gap-2">
          <button
            onClick={() => onEdit(post)}
            className="flex-1 bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded transition duration-200"
          >
            Edit
          </button>
          <button
            onClick={() => onDelete(post.id)}
            className="flex-1 bg-red-600 hover:bg-red-700 text-white font-semibold py-2 px-4 rounded transition duration-200"
          >
            Delete
          </button>
        </div>
      </div>
    </div>
  );
}

export default BlogPostCard;

