import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Archivos {

    String nombreCarpeta = "C:\\Users\\Ezee\\Desktop\\logs_partidas\\";

    protected String generarNombreArchivo() {
/*
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd - HH mm ss");
        String fechaHoraActualFormateada = fechaActual.format(formatter);

        return fechaHoraActualFormateada;
 */
        int nombre = contarArchivosCarpeta() + 1;

        if (nombre<10){
            String nombreConCero = "0"+String.valueOf(nombre);
            return nombreConCero;
        }
        else return String.valueOf(nombre);
    }

    protected String generarRuta() {

        File carpeta = new File(this.nombreCarpeta);

        if (!carpeta.exists()) {
            carpeta.mkdir();
        }


        String nombreArchivo = "partida_" + generarNombreArchivo() + ".txt";
        String rutaArchivo = this.nombreCarpeta + nombreArchivo;

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


    public int contarArchivosCarpeta(){
        int archivosEncontrados = 0;

        File f = new File(this.nombreCarpeta);
        File[] contenido = f.listFiles();

        for (File cadena:contenido){
            archivosEncontrados++;
        }
        return archivosEncontrados;
    }

    public void listaDeArchivos(){

        File f = new File(this.nombreCarpeta);
        File[] carpeta = f.listFiles();

        List<String>archivos = new ArrayList<>();

        for (File archivo:carpeta){
            System.out.println(archivo.getName());
        }
    }

    public void leerArchivo(){

        System.out.print("\nSe ha encontrado: " + contarArchivosCarpeta() + " archivos.\n");

        listaDeArchivos();

        System.out.println("Escriba el nombre del archivo que desea leer: ");

        Scanner scanner = new Scanner(System.in);
        String seleccion = this.nombreCarpeta+scanner.nextLine();
        //System.out.println(seleccion);
        File archivoSeleccionado = new File(seleccion);



        while (!archivoSeleccionado.exists()){
            System.out.print("El archivo no existe o está mal escrito.\n" +
                    "ingrese nuevamente: ");
            seleccion = this.nombreCarpeta+scanner.nextLine();
            archivoSeleccionado = new File(seleccion);
        }

        FileReader archivo;
        BufferedReader lector;

        try{
            archivo=new FileReader(archivoSeleccionado);
            lector = new BufferedReader(archivo);
            String cadena;

            while ((cadena = lector.readLine()) != null){
                System.out.println(cadena);
            }

        }catch (Exception e){
            System.out.println("error al leer el archivo." + e.getMessage());
        }

    }


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
