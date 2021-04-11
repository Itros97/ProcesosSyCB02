package com.util;

import com.db.ConexionDB;
import com.jdo.Compra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompraDB {

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


    //ELIMINAR COMPRA
    public void eliminarCompra(int idCompra) {

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


}
