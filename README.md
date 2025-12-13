# Sistema de Reservas – Backend (Spring Boot)

Backend REST desarrollado en **Java con Spring Boot**, orientado a practicar y demostrar conceptos fundamentales de desarrollo backend profesional: arquitectura en capas, validaciones, manejo de errores HTTP y persistencia con JPA.

El proyecto forma parte de mi proceso de aprendizaje en backend con Java y Spring.

---

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Bean Validation (Jakarta Validation)**
- **H2 Database (en memoria)**
- **Gradle**
- **Git / GitHub**

---

## 🧱 Arquitectura

El proyecto sigue una **arquitectura en capas**, separando responsabilidades:

- **Controller**: expone endpoints REST
- **Service**: contiene la lógica de negocio
- **Repository**: acceso a datos con JPA
- **DTOs**: separación entre modelo interno y contratos de API
- **Exception Handling**: manejo global de errores HTTP

---

## 👤 Funcionalidades actuales

### Usuarios
- Crear usuarios
- Obtener todos los usuarios
- Obtener usuario por ID
- Eliminar usuario

Incluye:
- Validaciones automáticas de datos de entrada
- Manejo correcto de códigos HTTP (200, 201, 400, 404, 204)
- Respuestas controladas mediante DTOs

---

## 🔗 Endpoints principales

### Obtener todos los usuarios
GET /usuarios

### Obtener usuario por ID
GET /usuarios/{id}

### Crear usuario
POST /usuarios

Ejemplo de body:
```json
{
  "telefono": "1134567890",
  "password": "password123",
  "nombre": "Eze",
  "email": "eze@example.com",
  "rol": "ADMIN"
}
```

### Eliminar usuario
DELETE /usuarios/{id}

---

## ⚠️ Manejo de errores

El backend cuenta con un manejador global de excepciones que devuelve errores de forma consistente:

400 Bad Request → datos inválidos

404 Not Found → recurso inexistente

201 Created → creación exitosa

204 No Content → eliminación exitosa

Las validaciones se realizan automáticamente mediante anotaciones (@NotBlank, @Email, etc.).

---

## 🗄️ Base de datos

Se utiliza H2 en memoria, ideal para desarrollo y pruebas.

La base se reinicia al reiniciar la aplicación

Accesible desde /h2-console cuando la app está en ejecución

---

## 🧠 Objetivo del proyecto

El objetivo principal es aprender y aplicar buenas prácticas de backend con Java y Spring, entendiendo el por qué de cada decisión técnica, más allá de simplemente implementar un CRUD.

---

## 📌 Próximos pasos

Implementar entidades de reservas y relaciones JPA

Seguridad básica (hash de contraseñas)

Tests unitarios

Paginación y filtros

---

## ✍️ Autor

Proyecto desarrollado por Ezequiel Bainer

