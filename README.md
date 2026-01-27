# Bienvenido a la documentacion del Backend de PetCare

> Este proyecto es una aplicación web full‑stack desarrollada con **Spring Boot** (backend) y **Angular** (frontend), orientada a arquitectura REST y despliegue en producción.
## Resumen del proyecto
Este proyecto consiste en una aplicación web moderna que implementa una arquitectura cliente‑servidor desacoplada. El backend expone una API REST construida con Spring Boot, mientras que el frontend consume estos servicios mediante Angular.

El sistema fue diseñado considerando buenas prácticas de seguridad, escalabilidad y despliegue, incluyendo configuración de CORS y generación de builds para producción.

### Pruebas

Link directo para probar la API usando Swagger
https://petcare-t2bx.onrender.com/documentacion/swagger-ui/index.html#/

## Email's y PDF

Los envios de email (llegan como spam) se realizan:
* Al crear una cuenta
* Al crear una mascota
* Al editar una mascota
* Al crear una solicitud de adopción (Aquí se genera un pdf)

## Arquitectura
```
Angular (SPA)
     │
     │ HTTP / JSON
     ▼
Spring Boot API REST
     │
     ▼
Base de datos (SQL)
```

- Separación frontend / backend
- Comunicación mediante REST
- Configuración por ambientes (dev / prod)

### Backend
- Java 17+
- Spring Boot
- Spring Web (REST)
- Spring Security
- JPA / Hibernate
- Maven

### Infraestructura / DevOps
- Git / GitHub
- Build de producción con `ng build`
- Empaquetado JAR
- Variables de entorno
- Configuración CORS

## Licencia

Proyecto desarrollado con fines educativos y demostrativos.
