package com.jdo;

import javax.jdo.annotations.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;

import com.db.ConexionDB;

@PersistenceCapable
public class Usuario {

    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    protected int idUsuario;
    //Otros valores
    protected String nombre;
    protected String nickname;
    protected String password;
    protected String apellido1;
    protected String apellido2;
    protected String correo;
    protected String direccion;
    protected int tarjetaCredito;
    protected boolean isAdmin;

    public Usuario(String nombre, String nickname, String password, String apellido1, String apellido2, String correo, String direccion, int tarjetaCredito, boolean isAdmin) {
        this.password = password;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.direccion = direccion;
        this.tarjetaCredito = tarjetaCredito;
        this.isAdmin = isAdmin;
    }

    public Usuario() {
        this.idUsuario = 0;
        this.nickname = "";
        this.password= "";
        this.nombre = "";
        this.apellido1 = "";
        this.apellido2 = "";
        this.correo = "";
        this.direccion = "";
        this.tarjetaCredito = 0;
        this.isAdmin = false;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTarjetaCredito() {
        return tarjetaCredito;
    }

    public void setTarjetaCredito(int tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public static Usuario getUsuario(String nickname)
    {
        Usuario user = new Usuario();
        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = "SELECT NICKNAME,PASSWORD,TIPO_CUENTA FROM USUARIO WHERE NICKNAME = '" + nickname + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                if(resultSet.getString("NICKNAME").equals(nickname))
                {
                    user.setNickname(nickname);
                    user.setPassword(resultSet.getString("PASSWORD"));
                }
                else
                {
                    System.err.println("Usuario Incorrecto");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        System.out.println(user.getNickname());
        System.out.println(user.getPassword());
        return user;
    }

    public static void InsertarUsuarios(Usuario nuevoUsuario)
    {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO USUARIO (NOMBRE,NICKNAME,PASSWORD,APELLIDO1,APELLODO2,CORREO,DIRECCION,TARJETACREDITO)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, nuevoUsuario.getNombre());
            preparedStatement.setString(2, nuevoUsuario.getNickname());
            preparedStatement.setString(3, nuevoUsuario.getPassword());
            preparedStatement.setString(4, nuevoUsuario.getApellido1());
            preparedStatement.setString(5, nuevoUsuario.getApellido2());
            preparedStatement.setString(6, nuevoUsuario.getCorreo());
            preparedStatement.setString(7, nuevoUsuario.getDireccion());
            preparedStatement.setInt(8, nuevoUsuario.getTarjetaCredito());
            preparedStatement.execute();

            System.out.println("Operacion existosa");
            ConexionDB.loggerBD.log(Level.INFO, "Nuevo usuario: "+nuevoUsuario.getNickname()+ "creado");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un ERROR");
            System.out.println(e);
        }
    }
}
