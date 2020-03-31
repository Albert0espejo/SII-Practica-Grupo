ALTER TABLE NOTICIAS DROP FOREIGN KEY FK_NOTICIAS_ONG_ID
ALTER TABLE ACTIVIDADES DROP FOREIGN KEY FK_ACTIVIDADES_ID_PROYECTO
ALTER TABLE SOLICITUD DROP FOREIGN KEY FK_SOLICITUD_PROYECTO_ID_PROYECTO
ALTER TABLE SOLICITUD DROP FOREIGN KEY FK_SOLICITUD_UNIVERSIDAD_ID_UNIVERSIDAD
ALTER TABLE USUARIO DROP FOREIGN KEY FK_USUARIO_UNIVERSIDAD_ID_UNIVERSIDAD
ALTER TABLE ALUMNO DROP FOREIGN KEY FK_ALUMNO_ID
ALTER TABLE ONG DROP FOREIGN KEY FK_ONG_ID
ALTER TABLE PAS DROP FOREIGN KEY FK_PAS_ID
ALTER TABLE PDI DROP FOREIGN KEY FK_PDI_ID
ALTER TABLE VOLUNTARIADO DROP FOREIGN KEY FK_VOLUNTARIADO_ID_PROYECTO
ALTER TABLE PROYECTO_ONG DROP FOREIGN KEY FK_PROYECTO_ONG_proyecto_ID_PROYECTO
ALTER TABLE PROYECTO_ONG DROP FOREIGN KEY FK_PROYECTO_ONG_ong_ID
DROP TABLE NOTICIAS
DROP TABLE PROYECTO
DROP TABLE ACTIVIDADES
DROP TABLE SOLICITUD
DROP TABLE USUARIO
DROP TABLE ALUMNO
DROP TABLE ONG
DROP TABLE PAS
DROP TABLE PDI
DROP TABLE UNIVERSIDAD
DROP TABLE VOLUNTARIADO
DROP TABLE PROYECTO_ONG
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
