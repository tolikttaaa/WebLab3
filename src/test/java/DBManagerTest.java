import controllers.DBManager;
import models.Dot;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DBManagerTest {
    private final DBManager manager = new DBManager();
    private final static String className = DBManager.class.getName();
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("dots").createEntityManager();

    @Test
    public void test1_emptyConstructor() throws NoSuchFieldException {
        assertNotNull("Object was not created", manager.getClass().getDeclaredField("em"));
    }

    @Test
    public void test4_getAll() {
        manager.deleteAll();
        manager.addDot(1, 1, 1, "False");
        manager.addDot(0, 0, 0, "True");
        String expectedIfTableTrue = "<table class=\"res-table\" id=\"table\">\n" +
                "<caption>Табличка</caption>\n" +
                "<tr><th>X</th><th>Y</th><th>R</th><th>RESULT</th></tr>\n" +
                "<tr><td>1.0</td><td>1.0</td><td>1.0</td><td>False</td></tr>\n" +
                "<tr><td>0.0</td><td>0.0</td><td>0.0</td><td>True</td></tr>\n" +
                "</table>";
        String realIfTableTrue = manager.getAll(true);
        String expectedIfTableFalse = "<circle r=\"3\" cx=\"270\" cy=\"30\" class=\"1.0\" stroke=\"red\" fill=\"red\"></circle>\n"
                + "<circle r=\"3\" cx=\"0\" cy=\"0\" class=\"0.0\" stroke=\"green\" fill=\"green\"></circle>\n";
        String realIfTableFalse = manager.getAll(false);
        assertEquals("html source doesn't match", expectedIfTableTrue, realIfTableTrue);
        assertEquals("strings don't match", expectedIfTableFalse, realIfTableFalse);
    }

    @Test
    public void test2_deleteAll() {
        manager.deleteAll();
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        List<Dot> dots = this.entityManager.createQuery("SELECT dot FROM Dot dot", Dot.class).getResultList();
        tx.commit();
        assertEquals(0, dots.size());
    }

    @Test
    public void test3_addDot() {
        manager.deleteAll();
        manager.addDot(1, 1, 1, "test");
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        List<Dot> dots = this.entityManager.createQuery("SELECT dot FROM Dot dot", Dot.class).getResultList();
        tx.commit();
        assertEquals(1, dots.size());
    }

}