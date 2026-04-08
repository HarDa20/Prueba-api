# Franquicias API

Prueba técnica desarrollada en **Spring Boot** para la gestión de **franquicias, sucursales y productos**, cumpliendo los criterios solicitados de creación, actualización, eliminación y consulta especializada de stock.

La solución implementa una **arquitectura por capas (Controller → Service → Repository)**, persistencia con **MySQL**, relaciones JPA entre entidades y consultas usando **programación funcional con Java Streams**.

---

# Tecnologías utilizadas

* **Java 17**
* **Spring Boot**
* **Spring Data JPA**
* **MySQL**
* **Maven**
* **Docker**
* **Git / GitHub**

#  Estructura del proyecto

src/main/java/com/DavidHernandez/franquicias_api
│
├── controller
│   ├── FranquiciaController.java
│   ├── SucursalController.java
│   └── ProductoController.java
│
├── service
│   ├── FranquiciaService.java
│   ├── SucursalService.java
│   └── ProductoService.java
│
├── repository
│   ├── FranquiciaRepository.java
│   ├── SucursalRepository.java
│   └── ProductoRepository.java
│
├── model
│   ├── Franquicia.java
│   ├── Sucursal.java
│   └── Producto.java
│
└── FranquiciasApiApplication.java


# Configuración para ejecutar en local

## 1) Clonar el repositorio


git clone https://github.com/HarDa20/Prueba-api.git
cd franquicias-api


## 2) Crear la base de datos en MySQL

Ejecuta en MySQL:

CREATE DATABASE franquicias_db;


## 3) Configurar credenciales

En `src/main/resources/application.properties`:

*properties*
spring.datasource.url=jdbc:mysql://localhost:3306/franquicias_db
spring.datasource.username=root
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true



## 4) Ejecutar la aplicación

mvn spring-boot:run

*La API quedará disponible en:*

http://localhost:8080



# Endpoints principales

## Crear franquicia

POST /api/franquicias

### Body

*json*
{
  "nombre": "Franquicia Centro"
}



## ✅ Crear sucursal en franquicia


POST /api/sucursales/franquicia/{franquiciaId}


### Body

*json*
{
  "nombre": "Sucursal Norte"
}



## Crear producto en sucursal

POST /api/productos/sucursal/{sucursalId}


### Body

*json*
{
  "nombre": "Coca Cola",
  "stock": 100
}



## Eliminar producto


DELETE /api/productos/{productoId}


##  Actualizar stock


PATCH /api/productos/{productoId}/stock?stock=200



##  Consultar producto con mayor stock por sucursal


GET /api/productos/mayor-stock/franquicia/{franquiciaId}

*Este endpoint retorna el producto con mayor stock por cada sucursal de la franquicia indicada.*


# Funcionalidades Plus implementadas

Además de los criterios base, se añadieron mejoras adicionales:

* Dockerfile para empaquetado
* Programación funcional con Streams
* Endpoint para actualizar nombre de franquicia
* Endpoint para actualizar nombre de sucursal
* Endpoint para actualizar nombre de producto


# Ejecución con Docker

## Construir imagen


docker build -t franquicias-api .


## Ejecutar contenedor


docker run -p 8080:8080 franquicias-api


# Decisiones técnicas

elegi **MySQL** como sistema de persistencia debido a la naturaleza relacional del problema:

* una franquicia tiene muchas sucursales
* una sucursal tiene muchos productos
* cada producto posee stock

Para la consulta del producto con mayor stock por sucursal se utilizó **programación funcional con Java Streams**, mejorando la legibilidad y mantenibilidad de la lógica.

---

# Autor

**David Hernandez**

Prueba técnica backend - Spring Boot.
