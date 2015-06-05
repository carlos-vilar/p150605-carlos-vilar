package p20150605;

import java.io.File;
import java.util.Date;
/**
 * Gestiona cuñas de anuncios publicitarios en radio.
 * 
 * Cada objeto se referirá a una cuña diferente. Es capaz de almacenar metadatos
 * sobre el anuncio y una referencia al archivo de audio que lo contiene. También
 * permite acciones tales como programar la cuña dentro de una secuencia de audio
 * clips y exportar la cuá completa (audio + metadatos) a un formato propio (.daf).
 * 
 * 
 * @author Carlos Vilar
 * @version 1.0.1
 * 
 */


public class AudioAnuncio extends NewClass
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    /**
     * Establece los metadatos del Spot.
     * 
     * @param producto String que contiene el nombre del producto
     * @param anunciante String que contiene el nombre de la empresa anunciante 
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }

    protected int checkDatos() {
        
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
    /**
     * Exporta secuencias de audio más los metadatos en formato .daf.
     * 
     * 
     * @param objeto_daw
     * @return El archivo .daf que contiene audio+metadatos.
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        // comprobamos previamente que no falte nada
        int resultado = checkDatos();
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }
    
}
