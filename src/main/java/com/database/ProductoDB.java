package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.cliente.jdo.Producto;
import com.cliente.jdo.Usuario;
import java.util.List;
import javax.swing.JList;

public class ProductoDB {

    //CREAR TABLA
    protected static void crearTablaProducto(Connection con) {

        PreparedStatement preparedStatement = null;

        //TABLA PRODUCTO
        String createProducto = "CREATE TABLE PRODUCTO(" +
                "IDPRODUCTO INTEGER PRIMARY KEY AUTO_INCREMENT," +
                "NOMBRE VARCHAR(50) NOT NULL," +
                "MARCA VARCHAR(20)," +
                "PRECIO DOUBLE NOT NULL," +
                "DESCRIPCION VARCHAR(300));";
        try {

            preparedStatement = con.prepareStatement(createProducto);
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error al crear la tabla" +e+ "");
        }
    }
    //ELIMINAR TABLA
    protected static void eliminarTablaProducto(Connection con) {

        PreparedStatement preparedStatement = null;

        String EliminarUsuario= "DROP TABLE IF EXISTS PRODUCTO";
        try {
            preparedStatement = con.prepareStatement(EliminarUsuario);
            preparedStatement.executeUpdate();

            System.out.println("Tabla PRODUCTO eliminada correctamente.");

        } catch (Exception e) {
            System.err.println("Tabla Producto no ha podido crearse : "+e);
        }
    }

    //INSERTAR PRODUCTO

    public static void insertarProducto(Producto nuevoProducto)
    {
        //Puede que sea necesarario efectuar algunos cambios en estas sentencias
        //ya que esto es SQL puro y estamos trabajando con JDO
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO PRODUCTO (IDPRODUCTO,NOMBRE,MARCA,PRECIO,DESCRIPCION)"
                    + " VALUES (?, ?, ?, ?, ?)";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.setInt(1, nuevoProducto.getIdProducto());
            preparedStatement.setString(2, nuevoProducto.getNombre());
            preparedStatement.setString(3, nuevoProducto.getMarca());
            preparedStatement.setFloat(4, nuevoProducto.getPrecio());
            preparedStatement.setString(5, nuevoProducto.getDescripcion());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar el producto");
            System.out.println(e);
        }
    }

    //SELECCIONAR PRODUCTO
    public static Producto seleccionarProducto(String nombre){
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            try {
                PreparedStatement pst = con.prepareStatement("SELECT * FROM PRODUCTO WHERE NOMBRE = '" + nombre + "'");
                ResultSet rs = pst.executeQuery();

                int id;
                String nom;
                String mar;
                float pre;
                String des;

                while(rs.next()) {
                	id = rs.getInt("IDPRODUCTO");
                    nom = rs.getString("NOMBRE");
                    mar = rs.getString("MARCA");
                    pre = rs.getFloat("PRECIO");
                    des = rs.getString("DESCRIPCION");


                    Producto e = new Producto(id, nom, mar, pre, des);
                    return e;

                }
                rs.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();

                return null;
            }

        } catch (Exception e) {
            System.out.println("ERROR al seleccionar el producto");
            System.out.println(e);
        }

        return null;
    }


    //ELIMINAR PRODUCTO
    public static void eliminarProducto(String nombre) {

        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM PRODUCTO WHERE NOMBRE = '" + nombre + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar el producto");
            System.out.println(e);
        }

    }

    public static void getAllProducts(ArrayList<Producto> productos) {

        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        

        int id;
        String des;
        String ma;
        String n;
        float pr;
        
        try{
            String query = "SELECT * FROM PRODUCTO";
            Statement statement = con.createStatement();
            ResultSet resulSet = statement.executeQuery(query);

            while (resulSet.next()){
            	id = resulSet.getInt("IDPRODUCTO");
            	des = resulSet.getString("DESCRIPCION");
            	ma = resulSet.getString("MARCA");
            	n = resulSet.getString("NOMBRE");
            	pr = resulSet.getFloat("PRECIO");
            	
            	
                Producto p = new Producto(n, ma, pr, des);
                productos.add(p);
                
            }

            for (int i = 1; i < productos.size(); i++){
                System.out.println("Numero de vueltas: " +i);
            }


        }catch (Exception e){

        }


    }
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM PRODUCTO";
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
