-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-05-2023 a las 01:18:18
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `mec`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `id` int(11) NOT NULL,
  `documento` int(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `correo` varchar(150) NOT NULL,
  `telefono` int(20) NOT NULL,
  `empresa` varchar(150) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`id`, `documento`, `nombre`, `apellidos`, `correo`, `telefono`, `empresa`, `fecha`) VALUES
(1, 7, 'Crisitano', 'Ronaldo', 'cr7@gmail.com', 777, 'Al-Nassr', '2023-05-22 15:23:53'),
(6, 10, 'Lionel', 'Messi', 'm10@gmail.com', 1010, 'PSG', '2023-05-25 22:29:21'),
(7, 11, 'Neymar', 'Da Silva', 'n11@gmail.com', 111, 'PSG', '2023-05-27 14:09:42'),
(9, 9, 'Erling', 'Haaland', 'em9@gmail.com', 314, 'Man-City', '2023-05-30 14:58:31'),
(10, 7, 'Kylian', 'Mbappé', 'km7@gmail.com', 7070, 'PSG', '2023-05-30 18:12:48'),
(11, 94, 'Eladio', 'Carrión', 'eladio@gmail.com', 1994, 'U', '2023-05-30 18:14:37');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `id` int(11) NOT NULL,
  `documento` int(20) NOT NULL,
  `nombre` varchar(150) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `correo` varchar(150) NOT NULL,
  `telefono` int(20) NOT NULL,
  `cargo` varchar(150) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id`, `documento`, `nombre`, `apellidos`, `correo`, `telefono`, `cargo`, `fecha`) VALUES
(1, 1, 'Eder', 'Arévalo', 'eder@gmail.com', 301, 'Desarrollador', '2023-05-25 14:52:16'),
(5, 2, 'Kevin', 'Russo', 'kevin@gmail.com', 302, 'Desarrollador', '2023-05-25 15:26:35'),
(6, 3, 'Santiago', 'Cardenas', 'santiago@gmail.com', 303, 'Desarrollador', '2023-05-25 15:28:04'),
(7, 4, 'Edinson', 'Galindo', 'edinson@gmail.com', 304, 'Desarrollador', '2023-05-25 15:28:41'),
(8, 5, 'Antonio', 'Royero', 'antonio@gmail.com', 305, 'Desarrollador', '2023-05-25 15:29:05'),
(9, 6, 'Carlos', 'Ortiz', 'carlos@gmail.com', 310, 'Diseñador', '2023-05-25 15:29:52'),
(12, 7, 'Cristian', 'Urango', 'cristian@gmail.com', 315, 'Mantenimiento', '2023-05-25 23:41:18'),
(13, 8, 'Abraham', 'Grey', 'abraham@gmail.com', 322, 'Diseñador', '2023-05-27 12:21:06'),
(14, 9, 'Emanuel', 'Martinez', 'emanuel@gmail.com', 310, 'Analista', '2023-05-27 12:25:07'),
(15, 10, 'Idel', 'Iriarte', 'idel@gmail.com', 302, 'Analista', '2023-05-27 12:27:05'),
(18, 11, 'Camila', 'Portto', 'camila@gmail.com', 315, 'Gerente', '2023-05-30 18:05:55'),
(19, 12, 'Sthefanny', 'Ávila', 'sthefanny@gmail.com', 321, 'Recepcionista', '2023-05-30 18:06:35');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mantenimiento`
--

CREATE TABLE `mantenimiento` (
  `id` int(11) NOT NULL,
  `ninventario` int(20) NOT NULL,
  `idcliente` int(20) NOT NULL,
  `mantenimiento` varchar(150) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `modelo` varchar(100) NOT NULL,
  `serial` varchar(100) NOT NULL,
  `fechaentrada` varchar(100) NOT NULL,
  `fechasalida` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mantenimiento`
--

INSERT INTO `mantenimiento` (`id`, `ninventario`, `idcliente`, `mantenimiento`, `descripcion`, `marca`, `modelo`, `serial`, `fechaentrada`, `fechasalida`) VALUES
(1, 522, 2042, 'Correctivo', 'Daño en el HDD', 'Dell', 'Optiplex', '3020', '25/05/2023', '26/05/2023'),
(2, 523, 4545, 'Preventivo', 'Ordenador lento', 'Lenovo', 'Thinkpad', 'lntk', '27/05/2023', ''),
(3, 524, 2121, 'Correctivo', 'No da imagen', 'Huawei', 'Notebook D15', '1135G7', '30/05/2023', ''),
(4, 525, 1414, 'Correctivo', 'No funciona teclado', 'Razer', 'Blade 15', '4070', '30/05/2023', '31/05/2023');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `pass`) VALUES
(1, 'admin', 'admin', 'admin#01');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `mantenimiento`
--
ALTER TABLE `mantenimiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
