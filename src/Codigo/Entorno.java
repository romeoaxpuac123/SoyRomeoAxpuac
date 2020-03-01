/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import CodigoASTCUP.NodoAbstracto;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class Entorno {
    Hashtable<String,Simbolo> Elementos;

    public Entorno() {
        Elementos = new Hashtable<>();
    }
    
    public boolean Agregar(String id, String tipo, String valor){
        if (!Elementos.containsKey(id)) {
            Simbolo sim = new Simbolo(id, valor, tipo);
            Elementos.put(id, sim);
            System.out.println("La variables se agregó -> "+id);
            return true;
        }else{
            System.out.println("La variables ya existe -> "+id);
            return false;
        }
    }
    
    public boolean Agregar2(String id, ArrayList <NodoAbstracto> Expresiones, String Tipo,String Borrador){
        if (!Elementos.containsKey(id)) {
            Simbolo sim = new Simbolo(id, Expresiones, Tipo,Borrador);
            Elementos.put(id, sim);
            System.out.println("La variables se agregó -> "+id);
            return true;
        }else{
            System.out.println("La variables ya existe -> "+id);
            return false;
        }
    }
    
    public boolean ExisteVector(String id){
         return(Elementos.containsKey(id));
          
    }
    public String ObtenerValor(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).ObtenerValor();
        } else{
            return "#Error";
        }
    }
    
    public String ObtenerTipo(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).ObtenerTipo();
        } else{
            return "#Error";
        }
    }
    
    public String ObtenerBorrador(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).getBorrador();
        } else{
            return "#Error";
        }
    }
    
    public ArrayList <NodoAbstracto> ObtenerLista(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).RetornarLista();
        } else{
            return null;
        }
    }
    
    public void ModificarValor(String id, String Valor, String Tipo){
     if (Elementos.containsKey(id)) {
           Elementos.get(id).ModificarValor(Valor, Tipo);
        }
    }
    public void ModificarValorLista(String id, ArrayList <NodoAbstracto> Expresiones, String Tipo, String Borrador){
     if (Elementos.containsKey(id)) {
           Elementos.get(id).ModificarValorLista(Expresiones, Tipo,Borrador);
        }
    }
    
    public void MostrarVectores(){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(ObtenerListaN(Clave2) ==0){
            System.out.println( "Vector : " + clave + " Valor:" + ObtenerValor(Clave2) + " Tipo:" + ObtenerTipo(Clave2));
        }
        }
    }
    
    public NodoAbstracto NodoLista(String id, int posicion){
    
        if (Elementos.containsKey(id)) {
            for(int i = 0; i < Elementos.get(id).RetornarLista().size();i++){
                if(i == posicion){
                    return Elementos.get(id).RetornarLista().get(i);
                }
            }
        } 
        return null;
    }
  
    public int ObtenerListaN(String id){
        if (Elementos.containsKey(id)) {
            return Elementos.get(id).ObtenerLista();
        } else{
            return 0;
        }
    }

    public void MostrarVectoresLista(){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(ObtenerListaN(Clave2) ==1){
            System.out.println( "Vector : " + clave + " Valor:" + ObtenerBorrador(Clave2) + " Tipo:" + ObtenerTipo(Clave2));
            }
          }
    }
    
     public void MostrarVectoresLista(Entorno entorno,JTextArea salida){
       Enumeration e = Elementos.keys();
        Object clave;
        while( e.hasMoreElements() ) {
            clave = e.nextElement();
            String Clave2 = (String) clave;
            if(ObtenerListaN(Clave2) ==1 && !"VectorDragonBallBeatles".equals(Clave2)){
            ArrayList <NodoAbstracto> Lista =  ObtenerLista(clave.toString());
            String Valores = "";
            for(int i = 0; i < Lista.size();i++){
                String val1 = Lista.get(i).Ejecutar(entorno, salida);
               // System.out.println("hoaaaaaaaaaa->" + Lista.get(i).TipoDato + "->" +Lista.get(i).Nombre );
                if("id".equals(Lista.get(i).TipoDato)){
                    Valores = Valores + entorno.ObtenerValor(Lista.get(i).Nombre) + ",";
                }else{
                      Valores = Valores + val1 + ",";
                }
              
            }
            System.out.println( "Vector : " + clave + " Valor:" + Valores + " Tipo:" + ObtenerTipo(Clave2));
            }
          }
    }
}
