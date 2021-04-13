# ProcesosSyCB02
-Paso 1 (En la consola SQL del XAMPP en el localhost)(Crear BD y superuser)
CREATE DATABASE EStoreDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON EStoreDB.* TO 'spq'@'localhost';
-Paso 2 (Compilar proyecto)
Una vez encima de la carpeta del proyecto
En la cmd "mvn clean compile"
-Paso 3 (Crear tablas)
Introduce el comando:
"mvn datanucleus:schema-create"
(Tambien se puede hacer en la pestaña maven del proyecto)
-Paso 4
Introduce el comando
