
import java.util.Random;

public class Combate {

    Random random = new Random();

    protected int turno = 1;
    protected int round = 1;


    public void combate(Jugador jugadorUno, Jugador jugadorDos) {


        while (!jugadorUno.getMazo().isEmpty() || !jugadorDos.getMazo().isEmpty()) {


            Personaje cartaUno = seleccionarCarta(jugadorUno);
            Personaje cartaDos = seleccionarCarta(jugadorDos);

            System.out.println(cartaUno);
            System.out.println(cartaDos);


            System.out.println("\n--  Round: " + round + "  --\n");

            while ((cartaUno.getSalud() > 0) && cartaDos.getSalud() > 0 && turno < 8) {

                System.out.println("\nTurno: " + turno);

                if (comprobarTurno(jugadorUno)) {
                    if (comprobarSalud(cartaUno)) {
                        atacar(cartaUno, cartaDos);
                        cambiarTurno(jugadorUno, jugadorDos);
                    } else {
                        jugadorUno.getMazo().remove(cartaUno);
                        if (comprobarMazo(jugadorUno)) {
                            try {
                                seleccionarCarta(jugadorUno);
                                if (jugadorUno.getMazo().equals(null)){
                                    comprobarGanador(jugadorUno,jugadorDos);
                                }
                            } catch (NullPointerException e) {
                                comprobarGanador(jugadorUno, jugadorDos);
                                break;
                            }
                        }
                    }
                }

                if (comprobarTurno(jugadorDos)) {
                    if (comprobarSalud(cartaDos)) {
                        atacar(cartaDos, cartaUno);
                        cambiarTurno(jugadorUno, jugadorDos);
                    } else {
                        jugadorDos.getMazo().remove(cartaDos);
                        if (comprobarMazo(jugadorDos)) {
                            try {
                                seleccionarCarta(jugadorDos);
                                if (jugadorDos.getMazo().equals(null)){
                                    comprobarGanador(jugadorUno,jugadorDos);
                                }
                            } catch (NullPointerException e) {
                                comprobarGanador(jugadorUno, jugadorDos);
                                break;
                            }

                        }
                    }
                }

                turno++;

            }
            if (turno == 8) {
                System.out.println("Se han jugado los 7 turnos establecidos.\nLos campeones se descansan.\nInicia nuevo round.");
                turno = 1;
                round++;
            }


        }


    }







    protected Personaje seleccionarCarta(Jugador jugador){

        if (comprobarMazo(jugador)){
            this.turno = 1;
            this.round++;
            return jugador.getMazo().get(random.nextInt(0,jugador.getMazo().size()));
        }else
            return null;
    }





    protected Boolean comprobarMazo(Jugador jugador){
        if (jugador.getMazo().isEmpty()){
            return Boolean.FALSE;
        }
        else return Boolean.TRUE;
    }

    protected Boolean comprobarTurno(Jugador jugador){
        if (jugador.getTurno().equals(Boolean.TRUE)) {
            return Boolean.TRUE;
        }else return Boolean.FALSE;
    }

    protected void cambiarTurno(Jugador jugador1,Jugador jugador2){
        if (jugador1.getTurno().equals(Boolean.TRUE)){
            jugador1.setTurno(Boolean.FALSE);
            jugador2.setTurno(Boolean.TRUE);
        }else {
            jugador1.setTurno(Boolean.TRUE);
            jugador2.setTurno(Boolean.FALSE);
        }

    }




    protected void atacar(Personaje atacante, Personaje defensor){

        int danio = (int) atacante.calcularAtaque(defensor);


        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + ", recibe " + danio + " puntos de daño.");
        System.out.println(defensor.getNombre() + " le restan " + defensor.getSalud() + " puntos de vida.\n");
        if (defensor.getSalud() == 0){
            System.out.println("Está fuera de combate.");
            System.out.println("Ha caido en el " + this.turno + "° turno.");
            System.out.println("\n--  Fin ROUND " + this.round + "  --\n");

        }

    }

    protected Boolean comprobarSalud(Personaje carta){
        if (carta.getSalud() <= 0 ){
            turno = 1;
            round++;
            return Boolean.FALSE;
        }
        else return Boolean.TRUE;
    }


    protected void comprobarGanador(Jugador jugadorUno,Jugador jugadorDos){
        if (comprobarMazo(jugadorUno)){
            System.out.println("JUGADOR: " + jugadorDos.getNombreJugador() + " HA GANADO LA PARTIDA");
            jugadorDos.imprimirMazoOriginal();
        }else if (comprobarMazo(jugadorDos)){
            System.out.println("JUGADOR: " + jugadorUno.getNombreJugador() + " HA GANADO LA PARTIDA");
            jugadorUno.imprimirMazoOriginal();
        }
    }






}

