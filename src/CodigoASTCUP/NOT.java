/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CodigoASTCUP;
import Codigo.Entorno;
import javax.swing.JTextArea;
/**
 *
 * @author Bayyron
 */
public class NOT extends NodoAbstracto{

    public NOT(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
    String val1 = this.Hijos.get(1).Ejecutar(entorno, salida);
        String Tipo1 = this.Hijos.get(1).TipoDato; 
        System.out.println("Entro al NOT->" + Tipo1);
        if("id".equalsIgnoreCase(Tipo1)){
            
        if(entorno.ExisteVector(this.Hijos.get(1).Nombre)){
            System.out.println("SI ENTRO AL ID NOT" + this.Hijos.get(1).Nombre);
            System.out.println("el tipo->"+ entorno.ObtenerTipo(this.Hijos.get(1).Nombre));
            if(entorno.ObtenerTipo(this.Hijos.get(1).Nombre).contains("booleano")){
                
                if(entorno.ObtenerListaN(this.Hijos.get(1).Nombre)==0){
                    if(entorno.ObtenerValor(this.Hijos.get(1).Nombre)== "true"){
                        this.TipoDato = "booleano";
                        return "true";
                    }else{
                        this.TipoDato = "booleano";
                        return "false";
                    }
                }else{
                    this.Expresiones = entorno.ObtenerLista(this.Hijos.get(1).Nombre);
                    this.Expresiones2.clear();
                    for(int i = 0; i < this.Expresiones.size(); i ++){
                        String Valor = this.Expresiones.get(i).Ejecutar(entorno, salida);
                        if(Valor.contains("true")){
                            Valor = "false";
                        }else{
                            Valor = "true";
                        }
                         NodoAbstracto nuevo = new Nodo("Booleano");
                          NodoAbstracto nuevoid = new Nodo(Valor);
                          nuevo.Hijos.add(nuevoid);
                           nuevo.TipoDato = "booleano";
                            this.Expresiones2.add(nuevo);
                    
                    }
                    entorno.ModificarValorLista(this.Hijos.get(1).Nombre, this.Expresiones2, "booleano", "as");
                    this.TipoDato = "id";
                    return this.Hijos.get(1).Nombre;
                }
            }else{
                return "#Error";
            }
        }else{
            return "#Error";
        }
        }
        if (val1.equalsIgnoreCase("#Error")){
            return "#Error";
        }
         if("booleano".equals(Tipo1)){        
             if("true".equals(val1)){
                 return "false";
             }
             else if("false".equals(val1)){
                 return "true";
             }
             else{
                 return "#Error";
             }
         }    
         return "#Error";
    
    }
}
