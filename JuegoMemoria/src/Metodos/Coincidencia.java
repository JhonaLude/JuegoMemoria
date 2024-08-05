/*
 * Para cambiar este encabezado de licencia, elija Encabezados de Licencia en Propiedades del Proyecto.
 * Para cambiar este archivo de plantilla, elija Herramientas | Plantillas
 * y abra la plantilla en el editor.
 */
package Metodos;
import javax.swing.JButton;
/**
 *
 * @author Jhonathan Alexander Ludeña Cevallos
 */
public class Coincidencia {
    private int numeroBtnon;
    private JButton boton;
    private int valorCoincidencia;
    
    public Coincidencia() {
    }
    
    public Coincidencia(int numeroBtnon, JButton boton, int valorCoincidencia) {
        this.numeroBtnon = numeroBtnon;
        this.boton = boton;
        this.valorCoincidencia = valorCoincidencia;
    }
    
    public int getNumeroBtnon() {
        return numeroBtnon;
    }
    
    public void setNumeroBtnon(int numeroBtnon) {
        this.numeroBtnon = numeroBtnon;
    }
    
    public JButton getBoton() {
        return boton;
    }
    
    public void setBoton(JButton boton) {
        this.boton = boton;
    }
    
    public int getValorCoincidencia() {
        return valorCoincidencia;
    }
    
    public void setValorCoincidencia(int valorCoincidencia) {
        this.valorCoincidencia = valorCoincidencia;
    }
    
    @Override
    public String toString() {
        return "Coincidencia{" + "numeroBtnon=" + numeroBtnon + ", boton=" + boton + ", valorCoincidencia=" + valorCoincidencia + '}';
    }
}
