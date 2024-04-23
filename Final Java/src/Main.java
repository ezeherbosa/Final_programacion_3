import java.util.Scanner;

//falta terminar menu y leer + borrar archivos

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Archivos archivador = new Archivos();


        //System.out.println("name?\n");
        //Jugador j1 = new Jugador(scanner.next());
        Jugador j1 = new Jugador("HERBOSOR");
        Jugador j2 = new Jugador("MAQUINIR");




        Partida partida = new Partida(j1,j2);


        /*
        partida.crearMazoManual();

        System.out.println(j1.getMazo());
        System.out.println("/////////");
        System.out.println(j2.getMazo());

        */





        partida.repartirMazo(partida.crearMazoAutomatico());

        String log = "Partida iniciada: \n\n" +
                      j1.getNombreJugador() + " - Vs - "+ j2.getNombreJugador() +
                      "\n\nLOS PERSONAJES SE PRESENTAN:\n\n"+

                    "Jugador 1: " + j1.getNombreJugador() + "\n"
                                  + j1.imprimirMazoOriginal() + "\n"
                                  +"  Vs.\n\n" +
                    "Jugador 2: " + j2.getNombreJugador() + "\n"
                                  + j2.imprimirMazoOriginal() + "\n";

        System.out.println(log);
        Archivos.anotar(log);



        Combate combate = new Combate();

        SorteoInicio sorteoInicio = new SorteoInicio();
        sorteoInicio.sorteoInicio(j1,j2);

        if (j1.getTurno() == Boolean.TRUE){
            combate.combate(j1,j2);
        } else {
           combate.combate(j2,j1);
            }

        Trono trono = new Trono();

        log = trono.imprimirTrono() +
               "Herbosa Ezequiel\n" +
               "UTN-FRBB\n" +
               "Programacion III - 2023";

        System.out.println(log);
        Archivos.anotar(log);

        archivador.persistir(String.valueOf(archivador.precarga));





    }
 }
