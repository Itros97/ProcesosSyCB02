package com.cliente.jdo;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

public class mainjdo {
    //Puede dar problemas por el JDK del JDE
    //1.mvn clean
    //2.mvn compile
    //3.mvn datanucleus-schemacreate
    public static void main(String[] args) {

            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

            PersistenceManager pm = pmf.getPersistenceManager();
            Transaction tx = pm.currentTransaction();
            try {
                tx.begin();
                Usuario userA = new Usuario("John", "Smith","","","","jdo","",1,false);
                pm.makePersistent(userA);
                Usuario userB = new Usuario("Albert", "Einstein","","","","mekatorke","",1,false);
                pm.makePersistent(userB);
                Usuario userC = new Usuario("Isaac", "Newton","","","","gnomo","",12,true);
                pm.makePersistent(userC);

                Producto productoA = new Producto("NVidiaGTX","Gygabyte",300.0f,"Grafica series 3000");
                pm.makePersistent(productoA);

/*
                Compra c1 = new Compra(userA,productoA);
                pm.makePersistent(c1);
  */
                tx.commit();


            } finally {
                if (tx.isActive()) {
                    tx.rollback();
                }
                pm.close();
            }
        }
}
