use gadb;

INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('EIF', 'Bachillerato', 'Informatica');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('ETE', 'Bachillerato', 'Administracion');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('DAB', 'Bachillerato', 'Danza');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('AEB', 'Bachillerato', 'Arte Escenico');
INSERT INTO `gadb`.`carrera` (`codigo`, `titulo`, `nombre`) VALUES ('MCA', 'Bachillerato', 'Canto');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF200', 'EIF', '2020', 'I', 'Fundamentos de informatica', '3', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF204', 'EIF', '2020', 'I', 'Programacion II', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF206', 'EIF', '2020', 'I', 'Estructuras de datos', '4', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF208', 'EIF', '2020', 'II', 'Programacion III', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('EIF210', 'EIF', '2020', 'II', 'Administracion de bases de datos', '4', '6');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB001', 'AEB', '2020', 'I', 'Expresion Escenica I', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB002', 'AEB', '2020', 'I', 'Elementos de Dramaturgia', '3', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB003', 'AEB', '2020', 'I', 'Taller de Experimentacion', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB004', 'AEB', '2020', 'II', 'Seminario de investigacion I', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB005', 'AEB', '2020', 'II', 'Metodos de investigación en las Artes Escenicas', '3', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('AEB006', 'AEB', '2020', 'II', 'Modulo I: Puesta en escena/plastica/dramaturgia', '5', '12');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB001', 'DAB', '2020', 'II', 'Taller de Expresion y Composicion IV', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB002', 'DAB', '2020', 'II', 'Seminario de Estilos de la Danza', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB003', 'DAB', '2020', 'I', 'DISEÑO DE VESTUARIO PARA LAS ARTES ESCENICAS', '3', '4');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB004', 'DAB', '2020', 'I', 'MONTAJE E INTERPRETACION ESCENICA', '5', '12');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('DAB005', 'DAB', '2020', 'II', 'Taller de Danzas Costarricenses', '5', '12');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE01', 'ETE', '2020', 'I', 'Desarrollo Socio-economico de Costa Rica', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE02', 'ETE', '2020', 'I', 'Paradigmas Administrativos', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE03', 'ETE', '2020', 'I', 'Finanzas Empresariales', '4', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE04', 'ETE', '2020', 'II', 'Administracion y Ambiente', '3', '6');
INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('ETE05', 'ETE', '2020', 'II', 'Contabilidad Intermedia', '5', '8');

INSERT INTO `gadb`.`curso` (`codigo`, `carrera_codigo`, `anio`, `ciclo`, `nombre`, `creditos`, `horas_semanales`) VALUES ('MCA12', 'MCA', '2020', 'I', 'Introduccion al Lied', '5', '12');

INSERT INTO `gadb`.`usuario` (`cedula`, `contrasena`) VALUES ('402370159', '123456');
INSERT INTO `gadb`.`usuario` (`cedula`, `contrasena`) VALUES ('117280151', '12345');

UPDATE `gadb`.`usuario` SET `nombre` = 'Felipe' WHERE (`cedula` = '117280151');
UPDATE `gadb`.`usuario` SET `nombre` = 'Carlos' WHERE (`cedula` = '402370159');
