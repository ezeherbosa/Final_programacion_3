import java.sql.SQLOutput;
import java.util.Random;

public class Combate {

    Archivos archivador = new Archivos();

    Random random = new Random();

    protected int turno = 1;
    protected int round = 1;

    public void combate(Jugador jugadorUno, Jugador jugadorDos) {

        String log = ("Jugador " + jugadorUno.getNombreJugador() + " inicia el combate.\n" +
                                    "\n++  Round: " + this.round + "  ++\n");


        System.out.println(log);
        Archivos.anotar(log);
        archivador.persistir(log);


        Personaje cartaUno = seleccionarCarta(jugadorUno);
        Personaje cartaDos = seleccionarCarta(jugadorDos);



        while (comprobarMazo(jugadorUno) && comprobarMazo(jugadorDos)) {



            if (!comprobarSalud(cartaUno)) {                    //comprobar jugadores vivos
                jugadorUno.getMazo().remove(cartaUno);          //borrar pj muerto

                try {
                    cartaUno = seleccionarCarta(jugadorUno);        //seleccionar nueva carta
                    log = "\n++  Round: " + this.round + "  ++\n";
                    System.out.println(log);
                    Archivos.anotar(log);
                }catch (IndexOutOfBoundsException e){
                    log = jugadorUno.getNombreJugador() + " Se ha quedado sin cartas";
                    System.out.println(log);
                    Archivos.anotar(log);

                }
            }

            if (!comprobarSalud(cartaDos)){
                jugadorDos.getMazo().remove(cartaDos);

                try {
                    cartaDos = seleccionarCarta(jugadorDos);
                    log = "\n++  Round: " + this.round + "  ++\n";
                    System.out.println(log);
                    Archivos.anotar(log);
                }catch (IndexOutOfBoundsException e){
                    log = jugadorDos.getNombreJugador() + " Se ha quedado sin cartas";
                    System.out.println(log);
                    Archivos.anotar(log);

                }
            }



            while ((comprobarSalud(cartaUno)) && (comprobarSalud(cartaDos)) && (turno < 8)) {

                log = "Turno: " + turno;
                System.out.println(log);
                Archivos.anotar(log);


                if (comprobarTurno(jugadorUno)) {                           //comprobar turno
                    if (comprobarSalud(cartaUno)) {                         //comprobar pj vivo
                        atacar(cartaUno, cartaDos);                         //atacar
                        cambiarTurno(jugadorUno, jugadorDos);
                        if (cartaDos.getSalud() == 0) {
                            jugadorDos.getMazo().remove(cartaDos);
                        }
                    }
                }

                if (comprobarTurno(jugadorDos)) {
                    if (comprobarSalud(cartaDos)) {
                        atacar(cartaDos, cartaUno);
                        cambiarTurno(jugadorUno, jugadorDos);
                        if (cartaUno.getSalud() == 0) {
                            jugadorUno.getMazo().remove(cartaUno);
                        }
                    }
                }


                turno++;

                if (turno == 8) {
                    log = "Se han jugado los 7 turnos reglamentarios.\nLos campeones se descansan." +
                          "\nInicia nuevo round.";
                    System.out.println(log);
                    Archivos.anotar(log);
                    turno = 1;
                    round++;

                    cartaUno = seleccionarCarta(jugadorUno);
                    cartaDos = seleccionarCarta(jugadorDos);

                    log =   "\n++  Round " + round + "  ++\n" +
                            "Ingresan nuevos luchadores:" +
                            "\nJugador " + jugadorUno.getNombreJugador() + ", llama a: " + cartaUno.getNombre() + ", Alias: " + cartaUno.getApodo() +
                            "\nJugador " + jugadorDos.getNombreJugador() + ", llama a: " + cartaDos.getNombre() + ", Alias: " + cartaDos.getApodo();

                    System.out.println(log);
                    Archivos.anotar(log);


                } // while turno

            }

        } //while pelea


        comprobarGanador(jugadorUno,jugadorDos);




    }//while rounds







    protected Personaje seleccionarCarta(Jugador jugador) {
        this.turno = 1;
        if (jugador.getMazo().size()>0) {
            return jugador.getMazo().get(random.nextInt(0, jugador.getMazo().size()));
        }else return jugador.getMazo().get(0);
    }


    protected Boolean comprobarMazo(Jugador jugador) {
        if (jugador.getMazo().isEmpty()) {
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }

    protected Boolean comprobarTurno(Jugador jugador) {
        if (jugador.getTurno().equals(Boolean.TRUE)) {
            return Boolean.TRUE;
        } else return Boolean.FALSE;
    }

    protected void cambiarTurno(Jugador jugador1, Jugador jugador2) {
        if (jugador1.getTurno().equals(Boolean.TRUE)) {
            jugador1.setTurno(Boolean.FALSE);
            jugador2.setTurno(Boolean.TRUE);
        } else {
            jugador1.setTurno(Boolean.TRUE);
            jugador2.setTurno(Boolean.FALSE);
        }

    }


    protected void atacar(Personaje atacante, Personaje defensor) {

        int danio = (int) atacante.calcularAtaque(defensor);

        String log = atacante.getNombre() + " ataca a " + defensor.getNombre() + ", recibe " + danio + " puntos de daño.\n" +
                     defensor.getNombre() + " le restan " + defensor.getSalud() + " puntos de vida.\n";

        System.out.println(log);
        Archivos.anotar(log);

        if (defensor.getSalud() == 0) {
            log = "Está fuera de combate.\n" +
                  "Ha caido en el " + this.turno + "° turno."+
                  "\nCampeon " + atacante.getNombre() + " obtiene 100 p de salud como recompensa";

            System.out.println(log);
            Archivos.anotar(log);

            atacante.setSalud(atacante.getSalud() + 100);

            log = atacante.getNombre() + ": " + atacante.getSalud() + "." +
                  "\n\n--  Fin ROUND " + this.round + "  --\n";

            System.out.println(log);
            Archivos.anotar(log);

            round++;

        }

    }

    protected Boolean comprobarSalud(Personaje carta) {
        if (carta.getSalud() <= 0) {
            turno = 1;
            return Boolean.FALSE;
        } else return Boolean.TRUE;
    }


    protected void comprobarGanador(Jugador jugadorUno, Jugador jugadorDos) {

        Jugador ganador = new Jugador();

        if (jugadorUno.getMazo().isEmpty()){
            ganador = jugadorDos;
        }else if (jugadorDos.getMazo().isEmpty()){
            ganador = jugadorUno;
        }

        String log = "JUGADOR: " + ganador.getNombreJugador() + " HA GANADO LA PARTIDA\n"+
                     "\n\nRENDIMOS HOMENAJE AL EQUIPO GANADOR: \n"+
                      ganador.imprimirMazoOriginal();

        System.out.println(log);
        Archivos.anotar(log);
    }


}





