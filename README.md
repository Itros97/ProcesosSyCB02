# ProcesosSyCB02

-Paso 1 (En la consola SQL del XAMPP en el localhost)(Crear BD y superuser)
//Si se usa el de defecto(root sin password)
CREATE DATABASE EStoreDB;

//Si se usa usuario creado(spq y password spq)(Hay que cambiar en ConexionDB y Datanucleus, el user y password)
//Linea 29 en ConexionesBD y en datanucleus 11 y12
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

-Paso 4 (Lanzar servidor y cliente)
4.1-Lanzar server
"mvn exec:java"
4.2-Lanzar cliente
"mvn -Pcliente exec:java" 
