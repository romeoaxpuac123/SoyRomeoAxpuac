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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Bayyron
 */
public class plot extends NodoAbstracto{

    public plot(String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String VectorNumeros = this.Hijos.get(0).Nombre;
        String TipoGrafica = this.Hijos.get(1).Ejecutar(entorno, salida).replaceAll("\"", "");
        String Nombrex = this.Hijos.get(2).Ejecutar(entorno, salida).replaceAll("\"", "");
        String NombreY = this.Hijos.get(3).Ejecutar(entorno, salida).replaceAll("\"", "");
        String TituloGrafica = this.Hijos.get(4).Ejecutar(entorno, salida).replaceAll("\"", "");
         System.out.println("VAMOS A GRAFICIAR EL PLOT CON NOMBRE->" + VectorNumeros + " Tipo grafica:" + TipoGrafica
        + "Titlo grafica:>" + TituloGrafica);
         //empezamos a graficar
        boolean Existencia = entorno.ExisteVector(VectorNumeros);
        String TipoVector = entorno.ObtenerTipo(VectorNumeros);
        if(Existencia = true && (TipoVector.contains("entero") || TipoVector.contains("decimal"))){
          if("P".equals(TipoGrafica.toUpperCase()) || "I".equals(TipoGrafica.toUpperCase()) || "O".equals(TipoGrafica.toUpperCase())){
              XYSeries series = new XYSeries("Titulo");
              this.Expresiones = entorno.ObtenerLista(VectorNumeros);
              for(int i = 0; i < this.Expresiones.size(); i++){
                  series.add(i+1,Double.parseDouble(this.Expresiones.get(i).Ejecutar(entorno, salida)));
              }
              XYSeriesCollection dataset = new XYSeriesCollection();
              dataset.addSeries(series);
              JFreeChart  chart = null;
              if("I".equals(TipoGrafica.toUpperCase())){
                chart = ChartFactory.createXYLineChart(TituloGrafica, Nombrex, NombreY, dataset, PlotOrientation.VERTICAL, true, true, true);
              }else if ("P".equals(TipoGrafica.toUpperCase())){
                chart = ChartFactory.createScatterPlot(TituloGrafica, Nombrex, NombreY, dataset, PlotOrientation.HORIZONTAL, true, true, true);
              }else if ("O".equals(TipoGrafica.toUpperCase())){
                  chart = ChartFactory.createXYAreaChart(TituloGrafica, Nombrex, NombreY, dataset, PlotOrientation.VERTICAL, true, true, true);
              }else{
                   salida.append("#ERROR: ERRORE EN UN PARAMETRO PLOT\n");
                    TError ERRORES = new TError("histograma",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PLOT"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    return "#Error";
              }
              ChartFrame f = new ChartFrame(TituloGrafica,chart);
            f.setSize(1000,600);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
              
          }else{
            salida.append("#ERROR: ERRORE EN UN PARAMETRO PLOT\n");
            TError ERRORES = new TError("histograma",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PLOT"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
          }
          
        }else{
            salida.append("#ERROR: ERRORE EN UN PARAMETRO PLOT\n");
            TError ERRORES = new TError("histograma",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PLOT"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
            
        }
        return "FIN PLOT";
    }

    
}
