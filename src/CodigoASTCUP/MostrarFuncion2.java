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
public class MostrarFuncion2 extends NodoAbstracto{

    public MostrarFuncion2(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
    //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("FUNCION CON PARAMETROS COMO SENTENCIA");
      String ElNombre = this.Hijos.get(0).Nombre;
      int totalParmetros = this.Hijos.get(1).Hijos.size();
      ArrayList <NodoAbstracto> ListaParetrosDeLlamada = new ArrayList <NodoAbstracto>();
      ArrayList <NodoAbstracto> ListaParetrosDeLaFuncion = entorno.ListaParetros(ElNombre);
      ArrayList <NodoAbstracto> ListaSentencias = entorno.ListaSentenciasFuncion(ElNombre);
      
      System.out.println("NOMBRE FUNCION:->" + ElNombre + "<->" + totalParmetros);
      
    
      return "MOSTRAR FUNCION1";
    }
    
}
