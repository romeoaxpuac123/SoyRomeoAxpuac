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
              System.out.println("VAMS A PLOETANR ALGO QUE NO ES O");
             System.out.println("VAMOS A PLOTEAR UNA MATRIZ");
                //POR EL MOMENTO SOLO UN VECTOR xd
                //ACÁ IRIA EL PLOTEO xd
                XYSeries series = new XYSeries(TipoGrafica);
                this.Expresiones = entorno.ObtenerLista(VectorNumeros);
                this.Expresiones2 = entorno.ObtenerLista(TituloGrafica);
                double limiteInicial = 0;//Double.parseDouble(this.Expresiones2.get(0).Ejecutar(entorno, salida));
                double limiteFinal = 0;
                if(this.Expresiones2.size() ==2){
                    limiteInicial = Double.parseDouble(this.Expresiones2.get(0).Ejecutar(entorno, salida));
                    limiteFinal = Double.parseDouble(this.Expresiones2.get(1).Ejecutar(entorno, salida));
                }else{
                    salida.append("#ERROR: ERRORE EN UN PARAMETRO PLOT\n");
                    TError ERRORES = new TError("histograma",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO PLOT"  );
                    TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
                    
                    return "#Error";
                }
                
                
                for(int i = 0; i < this.Expresiones.size(); i++){
                    double numerito = Double.parseDouble(this.Expresiones.get(i).Ejecutar(entorno, salida));
                    if(numerito > limiteInicial && numerito < limiteFinal){
                        series.add(i+1,numerito);
                    }
                    
                }
                XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series);
                JFreeChart  chart = ChartFactory.createScatterPlot(TipoGrafica, Nombrex, NombreY, dataset, PlotOrientation.VERTICAL, true, true, true);
                ChartFrame f = new ChartFrame("Titulo",chart);
            f.setSize(1000,600);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
          
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
