import { describe, it, expect, vi, beforeEach } from 'vitest';
import { render, screen, waitFor } from '@testing-library/react';
import userEvent from '@testing-library/user-event';
import BlogPostForm from '../BlogPostForm';

describe('BlogPostForm', () => {
  const mockOnSubmit = vi.fn();
  const mockOnCancel = vi.fn();

  beforeEach(() => {
    mockOnSubmit.mockClear();
    mockOnCancel.mockClear();
  });

  it('renders create form when no post provided', () => {
    render(<BlogPostForm onSubmit={mockOnSubmit} onCancel={mockOnCancel} />);
    expect(screen.getByText('Create New Post')).toBeInTheDocument();
    expect(screen.getByPlaceholderText('Enter post title')).toBeInTheDocument();
    expect(screen.getByPlaceholderText('Enter post content')).toBeInTheDocument();
  });

  it('renders edit form when post provided', () => {
    const post = {
      id: 1,
      title: 'Existing Post',
      content: 'Existing Content',
      author: 'Existing Author',
    };
    render(<BlogPostForm post={post} onSubmit={mockOnSubmit} onCancel={mockOnCancel} />);
    expect(screen.getByText('Edit Post')).toBeInTheDocument();
    expect(screen.getByDisplayValue('Existing Post')).toBeInTheDocument();
    expect(screen.getByDisplayValue('Existing Content')).toBeInTheDocument();
    expect(screen.getByDisplayValue('Existing Author')).toBeInTheDocument();
  });

  it('shows validation errors for empty title', async () => {
    const user = userEvent.setup();
    render(<BlogPostForm onSubmit={mockOnSubmit} onCancel={mockOnCancel} />);
    
    const titleInput = screen.getByPlaceholderText('Enter post title');
    await user.clear(titleInput);
    
    const contentInput = screen.getByPlaceholderText('Enter post content');
    await user.type(contentInput, 'Some content');
    
    screen.getByText('Create Post').click();
    
    await waitFor(() => {
      expect(screen.getByText('Title is required')).toBeInTheDocument();
    });
    expect(mockOnSubmit).not.toHaveBeenCalled();
  });

  it('shows validation error for short title', async () => {
    const user = userEvent.setup();
    render(<BlogPostForm onSubmit={mockOnSubmit} onCancel={mockOnCancel} />);
    
    await user.type(screen.getByPlaceholderText('Enter post title'), 'AB');
    await user.type(screen.getByPlaceholderText('Enter post content'), 'Some content');
    
    screen.getByText('Create Post').click();
    
    await waitFor(() => {
      expect(screen.getByText('Title must be at least 3 characters')).toBeInTheDocument();
    });
    expect(mockOnSubmit).not.toHaveBeenCalled();
  });

  it('calls onSubmit with correct data when form is valid', async () => {
    const user = userEvent.setup();
    render(<BlogPostForm onSubmit={mockOnSubmit} onCancel={mockOnCancel} />);
    
    await user.type(screen.getByPlaceholderText('Enter post title'), 'Valid Title');
    await user.type(screen.getByPlaceholderText('Enter post content'), 'Valid Content');
    await user.type(screen.getByPlaceholderText('Enter author name (optional)'), 'Author Name');
    
    screen.getByText('Create Post').click();
    
    await waitFor(() => {
      expect(mockOnSubmit).toHaveBeenCalledWith({
        title: 'Valid Title',
        content: 'Valid Content',
        author: 'Author Name',
      });
    });
  });

  it('calls onCancel when cancel button is clicked', () => {
    render(<BlogPostForm onSubmit={mockOnSubmit} onCancel={mockOnCancel} />);
    screen.getByText('Cancel').click();
    expect(mockOnCancel).toHaveBeenCalled();
  });
});

