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
public class Retorno extends NodoAbstracto{

    public Retorno (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("ENTRO A RETORNO");
        String Resultado = this.Hijos.get(0).Ejecutar(entorno, salida);
        System.out.println("RESUTLADO-------------------------retorno>:"+ Resultado);
        if(Resultado.toUpperCase().contains("#ERROR")){
                        salida.append("ERROR EN RETORNO "+ "\n");
                        TError ERRORES = new TError("Retorno",this.linea,this.columna,"Semantico","ERROR NO EXISTE EL VECTOR " + "ERROR EN RETORNO" );
                        TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#ERROR EN RETORNO";
        }        
        this.TipoDato = this.Hijos.get(0).TipoDato;
        //this.TipoDato = "entero";
        if(this.TipoDato.contains("id")){
            if(entorno.ObtenerListaN(Resultado)==0){
                 this.TipoDato = entorno.ObtenerTipo(Resultado);
                Resultado = entorno.ObtenerValor(Resultado);
            }else{
                 this.TipoDato = entorno.ObtenerTipo(Resultado);
                 String NombreVectorRomeo = "Entorno" + Resultado;
                 if (entorno.ExisteVector(NombreVectorRomeo)==false) {
                     entorno.Agregar2(NombreVectorRomeo, entorno.ObtenerLista(Resultado) , this.TipoDato,"aaa");
                     this.TipoDato = "id";
                 }else{
                      entorno.ModificarValorLista(NombreVectorRomeo, entorno.ObtenerLista(Resultado) , this.TipoDato,"aaa");
                      this.TipoDato = "id";
                 }
                 Resultado = NombreVectorRomeo;
            }
           
        }
        System.out.println("Valor a Retornar->" + Resultado + "Tipo->" + this.TipoDato);
        return "ESTOESUNRETORNOROMEO" +Resultado;
    

        
    }
    
}
