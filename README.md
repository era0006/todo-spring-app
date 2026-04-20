# Todo App - Spring Boot

REST API для управления задачами с авторизацией.

## Технологии
- Java 17, Spring Boot 3
- Spring Security (BCrypt)
- PostgreSQL, Flyway миграции
- Docker, docker-compose
- JUnit 5, Mockito (15+ тестов)

## Структура проекта
- `controller/` - REST endpoints
- `service/` - бизнес-логика
- `repository/` - работа с БД
- `model/` - сущности
- `dto/` - объекты для передачи данных
- `mapper/` - конвертация Entity ↔ DTO
- `security/` - конфигурация Spring Security
- `resources/db/migration/` - SQL миграции

## Как запустить
```bash
docker-compose up