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
import org.jfree.data.statistics.HistogramDataset;

/**
 *
 * @author Bayyron
 */
public class histograma extends NodoAbstracto{

    public histograma (String Nombre) {
        super(Nombre);
    }

    @Override
    public void Ejecutar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String Ejecutar(Entorno entorno, JTextArea salida) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String VectroNumeros = this.Hijos.get(0).Nombre;
        String TituloGrafica = this.Hijos.get(1).Nombre;
        String Nombrex = this.Hijos.get(2).Nombre;
        System.out.println("VAMOS A GRAFICIAR EL HISTOGRAMA CON NOMBRE->" + VectroNumeros + " Nombre grafica:" + Nombrex
        + "Titlo grafica:>" + TituloGrafica);
        boolean Existencia = entorno.ExisteVector(VectroNumeros);
        String TipoVector = entorno.ObtenerTipo(VectroNumeros);
        if(Existencia = true && (TipoVector.contains("entero") || TipoVector.contains("decimal"))){
                System.out.println("si vamos a graficar");
                HistogramDataset dataset = new HistogramDataset();
                this.Expresiones = entorno.ObtenerLista(VectroNumeros);
                double vector[] = new double[this.Expresiones.size()];              //{10,15,5,8,7,4,11,18,27,14,12};
                for(int i = 0; i < this.Expresiones.size(); i ++){
                   String Salida = this.Expresiones.get(i).Ejecutar(entorno, salida);
                    vector[i] = Double.parseDouble(Salida);
                }
                
                dataset.addSeries(TituloGrafica, vector, vector.length);
                JFreeChart chart = ChartFactory.createHistogram(TituloGrafica, Nombrex, null, dataset, PlotOrientation.VERTICAL, true, true, true);
                ChartFrame f = new ChartFrame(TituloGrafica,chart);
                f.setSize(1000,600);
                f.setLocationRelativeTo(null);
                f.setVisible(true);
                
        }else {
            salida.append("#ERROR: ERRORE EN UN PARAMETRO HISTOGRAMA\n");
            TError ERRORES = new TError("histograma",this.linea,this.columna,"Semantico", "ERRORE EN UN PARAMETRO histograma"  );
            TABLA_DE_ERRORES_SINTACTICOS.add(ERRORES);
            return "#Error";
        }
        
        
        return "FIN HISTOGRMA";
    }
    
}
