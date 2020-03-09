-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-03-2020 a las 13:59:24
-- Versión del servidor: 10.4.8-MariaDB
-- Versión de PHP: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "-03:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cineapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banners`
--

CREATE TABLE `banners` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `status` enum('Activo','Inactivo') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `banners`
--

INSERT INTO `banners` (`id`, `titulo`, `fecha`, `archivo`, `status`) VALUES
(1, 'Estreno - Kong La Isla Calavera', '2017-07-27', 'slide1.jpg', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles`
--

CREATE TABLE `detalles` (
  `id` int(11) NOT NULL,
  `director` varchar(100) DEFAULT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `sinopsis` text DEFAULT NULL,
  `trailer` varchar(255) DEFAULT NULL COMMENT 'URL del video en Youtube\n'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalles`
--

INSERT INTO `detalles` (`id`, `director`, `actores`, `sinopsis`, `trailer`) VALUES
(1, 'Jordan Vogt-Roberts', 'Samuel L. Jackson,Tom Hiddleston,Brie Larson,Toby Kebbell', 'Kong: La Isla Calavera reimagina el origen del mítico Kong en una irresistible aventura original del director Jordan Vogt-Roberts. En la película, un diverso equipo de exploradores es reunido para aventurarse en el interior de una isla del Pacífico tan bella como traicionera que no aparece en los mapas, sin saber que están invadiendo los dominios del mítico Kong. soreton', 'https://www.youtube.com/embed/86jhW2gPc84'),
(2, 'Daniel Espinosa', 'Jake Gyllenhaal, Ryan Reynolds, Rebecca Ferguson', 'Seis miembros de la tripulación de la Estación Espacial Internacional que están a punto de lograr uno de los descubrimientos más importantes en la historia humana: la primera evidencia de vida extraterrestre en Marte. A medida que el equipo comienza a investigar y sus métodos tienen consecuencias inesperadas, la forma viviente demostrará ser más inteligente de lo que cualquiera esperaba.', 'https://www.youtube.com/embed/_cq1XIVXdjU'),
(3, 'Bill Condon', 'Dan Stevens,Emma Watson,Luke Evans', 'LA BELLA Y LA BESTIA, de Disney, es una adaptación de acción real de la película animada, que revive a los queridos personajes del clásico cuento de Disney para una audiencia contemporánea, manteniendo la música original e incorporando varias nuevas canciones.', 'https://www.youtube.com/embed/4D8N06nx9rs'),
(4, 'Oriol Paulo', 'Mario Casas, Bárbara Lennie, José Coronado, Ana Wagener', 'Adrián Doria, un joven y exitoso empresario, despierta en la habitación de un hotel junto al cadáver de su amante. Acusado de asesinato, decide contratar los servicios de Virginia Goodman, la mejor preparadora de testigos del país. En el transcurso de una noche, asesora y cliente trabajarán para encontrar una duda razonable que le libre de la cárcel.', 'https://www.youtube.com/embed/sOxy2gtPY7A'),
(7, 'James Gunn', 'Dave Bautista,Bradley Cooper,Zoe Saldana,Vin Diesel,Chris Pratt', 'Ambientada en el nuevo contexto sonoro de \"Awesome Mixtape #2\", GUARDIANES DE LA GALAXIA VOL. 2, de Marvel, continua las aventuras del equipo en su travesia por los confines del cosmos. Los Guardianes deberan luchar para mantener unida a su nueva familia mientras intentan resolver el misterio del verdadero linaje de Peter Quill. Viejos rivales se convertiran en nuevos aliados y los personajes favoritos de los comics clasicos acudiran en ayuda de nuestros heroes a medida que el Universo Cinematografico de Marvel continua expandiendose.', 'https://www.youtube.com/embed/bBTtlcJwjSo'),
(8, 'sd', '2323', 'ss', 'https://www.youtube-nocookie.com/embed/OG4MmiBVQ5k'),
(9, 'cccc', 'sdsd', 'asdsddddd', 'https://youtu.be/YvBszQZge6c'),
(10, '333', '2323', '333333333333', 'https://youtu.be/YvBszQZge6c'),
(11, 'dd', 'Solomeo', 'ddddd', 'https://www.youtube.com/watch?v=HtEFCxsCdCM'),
(17, 'dd', '2323', 'ssssssss', 'https://www.youtube.com/embed/YvBszQZge6c');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horarios`
--

CREATE TABLE `horarios` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp(),
  `hora` time NOT NULL,
  `sala` varchar(100) NOT NULL,
  `precio` double NOT NULL DEFAULT 0,
  `idPelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `horarios`
--

INSERT INTO `horarios` (`id`, `fecha`, `hora`, `sala`, `precio`, `idPelicula`) VALUES
(1, '2020-02-21', '18:00:00', 'Premium', 55, 3),
(2, '2020-02-13', '18:00:00', 'Premium', 55, 3),
(3, '2020-02-13', '21:00:00', 'Premium', 55, 3),
(4, '2020-02-13', '18:00:00', 'Premium', 65, 4),
(5, '2020-02-13', '21:00:00', 'Premium', 65, 4),
(11, '2020-02-13', '14:00:00', 'Sala 1', 60, 2),
(12, '2020-02-13', '16:00:00', 'Sala 1', 60, 2),
(13, '2020-02-13', '14:00:00', 'Sala 1', 55, 3),
(14, '2020-02-13', '16:00:00', 'Sala 1', 55, 3),
(15, '2020-02-13', '14:00:00', 'Sala 1', 65, 4),
(16, '2020-02-13', '16:00:00', 'Sala 1', 65, 4),
(22, '2020-02-13', '17:00:00', 'Sala 2', 55, 3),
(23, '2020-02-13', '17:00:00', 'Sala 2', 65, 4),
(26, '2020-02-13', '16:00:00', 'Sala 3', 55, 3),
(27, '2020-02-13', '16:00:00', 'Sala 3', 65, 4),
(32, '2020-02-14', '18:00:00', 'Premium', 55, 3),
(33, '2020-02-14', '21:00:00', 'Premium', 55, 3),
(34, '2020-02-14', '18:00:00', 'Premium', 65, 4),
(35, '2020-02-14', '21:00:00', 'Premium', 65, 4),
(40, '2020-02-14', '14:00:00', 'Sala 1', 60, 2),
(41, '2020-02-14', '16:00:00', 'Sala 1', 60, 2),
(42, '2020-02-14', '14:00:00', 'Sala 1', 55, 3),
(43, '2020-02-14', '16:00:00', 'Sala 1', 55, 3),
(44, '2020-02-14', '14:00:00', 'Sala 1', 65, 4),
(45, '2020-02-14', '16:00:00', 'Sala 1', 65, 4),
(47, '2020-02-14', '17:00:00', 'Sala 2', 55, 3),
(48, '2020-02-14', '17:00:00', 'Sala 2', 65, 4),
(50, '2020-02-14', '16:00:00', 'Sala 3', 55, 3),
(51, '2020-02-14', '16:00:00', 'Sala 3', 65, 4),
(55, '2020-02-15', '20:00:00', 'Premium', 60, 2),
(59, '2020-02-15', '17:00:00', 'Sala 1', 60, 2),
(60, '2020-02-15', '19:00:00', 'Sala 1', 60, 2),
(61, '2020-02-15', '21:00:00', 'Sala 1', 60, 2),
(65, '2020-02-15', '16:00:00', 'Sala 2', 60, 2),
(71, '2020-02-15', '22:00:00', 'Sala 3', 60, 2),
(221, '2020-02-21', '18:00:00', 'Premium', 55, 3),
(455, '2020-02-28', '18:00:00', 'Premium', 55, 3),
(2321, '2020-02-21', '18:00:00', 'Premium', 55, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `noticias`
--

CREATE TABLE `noticias` (
  `id` int(11) NOT NULL,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `detalle` text NOT NULL,
  `status` enum('Activa','Inactiva') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `noticias`
--

INSERT INTO `noticias` (`id`, `titulo`, `fecha`, `detalle`, `status`) VALUES
(1, 'Tony Gilroy dirigirá Matusalén', '2017-09-02', 'Warner Bros. Pictures ha iniciado las negociaciones con Tony Gilroy (High Wire Act) para que escriba y dirija un thriller conocido hasta el momento como Methuselah.', 'Activa'),
(2, 'Guionista para Maléfica 2', '2017-09-02', 'Disney Pictures ha contratado a Jez Butterworth ( I Feel Good) para que re-escriba el guión de la secuela de Maléfica.', 'Activa'),
(3, 'Jon Bernthal se une a First Man', '2017-09-02', 'Jon Bernthal (Baby Driver) se pondrá a las órdenes de Damien Chazelle en la película de Universal Pictures y Amblin Entertainment First Man.', 'Inactiva'),
(4, 'Barry Seal: El traficante', '2017-09-02', 'El proximo mes se estrena la pelicula Barry Seal: El traficante. Nuevamente veremos a Tom Cruise.', 'Activa'),
(5, 'Ben Affleck podría dirigir Red Platoon', '2017-09-03', 'Ben Affleck (Liga de la justicia) ha iniciado las conversaciones con Sony Pictures, Immersive Pictures y Smokehouse Pictures para dirigir el drama bélico Red Platoon.', 'Activa'),
(6, 'Disney prepara una película sobre Obi-Wan Kenobi', '2017-09-03', 'Disney y Lucasfilm está preparando un nuevo spin-off de Star Wars, esa vez centrado en el personaje de Obi-Wan Kenobi.', 'Inactiva'),
(7, 'Primer vistazo a Cable y Domino en Deadpool 2', '2017-09-03', 'Se han publicado en las redes sociales las primeras fotografías de Zazie Beetz en el papel de Neena Thurman / Domino y Josh Brolin como Cable en la esperada Deadpool 2.', 'Activa'),
(8, 'Pedro Pascal se une a The Equalizer 2', '2017-09-03', 'Pedro Pascal (La Gran Muralla) participará en la secuela de la película de Sony Pictures The Equalizer: El Protector.', 'Activa'),
(9, 'Más reparto para Skyscraper', '2017-09-03', 'Chin Han (Ghost In the Shell) acompañará a Dwayne Johnson en el thriller de acción de Legendary Skyscraper.', 'Inactiva'),
(16, 'Tony Gilroy dirigirá Matusalén', '2020-10-02', 'Warner Bros. Pictures ha iniciado las negociaciones con Tony Gilroy (High Wire Act) para que escriba y dirija un thriller conocido hasta el momento como Methuselah.', 'Activa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `peliculas`
--

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `clasificacion` enum('A','B','C','D') NOT NULL,
  `genero` varchar(45) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `fechaEstreno` date NOT NULL,
  `status` enum('Activa','Inactiva') NOT NULL DEFAULT 'Activa',
  `idDetalle` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `peliculas`
--

INSERT INTO `peliculas` (`id`, `titulo`, `duracion`, `clasificacion`, `genero`, `imagen`, `fechaEstreno`, `status`, `idDetalle`) VALUES
(2, 'Life: Vida Inteligente', 104, 'B', 'Drama', 'life.png', '2018-03-06', 'Activa', 2),
(3, 'La Bella y La Bestia', 132, 'A', 'Infantil', 'bella.png', '2018-03-07', 'Activa', 3),
(4, 'Contratiempo', 106, 'B', 'Thriller', 'contratiempo.png', '2018-03-09', 'Activa', 4),
(17, 'PowerRanger', 3, 'C', 'Accion y Aventura', 'power-rangers.png', '2020-01-08', 'Activa', 17);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `perfiles`
--

CREATE TABLE `perfiles` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `perfil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `perfiles`
--

INSERT INTO `perfiles` (`id`, `username`, `perfil`) VALUES
(3, 'abc', 'EDITOR'),
(7, 'abcd', 'EDITOR'),
(8, 'abcdc', 'EDITOR'),
(6, 'chris', 'EDITOR'),
(1, 'marisol', 'GERENTE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `username`, `password`, `activo`, `email`, `telefono`) VALUES
(2, 'marisol', '$2a$10$fWux3K/fgOo0Mmv5bp3LAulN3S7drKbJD0U4iMYsN1odrAjmM3M2K', 1, '2323', '123213'),
(3, 'abc', '$2a$10$MlGOyZI5Lkgj/SM6L.cI7.uNP0y92SWLZYktTW6NiJC2KFSDvDBAa', 0, 'dd', 'dd'),
(8, 'chris', '$2a$10$2NIWVAE4wFuk/aHSSiCC2.g/n.ZHAxsSrgQoVSO516oD6dABhxK2C', 1, 'sss@sdsds.com', '34343'),
(12, 'abcd', '$2a$10$.ZgoonNNHWcIaT6GKbhCWOB1cbMwTW0wdGUaLPUX6oeUOR.4iSNAS', 1, 'dd', 'dd'),
(16, 'abcdc', '$2a$10$o4M7gd9OgQXWzZrVRzrB2Os4Yt/ElX.lFQsCxKLyeej0iUeywE6sC', 1, 'ddd', 'dd');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banners`
--
ALTER TABLE `banners`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalles`
--
ALTER TABLE `detalles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Horarios_Peliculas1_idx` (`idPelicula`);

--
-- Indices de la tabla `noticias`
--
ALTER TABLE `noticias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_Peliculas_Detalles1_idx` (`idDetalle`);

--
-- Indices de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cuenta_perfil_UNIQUE` (`username`,`perfil`),
  ADD KEY `fk_Usuarios_Perfil1` (`username`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `cuenta_UNIQUE` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `banners`
--
ALTER TABLE `banners`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `detalles`
--
ALTER TABLE `detalles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `horarios`
--
ALTER TABLE `horarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2322;

--
-- AUTO_INCREMENT de la tabla `noticias`
--
ALTER TABLE `noticias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1227;

--
-- AUTO_INCREMENT de la tabla `peliculas`
--
ALTER TABLE `peliculas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `perfiles`
--
ALTER TABLE `perfiles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `horarios`
--
ALTER TABLE `horarios`
  ADD CONSTRAINT `fk_Horarios_Peliculas1` FOREIGN KEY (`idPelicula`) REFERENCES `peliculas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Filtros para la tabla `peliculas`
--
ALTER TABLE `peliculas`
  ADD CONSTRAINT `fk_Peliculas_Detalles1` FOREIGN KEY (`idDetalle`) REFERENCES `detalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `perfiles`
--
ALTER TABLE `perfiles`
  ADD CONSTRAINT `fk_Usuarios_Perfil1` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`) ON DELETE CASCADE ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
