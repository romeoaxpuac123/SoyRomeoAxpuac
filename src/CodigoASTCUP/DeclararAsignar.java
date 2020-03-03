/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
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
      
      
       String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
       String Tipo1 = this.Hijos.get(1).TipoDato;
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
      }else if(val1.indexOf("#ERROR: El vector ")==0){
          salida.append(val1 +"\n");
          System.out.println("-------->"+  val1    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
          TError ERRORES = new TError(Identificador,this.linea,this.columna,"Semantico", val1  );
          TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
          
          return "ERROR AL DECLRAR VECTOR";
          
      }else if(val1.indexOf("#Error")==0){
          salida.append("#ERROR Aritmetico: El vector no puede ser asignado" +"\n");
          System.out.println("-------->"+  "Error en operación aritmetica"    +"<----------------Columna: " + this.columna + "**Fila: " + this.linea+1);
          TError ERRORES2 = new TError(Identificador,this.linea,this.columna,"Semantico", "Error en operación aritmetica"  );
          TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES2);
          return "ERROR AL DECLRAR VECTOR";
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
