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
        
        
        System.out.println("Se esta ejecutando el if");
        String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
        System.out.println("->"+ ValorExpresion);
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
                    entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                    System.out.println("-><-" + this.Expresiones.size() + "<->");
                    for(int i = 0; i < this.Expresiones.size();i++){
                        String Resultado = this.Expresiones.get(i).Ejecutar(Temporal, salida);
                        System.out.println("gracias por ser mi amiga->" + Resultado); 
                        if("break".equals(Resultado)){
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "break";
                        }
                        if("continue".equals(Resultado)){
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "continue";
                       }
                        if(Resultado.contains("ESTOESUNRETORNOROMEO")){
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
                    entorno = entorno.ModificandoEntornos(Temporal,entorno);
                    //System.out.println("vamos a ver que pedo2");
                    //entorno.MostrarVectores();
                }
                break;
            case "false":
                System.out.println("PUES NO ENTRO AL IF");
                
                if(this.Hijos.get(2)!= null){
                    System.out.println("-><-" + this.Expresiones2.size() + "<->");
                    Entorno Temporal = new Entorno();
                    entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
                    for(int i = 0; i < this.Expresiones2.size();i++){
                        String Resultado = this.Expresiones2.get(i).Ejecutar(Temporal, salida);
                        System.out.println("RESULTADOOOOOOOOOOOOOO_>" + Resultado);
                        if("break".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "break";
                        }
                        if("continue".equals(Resultado)){
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return "continue";
                       }
                        if(Resultado.contains("ESTOESUNRETORNOROMEO")){
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
                    entorno = entorno.ModificandoEntornos(Temporal,entorno);
                    //System.out.println("vamos a ver que pedo2");
                    //entorno.MostrarVectores();
                }
                System.out.println("FIN DEL NO IF");
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
