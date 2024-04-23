import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Archivos {

    protected String generarNombreArchivo() {

        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH mm ss");
        String fechaHoraActualFormateada = fechaActual.format(formatter);

        //System.out.println(fechaHoraActualFormateada);

        return fechaHoraActualFormateada;
    }

    protected String generarRuta() {
        String nombreCarpeta = "C:\\Users\\Ezee\\Desktop\\logs_partidas\\";

        File carpeta = new File(nombreCarpeta);

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }


        String nombreArchivo = "partida_" + generarNombreArchivo() + ".txt";
        String rutaArchivo = nombreCarpeta + nombreArchivo;

        return rutaArchivo;

    }

    public File crearArchivo() {

        File archivo = new File(generarRuta());

        try {
            if (archivo.createNewFile()) {
                //System.out.println("archivo creado");
            } else {
                //System.out.println("ya existe archivo");
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }

        return archivo;
    }



   /* public void persistir(String cadena){
        ArrayList <String> logs = new ArrayList<String>();
        logs.add(cadena);

        for (String palabra : logs) {
            guardar(palabra);
        }

    }*/


    File nombreArchivo = crearArchivo();



    public void persistir(String log) {


        try {
            FileWriter persistir = new FileWriter(nombreArchivo);
            persistir.write(log+"\n");
            persistir.close();
        }
        catch (IOException e){
            System.out.println("error escribiendo linea en archivo.");
        }

    }

    static String precarga = "Registros: \n\n";

    public static void anotar(String text){
        precarga = precarga + (text + "\n");
    }



}
