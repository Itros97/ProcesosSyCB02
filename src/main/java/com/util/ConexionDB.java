package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;
import com.util.ProductoDB;


public class ConexionDB {

    public final static Logger loggerBD = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    //CODIGO PARA LA CONEXION CON LA BASE DE DATOS
    public static Connection Conexion() {

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Conexion con la BD de XAMPP(EN MI CASO USO EL PUERTO 3307 EN VEZ DEL 3306 YA QUE NO ME DEJA ACCEDER A ESTE PRIMERO)
            //Lo que esta entre parentesis igual que el  datanuclus, user, password
            con = DriverManager.getConnection("jdbc:mysql://localhost:3307/EStoreDB", "root", "");

        } catch (Exception e) {


        }

        return con;
    }
    //CREACION DE LA BASE DE DATOS
    private void CrearBasesDeDatos(Connection con) {
        UsuarioDB.crearTablaUsuario(con);
        ProductoDB.crearTablaProducto(con);
        CompraDB.crearTablaCompra(con);

    }

    //ELIMINACION DE LA BASE DE DATOS
    private void BorrarBasesDeDatos(Connection con) {
        UsuarioDB.eliminarTablaUsuario(con);
        ProductoDB.eliminarTablaProducto(con);
        CompraDB.eliminarTablaCompra(con);
    }
}
