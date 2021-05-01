package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import com.cliente.ui.MainVShop;
import javax.swing.JOptionPane;

import com.cliente.jdo.Usuario;
import com.cliente.ui.MainVShop;

public class UsuarioDB {
	
	public static boolean correcto;

    //CREAR
    protected static void crearTablaUsuario(Connection con) {
        // TODO Auto-generated method stub
        PreparedStatement preparedStatement = null;

        //TABLA USUARIO
        String createUsuario = "CREATE TABLE USUARIO(" +
                "CORREO VARCHAR(50) PRIMARY KEY NOT NULL," +
                "NOMBRE VARCHAR(50)  NOT NULL," +
                "NICKNAME VARCHAR(50)  NOT NULL," +
                "PASSWORD VARCHAR(50) NOT NULL," +
                "APELLIDO1 VARCHAR(50)  NOT NULL," +
                "APELLIDO2 VARCHAR(50)  NOT NULL," +
                "DIRECCION VARCHAR(250)," +
                "TARJETA_CREDITO VARCHAR(50)," +
                "ISADMIN BOOLEAN);";
        try {

            preparedStatement = con.prepareStatement(createUsuario);
            preparedStatement.executeUpdate();
            System.out.println("Tabla USUARIO creada correctamente.");

        } catch (Exception e) {
            System.err.println("Error al crear la tabla" + e + "");
        }
    }

    //ELIMINAR TABLA
    protected static void eliminarTablaUsuario(Connection con) {

        PreparedStatement preparedStatement = null;

        String EliminarUsuario = "DROP TABLE IF EXISTS USUARIO";
        try {
            preparedStatement = con.prepareStatement(EliminarUsuario);
            preparedStatement.executeUpdate();

            System.out.println("Tabla USUARIO eliminada correctamente.");

        } catch (Exception e) {
            System.err.println("Tabla usuario no ha podido crearse : " + e);
        }
    }

    //INSERTAR USUARIO

    public static void insertarUsuarios(Usuario nuevoUsuario) {
        //Puede que sea necesarario efectuar algunos cambios en estas sentencias
        //ya que esto es SQL puro y estamos trabajando con JDO
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO USUARIO (CORREO,NOMBRE,NICKNAME,PASSWORD,APELLIDO1,APELLIDO2,DIRECCION,TARJETACREDITO, ISADMIN)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, nuevoUsuario.getCorreo());
            preparedStatement.setString(2, nuevoUsuario.getNombre());
            preparedStatement.setString(3, nuevoUsuario.getNickname());
            preparedStatement.setString(4, nuevoUsuario.getPassword());
            preparedStatement.setString(5, nuevoUsuario.getApellido1());
            preparedStatement.setString(6, nuevoUsuario.getApellido2());
            preparedStatement.setString(7, nuevoUsuario.getDireccion());
            preparedStatement.setInt(8, nuevoUsuario.getTarjetaCredito());
            preparedStatement.setBoolean(9, nuevoUsuario.isAdmin());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el usuario");
            System.out.println(e);
        }
    }


    //ELIMINAR USUARIO
    public static void eliminarUsuario(String correo) {

        PreparedStatement preparedStatement = null;
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
    public static boolean LoginUsuario(String nickname, String password) {
    	
    	correcto = false;
        boolean comprobar = false;

        try {
            PreparedStatement preparedStatement;
            Connection con = ConexionDB.Conexion();

            String query = "SELECT PASSWORD FROM USUARIO WHERE NICKNAME = '" + nickname + "'";

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                if (resultSet.getString("PASSWORD").equals(password)) {
                    System.out.println("Si");
                    if (getUsuario(nickname).isAdmin() == true) {
                        //Tengo que hacer el enable del boton Administrar
                        System.out.println("Es Admin");
                    } else {
                        System.out.println("No es admin");
                    }
                    comprobar = true;
                    break;
                } else {
                    System.out.println("Contrasenya Incorrecta");
                    JOptionPane.showMessageDialog(null, "EMAIL O CONTRASENYA INCORRECTAS");
                }
            }
        } catch (Exception e) {
            System.out.println("A ocurrido un ERROR");
            System.out.println(e);
        }
        if (comprobar == true) {
            System.out.println("Existe y la contrasenya concuerda,permitir el logeo");

           correcto = true;
           MainVShop.main(null);
          
        
        } else {
            System.out.println("Problema de conexion");
        }
        //Unicamente para ver que esto es cierto
        return comprobar;
    }

    /*
        public static boolean loginUsuario(String nickname, String password) {

            boolean comprobar = false;
            System.out.println("Voy a entrar por el try");
            try{
                PreparedStatement preparedStatement = null;
                Connection con = ConexionDB.Conexion();

                String query = "SELECT PASSWORD FROM USUARIO WHERE NICKNAME = '" + nickname + "'";
                System.out.println("Se va a ejecutar query");

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


                com.cliente.ui.MainVShop window = new com.cliente.ui.MainVShop();
                window.setVisible(true);
                window.setTitle("Tienda");
                window.setBounds(100, 100, 1280, 720);

            }
            return comprobar;
        }
        */
    //Obtener usuario logeado
    public static Usuario getUsuario(String correo) {
        Usuario user = new Usuario();
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = "SELECT NICKNAME,PASSWORD,ISADMIN FROM USUARIO WHERE CORREO = '" + correo + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("CORREO").equals(correo)) {
                    user.setNickname(correo);
                    user.setPassword(resultSet.getString("PASSWORD"));
                    user.setAdmin(resultSet.getBoolean("ISADMIN"));
                } else {
                    System.err.println("No hay usuario asi");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(user.getNickname());
        System.out.println(user.getPassword());
        System.out.println(user.isAdmin());
        return user;
    }

    public static void getAllUsers (ArrayList<Usuario>usuarioslist) {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();

        try {
            String query = "SELECT * FROM USUARIO";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
                Usuario n1= new Usuario();

                usuarioslist.add(n1);
            }
            for (int i = 1; i <usuarioslist.size(); i++) {
                System.out.println("Vuelta n: "+i);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}