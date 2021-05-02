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
            	
            	String correo = resultSet.getString("CORREO");
            	String ape1 = resultSet.getString("APELLIDO1");
            	String ape2 = resultSet.getString("APELLIDO2");
            	String dir = resultSet.getString("DIRECCION");
            	Boolean ad = resultSet.getBoolean("ISADMIN");
            	String ni = resultSet.getString("NICKNAME");
            	String no = resultSet.getString("NOMBRE");
            	String p = resultSet.getString("PASSWORD");
            	int t = resultSet.getInt("TARJETACREDITO");
            	
                Usuario n1= new Usuario(p, ni, no, ape1, ape2, correo, dir, t, ad);
                System.out.println(n1.toString());
                
                usuarioslist.add(n1);
            }
            for (int i = 1; i <usuarioslist.size(); i++) {
                System.out.println("Vuelta n: "+i);

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    

    
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM USUARIO";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next())
            {
              count++;
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        return count;
    }
}