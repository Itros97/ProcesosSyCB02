# ProcesosSyCB02

**Crear la base de datos y darle permisos a un usuario**

    CREATE DATABASE EStoreDB;

    CREATE DATABASE EStoreDB;
    CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
    GRANT ALL ON EStoreDB.* TO 'spq'@'localhost';

**Compilar el proyecto**

    "mvn clean"
    "mvn compile"
    "mvn datanucleus:enhance"
    

**Crear las tablas de la base de datos**

    "mvn datanucleus:schema-create"

**Testear el proyecto**

	//En la primera ocasion que se ejecute dará error
	//A la segunda funcionará correctamente
    "mvn test"
    

**Datos de prueba**

    "mvn -Pdatos exec:java"

**Lanzar servidor cliente**

*4.1-Lanzar server*

    "mvn exec:java"

*4.2-Lanzar cliente*

    "mvn -Pcliente exec:java" 
