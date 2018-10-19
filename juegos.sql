CREATE TABLE `juegos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `consola` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `obtenido` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1
