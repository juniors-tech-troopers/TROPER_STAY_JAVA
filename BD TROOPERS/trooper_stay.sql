-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         8.0.34 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para trooper_stay
DROP DATABASE IF EXISTS `trooper_stay`;
CREATE DATABASE IF NOT EXISTS `trooper_stay` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `trooper_stay`;

-- Volcando estructura para tabla trooper_stay.hospedajes
DROP TABLE IF EXISTS `hospedajes`;
CREATE TABLE IF NOT EXISTS `hospedajes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `tipo` int DEFAULT NULL,
  `capacidad` int DEFAULT NULL,
  `localizacion` varchar(50) DEFAULT NULL,
  `precio_por_noche` float DEFAULT NULL,
  `estado` tinyint(1) DEFAULT NULL,
  `id_usuario` int DEFAULT NULL,
  `id_usuario_inquilino` int DEFAULT NULL,
  `inicio_estadia` date DEFAULT NULL,
  `estadia` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla trooper_stay.hospedajes: ~5 rows (aproximadamente)
DELETE FROM `hospedajes`;
INSERT INTO `hospedajes` (`id`, `nombre`, `tipo`, `capacidad`, `localizacion`, `precio_por_noche`, `estado`, `id_usuario`, `id_usuario_inquilino`, `inicio_estadia`, `estadia`) VALUES
	(7, 'tutancamon', 2, 5, 'buenos aires', 123456, 1, 11, 14, '2023-10-13', '2023-10-15'),
	(8, 'calamuchita', 2, 6, 'río negro', 1450, 1, 11, 12, '2023-10-13', '2023-10-23'),
	(9, 'ohana', 3, 5, 'buenos aires', 14570, 0, 11, NULL, NULL, NULL),
	(10, 'pozo', 1, 5, 'buenos aires', 2000, 1, 11, 14, '2023-10-13', '2023-11-02'),
	(11, 'queso', 2, 6, 'buenos aires', 123475, 0, 11, NULL, NULL, NULL);

-- Volcando estructura para tabla trooper_stay.usuarios
DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre_de_usuario` varchar(50) DEFAULT NULL,
  `contrasenia` varchar(50) DEFAULT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `edad` int DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `saldo` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Volcando datos para la tabla trooper_stay.usuarios: ~2 rows (aproximadamente)
DELETE FROM `usuarios`;
INSERT INTO `usuarios` (`id`, `nombre_de_usuario`, `contrasenia`, `correo`, `edad`, `nombre`, `apellido`, `saldo`) VALUES
	(11, 'nelson', '1234', 'gg@gmail.com', 123, 'nelson', 'lassa', 40000),
	(12, 'asd', 'asd', 'asd', 123, 'asd', 'qwe', 85500),
	(14, 'gianca', 'test', 'gianca@gmail.com', 29, 'giancarlo', 'galvarini', 93088);

-- Volcando estructura para evento trooper_stay.Terminacion_alquileres
DROP EVENT IF EXISTS `Terminacion_alquileres`;
DELIMITER //
CREATE EVENT `Terminacion_alquileres` ON SCHEDULE EVERY 1 SECOND STARTS '2023-10-13 18:38:41' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
	UPDATE hospedajes 
	
	SET 
		estado = 0, 
		inicio_estadia = NULL, 
		estadia = NULL, 
		id_usuario_inquilino = NULL 
	
	WHERE FROM_UNIXTIME(UNIX_TIMESTAMP(NOW())) >= estadia;
END//
DELIMITER ;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
