import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Archivos {

    Scanner scanner = new Scanner(System.in);

    //String nombreCarpeta = "C:\\Users\\Ezee\\Desktop\\logs_partidas\\";
    String nombreCarpeta = "C:\\logs_partidas\\";

    protected String generarNombreArchivo() {

        int nombre = contarArchivosCarpeta() + 1;

        if (nombre<10){
            return "0"+nombre;
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
        File[] carpeta = f.listFiles();

        for (File archivos:carpeta){
            archivosEncontrados++;
        }
        return archivosEncontrados;
    }

    public void listaDeArchivos(){

        File f = new File(this.nombreCarpeta);
        File[] carpeta = f.listFiles();

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
        File archivoSeleccionado = new File(seleccion);



        while (!archivoSeleccionado.exists()){
            System.out.print("El archivo no existe o está mal escrito.\nIngrese nuevamente: ");
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
            lector.close();

        }catch (Exception e){
            System.out.println("error al leer el archivo." + e.getMessage());
        }

        System.out.print("Desea leer otro registro? S/N  ");
        String opcion = scanner.nextLine().toLowerCase();
        if (opcion.equals("s") || opcion.equals("si")){
            leerArchivo();
        }else if (opcion.equals("n") || opcion.equals("no")){
            System.out.println("Lectura finalizada");
        }

    }

    public void elimirArchivos(){

        System.out.print("\nSe encontraron " + contarArchivosCarpeta() + " archivos.\n" +
                "Esta acción no se puede deshacer, está seguro que desea eliminar todos los registros?.  S/N  ");
        String opcion = scanner.nextLine().toLowerCase();

        if (opcion.equals("s") || opcion.equals("si")){

            File f = new File(this.nombreCarpeta);
            File[] archivos = f.listFiles();

            for (File archivo:archivos){
                archivo.delete();
            }

            System.out.println("\nArchivos eliminados.\n");

        }
    }

    public void persistir(String log) {

        File nombreArchivo = crearArchivo();

        try {
            FileWriter persistir = new FileWriter(nombreArchivo);
            persistir.write(log+"\n");
            persistir.close();
        }
        catch (IOException e){
            System.out.println("error escribiendo linea en archivo.");
        }

    }

    public String horaInicio(){
        LocalDateTime fechaActual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd - HH:mm:ss");
        String fechaHoraActualFormateada = fechaActual.format(formatter);

        return fechaHoraActualFormateada;
    }

    static String precarga = "Registros: ";

    public static void anotar(String text){
        precarga = precarga + (text + "\n");
    }
}
