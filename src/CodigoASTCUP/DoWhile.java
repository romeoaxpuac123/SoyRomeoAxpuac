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
import Analizadores.ReporteTS;
import Codigo.Entorno;
import javax.swing.JTextArea;

/**
 *
 * @author Bayyron
 */
public class DoWhile extends NodoAbstracto{

    public DoWhile  (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
            this.Expresiones.clear();
            for(int i = 0; i < this.Hijos.get(1).Hijos.size(); i++){
                this.Expresiones.add(this.Hijos.get(1).Hijos.get(i));
            }
            System.out.println("SE ESTA EJECUTANDO WILE");
            System.out.println("Total de WHILE: " + this.Expresiones.size());
            String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
            System.out.println("->"+ ValorExpresion);
            if(this.Expresiones.size() == 0){
                    salida.append("#ERROR: La Sentencia del While es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                    return "#error en while";
            }
             Entorno Temporal = new Entorno();
             entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
            do{
                ElTipoDeAmbitoRomeo = "Local: DoWhile";
                NumeroEntornosRomeo++;
                for(int i = 0; i < this.Expresiones.size(); i++){
                    String Resultado = this.Expresiones.get(i).Ejecutar(Temporal, salida);
                    if("break".equals(Resultado)){
                        entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "break";
                    }
                    if("continue".equals(Resultado)){
                       i = this.Expresiones.size()-1;
                    }
                    if(Resultado.contains("ESTOESUNRETORNOROMEO")){
                             entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                            return Resultado;
                       }
                }
                ValorExpresion = this.Hijos.get(0).Ejecutar(Temporal, salida);
                System.out.println("amoramio" + ValorExpresion);
            }while("true".equals(ValorExpresion.toLowerCase()));
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
            entorno = entorno.ModificandoEntornos(Temporal,entorno);
        return "FIN DO WHILE";
    }
}
