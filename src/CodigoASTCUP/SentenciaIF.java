/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.NumeroEntornosRomeo;
import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class SentenciaIF extends NodoAbstracto{

    public SentenciaIF (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        ElTipoDeAmbitoRomeo = "Local: IF";
        NumeroEntornosRomeo++;
        this.Expresiones.clear();
            for(int i = 0; i < this.Hijos.get(1).Hijos.size(); i++){
                this.Expresiones.add(this.Hijos.get(1).Hijos.get(i));
            }
        if(this.Hijos.get(2)!= null){
            this.Expresiones2.clear();
            for(int i = 0; i < this.Hijos.get(2).Hijos.size(); i++){
                this.Expresiones2.add(this.Hijos.get(2).Hijos.get(i));
            }
        }
        
        ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
        System.out.println("Se esta ejecutando el if");
        String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
        System.out.println("->"+ ValorExpresion);
        
        if(ValorExpresion.contains("RomeoAxpuac")){
            ExpresionesRomeo.clear();
        ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
            ValorExpresion =  ExpresionesRomeo.get(0).Ejecutar(entorno, salida);
        }
        
        System.out.println("XXXy->" + ValorExpresion);
        //if(!"true".equals(ValorExpresion) || !"false".equals(ValorExpresion)){
        //    System.out.println("ERROR EN LA EXPRESION");
        //     return "#Error";
        // }
        
        switch (ValorExpresion.toLowerCase()) {
            case "true":
                System.out.println("PUES SI ENTRO AL IF");
                if(this.Expresiones.size() == 0){
                    salida.append("#ERROR: La Sentencia del IF es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    NumeroEntornosRomeo--;
                    if(NumeroEntornosRomeo==0)
                    ElTipoDeAmbitoRomeo = "Global";
                            return "ERROR";
                }else{
                    System.out.println("ejecutemos sentencias");
                    //String ValorExpresion2 = this.Hijos.get(1).Ejecutar(entorno, salida);
                    //String nombre = this.Hijos.get(1).Nombre;
                    //Entorno Global = new Entorno();
                    Entorno Temporal = new Entorno();
                    Temporal.AgregarElementosANuevoEntorno(entorno,Temporal);
                    System.out.println("-><-" + this.Expresiones.size() + "<->");
                    for(int i = 0; i < this.Expresiones.size();i++){
                        String Resultado = this.Expresiones.get(i).Ejecutar(Temporal, salida); //->
                        System.out.println("gracias por ser mi amiga->" + Resultado); 
                        if("break".equals(Resultado)){
                            //entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            ArrayList<String> ejemploLista = new ArrayList<String>(); 
                            ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                            }
                                  //proceso de vectores con listas
                    ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                    for(int pp = 0; pp < ejemploLista.size();pp++){
                         System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                         String[] palabras = ejemploLista.get(pp).split(";");
                         for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                             String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                             System.out.println("enloquecerse->" + EsoMero);
                         }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "break";
                        }
                        if("continue".equals(Resultado)){
                            //entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            ArrayList<String> ejemploLista = new ArrayList<String>(); 
                            ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                            }
                                  //proceso de vectores con listas
                    ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                    for(int pp = 0; pp < ejemploLista.size();pp++){
                         System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                         String[] palabras = ejemploLista.get(pp).split(";");
                         for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                             String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                             System.out.println("enloquecerse->" + EsoMero);
                         }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "continue";
                       }
                        if(Resultado.contains("ESTOESUNRETORNOROMEO")){
                            ArrayList<String> ejemploLista = new ArrayList<String>(); 
                            ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                            }
                            //proceso de vectores con listas
                            ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                 System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                                 String[] palabras = ejemploLista.get(pp).split(";");
                                 for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                     String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                     System.out.println("enloquecerse->" + EsoMero);
                                 }

                                 //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");

                             }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            entorno.MostrarVectoresLista(entorno, salida);
                            System.out.println("<-->");
                            this.TipoDato = this.Expresiones.get(i).TipoDato;
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return Resultado;
                       }
                       
                    }
                    //System.out.println("vamos a ver que pedo");
                    //entorno.MostrarVectores();
                    //System.out.println("libres");
                    //Temporal.MostrarVectores();
                     //Entorno pepa = new Entorno();
                     //pepa = entorno;
                     //entorno.Elementos.clear();
                     //entorno = Temporal.ModificandoEntornos(Temporal,entorno);
                     ArrayList<String> ejemploLista = new ArrayList<String>(); 
                     ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                     for(int pp = 0; pp < ejemploLista.size();pp++){
                         System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                         String[] palabras = ejemploLista.get(pp).split(";");
                         entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);
                         
                     }
                     //proceso de vectores con listas
                    ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                    for(int pp = 0; pp < ejemploLista.size();pp++){
                         System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                         String[] palabras = ejemploLista.get(pp).split(";");
                         for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                             String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                             System.out.println("enloquecerse->" + EsoMero);
                         }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                     System.out.println("terminamos el if--->");
                     entorno.MostrarVectores();
                     entorno.MostrarVectoresLista(entorno, salida);
                     System.out.println("<-->");
                     return "FIN IF";
                    //System.out.println("vamos a ver que pedo2");
                    //entorno.MostrarVectores();
                }
               // break;
            case "false":
                System.out.println("PUES NO ENTRO AL IF");
                
                if(this.Hijos.get(2)!= null){
                    System.out.println("-><-" + this.Expresiones2.size() + "<->");
                     Entorno Temporal = new Entorno();
                     Temporal.AgregarElementosANuevoEntorno(entorno,Temporal);
                    for(int i = 0; i < this.Expresiones2.size();i++){
                        String Resultado = this.Expresiones2.get(i).Ejecutar(Temporal, salida); //->
                        System.out.println("RESULTADOOOOOOOOOOOOOO_>" + Resultado);
                        if("break".equals(Resultado)){
  //->                          entorno = entorno.ModificandoEntornos(entorno,entorno); //->
                                ArrayList<String> ejemploLista = new ArrayList<String>(); 
                                ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                                for(int pp = 0; pp < ejemploLista.size();pp++){
                                    System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                    String[] palabras = ejemploLista.get(pp).split(";");
                                    entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                                }
                                  //proceso de vectores con listas
                                ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                                for(int pp = 0; pp < ejemploLista.size();pp++){
                                     System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                                     String[] palabras = ejemploLista.get(pp).split(";");
                                     for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                         String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                         System.out.println("enloquecerse->" + EsoMero);
                                }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                                }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "break";
                        }
                        if("continue".equals(Resultado)){
  //->                          entorno = entorno.ModificandoEntornos(entorno,entorno); //->
                            ArrayList<String> ejemploLista = new ArrayList<String>(); 
                            ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                            }
                                  //proceso de vectores con listas
                            ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                    String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                    System.out.println("enloquecerse->" + EsoMero);
                            }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "continue";
                       }
                        if(Resultado.contains("ESTOESUNRETORNOROMEO")){
                            System.out.println("ACA ESTA EL VALOR DEL RETORNO");
                            ArrayList<String> ejemploLista = new ArrayList<String>(); 
                            ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                            }
                                  //proceso de vectores con listas
                            ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                            System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                            String[] palabras = ejemploLista.get(pp).split(";");
                            for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                System.out.println("enloquecerse->" + EsoMero);
                            }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            
                            
                            
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            this.TipoDato = this.Expresiones2.get(i).TipoDato;
                            return Resultado;
                       }
                    }
                    //System.out.println("vamos a ver que pedo");
                    //entorno.MostrarVectores();
                    //System.out.println("libres");
                    //Temporal.MostrarVectores();
//->                    entorno = entorno.ModificandoEntornos(Temporal,entorno);
                        ArrayList<String> ejemploLista = new ArrayList<String>(); 
                            ejemploLista = Temporal.ModificandoEntornosLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                                System.out.println("VALOR EJEMPLOLISTA->" + ejemploLista.get(pp));
                                String[] palabras = ejemploLista.get(pp).split(";");
                                entorno.ModificarValor(palabras[0], palabras[1], palabras[2]);

                            }
                                  //proceso de vectores con listas
                            ejemploLista = Temporal.ModificandoEntornosVectorLista(Temporal, entorno);
                            for(int pp = 0; pp < ejemploLista.size();pp++){
                            System.out.println("VALOR EJEMPLOLISTAlargaaaaaaa->" + ejemploLista.get(pp));
                            String[] palabras = ejemploLista.get(pp).split(";");
                            for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                System.out.println("enloquecerse->" + EsoMero);
                            }

                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                    //System.out.println("vamos a ver que pedo2");
                    //entorno.MostrarVectores();
                }
                System.out.println("FIN DEL NO IFx");
                break;
            default:
                salida.append("#ERROR: La Expresión del IF es incorrecta \n");
                TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "La Expresión del IF es incorrecta"  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                System.out.println("ERROR");
                break;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
        return "Fin IF";
    }
    
    
}
