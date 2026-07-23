# 📚 Sistema Integral de Biblioteca

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.x-green)
![JWT](https://img.shields.io/badge/JWT-Autenticación-blue)
![MariaDB](https://img.shields.io/badge/MariaDB-11.x-blue)
![Maven](https://img.shields.io/badge/Maven-3.x-red)
![Docker](https://img.shields.io/badge/Docker-Container-blue)
![Estado](https://img.shields.io/badge/Sprint-19-success)

---

# 📖 Descripción

Sistema Integral de Biblioteca desarrollado con **Spring Boot**, aplicando arquitectura en capas, principios SOLID y buenas prácticas de desarrollo de software.

El proyecto permite administrar el proceso completo de una biblioteca:

- Gestión de usuarios
- Gestión de libros
- Gestión de ejemplares
- Préstamos
- Reservas
- Multas
- Seguridad mediante JWT
- API REST documentada con Swagger

---

# 🎯 Objetivo

Desarrollar un sistema robusto, escalable y mantenible para la administración de bibliotecas, aplicando tecnologías modernas y arquitectura empresarial.

---

# 🏗 Arquitectura

El proyecto utiliza una arquitectura en capas.

```
Controller
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
Entity
```

Se emplean además:

- DTO Request
- DTO Response
- Mapper Manual
- Constantes
- Excepciones Globales
- Validaciones con Jakarta Validation

---

# 🛠 Tecnologías

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Security
- JWT
- MariaDB
- Maven
- Docker
- Swagger / OpenAPI

---

# 📂 Estructura del proyecto

```
src
└── main
    ├── java
    │   └── mx.edu.itvo.biblioteca
    │       ├── config
    │       ├── constant
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── exception
    │       ├── mapper
    │       ├── repository
    │       ├── security
    │       ├── service
    │       └── util
    │
    └── resources
        ├── application.properties
        └── static
```

---

# ✅ Funcionalidades implementadas

## Seguridad

- JWT
- Spring Security
- Roles
- Permisos
- Endpoints protegidos

---

## Catálogos

- Categorías
- Editoriales
- Autores
- Idiomas
- Estados
- Tipos de Usuario
- Estados de Usuario

---

## Biblioteca

- Libros
- Ejemplares
- Control de inventario

---

## Circulación

- Préstamos
- Reservas
- Multas

---

## Backend

- CRUD completos
- Validaciones
- Manejo global de excepciones
- DTO
- Mapper manual
- Arquitectura en capas

---

# 📋 Estado del proyecto

| Módulo | Estado |
|---------|:------:|
| Seguridad JWT | ✅ |
| Usuarios | ✅ |
| Roles | ✅ |
| Categorías | ✅ |
| Editoriales | ✅ |
| Autores | ✅ |
| Idiomas | ✅ |
| Libros | ✅ |
| Ejemplares | ✅ |
| Préstamos | ✅ |
| Reservas | ✅ |
| Multas | ✅ |

---

# 🚀 Roadmap

## ✅ Sprint 1 - 19

- Configuración del proyecto
- Seguridad
- Catálogos
- Gestión bibliográfica
- Ejemplares
- Préstamos
- Reservas
- Multas
- Refactorización
- Optimización del backend

---

## 🔄 Sprint 20

- Dashboard
- Reportes
- Indicadores
- Estadísticas
- Vistas SQL
- Exportación PDF
- Exportación Excel

---

## 🔄 Sprint 21

- Integración final
- Optimización
- Docker Compose
- Pruebas finales
- Despliegue

---

# 📌 Características técnicas

- Arquitectura Layered
- Principios SOLID
- Código documentado con JavaDoc
- Separación DTO / Entity
- Repositorios JPA
- Validaciones centralizadas
- Excepciones globales
- Código desacoplado
- Refactorización continua

---

# 🐳 Docker

El proyecto puede ejecutarse mediante Docker utilizando MariaDB como motor de base de datos.

---

# 📑 API REST

La documentación de la API se encuentra disponible mediante Swagger.

```
http://localhost:8080/swagger-ui/index.html
```

---

# 🔐 Autenticación

La API utiliza autenticación mediante JWT.

Flujo:

```
Login

↓

JWT

↓

Authorization Bearer Token

↓

Endpoints protegidos
```

---

# 📈 Estado actual

**Versión**

```
v1.0.0
```

**Sprint**

```
Sprint 19 Finalizado
```

**Estado**

🟢 Backend completamente funcional

---

# 👨‍💻 Autor

**Conce**

Ingeniería en Sistemas Computacionales

Instituto Tecnológico del Valle de Oaxaca

---

# 📄 Licencia

Proyecto desarrollado con fines académicos y de aprendizaje.
