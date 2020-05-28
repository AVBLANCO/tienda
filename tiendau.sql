-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 28-05-2020 a las 03:53:04
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tiendau`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `clave` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `email`, `clave`) VALUES
(1, 'Bernardo Redin', 'bernarr@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seguir`
--

DROP TABLE IF EXISTS `seguir`;
CREATE TABLE IF NOT EXISTS `seguir` (
  `cliente` int(11) NOT NULL,
  `tienda` int(11) NOT NULL,
  PRIMARY KEY (`cliente`,`tienda`),
  KEY `seguir_tienda_fk` (`tienda`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

DROP TABLE IF EXISTS `servicio`;
CREATE TABLE IF NOT EXISTS `servicio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `descripcion` text NOT NULL,
  `tienda` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tienda_servicio_idx` (`tienda`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`id`, `nombre`, `descripcion`, `tienda`) VALUES
(1, 'Entrega de elementos a domicilio', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 1),
(2, 'Compra de mercado', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 1),
(3, 'Entrega de elementos a domicilio', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 1),
(4, 'Compra de mercado', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 1),
(5, 'Hacemos parciales de Web', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 1),
(8, 'Reparación de aires', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 2),
(9, 'Reparación de goteras', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque earum nostrum suscipit ducimus nihil provident, perferendis rem illo, voluptate atque, sit eius in voluptates, nemo repellat fugiat excepturi! Nemo, esse.', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tienda`
--

DROP TABLE IF EXISTS `tienda`;
CREATE TABLE IF NOT EXISTS `tienda` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `lema` varchar(200) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `clave` varchar(100) NOT NULL,
  `propietario` varchar(100) NOT NULL,
  `facebook` varchar(100) NOT NULL,
  `web` varchar(100) NOT NULL,
  `imagen` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tienda`
--

INSERT INTO `tienda` (`id`, `nombre`, `lema`, `descripcion`, `email`, `clave`, `propietario`, `facebook`, `web`, `imagen`) VALUES
(1, 'Eco Rapidisimos', 'Servicio de domicilio ecológico para toda la ciudad', 'Nuestro servicio de domicilio cumple con todos los estandares de seguridad para garantizar la tranquilidad de nuestros clientes.  Usamos bicicletas y vehiculos eléctricos alineados al cuidado del medio ambiente.  Trabajar con nosotros es trabajar por un mejor futuro.', 'info@ecorapidisimos.co', '1234', 'Mario Gonzalez', '', '1', 'https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_02.png'),
(2, 'Tu Reparación a la Mano', 'Reparamos cualquier tipo de daño en tu hogar', 'Contamos con un servicio especializado de reparación de plomería y construcción para el hogar.  Tranquilo nosotros nos preocupamos por ti.', 'info@reparamos.co', '1234', 'Karla Ortiz', '', 'www.reparamos.co', 'https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_01.png'),
(3, 'La Cava', 'Servicio de copias a domicilio', 'Con nuestro excelente modelo llevamos nuestras fotocopiadoras hasta la puerta de tu casa', 'info@lacava.com', '1234', 'Camila Vasquez', '', 'www.cava.com', 'https://sunlimetech.com/portfolio/boot4menu/assets/imgs/team/img_03.png');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `seguir`
--
ALTER TABLE `seguir`
  ADD CONSTRAINT `seguir_cliente_fk` FOREIGN KEY (`cliente`) REFERENCES `cliente` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `seguir_tienda_fk` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`tienda`) REFERENCES `tienda` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
