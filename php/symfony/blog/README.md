# Symfony Blog Application

A full-stack CRUD blog application built with Symfony 6, PostgreSQL, React, and Tailwind CSS.

## Features

- **Backend**: Symfony 6 REST API with PostgreSQL database
- **Frontend**: React 18 with Tailwind CSS for styling
- **CRUD Operations**: Create, Read, Update, Delete blog posts
- **Testing**: PHPUnit tests for backend, Vitest for frontend

## Requirements

- PHP 8.2+
- PostgreSQL 16+
- Composer
- Node.js 18+ and npm

## Installation

### Backend Setup

1. Install PHP dependencies:
```bash
composer install
```

2. Configure database connection in `.env`:
```env
DATABASE_URL="postgresql://user:password@127.0.0.1:5432/blog_db?serverVersion=16&charset=utf8"
```

3. Create database:
```bash
php bin/console doctrine:database:create
```

4. Run migrations:
```bash
php bin/console doctrine:migrations:migrate
```

### Frontend Setup

1. Install Node.js dependencies:
```bash
npm install
```

2. Build assets (for production):
```bash
npm run build
```

## Running the Application

### Backend Server

Start the Symfony development server:
```bash
./bin/serve
```

The API will be available at `http://127.0.0.1:8000`

### Frontend Development Server

In a separate terminal, start the Vite dev server:
```bash
npm run dev
```

The frontend will be available at `http://localhost:5173`

## API Endpoints

- `GET /api/blog-posts` - List all blog posts
- `GET /api/blog-posts/{id}` - Get a specific blog post
- `POST /api/blog-posts` - Create a new blog post
- `PUT /api/blog-posts/{id}` - Update a blog post
- `DELETE /api/blog-posts/{id}` - Delete a blog post

## Testing

### Backend Tests

Run PHPUnit tests:
```bash
./vendor/bin/phpunit
```

### Frontend Tests

Run Vitest tests:
```bash
npm test
```

## Project Structure

```
├── assets/              # React frontend source files
│   ├── components/      # React components
│   └── App.jsx         # Main React application
├── config/              # Symfony configuration
├── migrations/         # Database migrations
├── public/             # Public web directory
├── src/
│   ├── Controller/     # Symfony controllers
│   ├── Entity/         # Doctrine entities
│   └── Repository/      # Doctrine repositories
└── tests/              # Test files
```

