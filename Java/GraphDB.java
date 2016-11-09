

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


/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo #10
 * 
 * @author Rodrigo Arriaza, Alejandro Chaclán, Sebastián Galindo
 */

public class GraphDB {
    String[][] adjmatrix = new String [15][15];
    Graph grafito = new SingleGraph("Comunicaciones");
    Graph grafo6 = new MultiGraph("6 o mas correos");
    int[][] correos = new int[14][14];
    ArrayList<String> rankings = new ArrayList();
    ArrayList<Persona> losrankings = new ArrayList();
    
    /**
     * pre: Graph is empty
     * post: Graph is created after reading csv File
     */
    public void createGraph()
    {
        /*
        * Aqui se especifica la dorección en la que el documento .csv se encuentra
        */
        String csvFile = "/Users/Sebastián/Documents/UVG/2016/Segundo Ciclo/Algoritmos y Estructuras de Datos/HDT 10/hdt10-master/datos.csv"; //cambiar esto con la location del archivo datos.csv
        BufferedReader br = null;
        String line ="";
        
        int n = 0;
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use punto coma as separator
                String[] fila = line.split(";");
                
                adjmatrix[0][n]=fila[1];
                adjmatrix[1][n]=fila[2];
                adjmatrix[2][n]=fila[3];
                adjmatrix[3][n]=fila[4];
                adjmatrix[4][n]=fila[5];
                adjmatrix[5][n]=fila[6];
                adjmatrix[6][n]=fila[7];
                adjmatrix[7][n]=fila[8];
                adjmatrix[8][n]=fila[9];
                adjmatrix[9][n]=fila[10];
                adjmatrix[10][n]=fila[11];
                adjmatrix[11][n]=fila[12];
                adjmatrix[12][n]=fila[13];
                adjmatrix[13][n]=fila[14];
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
            /*
            * la siguiente linea se debe modificar con el user y el password de neo4j
            */
                    Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost/?user=neo4j,password=neo4jhdt10,debug=true,noSsl,flatten=[-1,100,1000]"); 
                    try (Statement stmt = con.createStatement()) {
                stmt.executeQuery("match (n) detach \n delete n");
               
                for (int m = 0; m<14 ; m++){
                grafito.addNode(adjmatrix[m][0]);
                String query = String.format("\"%s\"", adjmatrix[m][0]);
                stmt.executeQuery("CREATE (n:Person {name: "+query+"})");
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
                    String nombreq1 = String.format("\"%s\"", adjmatrix[j][0]);
                    String nombreq2 = String.format("\"%s\"", adjmatrix[i][0]);
                  stmt.executeQuery("match (n: Person {name: "+nombreq1+"})" +
                                    "match (m: Person {name: "+nombreq2+"})" +
                                      "create (n)-[:WROTE {quantity: "+correos[i][j]+"}]->(m)");
                  grafito.addEdge(""+adjmatrix[j][0]+adjmatrix[i][0], adjmatrix[j][0], adjmatrix[i][0], true);
                  
                if (correos[i][j]>6)
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
    
    /**
     * Método para mostrar el grafo original
     */
    public void mostrarGrafo (){
        grafito.display();
    }

    /**
     * Método para mostrar el grafo de las personas que tienen mas de 6 correos
     */
    public void mostrarGrafo6(){
        grafo6.display();
    }

    /**
     * Método para mostrar el page rank de todas las personas del grafo
     */
    public void pagerank() {
     losrankings.clear();
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
        
    }

    /**
     *
     * @return Devuelve los rankings de las personas segun su importancia
     */
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
    
    /**
     *
     * @return Devuelve las personas que mas se comunicaron (Es decir, mas correos enviaron)
     */
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
    
    /**
     *
     * @return Devuelve las personas que menos se comunicaron (Es decir, los que menos correos enviaron)
     */
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

    /**
     *
     * @param origen
     * @param destino
     * @return Devuelve la cantidad de correos que fueron enviados entre una persona origen y una destino
     */
    public String correos(String origen, String destino){
        String res = "";
        try {
                    Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost/?user=neo4j,password=neo4jhdt10,debug=true,noSsl,flatten=[-1,100,1000]");
                    try (Statement stmt = con.createStatement()) {
        
        String queryo = String.format("\"%s\"",origen);
        String queryd = String.format("\"%s\"",destino);
        ResultSet rs = stmt.executeQuery("match (l {name: "+queryo+"})\n"+
                                         "match (m {name: "+queryd+"})\n"+
                                         "match path = shortestPath( (l)-[:WROTE*..3]-(m) ) \n"+
                                         "UNWIND nodes(path) as n\n" +
                                         "RETURN reduce(quantity=0, r in relationships(path) | quantity+r.quantity) AS totalWeight"); 
                                            //"RETURN n.name;");
        if (rs.next()){
            int minimoCorreos = rs.getInt("totalWeight");
            res ="Cantidad de correos de "+origen+" a "+destino+" es: "+minimoCorreos;
        
        } else {    res = "No hay correos entre "+origen + " y "+destino;
        } 
                    }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return res;
    }
}
