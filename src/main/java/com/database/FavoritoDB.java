package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.cliente.jdo.Favorito;
import com.cliente.jdo.Producto;
import com.cliente.jdo.Usuario;

public class FavoritoDB {
	
	/**
	 * This is the method that inserts favorite products into the database
	 * @param nuevoFavorito
	 */
	public static void insertarFavorito(Favorito nuevoFavorito) {
    
        PreparedStatement preparedStatement = null;
     
        Connection con = ConexionDB.Conexion();
        try {
        	
            String query = " INSERT INTO FAVORITO (IDPRODUCTO,NICKNAME)"
                    + " VALUES (?, ?)";

            preparedStatement = con.prepareStatement(query);


            preparedStatement.setInt(1, nuevoFavorito.getIdProducto());
            preparedStatement.setString(2, nuevoFavorito.getNickname());
            preparedStatement.execute();

            System.out.println("Insert existoso");

        } catch (Exception e) {
            System.out.println("ERROR al insertar la compra");
            System.out.println(e);
        }
    }
	
	/**
	 * Method used to recover all the favorite products
	 * @param nickname
	 * @param fav
	 */
	public static void getAllFavoritos (String nickname, ArrayList<Favorito> fav) {
		
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        
        fav = new ArrayList<>();

        try {
            String query = "SELECT * FROM FAVORITO WHERE NICKNAME = '" + nickname + "'";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
           
            
            
            while (resultSet.next()){
            	
                String nicknameUsu = resultSet.getString("NICKNAME");
                int idProducto = resultSet.getInt("IDPRODUCTO");

                Favorito f = new Favorito(nicknameUsu, idProducto);
                fav.add(f);
                              
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        
	}
	
	/**
	 * This is the method that shows the quantity of favorite product items of the database
	 * @return
	 */
    public static int rowcount () {
        PreparedStatement preparedStatement = null;
        Connection con = ConexionDB.Conexion();
        int count=0;
        try {
            String query = "SELECT * FROM FAVORITO";
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
