# ProcesosSyCB02

**Crear la base de datos y darle permisos a un usuario**

    CREATE DATABASE EStoreDB;

    CREATE DATABASE EStoreDB;
    CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
    GRANT ALL ON EStoreDB.* TO 'spq'@'localhost';

**Compilar el proyecto**

    "mvn clean compile"

**Crear las tablas de la base de datos**
    
    "mvn datanucleus:enhance"
    "mvn datanucleus:schema-create"

**Datos de prueba**

**Lanzar servidor cliente**

*4.1-Lanzar server*

    "mvn exec:java"

*4.2-Lanzar cliente*

    "mvn -Pcliente exec:java" 
