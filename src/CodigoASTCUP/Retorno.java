/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;

import static Analizadores.IDE.TABLA_DE_ERRORES_SINTACTICOS;
import Analizadores.TError;
import Codigo.Entorno;
import java.util.ArrayList;
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
        if(this.TipoDato.contains("Lista")){
            System.out.println("wuju");
            entorno.MostrarVectoresLista(entorno, salida);
            int TOTALITO = this.Hijos.get(0).Hijos.get(1).Hijos.size();
            System.out.println("VEAMOS EL TOTAL DE HIJOS de LISTA PUM->" + TOTALITO);
            ArrayList <NodoAbstracto> ExpresionesP = new ArrayList();
            for(int i = 0; i <this.Hijos.get(0).Hijos.get(1).Hijos.size();i++ ){
                String gallea = this.Hijos.get(0).Hijos.get(1).Hijos.get(i).Ejecutar(entorno, salida);
                String Tipo = this.Hijos.get(0).Hijos.get(1).Hijos.get(i).TipoDato;
                System.out.println("saligaPUM->" + gallea + "<->" + Tipo);
                //String NAU = entorno.ObtenerValor(gallea);
                //System.out.println("NAU->" +NAU);
                if(entorno.ObtenerListaN(gallea)==0){
                    System.out.println("NO TIENE HOJOS");
                    NodoAbstracto nuevo = new Nodo("Cadena");
                    NodoAbstracto nuevovalor = new Nodo(entorno.ObtenerValor(gallea));
                    nuevo.Hijos.add(nuevovalor);
                    nuevo.TipoDato = entorno.ObtenerTipo(gallea);
                    ExpresionesP.add(nuevo);
                }else{
                    System.out.println("SI TIENE HOJOS" + gallea);
                     ArrayList <NodoAbstracto> ExpresionesXP = new ArrayList();   
                     ExpresionesXP = entorno.ObtenerLista("SHAKALAKA");
                     System.out.println("puta");
                     System.out.println("SI TIENE HOJOS");
                     for( int t = 0; t < ExpresionesXP.size(); t ++){
                         NodoAbstracto nuevo = new Nodo("Cadena");
                            NodoAbstracto nuevovalor = new Nodo(ExpresionesXP.get(t).Ejecutar(entorno, salida));
                            nuevo.Hijos.add(nuevovalor);
                            nuevo.TipoDato =ExpresionesXP.get(t).TipoDato;
                            ExpresionesP.add(nuevo);
                    }
                }
                
                
            }
            System.out.println("TOTAL DE HIJOS PUUUM---------------------------------------->" + ExpresionesP.size());
             if(entorno.ExisteVector("ELHOUR")==false){
                entorno.Agregar2("ELHOUR", ExpresionesP, "ELHOUR", "AF");
            }else{
                entorno.ModificarValorLista("ELHOUR", ExpresionesP, "ELHOUR", "AF");
            }
            Resultado = "ELHOUR";
            this.TipoDato = "Lista";
        }
        if(this.TipoDato.contains("FuncionC")){
            int TOTALITO = this.Hijos.get(0).Hijos.get(1).Hijos.size();
            System.out.println("VEAMOS EL TOTAL DE HIJOS de SHAKA->" + TOTALITO);
            ArrayList <NodoAbstracto> ExpresionesP = new ArrayList();
            for(int i = 0; i <this.Hijos.get(0).Hijos.get(1).Hijos.size();i++ ){
                String gallea = this.Hijos.get(0).Hijos.get(1).Hijos.get(i).Ejecutar(entorno, salida);
                String Tipo = this.Hijos.get(0).Hijos.get(1).Hijos.get(i).TipoDato;
                System.out.println("saliga->" + gallea + "<->" + Tipo);
                NodoAbstracto nuevo = new Nodo("Cadena");
                NodoAbstracto nuevovalor = new Nodo(entorno.ObtenerValor(gallea));
                nuevo.Hijos.add(nuevovalor);
                nuevo.TipoDato = entorno.ObtenerTipo(gallea);
                ExpresionesP.add(nuevo);
            }
            
            if(entorno.ExisteVector("SHAKALAKA")==false){
                entorno.Agregar2("SHAKALAKA", ExpresionesP, "SHAKA", "AF");
            }else{
                entorno.ModificarValorLista("SHAKALAKA", ExpresionesP, "SHAKA", "AF");
            }
            Resultado = "SHAKALAKA";
            this.TipoDato = "SHAKA";
        }
        
        System.out.println("Valor a Retornar->" + Resultado + "Tipo->" + this.TipoDato);
        return "ESTOESUNRETORNOROMEO" +Resultado;
    

        
    }
    
}
