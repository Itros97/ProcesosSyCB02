# ProcesosSyCB02
-Paso 1 (En la consola SQL del XAMPP en el localhost)
CREATE DATABASE EStoreDB;
CREATE USER IF NOT EXISTS 'root'@'localhost' IDENTIFIED BY 'root';
GRANT ALL ON EStoreDB.* TO 'root'@'localhost';
-Paso 2
Una vez encima de la carpeta del proyecto
En la cmd "mvn clean compile"
-Paso 3
Introduce el comando:
"mvn datanucleus:schema-create"
-Paso 4
Introduce el comando
