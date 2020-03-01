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
public class DeclararAsignar extends NodoAbstracto{

    public DeclararAsignar(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
      String Identificador = this.Hijos.get(0).Nombre;
      
      String Tipo1 = this.Hijos.get(1).TipoDato;
       String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
         System.out.println("Se esta declarando el vector:" + Identificador + " Tipo->" + Tipo1 + " Valor->" + val1);
      if("RomeoAxpuac".equals(val1)){
        System.out.println("SUMA DE DOS VECTORES");
        ArrayList <NodoAbstracto> ExpresionesLola = new ArrayList();
        ArrayList <NodoAbstracto> ExpresionesLola2 = new ArrayList();
        boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
        if(!ExisteVector == true){
            entorno.Agregar2(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
        }else{
            entorno.ModificarValorLista(Identificador, entorno.ObtenerLista("VectorDragonBallBeatles"), entorno.ObtenerTipo("VectorDragonBallBeatles"), "prit2");
        }
         entorno.ModificarValorLista("VectorDragonBallBeatles",ExpresionesLola, "cadena", "prit");
         entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
         System.out.println("---------");
          return "Fin";
      }
      boolean ExisteVector =  entorno.ExisteVector(Identificador); 
      
        if(!ExisteVector == true){
            entorno.Agregar(Identificador, Tipo1, val1);
        }else{
            entorno.ModificarValor(Identificador, val1, Tipo1);
        }
        
        entorno.MostrarVectores();
         entorno.MostrarVectoresLista(entorno,salida);
        System.out.println("---------");
      return "FIN DECLARAR ASGINAR";
    }
    
}
