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
public class SentenciaIFElseIF extends NodoAbstracto{

    public SentenciaIFElseIF(String Nombre) {
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
        //la parte de if ya esta
        this.Expresiones2.clear();
        for(int i = 0; i < this.Hijos.get(1).Hijos.size(); i++){
             this.Expresiones2.add(this.Hijos.get(1).Hijos.get(i));
        }
        // for(int i = 0;i< this.Expresiones.size();i++){
        //    String resultado = this.Expresiones.get(i).Ejecutar(entorno, salida);
       // }
        // System.out.println("lista1->" + this.Expresiones2.size());
         
         
         //la parte del else if
         
         //System.out.println("nombre nodo2->" + this.Hijos.get(2).Hijos.size());
         this.Expresiones.add(this.Hijos.get(2));
         //this.Expresiones.get(0).Hijos.add(this.Hijos.get(2).Hijos.get(1));
         //System.out.println("lista2->" + this.Expresiones.size());
         for(int i = 2; i<this.Hijos.get(2).Hijos.size();i++){
             //System.out.println("iiii" + i);
            this.Expresiones.add(this.Hijos.get(2).Hijos.get(i));
         }
         
         //System.out.println("lista2->" + this.Expresiones.size());
       ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
        String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
         if(ValorExpresion.contains("RomeoAxpuac")){
            ExpresionesRomeo.clear();
        ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
            ValorExpresion =  ExpresionesRomeo.get(0).Ejecutar(entorno, salida);
        }
        switch (ValorExpresion.toLowerCase()) {
            case "true":
                if(this.Expresiones2.size() == 0){
                    salida.append("#ERROR: La Sentencia del IF es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    
                }else{
                    System.out.println("ejecutemos sentencias");
                    Entorno Temporal = new Entorno();
                    entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                    //String ValorExpresion2 = this.Hijos.get(1).Ejecutar(entorno, salida);
                    //String nombre = this.Hijos.get(1).Nombre;
                    System.out.println("-><-" + this.Expresiones2.size() + "<->");
                    for(int i = 0; i < this.Expresiones2.size();i++){
                        String Resultado = this.Expresiones2.get(i).Ejecutar(Temporal, salida);
                        
                        if("break".equals(Resultado)){
                           //-> entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            
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
                            NumeroEntornosRomeo--;
                         if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                                return "break";
                        }
                        if("continue".equals(Resultado)){
                        //->    entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "continue";
                       }
                       if(Resultado.contains("ESTOESUNRETORNOROMEO")){
                        //->    entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
                        
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return Resultado;
                       }
                    }
                //->    entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
                
                
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                     return "FIN ELSEIF";
                }
                break;
            case "false":
                 System.out.println("Entro al else if");
                 Entorno Temporal = new Entorno();
                 int bandera = 0;
                 entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                for(int i = 0 ; i< this.Expresiones.size();i++){
                    String Resultadox = this.Expresiones.get(i).Hijos.get(0).Ejecutar(Temporal, salida);
                       if(Resultadox.contains("RomeoAxpuac")){
                            ExpresionesRomeo.clear();
                            ExpresionesRomeo = Temporal.ObtenerLista("VectorDragonBallBeatles");
                            Resultadox =  ExpresionesRomeo.get(0).Ejecutar(Temporal, salida);
                        }
                    System.out.println("sadfjaslkdjfklasd adfasdf->" + Resultadox );
                     switch (Resultadox.toLowerCase()) {
                        case "true":
                            for(int xx = 0; xx < this.Expresiones.get(i).Hijos.get(1).Hijos.size() ; xx ++){
                                String VamosAVer = this.Expresiones.get(i).Hijos.get(1).Hijos.get(xx).Ejecutar(Temporal, salida);
                                if("break".equals(VamosAVer)){
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
                                NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                                        return "break";
                                        }
                          if("continue".equals(VamosAVer)){
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
                            
                            
                            
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                                            return "continue";
                                       }
                  if(VamosAVer.contains("ESTOESUNRETORNOROMEO")){
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
                            
                            
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return VamosAVer;
                         }
                            
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
                            
                            
                            
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "FIN ELSE IF";
                        case "false":
                         //   if((i + 1) ==  this.Expresiones.size() && NumeroEntornosRomeo!=0){
                         //       return "false";
                         //   }else{
                         //       continue;
                         //   }
                            
                            //return "false";
                            //continue;
                         //entorno.ModificarValorLista(palabras[0], Temporal.ObtenerLista(palabras[0]), palabras[1], "");
                         break;
                            
                            
                            
                        default:
                            break;
                    } 
                }
                if(bandera == 0){
                    //ejecutamos el else :D
                    System.out.println("LA ULTIMA OCPION COMO YO");
                    if(this.Hijos.get(3) ==null){
                        System.out.println("si es null a chingar a su madre");
                        return "Fin";
                    }
                    if(this.Hijos.get(3)!=null){
                        System.out.println("ESTO ES UN ELSE->");
                        this.Expresiones2.clear();
                        for(int i = 0; i < this.Hijos.get(3).Hijos.size(); i++){
                             this.Expresiones2.add(this.Hijos.get(3).Hijos.get(i));
                        }
                        //Entorno Temporal = new Entorno();
                        entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                        
                        for(int i = 0; i < this.Expresiones2.size(); i ++){
                            String Resuladito = this.Expresiones2.get(i).Ejecutar(Temporal, salida);
                             if("break".equals(Resuladito)){
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
                                
                                
                                NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                                        return "break";
                             }
                             if("continue".equals(Resuladito)){
                                //->entorno = entorno.ModificandoEntornos(Temporal,entorno);
                                
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
                                
                                
                                NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                                            return "continue";
                              }
                            if(Resuladito.contains("ESTOESUNRETORNOROMEO")){
                       //->      entorno = entorno.ModificandoEntornos(Temporal,entorno);
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
                             
                             
                                NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return Resuladito;
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
                        
                                NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "FIN ELSEIF";
                    }
                    System.out.println("ACA IRIA EL ELSE NADA MAS");
                }
                break;
            default:
                salida.append("#ERROR: La Expresión del IF es incorrecta \n");
                TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "La Expresión del IF es incorrecta"  );
                TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                System.out.println("ERROR");
                break;
        }
        
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
        return "FIN ELSEIF";
    }

    
}
