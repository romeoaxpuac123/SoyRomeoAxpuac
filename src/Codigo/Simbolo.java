/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigo;

import CodigoASTCUP.NodoAbstracto;
import java.util.ArrayList;

/**
 *
 * @author Bayyron
 */
public class Simbolo {
    String Id;
    String Valor ="";
    String Borrador ="";
    String Tipo;
    int lista = 0;
    public ArrayList <NodoAbstracto> Expresiones = new ArrayList();
    public Simbolo(String Id, String Valor, String Tipo) {
        this.Id = Id;
        this.Valor = Valor;
        this.Tipo = Tipo;
    }

     public Simbolo(String Id, ArrayList <NodoAbstracto> Expresiones, String Tipo, String Borrador) {
        this.Id = Id;
        this.Expresiones = Expresiones;
        this.Tipo = Tipo;
        this.lista = 1;
        this.Borrador = Borrador;
        this.Valor = "";
    }
     
    public int ObtenerLista(){
        return this.lista;
    } 
    public String ObtenerId() {
        return Id;
    }

    public String ObtenerValor() {
        return Valor;
    }

    public String ObtenerTipo() {
        return Tipo;
    }
    public void ModificarValor(String Valor,String Tipo){
        this.Valor = Valor;
        this.Tipo = Tipo;
    }
    public void ModificarValorLista(ArrayList <NodoAbstracto> Expresiones,String Tipo, String Borrador){
        this.Expresiones = Expresiones;
        this.Tipo = Tipo;
        this.Valor = "";
        this.Borrador = Borrador;
        this.lista = 1;
    }
    public String getBorrador(){
        return this.Borrador;
    }
   
    public ArrayList <NodoAbstracto> RetornarLista(){
        return this.Expresiones;
    }
}
