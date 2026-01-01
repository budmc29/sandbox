FROM php:8.4-fpm-alpine

RUN apk add --no-cache \
    postgresql-dev \
    icu-dev \
    linux-headers \
    && docker-php-ext-install pdo pdo_pgsql intl opcache

COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

WORKDIR /app

COPY composer.json ./
RUN composer install --no-scripts --no-autoloader --no-dev --ignore-platform-reqs || true

COPY . .
RUN composer install --no-dev --optimize-autoloader --ignore-platform-reqs

RUN mkdir -p /app/var && chown -R www-data:www-data /app/var

EXPOSE 9000

CMD ["php-fpm"]

