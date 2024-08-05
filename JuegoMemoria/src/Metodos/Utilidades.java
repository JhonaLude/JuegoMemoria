/*
 * Para cambiar este encabezado de licencia, elija Encabezados de Licencia en Propiedades del Proyecto.
 * Para cambiar este archivo de plantilla, elija Herramientas | Plantillas
 * y abra la plantilla en el editor.
 */
package Metodos;

import InterfazGrafica.Principal;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonathan Alexander Ludeña Cevallos
 */
public class Utilidades {

    private List<Coincidencia> coincidencia = new ArrayList<>();
    private List<Coincidencia> aciertos = new ArrayList<>();

    //MÉTODO DONDE SE CARGAN NÚMEROS ALEATORIOS EN FILA
    public static List<Integer> filasTabla() {
        List<Integer> lista = new ArrayList<>();
        Random r = new Random();
        int aumento = 1;
        for (int i = 0; i < aumento; i++) {
            if (lista.size() != 4) {
                aumento++;
            }
            int valor = r.nextInt(5);
            if (!lista.contains(valor) && lista.size() != 5 && valor != 0) {
                lista.add(valor);
            }
        }
        return lista;
    }

    //MÉTODO PARA INGRESAR LAS DOS FILAS
    public static List<Integer> filasTablaCompleta() {
        List<Integer> todas = new ArrayList<>();
        todas.addAll(filasTabla());
        todas.addAll(filasTabla());
        return todas;
    }

    //MÉTODO PARA PINTAR LAS IMÁGENES
    public void pintarImagen(JButton boton, int valor) {
        try {
            boton.setIcon(new ImageIcon(getClass().getResource("/Imagenes/0" + valor + ".png")));
            boton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            boton.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    //MÉTODO QUE INICIALIZA LAS IMÁGENES EN ?
    public void imgInicio() {
        pintarImagen(Principal.cartaUno, 9);
        pintarImagen(Principal.cartaDos, 9);
        pintarImagen(Principal.cartaTres, 9);
        pintarImagen(Principal.cartaCuatro, 9);
        pintarImagen(Principal.cartaCinco, 9);
        pintarImagen(Principal.cartaSeis, 9);
        pintarImagen(Principal.cartaSiete, 9);
        pintarImagen(Principal.cartaOcho, 9);
    }
        
    //MÉTODO PARA CUANDO LOS DOS VALORES SEAN IGUALES 
    public void pintarCoincidencia() {
        System.out.println(getCoincidencia().size());
        if (getCoincidencia().size() == 1) {
            pintarImagen(getCoincidencia().get(0).getBoton(), getCoincidencia().get(0).getValorCoincidencia());
        } else if(getCoincidencia().size() == 2) {
            pintarImagen(getCoincidencia().get(1).getBoton(), getCoincidencia().get(1).getValorCoincidencia());
        }
    }
    
    //MÉTODO DONDE LAS IMÁGENES YA HICIERON COINCIDENCIA
    public void imgInicioCoincidencia() {
        if (aciertos.size() == 8) {
            JOptionPane.showMessageDialog(null, "¡HAS GANADO!");

            for (int i = 0; i < aciertos.size(); i++) {
                pintarImagen(aciertos.get(i).getBoton(), aciertos.get(i).getValorCoincidencia());
                aciertos.get(i).getBoton().setEnabled(true);
            }
            aciertos.clear();
            imgInicio();
        }
        for (int i = 0; i < aciertos.size(); i++) {
            System.out.println(aciertos.get(i).getNumeroBtnon() + "_" + aciertos.get(i).getValorCoincidencia());
            pintarImagen(aciertos.get(i).getBoton(), aciertos.get(i).getValorCoincidencia());
            aciertos.get(i).getBoton().setEnabled(false);
        }
    }

    //MÉTODO QUE CONTROLA LA EJECUCIÓN
    public void reiniciar() {
        imgInicio();
        imgInicioCoincidencia();
    }

    //MÉTODO DE COINCIDENCIA
    public void coincidencia() {
        if (getCoincidencia().size() == 2) {
            if (getCoincidencia().get(0).getNumeroBtnon() != 0 && getCoincidencia().get(1).getNumeroBtnon() != 0) {

                if (getCoincidencia().get(0).getValorCoincidencia() == getCoincidencia().get(1).getValorCoincidencia()) {
                    aciertos.add(getCoincidencia().get(0));
                    aciertos.add(getCoincidencia().get(1));
                    getCoincidencia().clear();
                    reiniciar();
                } else {                    
                    Runnable mx = new Runnable() {
                        @Override
                        public void run() {
                            getCoincidencia().clear();
                            reiniciar();
                        }
                    };
                    establecerTiempoEspera(mx, 2000);
                }
            }
        }
    }

    public void establecerTiempoEspera(Runnable ejecutable, int retraso) {
        new Thread(() -> {
            try {
                Thread.sleep(retraso);
                ejecutable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    public List<Coincidencia> getCoincidencia() {
        return coincidencia;
    }

    public void setCoincidencia(List<Coincidencia> coincidencia) {
        this.coincidencia = coincidencia;
    }

}