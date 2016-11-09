/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Rodrigo
 */
public class GraphDBTest {
    
    public GraphDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createGraph method, of class GraphDB.
     * Se comprueba que se anada bien un nodo y un vertice
     * 
     */
    @Test
    public void testaddNode() {
        System.out.println("createGraph");
        GraphDB instance = new GraphDB();
        Graph grafoprueba = new SingleGraph("prueba");
        grafoprueba.addNode("nodo1");
        grafoprueba.addNode("nodo2");
        grafoprueba.addEdge("arista12", "nodo1", "nodo2", true);
        boolean result = grafoprueba.getNode("nodo1") == null;
        boolean expResult = false;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.        
    }
@Test
    public void testaddEdge() {
        System.out.println("createGraph");
        GraphDB instance = new GraphDB();
        Graph grafoprueba = new SingleGraph("prueba");
        grafoprueba.addNode("nodo1");
        grafoprueba.addNode("nodo2");
        grafoprueba.addEdge("arista12", "nodo1", "nodo2", true);
        boolean result = grafoprueba.getEdge("arista12") == null;
        boolean expResult = false;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.        
    }

    /**
     * Test of createGraph method, of class GraphDB.
     */
    @Test
    public void testCreateGraph() {
        System.out.println("createGraph");
        GraphDB instance = new GraphDB();
        instance.createGraph();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarGrafo method, of class GraphDB.
     */
    @Test
    public void testMostrarGrafo() {
        System.out.println("mostrarGrafo");
        GraphDB instance = new GraphDB();
        instance.mostrarGrafo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarGrafo6 method, of class GraphDB.
     */
    @Test
    public void testMostrarGrafo6() {
        System.out.println("mostrarGrafo6");
        GraphDB instance = new GraphDB();
        instance.mostrarGrafo6();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pagerank method, of class GraphDB.
     */
    @Test
    public void testPagerank() {
        System.out.println("pagerank");
        GraphDB instance = new GraphDB();
        instance.pagerank();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRankings method, of class GraphDB.
     */
    @Test
    public void testGetRankings() {
        System.out.println("getRankings");
        GraphDB instance = new GraphDB();
        String expResult = "";
        String result = instance.getRankings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of masComunicados method, of class GraphDB.
     */
    @Test
    public void testMasComunicados() {
        System.out.println("masComunicados");
        GraphDB instance = new GraphDB();
        String expResult = "";
        String result = instance.masComunicados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menosComunicados method, of class GraphDB.
     */
    @Test
    public void testMenosComunicados() {
        System.out.println("menosComunicados");
        GraphDB instance = new GraphDB();
        String expResult = "";
        String result = instance.menosComunicados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of correos method, of class GraphDB.
     */
    @Test
    public void testCorreos() {
        System.out.println("correos");
        String origen = "";
        String destino = "";
        GraphDB instance = new GraphDB();
        String expResult = "";
        String result = instance.correos(origen, destino);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
