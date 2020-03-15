/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.ElTipoDeAmbitoRomeo;
import static Analizadores.IDE.NumeroEntornosRomeo;
import Codigo.Entorno;
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
                            entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
                        return "break";
                        }
            }
         }
         entorno = entorno.ModificandoEntornos(Temporal,entorno);
                            NumeroEntornosRomeo--;
                                if(NumeroEntornosRomeo==0)
                                ElTipoDeAmbitoRomeo = "Global";
        return "FIN SWITHC";
    }
    
}
