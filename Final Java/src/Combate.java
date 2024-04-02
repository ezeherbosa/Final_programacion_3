import java.util.Random;

public class Combate {

    Random random = new Random();

    protected int turno = 1;
    protected int round = 1;

    public void combate(Jugador jugadorUno, Jugador jugadorDos) {



        System.out.println("\n++  Round: " + this.round + "  ++\n");

        Personaje cartaUno = seleccionarCarta(jugadorUno);
        Personaje cartaDos = seleccionarCarta(jugadorDos);



        while (comprobarMazo(jugadorUno) && comprobarMazo(jugadorDos)) {



            if (!comprobarSalud(cartaUno)) {                    //comprobar jugadores vivos
                jugadorUno.getMazo().remove(cartaUno);          //borrar pj muerto

                try {
                    cartaUno = seleccionarCarta(jugadorUno);        //seleccionar nueva carta
                    System.out.println("\n++  Round: " + this.round + "  ++\n");
                }catch (IndexOutOfBoundsException e){
                    System.out.println(jugadorUno.getNombreJugador() + " Se ha quedado sin cartas");

                }


            }

            if (!comprobarSalud(cartaDos)){
                jugadorDos.getMazo().remove(cartaDos);

                try {
                    cartaDos = seleccionarCarta(jugadorDos);
                    System.out.println("\n--  Round: " + this.round + "  --\n");
                }catch (IndexOutOfBoundsException e){
                    System.out.println(jugadorDos.getNombreJugador() + " Se ha quedado sin cartas");

                }



            }



            while ((comprobarSalud(cartaUno)) && (comprobarSalud(cartaDos)) && (turno < 8)) {

                System.out.println("\nTurno: " + turno);


                if (comprobarTurno(jugadorUno)) {
                    if (comprobarSalud(cartaUno)) {                                           //comprobar turno //comprobar pj vivo
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
                    System.out.println("Se han jugado los 7 turnos establecidos.\nLos campeones se descansan.\nInicia nuevo round.");
                    turno = 1;
                    round++;

                    cartaUno = seleccionarCarta(jugadorUno);
                    cartaDos = seleccionarCarta(jugadorDos);

                    System.out.println("\n--  Round " + round + "  --\n");

                    System.out.println("Ingresan nuevos luchadores:");

                    System.out.println("\nJugador " + jugadorUno.getNombreJugador() + ", llama a: " + cartaUno.getNombre() + ", Alias: " + cartaUno.getApodo());
                    System.out.println("\nJugador " + jugadorDos.getNombreJugador() + ", llama a: " + cartaDos.getNombre() + ", Alias: " + cartaDos.getApodo());

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
//        System.out.println("\n jugador " + jugador.getNombreJugador() + " tiene " + jugador.getMazo().size() + " cartas.\n ");

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


        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + ", recibe " + danio + " puntos de daño.");
        System.out.println(defensor.getNombre() + " le restan " + defensor.getSalud() + " puntos de vida.\n");
        if (defensor.getSalud() == 0) {
            System.out.println("Está fuera de combate.");
            System.out.println("Ha caido en el " + this.turno + "° turno.");



            System.out.println("Campeon " + atacante.getNombre() + " obtiene 100 p de salud como recompensa");
            atacante.setSalud(atacante.getSalud() + 100);
            System.out.println(atacante.getNombre() + ": " + atacante.getSalud() + ".");
            System.out.println("\n--  Fin ROUND " + this.round + "  --\n");
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


            System.out.println("JUGADOR: " + ganador.getNombreJugador() + " HA GANADO LA PARTIDA");
            ganador.imprimirMazoOriginal();

    }




}





