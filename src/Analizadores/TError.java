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
        this.lexema = lexema;
        this. linea = linea;
        this.columna = columna;
        this.tipo = tipo;
        this.descripcion = descripcion;        
    }
    
}
