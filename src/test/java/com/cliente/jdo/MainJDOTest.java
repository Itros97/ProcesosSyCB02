package com.cliente.jdo;

public class MainJDOTest {
/*
        private PersistenceManagerFactory pmf = null;

        private PersistenceManager pm = null;

        private Transaction tx = null;

        //Generamos la BD ya que es necesaria para los test sobre los objetos de tipo JDO
    @Before
    public void setUp() throws Exception {
        // Code executed before each test
        this.pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");

        System.out.println("DataNucleus AccessPlatform with JDO");
        System.out.println("===================================");

        // Persistencia de producto y usuario
        this.pm = this.pmf.getPersistenceManager();
        this.tx = this.pm.currentTransaction();
    }
    @Test
    public void testProductCreation() {
        try
        {
            tx.begin();
            Producto p1 = new Producto();
            Usuario u1 = new Usuario();
            pm.makePersistent(p1);
            pm.makePersistent(u1);

            tx.commit();
            System.out.println("Datos han persistido, conexion correcta");
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
        System.out.println("");
    }
*/
}
