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

    
}
