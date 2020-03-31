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
public class While extends NodoAbstracto{

    public While  (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
            System.out.println("Total de sentencias" + this.Hijos.get(1).Hijos.size());
            this.Expresiones.clear();
            for(int i = 0; i < this.Hijos.get(1).Hijos.size(); i++){
                this.Expresiones.add(this.Hijos.get(1).Hijos.get(i));
            }
            ElTipoDeAmbitoRomeo = "WHILE";
            System.out.println("SE ESTA EJECUTANDO WILE");
            System.out.println("Total de WHILE: " + this.Expresiones.size());
            String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
            System.out.println("SADFDSAFADSFA***************************->"+ ValorExpresion);
            ArrayList <NodoAbstracto> ExpresionesRomeo = new ArrayList();
            ArrayList <NodoAbstracto> ExpresionesRomeo2 = new ArrayList();
                if(ValorExpresion.contains("RomeoAxpuac")){
                ExpresionesRomeo.clear();
                ExpresionesRomeo = entorno.ObtenerLista("VectorDragonBallBeatles");
                ValorExpresion =  ExpresionesRomeo.get(0).Ejecutar(entorno, salida);
            }
            if(this.Expresiones.size() == 0){
                    salida.append("#ERROR: La Sentencia del While es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#error en while";
            }
            Entorno Temporal = new Entorno();
            entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
            
          
            System.out.println("asjflkjasdlkfjlasd-"+ this.Expresiones.size() );
            while("true".equals(ValorExpresion.toLowerCase())){
               
                    System.out.println("ENTRAMOS AL WHILEEEEEEEEEEEEEEEE-->");
                for(int q = 0; q < this.Expresiones.size(); q++){
                     String Resultado = this.Expresiones.get(q).Ejecutar(Temporal, salida);
                              
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
                        return "break";
                    }
                    if("continue".equals(Resultado)){
                       q = this.Expresiones.size()-1;
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
                    System.out.println("----stodaiva------>" + Resultado);
                }
                ValorExpresion = this.Hijos.get(0).Ejecutar(Temporal, salida);
                
                System.out.println("----------PORLO MENOS--------------------->" + ValorExpresion);
                
                ArrayList <NodoAbstracto> ExpresionesRomeo2x = new ArrayList();
                String ValorXD = "";  
                ExpresionesRomeo2x.clear();
               
                ExpresionesRomeo2x = Temporal.ObtenerLista("VectorDragonBallBeatles");
                //System.out.println("DEFINITIVO->" + ExpresionesRomeo2x.size());
                
                if(ValorExpresion.contains("RomeoAxpuac") && ExpresionesRomeo2x!=null && ExpresionesRomeo2x.size()>0){
                                   System.out.println("ICIOIFWHIWLE" + ExpresionesRomeo2x.size()); 
                
              
                     ValorXD =  ExpresionesRomeo2x.get(0).Ejecutar(Temporal, salida);
                                System.out.println("FINCIOIFWHIWLE"); 
                                ValorExpresion = ValorXD;
                }
                //ValorExpresion = ValorXD;

                System.out.println("EL IDIOTA-------->" + ValorXD);

                System.out.println("----------PORLO MENOS2--------------------->" + ValorExpresion);
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
            ElTipoDeAmbitoRomeo = "Global";
            return "FIN WHILE";
    }
    
}
