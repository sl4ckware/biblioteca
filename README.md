# 📚 Sistema Integral de Biblioteca

Sistema web para la administración integral de una biblioteca,
desarrollado con Java y Spring Boot bajo una arquitectura empresarial
por capas.

El sistema permite gestionar usuarios, libros, ejemplares, préstamos,
reservas, dashboard e informes administrativos.

------------------------------------------------------------------------

# 📌 Descripción del Proyecto

El Sistema Integral de Biblioteca tiene como objetivo digitalizar y
optimizar los procesos principales de una biblioteca mediante una
plataforma web segura y escalable.

Principales funcionalidades:

-   Administración de usuarios.
-   Gestión del catálogo bibliográfico.
-   Control de ejemplares.
-   Gestión de préstamos.
-   Gestión de reservas.
-   Autenticación mediante JWT.
-   Dashboard de indicadores.
-   Generación de reportes PDF y Excel.

------------------------------------------------------------------------

# 🎯 Objetivo General

Desarrollar un sistema integral para administrar los procesos
bibliotecarios mediante una arquitectura basada en servicios REST,
persistencia con JPA y seguridad JWT.

------------------------------------------------------------------------

# 🚀 Características Principales

## 👥 Usuarios

-   Registro y actualización de usuarios.
-   Consulta de información.
-   Tipos de usuario.
-   Estados de usuario.

## 📖 Gestión Bibliográfica

Incluye:

-   Libros.
-   Autores.
-   Categorías.
-   Editoriales.
-   Idiomas.
-   Ejemplares.

## 🔐 Seguridad

Implementación de:

-   Spring Security.
-   Autenticación JWT.
-   Protección de endpoints.
-   Control de acceso.

## 🔄 Préstamos

Permite:

-   Registro de préstamos.
-   Consulta de préstamos.
-   Control de estados.
-   Relación usuario - ejemplar - bibliotecario.

## 📌 Reservas

Incluye:

-   Registro de reservas.
-   Consulta.
-   Control de estados.

## 📊 Dashboard

Indicadores:

-   Total libros.
-   Total ejemplares.
-   Total usuarios.
-   Préstamos activos.
-   Reservas activas.
-   Rankings bibliográficos.

## 📄 Reportes

Generación de:

-   Dashboard PDF.
-   Dashboard Excel.
-   Reporte administrativo PDF.
-   Reporte administrativo Excel.
-   Reporte de préstamos.
-   Reporte de reservas.

------------------------------------------------------------------------

# 🏗 Arquitectura del Sistema

El sistema utiliza arquitectura por capas:

``` text
Cliente Web
     |
     |
Controllers REST
     |
     |
Services
     |
     |
ServiceImpl
     |
     |
Repositories
     |
     |
JPA / Hibernate
     |
     |
MariaDB
```

------------------------------------------------------------------------

# 🛠 Tecnologías Utilizadas

## Backend

-   Java.
-   Spring Boot.
-   Spring Data JPA.
-   Hibernate ORM.
-   Spring Security.
-   JWT.
-   Maven.

## Base de Datos

-   MariaDB.

## Documentación API

-   Swagger OpenAPI.

## Frontend

-   HTML5.
-   JavaScript.
-   Bootstrap.
-   CSS.

## Herramientas

-   Git.
-   GitHub.
-   Docker.
-   NetBeans.

------------------------------------------------------------------------

# 📂 Estructura del Proyecto

``` text
biblioteca
|
├── controller
├── service
├── service.impl
├── repository
├── entity
├── dto
├── security
└── config
```

------------------------------------------------------------------------

# ⚙️ Requisitos

-   Java 21 o superior.
-   Maven.
-   MariaDB.
-   Git.

------------------------------------------------------------------------

# 🗄 Configuración de Base de Datos

Crear la base de datos:

``` sql
CREATE DATABASE biblioteca;
```

Configurar:

``` properties
spring.datasource.url=jdbc:mariadb://localhost:3306/biblioteca
spring.datasource.username=root
spring.datasource.password=password
```

------------------------------------------------------------------------

# ▶️ Ejecución

Clonar repositorio:

``` bash
git clone https://github.com/sl4ckware/biblioteca.git
```

Ejecutar:

``` bash
./mvnw spring-boot:run
```

Sistema disponible:

``` text
http://localhost:8080
```

------------------------------------------------------------------------

# 📘 Swagger

Documentación API:

``` text
http://localhost:8080/swagger-ui/index.html
```

------------------------------------------------------------------------

# 🧪 Pruebas Realizadas

Validaciones realizadas:

✅ Compilación Maven.

✅ Conexión MariaDB.

✅ Autenticación JWT.

✅ Pruebas API REST.

✅ Dashboard.

✅ Generación PDF.

✅ Generación Excel.

------------------------------------------------------------------------

# 📈 Estado del Proyecto

Proyecto finalizado para entrega académica.

Módulos completados:

-   Usuarios.
-   Seguridad JWT.
-   Catálogos.
-   Libros.
-   Ejemplares.
-   Préstamos.
-   Reservas.
-   Dashboard.
-   Reportes.

------------------------------------------------------------------------

# 👨‍💻 Autor

Conce

Proyecto académico:

**Sistema Integral de Biblioteca**

------------------------------------------------------------------------

# 📄 Licencia

Proyecto desarrollado con fines académicos.
