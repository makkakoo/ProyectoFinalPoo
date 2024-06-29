-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2023 a las 05:17:20
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
-- Base de datos: `bdproyectofinal`
--

DELIMITER $$
--
-- Funciones
--
CREATE DEFINER=`root`@`localhost` FUNCTION `codGeneradoDoctor` () RETURNS CHAR(4) CHARSET utf8mb4 COLLATE utf8mb4_general_ci  begin
	DECLARE num CHAR(4);
    DECLARE variable CHAR(4);
    SET variable = 'D001';
    while EXISTS (SELECT 1 FROM doctor WHERE CODIGO_DOCTOR = variable) do
		SELECT IFNULL(RIGHT(MAX(CODIGO_DOCTOR), 2), 00) + 1 INTO num FROM doctor;
        
        SET variable = CASE LENGTH(num) 
        				WHEN 1 THEN CONCAT('D00', num)
                        WHEN 2 THEN CONCAT('D0', num)
                        ELSE CONCAT('D', num) END;
    end while;
    RETURN VARIABLE;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `CODIGO_CITA` char(4) NOT NULL,
  `PACIENTE_DNI` char(8) NOT NULL,
  `PAGO` double(8,2) NOT NULL,
  `DESCUENTO` double(8,2) NOT NULL,
  `MOTIVO_CONSULTA` varchar(200) NOT NULL,
  `CODIGO_DOCTOR` char(4) NOT NULL,
  `CODIGO_HORARIO` varchar(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`CODIGO_CITA`, `PACIENTE_DNI`, `PAGO`, `DESCUENTO`, `MOTIVO_CONSULTA`, `CODIGO_DOCTOR`, `CODIGO_HORARIO`) VALUES
('C002', '988343', 0.00, 0.00, '2do chequeo de embarazo', 'D008', 'H013'),
('C003', '657849', 0.00, 45.00, 'das', 'D006', 'H010'),
('C004', '988343', 30.00, 30.00, 'Chequeo de embarazo', 'D008', 'H013'),
('C005', '999000', 0.00, 0.00, 'necesita ayuda rapido, tiene depresion', 'D010', 'H017');

--
-- Disparadores `cita`
--
DELIMITER $$
CREATE TRIGGER `trg_actualizar_cupos` AFTER INSERT ON `cita` FOR EACH ROW BEGIN
    DECLARE cuopos_actuales INT;
    
    -- Obtener los cuopos actuales del código_horario y codigo_doctor
    SELECT CUPOS INTO cuopos_actuales
    FROM DOCTOR_TURNO
    WHERE CODIGO_HORARIO = NEW.CODIGO_HORARIO
    AND CODIGO_DOCTOR = NEW.CODIGO_DOCTOR;
    
    -- Disminuir los cuopos en 1
    SET cuopos_actuales = cuopos_actuales - 1;
    
    -- Actualizar los cuopos en la tabla DOCTOR_TURNO
    UPDATE DOCTOR_TURNO
    SET CUPOS = cuopos_actuales
    WHERE CODIGO_HORARIO = NEW.CODIGO_HORARIO
    AND CODIGO_DOCTOR = NEW.CODIGO_DOCTOR;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_disminuir_cupos` AFTER DELETE ON `cita` FOR EACH ROW BEGIN
    UPDATE DOCTOR_TURNO
    SET CUPOS = CUPOS - 1
    WHERE CODIGO_DOCTOR = OLD.CODIGO_DOCTOR
    AND CODIGO_HORARIO = OLD.CODIGO_HORARIO;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `trg_generar_codigo_cita` BEFORE INSERT ON `cita` FOR EACH ROW BEGIN
    DECLARE last_code CHAR(4);
    DECLARE new_code CHAR(4);

    -- Obtener el último código de cita de la tabla
    SELECT CODIGO_CITA INTO last_code
    FROM CITA
    ORDER BY CODIGO_CITA DESC
    LIMIT 1;

    -- Verificar si hay registros en la tabla
    IF last_code IS NULL THEN
        SET new_code = 'C001'; -- Si no hay registros, el nuevo código es 'C001'
    ELSE
        SET new_code = CONCAT('C', LPAD(CAST(SUBSTRING(last_code, 2) AS INT) + 1, 3, '0'));
        -- Generar el nuevo código incrementando en 1 el último código existente
    END IF;

    -- Asignar el nuevo código de cita al nuevo registro
    SET NEW.CODIGO_CITA = new_code;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `doctor` (
  `CODIGO_DOCTOR` char(4) NOT NULL,
  `Persona_DNI` char(8) NOT NULL,
  `CODIGO_ESPE` char(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `doctor`
--

INSERT INTO `doctor` (`CODIGO_DOCTOR`, `Persona_DNI`, `CODIGO_ESPE`) VALUES
('D001', '71463441', 'E020'),
('D004', '9483', 'E002'),
('D005', '456457', 'E007'),
('D006', '5454567', 'E001'),
('D007', '883459', 'E001'),
('D008', '34574310', 'E004'),
('D009', '00120213', 'E001'),
('D010', '66666', 'E013');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor_turno`
--

CREATE TABLE `doctor_turno` (
  `CODIGO_HORARIO` char(4) NOT NULL,
  `CODIGO_DOCTOR` char(4) NOT NULL,
  `FECHA` date NOT NULL,
  `CUPOS` int(11) NOT NULL,
  `TURNO` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `doctor_turno`
--

INSERT INTO `doctor_turno` (`CODIGO_HORARIO`, `CODIGO_DOCTOR`, `FECHA`, `CUPOS`, `TURNO`) VALUES
('H006', 'D001', '2023-07-19', 10, 'Turno mañana'),
('H007', 'D004', '2023-07-19', 10, 'Turno mañana'),
('H008', 'D005', '2023-07-20', 10, 'Turno mañana'),
('H009', 'D005', '2023-07-20', 10, 'Turno Tarde'),
('H010', 'D006', '2023-07-21', 9, 'Turno Tarde'),
('H011', 'D007', '2023-07-17', 10, 'Turno mañana'),
('H013', 'D008', '2023-07-27', 8, 'Turno mañana'),
('H014', 'D009', '2023-07-20', 10, 'Turno mañana'),
('H015', 'D009', '2023-07-19', 10, 'Turno Tarde'),
('H016', 'D009', '2023-07-26', 10, 'Turno mañana'),
('H017', 'D010', '2023-12-25', 9, 'Turno mañana'),
('H018', 'D010', '2023-12-25', 10, 'Turno Tarde');

--
-- Disparadores `doctor_turno`
--
DELIMITER $$
CREATE TRIGGER `generar_codigo_horario` BEFORE INSERT ON `doctor_turno` FOR EACH ROW BEGIN
    DECLARE ult_codigo INT;
    DECLARE nuevo_codigo VARCHAR(4);
    
    -- Obtener el último código de horario
    SELECT SUBSTRING(MAX(CODIGO_HORARIO), 2) INTO ult_codigo FROM DOCTOR_TURNO;
    
    IF ult_codigo IS NULL THEN
        SET nuevo_codigo = 'H001';
    ELSE
        SET nuevo_codigo = CONCAT('H', LPAD(ult_codigo + 1, 3, '0'));
    END IF;
    
    -- Asignar el nuevo código de horario al nuevo registro
    SET NEW.CODIGO_HORARIO = nuevo_codigo;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especialidad`
--

CREATE TABLE `especialidad` (
  `CODIGO_ESPE` char(4) NOT NULL,
  `NOMBRE_ESPECIALIDAD` varchar(30) NOT NULL,
  `TARIFA` double(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`CODIGO_ESPE`, `NOMBRE_ESPECIALIDAD`, `TARIFA`) VALUES
('E001', 'TRAUMATOLOGÍA', 45.00),
('E002', 'CARDIOLOGÍA', 50.00),
('E003', 'DERMATOLOGÍA', 55.00),
('E004', 'GINECOLOGÍA', 60.00),
('E005', 'PEDIATRÍA', 40.00),
('E006', 'NEUROLOGÍA', 70.00),
('E007', 'OFTALMOLOGÍA', 55.00),
('E008', 'PSICOLOGÍA', 50.00),
('E009', 'UROLOGÍA', 65.00),
('E010', 'ODONTOLOGÍA', 45.00),
('E011', 'OTORRINOLARINGOLOGÍA', 60.00),
('E012', 'ENDOCRINOLOGÍA', 55.00),
('E013', 'PSIQUIATRÍA', 70.00),
('E014', 'NUTRICIÓN', 45.00),
('E015', 'GASTROENTEROLOGÍA', 60.00),
('E016', 'REUMATOLOGÍA', 55.00),
('E017', 'NEUMOLOGÍA', 50.00),
('E018', 'ONCOLOGÍA', 75.00),
('E019', 'FISIOTERAPIA', 40.00),
('E020', 'RADIOLOGÍA', 65.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `TIPO_SEGURO` varchar(25) NOT NULL,
  `DNI` char(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`TIPO_SEGURO`, `DNI`) VALUES
('Completo', '657849'),
('No tiene', '84365'),
('Parcial', '988343'),
('No tiene', '999000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `DNI` char(8) NOT NULL,
  `NOMBRE` varchar(30) NOT NULL,
  `APELLIDO` varchar(50) NOT NULL,
  `CELULAR` char(9) NOT NULL,
  `CORREO` varchar(60) NOT NULL,
  `DIRECCION` varchar(60) NOT NULL,
  `EDAD` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`DNI`, `NOMBRE`, `APELLIDO`, `CELULAR`, `CORREO`, `DIRECCION`, `EDAD`) VALUES
('00120213', 'Jose', 'Pelaez', '09876', '@@', 'direc', 45),
('34574310', 'Walter', 'Falcon', '9312458', '@@', 'direc', 23),
('456457', 'Dominith', 'Anton', '325', 'correo', 'direc', 54),
('5454567', 'Pancho', 'Rodriguez', '325468', '@@', 'dreic', 34),
('657849', 'Julio', 'Torres', '4236', 'correo', 'direc', 34),
('66666', 'Switch Antonio', 'Nya', '1235', '@@', 'direc', 36),
('71463441', 'Adrian', 'Cisneros', '952394993', 'ad@utp.edu.pe', 'direc', 19),
('7569248', 'Espiritu', 'Falcon', '123456789', '@@', 'DIREC', 20),
('84365', 'Monica', 'Torres', '3425', 'correo', 'direc', 29),
('883459', 'Zambo', 'Cavcero', '087', 'correo', 'direc', 54),
('9483', 'Walter', 'Falcon', '923432', 'correo', 'direc', 45),
('98765432', 'Mr Peet', 'Arevalo', '83627541', '@@', 'direcc', 53),
('988343', 'Gresly', 'Ruiz', '4575', 'correo', 'direc', 12),
('999000', 'Nya', 'Cortez', '0000', 'navaja@ayuda.com', 'depresion', 34),
('9999999', 'Dr', 'TV', '123', '@@', 'direcc', 49);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcionista`
--

CREATE TABLE `recepcionista` (
  `RecepCod` varchar(4) NOT NULL,
  `DNI` char(8) NOT NULL,
  `CodRecep` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `recepcionista`
--

INSERT INTO `recepcionista` (`RecepCod`, `DNI`, `CodRecep`) VALUES
('R001', '98765432', 'falcon'),
('R002', '7569248', 'falcon'),
('R003', '9999999', 'falcon');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`CODIGO_CITA`),
  ADD KEY `CITA_DOCTOR` (`CODIGO_DOCTOR`),
  ADD KEY `CITA_PACIENTE` (`PACIENTE_DNI`),
  ADD KEY `CODIGO_HORARIO` (`CODIGO_HORARIO`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`CODIGO_DOCTOR`),
  ADD KEY `DOCTOR_ESPECIALIDAD` (`CODIGO_ESPE`),
  ADD KEY `DOCTOR_Persona` (`Persona_DNI`);

--
-- Indices de la tabla `doctor_turno`
--
ALTER TABLE `doctor_turno`
  ADD PRIMARY KEY (`CODIGO_HORARIO`),
  ADD KEY `DOCTOR_TURNO_DOCTOR` (`CODIGO_DOCTOR`);

--
-- Indices de la tabla `especialidad`
--
ALTER TABLE `especialidad`
  ADD PRIMARY KEY (`CODIGO_ESPE`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`DNI`);

--
-- Indices de la tabla `recepcionista`
--
ALTER TABLE `recepcionista`
  ADD PRIMARY KEY (`RecepCod`),
  ADD KEY `RECEPCIONISTA_Persona` (`DNI`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `CITA_DOCTOR` FOREIGN KEY (`CODIGO_DOCTOR`) REFERENCES `doctor` (`CODIGO_DOCTOR`),
  ADD CONSTRAINT `CITA_PACIENTE` FOREIGN KEY (`PACIENTE_DNI`) REFERENCES `paciente` (`DNI`),
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`CODIGO_HORARIO`) REFERENCES `doctor_turno` (`CODIGO_HORARIO`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `doctor`
--
ALTER TABLE `doctor`
  ADD CONSTRAINT `DOCTOR_ESPECIALIDAD` FOREIGN KEY (`CODIGO_ESPE`) REFERENCES `especialidad` (`CODIGO_ESPE`),
  ADD CONSTRAINT `DOCTOR_Persona` FOREIGN KEY (`Persona_DNI`) REFERENCES `persona` (`DNI`);

--
-- Filtros para la tabla `doctor_turno`
--
ALTER TABLE `doctor_turno`
  ADD CONSTRAINT `DOCTOR_TURNO_DOCTOR` FOREIGN KEY (`CODIGO_DOCTOR`) REFERENCES `doctor` (`CODIGO_DOCTOR`);

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `PACIENTE_Persona` FOREIGN KEY (`DNI`) REFERENCES `persona` (`DNI`);

--
-- Filtros para la tabla `recepcionista`
--
ALTER TABLE `recepcionista`
  ADD CONSTRAINT `RECEPCIONISTA_Persona` FOREIGN KEY (`DNI`) REFERENCES `persona` (`DNI`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
