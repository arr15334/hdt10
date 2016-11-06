/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Diego
 */
//implements Comparable
public class Persona implements Comparable<Persona>{
    private Integer num;
    private String name;

    public Persona(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }
    public String getName(){
        return name;
    }
    
    
    @Override
    public int compareTo(Persona p){
        return num.compareTo(p.getNum());
    }
    
    
    
}
