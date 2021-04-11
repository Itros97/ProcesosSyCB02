package com.util;

import com.db.ConexionDB;
import com.jdo.Usuario;
import com.ui.mainVShop;

import java.sql.*;

public class UsuarioDB {

    //CREAR
    protected static void crearTablaUsuario(Connection con) {
        // TODO Auto-generated method stub
        PreparedStatement preparedStatement = null;

        //TABLA USUARIO
        String createUsuario = "CREATE TABLE USUARIO(" +
                "CORREOELECTRONICO VARCHAR(50) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(50)  NOT NULL," +
                "NICKNAME VARCHAR(50)  NOT NULL," +
                "PASSWORD VARCHAR(50) NOT NULL," +
                "APELLIDO1 VARCHAR(50)  NOT NULL," +
                "APELLIDO2 VARCHAR(50)  NOT NULL," +
                "CALLE VARCHAR(250)," +
                "TARJETA_CREDITO VARCHAR(50)," +
                "TIPO_CUENTA BOOLEAN);";
        try {

            preparedStatement = con.prepareStatement(createUsuario);
            preparedStatement.executeUpdate();
            System.out.println("Tabla USUARIO creada correctamente.");

        } catch (Exception e) {
            System.err.println("Error al crear la tabla" +e+ "");
        }
    }
    
    //ELIMINAR TABLA
    protected static void eliminarTablaUsuario(Connection con) {

        PreparedStatement preparedStatement = null;

        String EliminarUsuario= "DROP TABLE IF EXISTS USUARIO";
        try {
            preparedStatement = con.prepareStatement(EliminarUsuario);
            preparedStatement.executeUpdate();

            System.out.println("Tabla USUARIO eliminada correctamente.");

        } catch (Exception e) {
            System.err.println("Tabla usuario no ha podido crearse : "+e);
        }
    }

    //INSERTAR USUARIO

    public static void insertarUsuarios(Usuario nuevoUsuario)
    {
        //Puede que sea necesarario efectuar algunos cambios en estas sentencias
        //ya que esto es SQL puro y estamos trabajando con JDO
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO USUARIO (NOMBRE,PASSWORD,APELLIDO1,APELLIDO2,CORREO,DIRECCION,TARJETADECREDITO, ISADMIN)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setString(1, nuevoUsuario.getNombre());
            preparedStatement.setString(2, nuevoUsuario.getPassword());
            preparedStatement.setString(3, nuevoUsuario.getApellido1());
            preparedStatement.setString(4, nuevoUsuario.getApellido2());
            preparedStatement.setString(5, nuevoUsuario.getCorreo());
            preparedStatement.setString(6, nuevoUsuario.getDireccion());
            preparedStatement.setInt(7, nuevoUsuario.getTarjetaCredito());
            preparedStatement.setBoolean(8, nuevoUsuario.isAdmin());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el usuario");
            System.out.println(e);
        }
    }


    //ELIMINAR USUARIO
    public static void eliminarUsuario(String correo) {

        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM USUARIO WHERE CORREO = '" + correo + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el usuario");
            System.out.println(e);
        }

    }

    //LOGIN

    public static boolean loginUsuario(String nickname, String password) {

        boolean comprobar = false;

        try{
            PreparedStatement preparedStatement;
            Connection con = ConexionDB.Conexion();

            String query = "SELECT PASSWORD FROM USUARIO WHERE NICKNAME = '" + nickname + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                if (resultSet.getString("PASSWORD").equals(password)) {
                    System.out.println("Si");
                    comprobar = true;
                    break;
                } else {
                    System.out.println("Contrasenya Incorrecta");
                }
            }

        }catch (Exception e){
            System.out.println("Ha ocurrido un ERROR");
            System.out.println(e);
        }
        if (comprobar == true) {
            System.out.println("Existe y la contrasenya concuerda,permitir el logeo");
            mainVShop window = new mainVShop();
        }
        return comprobar;
    }

}
