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
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Bayyron
 */
public class pie  extends NodoAbstracto{

    public pie (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        System.out.println("GRAFICA DE PIE--------------->");
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String VectorDatos = this.Hijos.get(0).Nombre;
       String Datos = this.Hijos.get(1).Nombre;
       String NombreGrafica = this.Hijos.get(2).Ejecutar(entorno, salida);
       
       if(this.Hijos.get(2).TipoDato.contains("id")){
           if(!entorno.ExisteVector(NombreGrafica)){
            salida.append("#ERROR: ERRORE EN UN PARAMETRO PIE\n");
             TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PIE"  );
             TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
             return "#Error";
           }
           if(entorno.ObtenerListaN(Datos)==0){
               NombreGrafica = entorno.ObtenerValor(NombreGrafica);
           }else{
               NombreGrafica = entorno.ObtenerLista(NombreGrafica).get(0).Ejecutar(entorno, salida);
           }
       }
       if(NombreGrafica.equalsIgnoreCase("#Error") ){
             salida.append("#ERROR: ERRORE EN UN PARAMETRO PIE\n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PIE"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
        }
      
       String TipoVector1 = entorno.ObtenerTipo(VectorDatos);
       this.Expresiones = entorno.ObtenerLista(VectorDatos);
       this.Expresiones2 = entorno.ObtenerLista(Datos);
        System.out.println("VAMOS A GRAFICAR:"+ NombreGrafica + "<->" + VectorDatos + "VRS." + Datos + "TIP1" + TipoVector1);
       if((TipoVector1.contains("entero") || TipoVector1.contains("decimal"))
               && (this.Expresiones.size() == this.Expresiones2.size())){
           //Vamos a graficar
                DefaultPieDataset dataset = new DefaultPieDataset();
                for(int i = 0; i < this.Expresiones.size(); i ++){
                    //dataset.setValue(this.Expresiones2.get(i).Ejecutar(entorno, salida), Double.parseDouble(this.Expresiones2.get(i).Ejecutar(entorno, salida)));
                    String Lado1 = this.Expresiones2.get(i).Ejecutar(entorno, salida);
                    double Lado2 = Double.parseDouble(this.Expresiones.get(i).Ejecutar(entorno, salida));
                    System.out.println("bruja->" + Lado1 + "<->" + Lado2);
                    dataset.setValue(Lado1, Lado2);
                }
                //dataset.setValue("Bayron", 20.1);
                JFreeChart pie = ChartFactory.createPieChart(NombreGrafica, dataset, true, true, false);
                ChartFrame f = new ChartFrame(NombreGrafica ,pie);
                f.setSize(1000,600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                System.out.println("FIN GRAFICA");
       
       }else{
            salida.append("#ERROR: ERRORE EN UN PARAMETRO PIE \n");
            TError ERRORES = new TError("pie",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PIE"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
       }
        
    
       return "FIN PIE";
    }
}
