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
        if(tipo.contains("Lista")){
            if(entorno.ExisteVector(val)){
                tipo = "id";
            }
        }
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
        if(tipo.contains("FuncionC")| tipo.contains("CasteoC")){
            val = "";
            System.out.println("print los hijos del c son->" + this.Hijos.get(0).Expresiones.size());
            for(int i = 0; i < this.Hijos.get(0).Expresiones.size(); i ++){
                String Valor = this.Hijos.get(0).Expresiones.get(i).Ejecutar(entorno, salida);
                val = val + "[" + (i+1) + "]" + Valor + "\n";
            }
            //val = "putos todos";
        
        }
        
        if(val.contains("VectorSlushi")){
             //this.Expresiones = entorno.ObtenerLista("VectorDragonBallBeatles");
            for(int i = 0; i < this.Hijos.get(0).Expresiones.size();i++){
                        String Resultado = this.Hijos.get(0).Expresiones.get(i).Ejecutar(entorno, salida);
                        String TipoR = this.Hijos.get(0).Expresiones.get(i).TipoDato;
                        System.out.println("RESULTADODG->"+ Resultado + "<->" + TipoR);
                        if(!tipo.contains("KAMIKAZE")){
                             //ElMero = ElMero + "[" + (i+1) + "]";
                        }
                        if(TipoR.contains("id")){
                             ArrayList <NodoAbstracto> Expresionesxxx = new ArrayList();
                             if(entorno.ObtenerListaN(Resultado)==1){
                              Expresionesxxx = entorno.ObtenerLista(Resultado);
                                for(int p = 0; p < Expresionesxxx.size();p++){
                                 String ResulTexto = Expresionesxxx.get(p).Ejecutar(entorno, salida);
                                  if(!tipo.contains("KAMIKAZE")){
                                        ElMero = ElMero + "[" + (p+1) + "] ";
                                   }
                                 ElMero = ElMero + ResulTexto + " ";
                                 if(!tipo.contains("KAMIKAZE")){
                                        ElMero = ElMero + "\n";
                                 }
                                }
                             }else{
                                 if(!tipo.contains("KAMIKAZE")){
                                        ElMero = ElMero + "[" + (1) + "] ";
                                   }
                                 ElMero = ElMero + entorno.ObtenerValor(Resultado);
                                 if(!tipo.contains("KAMIKAZE")){
                                        ElMero = ElMero + "\n";
                                 }
                             }
                            
                        }else{
                             if(!tipo.contains("KAMIKAZE")){
                                ElMero = ElMero + "[" + (i+1) + "] ";
                             }
                              if(i+1 != this.Hijos.get(0).Expresiones.size()){
                             
                              ElMero = ElMero + Resultado + " ";
                              if(!tipo.contains("KAMIKAZE")){
                                        ElMero = ElMero + "\n";
                                 }
                            }else{
                                ElMero = ElMero + Resultado;
                                if(!tipo.contains("KAMIKAZE")){
                                        ElMero = ElMero + "\n";
                                 }
                            }
                        }
                      if(!tipo.contains("KAMIKAZE")){
                             ElMero = ElMero + "\n";
                      }
                       
                    }
            val = ElMero + "";
        
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
                String TipoXD = entorno.ObtenerTipo(val);
                System.out.println("IMPRIMIRADFASDFSADFSADF" + TipoXD);
                if(entorno.ObtenerListaN(val)==0){
                    val = entorno.ObtenerValor(val);
                }else{
                   // String ElMero = "[";
                    this.Expresiones = entorno.ObtenerLista(val);
                    for(int i = 0; i < this.Expresiones.size();i++){
                        String Resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
                        String TipoResultado = this.Expresiones.get(i).TipoDato;
                        System.out.println("TIPO->" + TipoResultado);
                              if(TipoXD.contains("Lista")){
                                     ElMero = ElMero + "["+ (i+1)+ "]";
                              }
                              if(TipoResultado.contains("id")){
                                  System.out.println("TENEMOS UN ID");
                                  if(entorno.ObtenerListaN(Resultado)==0){
                                        ElMero = ElMero +  entorno.ObtenerValor(Resultado)  + " ";
                                  }else{
                                      System.out.println("si tiene lidta diablao");
                                      for (int ix = 0; ix < entorno.ObtenerLista(Resultado).size();ix++){
                                          String RS = entorno.ObtenerLista(Resultado).get(ix).Ejecutar(entorno, salida);
                                          ElMero = ElMero + RS + " ";
                                      }
                                  }
                                  continue;
                              }if(TipoResultado.contains("FuncionC")){
                                  for(int ui = 1; ui < this.Expresiones.get(i).Hijos.size();ui++){
                                         String Salidta = this.Expresiones.get(i).Hijos.get(ui).Ejecutar(entorno, salida);
                                         ElMero = ElMero  +  Salidta + " ";
                                  }
                                  //ElMero = ElMero + "PUTA VIDA";
                              }
                              
                              else{
                                  ElMero = ElMero +  Resultado  + " ";
                              }
                              if(TipoXD.contains("Lista")){
                                     ElMero = ElMero + "\n";
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
            salida.append("" + val + ""+"\n");
           
        }else{
            TError ERRORES = new TError("Imprimir",this.linea,this.columna,"Semantico", "Error en el contenido a imprimir"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            salida.append("#Error en el contenido a imprimir: "+val +"\n");
             return "ERROR";
        }
        return "imprimir";
    }
    
    
}
