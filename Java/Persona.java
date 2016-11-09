/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructuras de Datos
 * Hoja de Trabajo #10
 * 
 * @author Rodrigo Arriaza, Alejandro Chaclán, Sebastián Galindo
 */
//implements Comparable
public class Persona implements Comparable<Persona>{
    
    //Atributos del objeto persona
    private Integer num;
    private String name;

    /*
    * Método constructor de la clase Persona
    */
    public Persona(int num, String name) {
        this.num = num;
        this.name = name;
    }

    /*
    * Método que retorna la cantidad de correos enviada por una persona
    */
    public int getNum() {
        return num;
    }
    
    /*
    * Método que retorna el nombre de la persona
    */
    public String getName(){
        return name;
    }
    
    /*
    * Método compareTo
    */
    @Override
    public int compareTo(Persona p){
        return num.compareTo(p.getNum());
    }
    
    
    
}
