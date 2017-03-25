

import br.edu.ifsul.modelo.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestePersistirEstado {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirEstado() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("SGO-ModelPULocal");
        em = emf.createEntityManager();
    }
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    @Test
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Estado obj = new Estado();
            obj.setNome("Administrativo");
            obj.setUf("SP");
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
