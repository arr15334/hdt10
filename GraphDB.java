

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.algorithm.PageRank;
import org.graphstream.algorithm.generator.DorogovtsevMendesGenerator;
import org.graphstream.graph.Node;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */

public class GraphDB {
    String[][] adjmatrix = new String [15][15];
    Graph grafito = new SingleGraph("Comunicaciones");
    Graph grafo6 = new MultiGraph("6 o mas correos");
    int[][] correos = new int[14][14];
    ArrayList<String> rankings = new ArrayList();
    ArrayList<Persona> losrankings = new ArrayList();
    
    public void createGraph()
    {
        String csvFile = "/Users/Diego/Documents/NetBeansProjects/neo4jprueba/datos.csv";
        BufferedReader br = null;
        String line ="";
        //String[][] adjmatrix = new String[15][15];
        
        int n = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] country = line.split(";");
                
                adjmatrix[0][n]=country[1];
//                correos[0][i]=Integer.parseInt(country[1]);
                adjmatrix[1][n]=country[2];
                adjmatrix[2][n]=country[3];
                adjmatrix[3][n]=country[4];
                adjmatrix[4][n]=country[5];
                adjmatrix[5][n]=country[6];
                adjmatrix[6][n]=country[7];
                adjmatrix[7][n]=country[8];
                adjmatrix[8][n]=country[9];
                adjmatrix[9][n]=country[10];
                adjmatrix[10][n]=country[11];
                adjmatrix[11][n]=country[12];
                adjmatrix[12][n]=country[13];
                adjmatrix[13][n]=country[14];
                n++;
                }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
                    Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost/?user=neo4j,password=123,debug=true,noSsl,flatten=[-1,100,1000]");
                    try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("match (n) detach \n delete n");
                
                ResultSet rs = stmt.executeQuery(   "create (Per1:Person {name:\"Per 1\"})\n" +
                                                    "create (Per2:Person {name:\"Per 2\"})\n" +
                                                    "create (Per3:Person {name:\"Per 3\"})\n" +
                                                    "create (Per4:Person {name:\"Per 4\"})\n" +
                                                    "create (Per5:Person {name:\"Per 5\"})\n" +
                                                    "create (Per6:Person {name:\"Per 6\"})\n" +
                                                    "create (Per7:Person {name:\"Per 7\"})\n" +
                                                    "create (Per8:Person {name:\"Per 8\"})\n" +
                                                    "create (Per9:Person {name:\"Per 9\"})\n" +
                                                    "create (Per10:Person {name:\"Per 10\"})\n" +
                                                    "create (Per11:Person {name:\"Per 11\"})\n" +
                                                    "create (Per12:Person {name:\"Per 12\"})\n" +
                                                    "create (Per13:Person {name:\"Per 13\"})\n" +
                                                    "create (Per14:Person {name:\"Per 14\"})");
                stmt.executeQuery( "match (m:Person {name: \"Per 1\"})\n" +
                                    "match (n:Person {name: \"Per 2\"})\n" +
                                    "match (o:Person {name: \"Per 3\"})\n" +
                                    "match (p:Person {name: \"Per 9\"})\n" +
                                    "match (q:Person {name: \"Per 14\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 3}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 6}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(q)" );
                stmt.executeQuery("match (m:Person {name: \"Per 2\"})\n" +
                                    "match (n:Person {name: \"Per 1\"})\n" +
                                    "match (o:Person {name: \"Per 3\"})\n" +
                                    "match (p:Person {name: \"Per 4\"})\n" +
                                    "match (q:Person {name: \"Per 12\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 5}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 8}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(q)");
                stmt.executeQuery("match (m:Person {name: \"Per 3\"})\n" +
                                    "match (n:Person {name: \"Per 1\"})\n" +
                                    "match (o:Person {name: \"Per 4\"})\n" +
                                    "\n" +
                                    "CREATE (m)-[:WROTE {quantity: 5}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(o)");
                stmt.executeQuery("match (m:Person {name: \"Per 4\"})\n" +
                                    "match (n:Person {name: \"Per 5\"})\n" +
                                    "match (o:Person {name: \"Per 6\"})\n" +
                                    "match (p:Person {name: \"Per 11\"})\n" +
                                    "match (q:Person {name: \"Per 13\"})\n" +
                                    "match (r:Person {name: \"Per 14\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 5}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 3}]->(q)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(r)");
                stmt.executeQuery("match (m:Person {name: \"Per 5\"})\n" +
                                    "match (n:Person {name: \"Per 4\"})\n" +
                                    "match (o:Person {name: \"Per 6\"})\n" +
                                    "match (p:Person {name: \"Per 11\"})\n" +
                                    "match (q:Person {name: \"Per 12\"})\n" +
                                    "match (r:Person {name: \"Per 13\"})\n" +
                                    "match (s:Person {name: \"Per 14\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 6}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 4}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 3}]->(q)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(r)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 9}]->(s)");
                stmt.executeQuery("match (m:Person {name: \"Per 6\"})\n" +
                                    "match (n:Person {name: \"Per 4\"})\n" +
                                    "match (o:Person {name: \"Per 5\"})\n" +
                                    "match (p:Person {name: \"Per 12\"})\n" +
                                    "match (q:Person {name: \"Per 13\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 6}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(q)");
                stmt.executeQuery("match (m:Person {name: \"Per 7\"})\n" +
                                    "match (n:Person {name: \"Per 8\"})\n" +
                                    "match (o:Person {name: \"Per 9\"})\n" +
                                    "match (p:Person {name: \"Per 11\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 12}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 13}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(p)");
                stmt.executeQuery("match (m:Person {name: \"Per 8\"})\n" +
                                    "match (n:Person {name: \"Per 6\"})\n" +
                                    "match (o:Person {name: \"Per 7\"})\n" +
                                    "match (p:Person {name: \"Per 9\"})\n" +
                                    "match (q:Person {name: \"Per 10\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 3}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 14}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 21}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(q)");
                stmt.executeQuery("match (m:Person {name: \"Per 9\"})\n" +
                                        "match (n:Person {name: \"Per 5\"})\n" +
                                        "match (o:Person {name: \"Per 7\"})\n" +
                                        "match (p:Person {name: \"Per 8\"})\n" +
                                        "CREATE (m)-[:WROTE {quantity: 4}]->(n)\n" +
                                        "CREATE (m)-[:WROTE {quantity: 12}]->(o)\n" +
                                        "CREATE (m)-[:WROTE {quantity: 23}]->(p)");
                stmt.executeQuery("match (m:Person {name: \"Per 10\"})\n" +
                                    "match (o:Person {name: \"Per 4\"})\n" +
                                    "match (p:Person {name: \"Per 5\"})\n" +
                                    "match (q:Person {name: \"Per 6\"})\n" +
                                    "match (r:Person {name: \"Per 7\"})\n" +
                                    "match (s:Person {name: \"Per 11\"})\n" +
                                    "match (t:Person {name: \"Per 12\"})\n" +
                                    "match (u:Person {name: \"Per 13\"})\n" +
                                    "match (v:Person {name: \"Per 14\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 9}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(q)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(r)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 5}]->(s)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 4}]->(t)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 8}]->(u)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 7}]->(v)");
                stmt.executeQuery("match (m:Person {name: \"Per 11\"})\n" +
                                    "match (n:Person {name: \"Per 4\"})\n" +
                                    "match (o:Person {name: \"Per 6\"})\n" +
                                    "match (p:Person {name: \"Per 10\"})\n" +
                                    "match (q:Person {name: \"Per 13\"})\n" +
                                    "match (r:Person {name: \"Per 14\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 4}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 9}]->(q)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 1}]->(r)");
                stmt.executeQuery("match (m:Person {name: \"Per 12\"})\n" +
                                    "match (n:Person {name: \"Per 4\"})\n" +
                                    "match (o:Person {name: \"Per 5\"})\n" +
                                    "match (p:Person {name: \"Per 6\"})\n" +
                                    "match (q:Person {name: \"Per 10\"})\n" +
                                    "match (r:Person {name: \"Per 11\"})\n" +
                                    "match (s:Person {name: \"Per 13\"})\n" +
                                    "match (t:Person {name: \"Per 14\"})\n" +
                                    "CREATE (m)-[:WROTE {quantity: 4}]->(n)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 4}]->(o)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 9}]->(p)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 2}]->(q)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 4}]->(r)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 8}]->(s)\n" +
                                    "CREATE (m)-[:WROTE {quantity: 9}]->(t)");
                stmt.executeQuery("match (m:Person {name: \"Per 13\"})\n" +
                            "match (n:Person {name: \"Per 4\"})\n" +
                            "match (o:Person {name: \"Per 5\"})\n" +
                            "match (p:Person {name: \"Per 10\"})\n" +
                            "match (q:Person {name: \"Per 11\"})\n" +
                            "match (r:Person {name: \"Per 12\"})\n" +
                            "CREATE (m)-[:WROTE {quantity: 1}]->(n)\n" +
                            "CREATE (m)-[:WROTE {quantity: 3}]->(o)\n" +
                            "CREATE (m)-[:WROTE {quantity: 2}]->(p)\n" +
                            "CREATE (m)-[:WROTE {quantity: 3}]->(q)\n" +
                            "CREATE (m)-[:WROTE {quantity: 2}]->(r)");
                stmt.executeQuery("match (m:Person {name: \"Per 14\"})\n" +
                        "match (n:Person {name: \"Per 4\"})\n" +
                        "match (o:Person {name: \"Per 10\"})\n" +
                        "match (p:Person {name: \"Per 11\"})\n" +
                        "match (q:Person {name: \"Per 12\"})\n" +
                        "CREATE (m)-[:WROTE {quantity: 7}]->(n)\n" +
                        "CREATE (m)-[:WROTE {quantity: 6}]->(o)\n" +
                        "CREATE (m)-[:WROTE {quantity: 8}]->(p)\n" +
                        "CREATE (m)-[:WROTE {quantity: 3}]->(q)");
                
                for (int m = 0; m<14 ; m++){
                grafito.addNode(adjmatrix[m][0]);
                //stmt.executeQuery("CREATE (n:Person {name: \"adjmatrix[m][0]\"})");
                // "create (Per1:Person {name:\"Per 1\"})\n"
                        }
                
        for (int j = 0; j<14;j++){
            for (int i = 0; i<14; i++){
                correos[i][j]=Integer.parseInt(adjmatrix[i][j+1]);
            }
        }
        //BetweennessCentrality bcb = new BetweennessCentrality();
        
        for (int j = 0; j<14;j++){
            for (int i = 0; i<14; i++){
                if (correos[i][j]>0){
          //        Node nodo1 = grafito.getNode(adjmatrix[j][0]);  
            //      Node nodo2 = grafito.getNode(adjmatrix[i][0]);
                  //  stmt.executeQuery("match (n: Person {name: \"adjmatrix[j][0]\"})"
                    //                  +"create (n)-[:WROTE {quantity: "+correos[i][j]+"}]->(m)");
                  grafito.addEdge(""+adjmatrix[j][0]+adjmatrix[i][0], adjmatrix[j][0], adjmatrix[i][0], true);
                  
                if (correos[i][j]>5)
                {
                    if (grafo6.getNode(adjmatrix[i][0])==null){
                    grafo6.addNode(adjmatrix[i][0]);
                    //grafo6.addEdge(""+adjmatrix[j][0]+adjmatrix[i][0], adjmatrix[j][0], adjmatrix[i][0], true);
                    }
                    if (grafo6.getNode(adjmatrix[j][0])==null){
                    grafo6.addNode(adjmatrix[j][0]);
                    //grafo6.addEdge(""+adjmatrix[j][0]+adjmatrix[i][0], adjmatrix[j][0], adjmatrix[i][0], true);
                    }
                    grafo6.addEdge(""+adjmatrix[j][0]+adjmatrix[i][0], adjmatrix[j][0], adjmatrix[i][0], true);
                }
                  
              //    bcb.setWeight(nodo1, nodo2, correos[i][j]);
                }
            }
        }
                
                /*
                        ResultSet rs = stmt.executeQuery("MATCH (n:Person)-[rel:WROTE]->(m:Person) \n WHERE rel.quantity > 5 \n RETURN n.name");
                        while (rs.next()) {
                            System.out.println(rs.getString("n.name"));
                        }*/
                    }
                    con.close();

                }catch (Exception ex){
                    ex.printStackTrace();
                }
            
            }
    
    public void mostrarGrafo (){
        grafito.display();
    }
    public void mostrarGrafo6(){
        grafo6.display();
    }
    public void pagerank() {
        /*
        DorogovtsevMendesGenerator generator = new DorogovtsevMendesGenerator();
	generator.setDirectedEdges(true, true);
	generator.addSink(grafito);
        */
        PageRank pageRank = new PageRank();
        pageRank.setVerbose(true);
	pageRank.init(grafito);
        
        
        
        for (Node node : grafito){
            double rank = pageRank.getRank(node);
            rank = rank*100;
            rankings.add(""+rank+"% "+node.getId());
            int r = (int) rank;
            Persona p = new Persona(r, node.getId());
            losrankings.add(p);
        }
        rankings.sort(null);
        losrankings.sort(null);
        
        /*
        generator.begin();
			while (grafito.getNodeCount() < 30) {
				generator.nextEvents();
				for (Node node : grafito) {
					double rank = pageRank.getRank(node);
					node.addAttribute("ui.size", 5 + Math.sqrt(grafito.getNodeCount() * rank * 20));
					node.addAttribute("ui.label", String.format("%.2f%%", rank * 100));
				}
				Thread.sleep(500);
			}
        */
    }
    public String getRankings ()
    {
        String o = "";
        int i =0;
        for (Persona p: losrankings){
            o = o + losrankings.get(i).getName()+": "+losrankings.get(i).getNum()+"\n";
            i++;
        }
        return o;
    }
    
    public String masComunicados (){
        String s = "";
        ArrayList<Persona> comunicaciones = new ArrayList();
        for (Node node : grafito){
            Persona p = new Persona(node.getDegree(), node.getId());
            comunicaciones.add(p);
        }
        comunicaciones.sort(null);
        s = comunicaciones.get(13).getName()+"\n "+comunicaciones.get(12).getName()+"\n "+comunicaciones.get(11).getName()+" ";
        return s;
    }
    
    public String menosComunicados (){
        String s = "";
        ArrayList<Persona> comunicaciones = new ArrayList();
        for (Node node : grafito){
            Persona p = new Persona(node.getDegree(), node.getId());
            comunicaciones.add(p);
        }
        comunicaciones.sort(null);
        s = comunicaciones.get(0).getName()+"\n "+comunicaciones.get(1).getName()+"\n "+comunicaciones.get(2).getName()+" ";
        return s;
    }
}
