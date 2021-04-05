package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
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
}
