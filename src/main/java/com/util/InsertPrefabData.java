package com.util;

import com.jdo.Producto;

public class InsertPrefabData {

    public static void main(String[] args) {
        ConexionDB bd = new ConexionDB();
        //bd.ReiniciarBasesDeDatos();
        
        Producto p1 = new Producto("hey","dsdsds",5,"Hola");
        bd.InsertarProducto(p1);

    }
}
