package com.jdo;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Extent;
import javax.jdo.Query;
import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

public class mainjdo {
    //Puede dar problemas por el JDK del JDE
    //1.mvn compile
    //2.mvn datanucleus:example
    //3.mvn exec:java
    public static void main(String[] args) {

        System.out.println("Starting ....");
        // Create a PersistenceManagerFactory for this datastore
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        //Persistencia de Producto y Usuario
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            System.out.println("Persisting products");
            Producto p1 = new Producto("NvidiaGTX3070","Gigabyte",499.99f,"La ultima remesa de graficas");
            Usuario u1 = new Usuario("jose","jose","jose","jose","jose","jose@jose.jose","jose",1234,false);

            pm.makePersistent(p1);
         //   pm.makePersistent(u1);


            tx.commit();
            System.out.println("Producto y Usuario han persistido");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
    }
}
