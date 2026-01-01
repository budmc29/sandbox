import React, { useState, useEffect } from 'react';
import BlogPostList from './components/BlogPostList';
import BlogPostForm from './components/BlogPostForm';

function App() {
  const [posts, setPosts] = useState([]);
  const [editingPost, setEditingPost] = useState(null);
  const [showForm, setShowForm] = useState(false);
  const [loading, setLoading] = useState(true);

  const API_URL = '/api/blog-posts';

  useEffect(() => {
    fetchPosts();
  }, []);

  const fetchPosts = async () => {
    try {
      setLoading(true);
      const response = await fetch(API_URL);
      if (response.ok) {
        const data = await response.json();
        setPosts(data);
      }
    } catch (error) {
      console.error('Error fetching posts:', error);
    } finally {
      setLoading(false);
    }
  };

  const handleCreate = async (postData) => {
    try {
      const response = await fetch(API_URL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(postData),
      });

      if (response.ok) {
        await fetchPosts();
        setShowForm(false);
      } else {
        const error = await response.json();
        alert('Error creating post: ' + JSON.stringify(error));
      }
    } catch (error) {
      console.error('Error creating post:', error);
      alert('Error creating post');
    }
  };

  const handleUpdate = async (id, postData) => {
    try {
      const response = await fetch(`${API_URL}/${id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(postData),
      });

      if (response.ok) {
        await fetchPosts();
        setEditingPost(null);
        setShowForm(false);
      } else {
        const error = await response.json();
        alert('Error updating post: ' + JSON.stringify(error));
      }
    } catch (error) {
      console.error('Error updating post:', error);
      alert('Error updating post');
    }
  };

  const handleDelete = async (id) => {
    if (!window.confirm('Are you sure you want to delete this post?')) {
      return;
    }

    try {
      const response = await fetch(`${API_URL}/${id}`, {
        method: 'DELETE',
      });

      if (response.ok) {
        await fetchPosts();
      } else {
        alert('Error deleting post');
      }
    } catch (error) {
      console.error('Error deleting post:', error);
      alert('Error deleting post');
    }
  };

  const handleEdit = (post) => {
    setEditingPost(post);
    setShowForm(true);
  };

  const handleCancel = () => {
    setEditingPost(null);
    setShowForm(false);
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <div className="container mx-auto px-4 py-8 max-w-6xl">
        <header className="mb-8">
          <h1 className="text-4xl font-bold text-gray-900 mb-2">Blog Posts</h1>
          <p className="text-gray-600">Manage your blog posts</p>
        </header>

        {!showForm && (
          <button
            onClick={() => setShowForm(true)}
            className="mb-6 bg-blue-600 hover:bg-blue-700 text-white font-semibold py-2 px-4 rounded-lg shadow-md transition duration-200"
          >
            + Create New Post
          </button>
        )}

        {showForm && (
          <div className="mb-8">
            <BlogPostForm
              post={editingPost}
              onSubmit={editingPost ? (data) => handleUpdate(editingPost.id, data) : handleCreate}
              onCancel={handleCancel}
            />
          </div>
        )}

        {loading ? (
          <div className="text-center py-12">
            <div className="inline-block animate-spin rounded-full h-12 w-12 border-b-2 border-blue-600"></div>
            <p className="mt-4 text-gray-600">Loading posts...</p>
          </div>
        ) : (
          <BlogPostList
            posts={posts}
            onEdit={handleEdit}
            onDelete={handleDelete}
          />
        )}
      </div>
    </div>
  );
}

export default App;

