/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

/**
 *
 * @author Bayyron
 */
public class TError {
    String lexema, tipo, descripcion;
    int linea, columna;
    
    public  TError(String lexema, int linea, int columna, String tipo, String descripcion){
        System.out.println("SE AGREGO NUEVO ERROR->" + lexema);
        this.lexema = lexema;
        this. linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;        
    }
    public String Lexema(){
        return this.lexema;
    }
    public int linea (){
        return this.linea;
    }
    public int columna(){
        return this.columna;
    }
    public String tipo(){
        return this.tipo;
    }
    public String descripcion(){
        return this.descripcion;
    }
    
    
}
