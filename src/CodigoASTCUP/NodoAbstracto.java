/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public abstract class NodoAbstracto {
    public String Nombre;    
    public int id, linea, columna;
    public String Cadena;
    public String TipoDato;
    public ArrayList<NodoAbstracto> Hijos;
    public ArrayList <NodoAbstracto> Expresiones = new ArrayList();
    public ArrayList <NodoAbstracto> Expresiones2 = new ArrayList();
    public ArrayList <NodoAbstracto> Expresiones3 = new ArrayList();
    public int EsVector = 0;
    public NodoAbstracto() {
    }
    
    public NodoAbstracto(String Cadena, int codigo){
        this.Cadena = Cadena;
    }
    
    public NodoAbstracto(String nom)
    {
        this.Nombre = nom;
        this.id=0;
        this.linea=0;
        this.columna=0;
        this.Hijos = new ArrayList<>();
    }
    
    public NodoAbstracto(String nom, int lin, int col)
    {
        this.Nombre = nom;
        this.id=0;
        this.linea=lin;
        this.columna=col;
        this.Hijos = new ArrayList<>();
    }
    public abstract void Ejecutar();
    public abstract String Ejecutar(Entorno entorno,JTextArea salida);
}
