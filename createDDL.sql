CREATE TABLE NOTICIAS (ID_NOTICIA BIGINT NOT NULL, AUTOR VARCHAR(255), FECHA_PUBLICACION DATE, TEXTO VARCHAR(255), TITULO VARCHAR(255), ONG_ID BIGINT, PRIMARY KEY (ID_NOTICIA))
CREATE TABLE PROYECTO (ID_PROYECTO BIGINT NOT NULL, DTYPE VARCHAR(31), DESCRIPCION VARCHAR(255), ESTADO VARCHAR(255), FECHA_FINAL DATE, FECHA_INICIO DATE, LUGAR VARCHAR(255), PRIMARY KEY (ID_PROYECTO))
CREATE TABLE ACTIVIDADES (ID_PROYECTO BIGINT NOT NULL, CAPACIDAD_ALUMNOS INTEGER, NOMBRE_ACTIVIDAD VARCHAR(255), RECONOCIMIENTOS VARCHAR(255), PRIMARY KEY (ID_PROYECTO))
CREATE TABLE SOLICITUD (ID_SOLICITUD BIGINT NOT NULL, ESTADO VARCHAR(255), PROYECTO_ID_PROYECTO BIGINT, UNIVERSIDAD_ID_UNIVERSIDAD BIGINT, PRIMARY KEY (ID_SOLICITUD))
CREATE TABLE USUARIO (ID BIGINT NOT NULL, DTYPE VARCHAR(31), CONTRASENA VARCHAR(255), CORREO VARCHAR(255), USUARIO VARCHAR(255), UNIVERSIDAD_ID_UNIVERSIDAD BIGINT, PRIMARY KEY (ID))
CREATE TABLE ALUMNO (ID BIGINT NOT NULL, ALUMNO VARCHAR(255), DNI VARCHAR(255), DESTINOS_DESEADOS VARCHAR(255), DIRECCION VARCHAR(255), IDIOMAS VARCHAR(255), NOMBRE VARCHAR(255), NUMERO_EXPEDIENTE INTEGER, PRIMARY KEY (ID))
CREATE TABLE ONG (ID BIGINT NOT NULL, DESCRIPCION VARCHAR(255), DIRECCION_WEB VARCHAR(255), NOMBRE VARCHAR(255), REPRESENTANTE VARCHAR(255), TELEFONO INTEGER, CITY VARCHAR(255), COUNTRY VARCHAR(255), STATE VARCHAR(255), STREET1 VARCHAR(255), STREET2 VARCHAR(255), ZIPCODE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PAS (ID BIGINT NOT NULL, FACULTAD VARCHAR(255), REPRESENTANTE VARCHAR(255), SERVICIO VARCHAR(255), TELEFONO VARCHAR(255), CITY VARCHAR(255), COUNTRY VARCHAR(255), STATE VARCHAR(255), STREET1 VARCHAR(255), STREET2 VARCHAR(255), ZIPCODE VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE PDI (ID BIGINT NOT NULL, APELLIDOS VARCHAR(255), DNI VARCHAR(255), DEPARTAMENTO VARCHAR(255), ES_GESTOR VARCHAR(255), NOMBRE VARCHAR(255), TELEFONO VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE UNIVERSIDAD (ID_UNIVERSIDAD BIGINT NOT NULL, DTYPE VARCHAR(31), CIUDAD VARCHAR(255), CODIGO_POSTAL BIGINT, DIRECCION_WEB VARCHAR(255), NOMBRE VARCHAR(255), CITY VARCHAR(255), COUNTRY VARCHAR(255), STATE VARCHAR(255), STREET1 VARCHAR(255), STREET2 VARCHAR(255), ZIPCODE VARCHAR(255), PRIMARY KEY (ID_UNIVERSIDAD))
CREATE TABLE VOLUNTARIADO (ID_PROYECTO BIGINT NOT NULL, NOMBRE_VOLUNTARIADO VARCHAR(255), PRIMARY KEY (ID_PROYECTO))
CREATE TABLE PROYECTO_ONG (ong_ID BIGINT NOT NULL, proyecto_ID_PROYECTO BIGINT NOT NULL, PRIMARY KEY (ong_ID, proyecto_ID_PROYECTO))
ALTER TABLE NOTICIAS ADD CONSTRAINT FK_NOTICIAS_ONG_ID FOREIGN KEY (ONG_ID) REFERENCES USUARIO (ID)
ALTER TABLE ACTIVIDADES ADD CONSTRAINT FK_ACTIVIDADES_ID_PROYECTO FOREIGN KEY (ID_PROYECTO) REFERENCES PROYECTO (ID_PROYECTO)
ALTER TABLE SOLICITUD ADD CONSTRAINT FK_SOLICITUD_PROYECTO_ID_PROYECTO FOREIGN KEY (PROYECTO_ID_PROYECTO) REFERENCES PROYECTO (ID_PROYECTO)
ALTER TABLE SOLICITUD ADD CONSTRAINT FK_SOLICITUD_UNIVERSIDAD_ID_UNIVERSIDAD FOREIGN KEY (UNIVERSIDAD_ID_UNIVERSIDAD) REFERENCES UNIVERSIDAD (ID_UNIVERSIDAD)
ALTER TABLE USUARIO ADD CONSTRAINT FK_USUARIO_UNIVERSIDAD_ID_UNIVERSIDAD FOREIGN KEY (UNIVERSIDAD_ID_UNIVERSIDAD) REFERENCES UNIVERSIDAD (ID_UNIVERSIDAD)
ALTER TABLE ALUMNO ADD CONSTRAINT FK_ALUMNO_ID FOREIGN KEY (ID) REFERENCES USUARIO (ID)
ALTER TABLE ONG ADD CONSTRAINT FK_ONG_ID FOREIGN KEY (ID) REFERENCES USUARIO (ID)
ALTER TABLE PAS ADD CONSTRAINT FK_PAS_ID FOREIGN KEY (ID) REFERENCES USUARIO (ID)
ALTER TABLE PDI ADD CONSTRAINT FK_PDI_ID FOREIGN KEY (ID) REFERENCES USUARIO (ID)
ALTER TABLE VOLUNTARIADO ADD CONSTRAINT FK_VOLUNTARIADO_ID_PROYECTO FOREIGN KEY (ID_PROYECTO) REFERENCES PROYECTO (ID_PROYECTO)
ALTER TABLE PROYECTO_ONG ADD CONSTRAINT FK_PROYECTO_ONG_proyecto_ID_PROYECTO FOREIGN KEY (proyecto_ID_PROYECTO) REFERENCES PROYECTO (ID_PROYECTO)
ALTER TABLE PROYECTO_ONG ADD CONSTRAINT FK_PROYECTO_ONG_ong_ID FOREIGN KEY (ong_ID) REFERENCES USUARIO (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
