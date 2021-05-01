package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cliente.jdo.Compra;

public class CompraDB {

    //CREAR TABLA COMPRA
    protected static void crearTablaCompra(Connection con) {
        // TODO Auto-generated method stub
        PreparedStatement preparedStatement = null;

        //TABLA USUARIO
        String createCompra = "CREATE TABLE COMPRA(" +
                "IDCOMPRA INTEGER AUTO_INCREMENT," +
                "CORREOELECTRONICO VARCHAR(50) NOT NULL," +
                "IDPRODUCTO INTEGER NOT NULL," +
                "PRIMARY KEY (IDCOMPRA,CORREOELECTRONICO,IDPRODUCTO)," +
                "CONSTRAINT FOREIGN KEY (CORREOELECTRONICO)" +
                "REFERENCES USUARIO (CORREOELECTRONICO)" +
                "ON DELETE CASCADE," +
                "CONSTRAINT FOREIGN KEY (IDPRODUCTO)" +
                "REFERENCES PRODUCTO (IDPRODUCTO)" +
                "ON DELETE CASCADE" +
                ");";
        try {

            preparedStatement = con.prepareStatement(createCompra);
            preparedStatement.executeUpdate();
            System.out.println("Tabla COMPRA creada correctamente.");

        } catch (Exception e) {
            System.err.println("Error al crear la tabla" +e+ "");
        }
    }
    //ELIMINAR TABLA
    protected static void eliminarTablaCompra(Connection con) {

        PreparedStatement preparedStatement = null;

        String EliminarCompra= "DROP TABLE IF EXISTS COMPRA";
        try {
            preparedStatement = con.prepareStatement(EliminarCompra);
            preparedStatement.executeUpdate();

            System.out.println("Tabla COMPRA eliminada correctamente.");

        } catch (Exception e) {
            System.err.println("Tabla COMPRA no ha podido crearse : "+e);
        }
    }
    //INSERTAR COMPRA

    public static void insertarCompra(Compra nuevaCompra)
    {
        //Puede que sea necesarario efectuar algunos cambios en estas sentencias
        //ya que esto es SQL puro y estamos trabajando con JDO
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            String query = " INSERT INTO COMPRA (IDCOMPRA,CORREOUSUARIO,IDPRODUCTOCOMPRA)"
                    + " VALUES (?, ?, ?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setInt(1, nuevaCompra.getIdCompra());
            preparedStatement.setString(2, nuevaCompra.getCorreoUsuario());
            preparedStatement.setInt(3, nuevaCompra.getIdProductoCompra());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar la compra");
            System.out.println(e);
        }
    }

    //SELECT COMPRA
/*
    public static Compra seleccionarCompra(int idC){
        PreparedStatement preparedStatement = null;
        //Debe ser el metodo que haga conexion con la base de datos, es decir tenemos que especificar donde se encuentra esta tabla
        Connection con = ConexionDB.Conexion();
        try {
            try {
                PreparedStatement pst = con.prepareStatement("SELECT * FROM COMPRA WHERE NOMBRE = '" + idC + "'");
                ResultSet rs = pst.executeQuery();

                int id;
                String cus;
                int idP;

                while(rs.next()) {
                    id = rs.getInt("IDCOMPRA");
                    cus = rs.getString("CORREOUSUARIO");
                    idP = rs.getInt("IDPRODUCTOCOMPRA");
                    
                    Compra e = new Compra(id, cus, idP);
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
*/

    //ELIMINAR COMPRA
    public static void eliminarCompra(int idCompra) {

        PreparedStatement preparedStatement= null;
        Connection con = ConexionDB.Conexion();

        try {

            String query = "DELETE FROM COMPRA WHERE ID = '" + idCompra + "'";

            preparedStatement = con.prepareStatement(query);

            preparedStatement.execute();
            preparedStatement.close();

        } catch (SQLException e) {

            System.out.println("No se pudo eliminar la compra");
            System.out.println(e);
        }

    }
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM COMPRA";
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
