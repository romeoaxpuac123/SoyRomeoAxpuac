/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.NumeroEntornosRomeo;
import Codigo.Entorno;
import java.util.ArrayList;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class Switch extends NodoAbstracto{

    public Switch(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
        System.out.println("El valor a evaluar->" + ValorExpresion);
        ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
        ExpresionesRomeo = entorno.ObtenerLista(ValorExpresion);
        if(this.Hijos.get(0).TipoDato.contains("id") && entorno.ObtenerListaN(ValorExpresion)==1){
            ValorExpresion =  ExpresionesRomeo.get(0).Ejecutar(entorno, salida);
        }else if(this.Hijos.get(0).TipoDato.contains("id")){
            ValorExpresion = entorno.ObtenerValor(ValorExpresion);
        }
        //Sacando el total de CASES
          ElTipoDeAmbitoRomeo = "Local: SWITCH";
               NumeroEntornosRomeo++;
        System.out.println("Total de Cases" + this.Hijos.get(1).Hijos.size());
         this.Expresiones.add(this.Hijos.get(1));
         for(int i = 2; i<this.Hijos.get(1).Hijos.size();i++){
            this.Expresiones.add(this.Hijos.get(1).Hijos.get(i));
         }
         System.out.println("tamaño de cases" + this.Expresiones.size());
         Entorno Temporal = new Entorno();
         entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
         int bandera = 0;
         for(int i = 0; i < this.Expresiones.size(); i ++){
             String Resultado = this.Expresiones.get(i).Hijos.get(0).Ejecutar(Temporal, salida);
             System.out.println("i->" + i + "->" + ValorExpresion  + "<->" + Resultado);
             
             if(ValorExpresion.equals(Resultado)){
                 
                 for(int x = 0; x < this.Expresiones.get(i).Hijos.get(1).Hijos.size();x++){
                     String Resultadox = this.Expresiones.get(i).Hijos.get(1).Hijos.get(x).Ejecutar(Temporal, salida);
                     if("break".equals(Resultadox)){
                     //       entorno = entorno.ModificandoEntornos(Temporal,entorno);
                     //   return "break";
                     bandera = 1;
                     break;
                     }
                        if(Resultado.contains("ESTOESUNRETORNOROMEO")){
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
                            return Resultado;
                       }
                 }
                 if (bandera == 1){
                     break;
                 }
             }
             
         }
         if(this.Hijos.get(2)!=null && bandera == 0){
         //acá se ejecuta el default
            for(int i = 0; i < this.Hijos.get(2).Hijos.size();i++){
                String Resultado = this.Hijos.get(2).Hijos.get(i).Ejecutar(Temporal, salida);
                if("break".equals(Resultado)){
                        //    entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
                           if(Resultado.contains("ESTOESUNRETORNOROMEO")){
                            // entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
                            return Resultado;
                       }
            }
         }
        // entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
        return "FIN SWITHC";
    }
    
}
