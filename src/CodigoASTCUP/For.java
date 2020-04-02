/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.NumeroEntornosRomeo;
import Analizadores.TError;
import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class For extends NodoAbstracto{

    public For (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        
        this.Expresiones.clear();
            for(int i = 0; i < this.Hijos.get(2).Hijos.size(); i++){
                this.Expresiones.add(this.Hijos.get(2).Hijos.get(i));
            }
            
       String NombreTemporal = this.Hijos.get(0).Nombre;
       String ExpresionTemporal =this.Hijos.get(0).Ejecutar(entorno, salida);
       String TipoTemporal = entorno.ObtenerTipo(this.Hijos.get(0).Nombre); 
        
        
       String TipoVariable1 =this.Hijos.get(0).TipoDato;
       System.out.println("Variable 1: " + TipoVariable1);
       Entorno Temporal = new Entorno();
       entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
        ElTipoDeAmbitoRomeo = "Local: FOR";
        NumeroEntornosRomeo++;
        
        //trabajemos los valores de la expresion 1
        if("id".equals(TipoVariable1)){
            String NombreVariable1 = this.Hijos.get(0).Nombre;
            String NombreVariable2 = this.Hijos.get(1).Nombre;
            String TipoVariable2 = this.Hijos.get(1).TipoDato;
            String ValorVariable2 = this.Hijos.get(1).Ejecutar(Temporal, salida);
            System.out.println("NombreVariable2->" + NombreVariable2 + "Tipo2" + TipoVariable2); 
            System.out.println("NombreVariable1->" + NombreVariable1);
            if(Temporal.ExisteVector(NombreVariable1)==false){
                Temporal.Agregar(NombreVariable1, "entero", "1");
            }
            if("entero".equals(TipoVariable2) || "decimal".equals(TipoVariable2) || "cadena".equals(TipoVariable2) || "booleano".equals(TipoVariable2) ){
                Temporal.ModificarValor(NombreVariable1,ValorVariable2 , TipoVariable2);
                for(int x = 0; x < this.Expresiones.size(); x++){
                        String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
                         if("break".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                }
            }else if("id".equals(TipoVariable2)){
                if(Temporal.ObtenerListaN(NombreVariable2)==0){
                    System.out.println("ES VECTOR CORTO");
                    Temporal.ModificarValor(NombreVariable1,ValorVariable2 , Temporal.ObtenerTipo(NombreVariable2));
                    for(int x = 0; x < this.Expresiones.size(); x++){
                            String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
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
                                if(ejemploLista.get(pp).contains("VectorDragonBallBeatles")==false){
                                String[] palabras = ejemploLista.get(pp).split(";");
                                for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                    String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                    System.out.println("enloquecerse->" + EsoMero);
                                }
                            }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            
                            
                            
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                    }                
                }else{
                    System.out.println("ES VECTOR LARGO");
                    for(int i = 0; i< Temporal.ObtenerLista(NombreVariable2).size();i++){
                        String ValorNuevo = Temporal.ObtenerLista(NombreVariable2).get(i).Ejecutar(Temporal, salida);
                        String TipoNuevo = Temporal.ObtenerLista(NombreVariable2).get(i).TipoDato;
                        //System.out.println("El nuevo valor->" + ValorNuevo);
                        //System.out.println("El nuevo Tipo->" + TipoNuevo);
                        Temporal.ModificarValor(NombreVariable1,ValorNuevo,TipoNuevo);
                        for(int x = 0; x < this.Expresiones.size(); x++){
                            String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
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
                                if(ejemploLista.get(pp).contains("VectorDragonBallBeatles")==false){
                                String[] palabras = ejemploLista.get(pp).split(";");
                                for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                    String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                    System.out.println("enloquecerse->" + EsoMero);
                                }
                            }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                        } 
                    }
                }
            }else if("vector".equals(TipoVariable2)){
                String ValorNuevo = this.Hijos.get(1).Ejecutar(Temporal, salida);
                String TipoNuevo = this.Hijos.get(1).TipoDato;
                System.out.println("VAMOS CON EL ENUEVO VALOR->" + ValorNuevo + "->Tipo" + TipoNuevo);
                Temporal.ModificarValor(NombreVariable1,ValorNuevo,TipoNuevo);
                for(int x = 0; x < this.Expresiones.size(); x++){
                    String Resultado = this.Expresiones.get(x).Ejecutar(Temporal, salida);
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
                                if(ejemploLista.get(pp).contains("VectorDragonBallBeatles")==false){
                                String[] palabras = ejemploLista.get(pp).split(";");
                                for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                    String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                    System.out.println("enloquecerse->" + EsoMero);
                                }
                            }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
                            System.out.println("NombreTemporal" + NombreTemporal);
                            //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN FOR";
                        }
                         if("continue".equals(Resultado)){
                             x = this.Expresiones.size()-1;
                        }
                } 
            }
            
        }else{
            salida.append("#ERROR: La expresion1 debe ser un vector + \n");
            TError ERRORES = new TError("FOR",this.linea,this.columna,"Semantico", "#ERROR: La expresion1 debe ser un vector");
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
            return "#ERROR: La expresion1 debe ser un vector";
        }
               
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
                                if(ejemploLista.get(pp).contains("VectorDragonBallBeatles")==false){
                                String[] palabras = ejemploLista.get(pp).split(";");
                                for(int px = 0; px < Temporal.ObtenerLista(palabras[0]).size();px++){
                                    String EsoMero = Temporal.ObtenerLista(palabras[0]).get(px).Ejecutar(Temporal, salida);
                                    System.out.println("enloquecerse->" + EsoMero);
                                }
                            }
                         
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         
                     }
                     //finprocesos de vecotres con lista
                            System.out.println("terminamos el if--->");
                            entorno.MostrarVectores();
                            System.out.println("<-->");
        
        System.out.println("NombreTemporal" + NombreTemporal);
        //entorno.ModificarValor(NombreTemporal,ExpresionTemporal,TipoTemporal);
      
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
       return "FINFOR";
    }
    
}
