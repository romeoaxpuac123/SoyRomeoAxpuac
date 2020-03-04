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
            System.out.println("SE ESTA EJECUTANDO WILE");
            System.out.println("Total de WHILE: " + this.Expresiones.size());
            String ValorExpresion = this.Hijos.get(0).Ejecutar(entorno, salida);
            System.out.println("->"+ ValorExpresion);
            if(this.Expresiones.size() == 0){
                    salida.append("#ERROR: La Sentencia del While es incorrecta \n");
                    TError ERRORES = new TError("IF",this.linea,this.columna,"Semantico", "ERROR: La Sentencia del IF es incorrecta"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#error en while";
            }
             Entorno Temporal = new Entorno();
             entorno.AgregarElementosANuevoEntorno(entorno,Temporal);
            while("true".equals(ValorExpresion.toLowerCase())){
                
                for(int i = 0; i < this.Expresiones.size(); i++){
                    this.Expresiones.get(i).Ejecutar(Temporal, salida);
                }
                ValorExpresion = this.Hijos.get(0).Ejecutar(Temporal, salida);
                System.out.println("amoramio" + ValorExpresion);
            }
            entorno = entorno.ModificandoEntornos(Temporal,entorno);
            return "FIN WHILE";
    }
    
}
