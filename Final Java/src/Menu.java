import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);

public void iniciaMenu() {

    Archivos archivos = new Archivos();


    System.out.println("MENU DEL JUEGO:\n");
    System.out.println("Opcion 1:  Nueva partida - PERSONAJES ALEATORIOS.");
    System.out.println("Opcion 2:  Nueva partida - PERSONAJES MANUALES.");
    System.out.println("Opcion 3:  Leer registro partidas anteriores.");
    System.out.println("Opcion 4:  Borrar historial de partidas.");
    System.out.println("Opcion 5:  Salir.");
    System.out.print("\nOpcion n°: ");

    int opcion = Partida.ingresoInt();//scanner.nextInt();


    switch (opcion) {
        case 1:
            System.out.println("Nueva partida - PERSONAJES ALEATORIOS.\n");

            Partida partida = new Partida();

            partida.repartirMazo(partida.crearMazoAutomatico());

            String log = "Partida iniciada: \n\n" +
                    partida.jugadorUno.getNombreJugador() + " - Vs - "+ partida.jugadorDos.getNombreJugador() +
                    "\n\nLOS PERSONAJES SE PRESENTAN:\n\n"+

                    "Jugador 1: " + partida.jugadorUno.getNombreJugador() + "\n"
                    + partida.jugadorUno.imprimirMazoOriginal() + "\n"
                    +"  Vs.\n\n" +
                    "Jugador 2: " + partida.jugadorDos.getNombreJugador() + "\n"
                    + partida.jugadorDos.imprimirMazoOriginal() + "\n";

            System.out.println(log);
            Archivos.anotar(log);

            SorteoInicio sorteoInicio = new SorteoInicio();
            sorteoInicio.sorteoInicio(partida.jugadorUno,partida.jugadorDos);

            Combate combate = new Combate();

            if (partida.jugadorUno.getTurno() == Boolean.TRUE){
                combate.combate(partida.jugadorUno,partida.jugadorDos);
            } else {
                combate.combate(partida.jugadorDos,partida.jugadorUno);
            }

            controlMenu();

            break;


        case 2:
            System.out.println("Nueva partida - PERSONAJES MANUALES.");

            partida = new Partida();

            System.out.println("Rutina de cracion manual de personajes.");

            partida.crearMazoManual();
            partida.repartirMazo(partida.crearMazoAutomatico());

            log = "Partida iniciada: \n\n" +
                    partida.jugadorUno.getNombreJugador() + " - Vs - "+ partida.jugadorDos.getNombreJugador() +
                    "\n\nLOS PERSONAJES SE PRESENTAN:\n\n"+

                    "Jugador 1: " + partida.jugadorUno.getNombreJugador() + "\n"
                    + partida.jugadorUno.imprimirMazoOriginal() + "\n"
                    +"  Vs.\n\n" +
                    "Jugador 2: " + partida.jugadorDos.getNombreJugador() + "\n"
                    + partida.jugadorDos.imprimirMazoOriginal() + "\n";

            System.out.println(log);
            Archivos.anotar(log);

             combate = new Combate();

             sorteoInicio = new SorteoInicio();
             sorteoInicio.sorteoInicio(partida.jugadorUno,partida.jugadorDos);

            if (partida.jugadorUno.getTurno() == Boolean.TRUE){
                combate.combate(partida.jugadorUno,partida.jugadorDos);
            } else {
                combate.combate(partida.jugadorDos,partida.jugadorUno);
            }
            controlMenu();
            break;

        case 3:
            System.out.println("Leer registro partidas anteriores.");
            try {
                archivos.leerArchivo();
            } catch (Exception e){
                System.out.println("\nNo se encontraron partidas anteriores.");
                }
            controlMenu();
            break;
        case 4:
            System.out.println("Borrar historial de partidas.");
            try{
                archivos.elimirArchivos();
            } catch (Exception e){
                System.out.println("\nNo se encontraron partidas anteriores.");
            }
            controlMenu();
            break;
        case 5:
            System.out.println("\nPROGRAMA FINALIZADO.");
            break;
        default:
            System.out.print("Opcion invalida, intente nuevamente:\n\n");
            iniciaMenu();
        }//switch


    }//menu


    private void controlMenu(){

        System.out.print("\n\nPresione  \"S\"  si quiere ejecutar el menu.\nPresione  \"N\"  si quiere terminar el programa.\nOpcion:  ");

        String opcion = scanner.nextLine().toLowerCase();

        while (!opcion.equals("s") && (!opcion.equals("n"))){
            System.out.print("\n\nPresione  \"S\"  si quiere ejecutar el menu.\nPresione  \"N\"  si quiere terminar el programa.\nOpcion:  ");
            opcion = scanner.nextLine().toLowerCase();
        }

        if (opcion.equals("s")){
            iniciaMenu();
        }else {
            System.out.println("\n\nPROGRAMA FINALIZADO.");
        }


    }

}//clase
