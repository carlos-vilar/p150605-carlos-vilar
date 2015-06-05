/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author alumno
 */
public abstract class NewClass {
    protected static final int Duración = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg;

    public NewClass() {
    }

    /**
     * Establece los metadatos del Spot.
     *
     * @param producto String que contiene el nombre del producto
     * @param anunciante String que contiene el nombre de la empresa anunciante
     */
    public abstract void setMetaDatos(String producto, String anunciante);

    /**
     * Establece la duración.
     *
     *
     * @param duracion
     * @throws IllegalArgumentException
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > Duración) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * Vincula el objeto "AudioAnuncio" con el archivo de audio.
     *
     * Vincula el objeto "AudioAnuncio" con el archivo de audio wur contiene la cuña
    publicitaria.
     *
     * @param nombre_archivo Nombre del objeto AudioAnuncio
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * Programa la cuña dentro de una secuencia de audio clips.
     *
     * Programa la cuña dentro de una secuencia de audio clips y exporta la cuña
     * completa.
     *
     * @param cola_reproduccion
     * @return El archivo con la secuencia de audio clips.
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date Fecha1) {
        // comprobamos previamente que no falte nada
        int resultado = checkDatos();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }

    protected abstract int checkDatos();

    /**
     * Exporta secuencias de audio más los metadatos en formato .daf.
     *
     *
     * @param objeto_daw
     * @return El archivo .daf que contiene audio+metadatos.
     */
    public abstract int ExportaAFormatoDAW(Object objeto_daw);
    
}
