# springbook-java--solucion-servidor-cliente-
Sistema de gestión de logística terrestre y maritima.(Logica de negocio CRUD), 
implementando servicio apirest.


PRUEBA TECNICA:


Empresa: Software  Estrategico



INTRODUCCIÓN :
Este repositorio consiste en mostrar las habilidades técnicas (Springbook-Java) a travéz de la resolución de los problemas planteados .




TECNOLOGÍA Y PATRONES DE DISEÑO EMPLEADO.

.Patron de diseño -> Inyección de dependencia.
.Estandar JWT -> Control de sessione de usuarios 
.Rest con el framework -> springbook
.Mapeo objeto-relacional -> Hibernate
.Repositorios de git
.HTML
.JAVASCRIPT
.CSS


PLAN DE TRABAJO :
El repositorio se realizó en 2 días y para ello se propuso dividir el proyecto en una serie de etapas que se detallarán a continuación :

ETAPA 1 :
Plantear la lógica inicial de los problemas.
ETAPA 2 :
Creacion y normalizacion de bases de datos .
ETAPA 3 :
Plasmar la lógica en código(Api Rest) .
ETAPA 3 :
Consumir Api Rest (CLIENTE)
ETAPA 4 :
Versión final README.



ARCHIVOS IMPORTANTES
El proyecto presenta los siguientes archivos para uso del usuario:
README.md con descripción del repositorio, imagenes del mismo y organización.
index.html: Pagina Principal para iniciar sesión.
src: Todo el codigo fuente.
controllers: Definimos las rutas.
dao: Toda la logica relacionada con la base de datos
modelo: Nombres de la entidades (estrutura).
static: Frontend (consumidor de Api Rest).


CONFIGURACIÓN Y EJECUCIÓN.
Para compilar el proyecto api utilice maven. Puede utilizar el intellij idea, IDE eclipse o Spring Tool Suit para compilar o ejecutar. Este levantará el servicio por el puerto 8080. Este proyecto conectará a una base de datos Mysql. Para compilar el proyecto cliente utilice node.
![ddd](https://user-images.githubusercontent.com/89054795/149599681-c21666c8-d778-446f-8947-ce47df0e79ef.png)


![11](https://user-images.githubusercontent.com/89054795/149599807-1cd62272-dd2c-49a7-8d3b-064bffbb0960.png)


Script para crear la Base de dato y las tablas en mysql.

Nombre de la base de datos: envio
![sss](https://user-images.githubusercontent.com/89054795/149599251-9b41804c-cdaf-4ddd-ad5b-55500a962ebd.png)




CREATE TABLE `bodega` (
  `id_bodega` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_localizacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `localizacion` (
  `id_localizacion` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



CREATE TABLE `maritima` (
  `id` int(11) NOT NULL,
  `id_producto_maritimo` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `fecha_registro` date NOT NULL,
  `precio_envio` double NOT NULL,
  `numero_flota` varchar(250) NOT NULL,
  `numero_guia` varchar(250) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha_entrega` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `producto_maritimo` (
  `id_producto_maritimo` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_puerto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `producto_terrestre` (
  `id_producto_terrestre` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_bodega` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `puerto` (
  `id_puerto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `id_localizacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `terrestre` (
  `id` int(11) NOT NULL,
  `id_producto_terrestre` int(11) NOT NULL,
  `cantidad_producto` int(11) NOT NULL,
  `fecha_registro` date NOT NULL,
  `precio_envio` double NOT NULL,
  `placa_vehiculo` varchar(250) NOT NULL,
  `numero_guia` varchar(250) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `fecha_entrega` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



ALTER TABLE `bodega`
  ADD PRIMARY KEY (`id_bodega`),
  ADD KEY `fk_localizacion` (`id_localizacion`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`);

--
-- Indices de la tabla `localizacion`
--
ALTER TABLE `localizacion`
  ADD PRIMARY KEY (`id_localizacion`);

--
-- Indices de la tabla `maritima`
--
ALTER TABLE `maritima`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cliente` (`id_cliente`),
  ADD KEY `fk_producto_maritimo` (`id_producto_maritimo`);

--
-- Indices de la tabla `producto_maritimo`
--
ALTER TABLE `producto_maritimo`
  ADD PRIMARY KEY (`id_producto_maritimo`),
  ADD KEY `fk_puerto` (`id_puerto`);

--
-- Indices de la tabla `producto_terrestre`
--
ALTER TABLE `producto_terrestre`
  ADD PRIMARY KEY (`id_producto_terrestre`),
  ADD KEY `fk_bodega` (`id_bodega`);

--
-- Indices de la tabla `puerto`
--
ALTER TABLE `puerto`
  ADD PRIMARY KEY (`id_puerto`),
  ADD KEY `fk_localiza` (`id_localizacion`);

--
-- Indices de la tabla `terrestre`
--
ALTER TABLE `terrestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_producto_terrestre` (`id_producto_terrestre`),
  ADD KEY `fk_clientes` (`id_cliente`);

