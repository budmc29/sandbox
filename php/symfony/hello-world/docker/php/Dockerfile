FROM php:8.2-fpm-alpine

RUN apk add --no-cache \
    postgresql-dev \
    icu-dev \
    && docker-php-ext-install pdo pdo_pgsql intl opcache

COPY --from=composer:latest /usr/bin/composer /usr/bin/composer

WORKDIR /app

COPY composer.json composer.lock ./
RUN composer install --no-scripts --no-autoloader

COPY . .
RUN composer dump-autoload --optimize

RUN chown -R www-data:www-data /app/var

EXPOSE 9000

CMD ["php-fpm"]

