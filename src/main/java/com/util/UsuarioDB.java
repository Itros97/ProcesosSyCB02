package com.util;

import com.db.ConexionDB;
import com.jdo.Usuario;
import com.ui.mainVShop;

import java.sql.*;

public class UsuarioDB {

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
    public void eliminarUsuario(String correo) {

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
