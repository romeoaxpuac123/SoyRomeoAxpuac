/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class Imprimir extends NodoAbstracto{

    @Override
    public void Ejecutar() {
         System.err.println("Se esta ejecutnado imprimir\n");
    }

    public Imprimir(String Valor) {
        super(Valor);
    }

    @Override
    public String Ejecutar(Entorno entorno,JTextArea salida) {
        
        System.out.println("<->" + "entro a imprimir" + this.Hijos.get(0).Nombre);
        String val = this.Hijos.get(0).Ejecutar(entorno, salida);
        String tipo = this.Hijos.get(0).TipoDato;
        System.out.println("----------->Se esta ejecutnado imprimir->" + val + "<->");
        System.out.println("vectores:");
        entorno.MostrarVectoresLista(entorno, salida);
        System.out.println("safasd");
        System.out.println("TIPO->" + tipo);
        String ElMero = "";
        int bandera = 0;
        if (val.toUpperCase().contains("#ERROR")){
            TError ERRORES = new TError("Imprimir",this.linea,this.columna,"Semantico", "Error en el contenido a imprimir"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            salida.append("#Error en el contenido a imprimir: "+val +"\n");
             return "ERROR";
        }
        
        if(val.contains("RomeoAxpuac")){
            System.out.println("VAMOS A BUSCAR AL DRAGONBALL");
            this.Expresiones = entorno.ObtenerLista("VectorDragonBallBeatles");
            for(int i = 0; i < this.Expresiones.size();i++){
                        String Resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
                        System.out.println("RESULTADODG->"+ Resultado);
                        if(i+1 != this.Expresiones.size()){
                              ElMero = ElMero + Resultado + ",";
                        }else{
                            ElMero = ElMero + Resultado;
                        }
                       
                    }
            val = ElMero + "";
            bandera = 1;
        }
        
        if(tipo.contains("id") && bandera == 0){
            if(entorno.ExisteVector(val)){
                if(entorno.ObtenerListaN(val)==0){
                    val = entorno.ObtenerValor(val);
                }else{
                   // String ElMero = "[";
                    this.Expresiones = entorno.ObtenerLista(val);
                    for(int i = 0; i < this.Expresiones.size();i++){
                        String Resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
                        if(i+1 != this.Expresiones.size()){
                              ElMero = ElMero + Resultado + ",";
                        }else{
                            ElMero = ElMero + Resultado;
                        }
                       
                    }
                    
                    val = ElMero + "";
                }
                
            }else{
                 TError ERRORES = new TError("Imprimir",this.linea,this.columna,"Semantico", "Error en el contenido a imprimir: No existe vector" + val  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                salida.append("#Error en el contenido a imprimir: "+val +"\n");
                return "ERROR";
            }
        }
        val = val.replace("\\\"", "\"");
        val = val.replace("\\n", "\n");
        val = val.replace("\\r", "\r");
        val = val.replace("\\t", "\t");
        val = val.replace("\\\\", "\\");
        
        
        //if("RomeoAxpuac".equals(val)){
            //String hola = "[";
        //    this.Expresiones = entorno.ObtenerLista("VectorDragonBallBeatles");
        //    System.out.println("asdf->" + entorno.ObtenerLista("VectorDragonBallBeatles").size());
            
      //  }
        if (!val.toUpperCase().contains("#ERROR")){
            salida.append("[" + val + "]"+"\n");
           
        }else{
            TError ERRORES = new TError("Imprimir",this.linea,this.columna,"Semantico", "Error en el contenido a imprimir"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            salida.append("#Error en el contenido a imprimir: "+val +"\n");
             return "ERROR";
        }
        return "imprimir";
    }
    
    
}
