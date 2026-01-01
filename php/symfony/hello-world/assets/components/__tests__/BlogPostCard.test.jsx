import { describe, it, expect, vi } from 'vitest';
import { render, screen } from '@testing-library/react';
import BlogPostCard from '../BlogPostCard';

describe('BlogPostCard', () => {
  const mockPost = {
    id: 1,
    title: 'Test Post',
    content: 'This is a test post content that is longer than 150 characters to test truncation functionality properly.',
    author: 'Test Author',
    createdAt: '2024-01-01 12:00:00',
    updatedAt: '2024-01-01 12:00:00',
  };

  it('renders post title', () => {
    render(<BlogPostCard post={mockPost} onEdit={vi.fn()} onDelete={vi.fn()} />);
    expect(screen.getByText('Test Post')).toBeInTheDocument();
  });

  it('renders post author when provided', () => {
    render(<BlogPostCard post={mockPost} onEdit={vi.fn()} onDelete={vi.fn()} />);
    expect(screen.getByText(/Test Author/)).toBeInTheDocument();
  });

  it('renders truncated content', () => {
    render(<BlogPostCard post={mockPost} onEdit={vi.fn()} onDelete={vi.fn()} />);
    const content = screen.getByText(/This is a test post content/);
    expect(content).toBeInTheDocument();
    expect(content.textContent.length).toBeLessThanOrEqual(153);
  });

  it('calls onEdit when edit button is clicked', () => {
    const onEdit = vi.fn();
    render(<BlogPostCard post={mockPost} onEdit={onEdit} onDelete={vi.fn()} />);
    screen.getByText('Edit').click();
    expect(onEdit).toHaveBeenCalledWith(mockPost);
  });

  it('calls onDelete when delete button is clicked', () => {
    const onDelete = vi.fn();
    render(<BlogPostCard post={mockPost} onEdit={vi.fn()} onDelete={onDelete} />);
    screen.getByText('Delete').click();
    expect(onDelete).toHaveBeenCalledWith(mockPost.id);
  });
});

