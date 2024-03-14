import java.util.ArrayList;
import java.util.Random;

public class Partida {

    Jugador jugadorUno;
    Jugador jugadorDos;
    





    public Partida(Jugador jugadorUno, Jugador jugadorDos) {

       this.jugadorUno = jugadorUno;
       this.jugadorDos = jugadorDos;

    }

    public Jugador getJugadorUno() {
        return jugadorUno;
    }

    public void setJugadorUno(Jugador jugadorUno) {
        this.jugadorUno = jugadorUno;
    }

    public Jugador getJugadorDos() {
        return jugadorDos;
    }

    public void setJugadorDos(Jugador jugadorDos) {
        this.jugadorDos = jugadorDos;
    }




    public ArrayList<Personaje> crearMazo(){
        Random random = new Random();
        int contador = 0;
        GeneradorStrings generadorStrings = new GeneradorStrings();
        GeneradorFecha generadorFecha = new GeneradorFecha();
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();


        while (contador < 6){
            //Personaje cartaCreada = null;

            int claseACrear = random.nextInt(3);

           if (claseACrear == 0) {
               Humano carta = new Humano(generadorStrings.generarNombre(), generadorStrings.generarApodo(),
                       generadorFecha.GenerarFechaAleatoria(), 1000, random.nextInt(1, 10),
                       random.nextInt(1, 5), random.nextInt(1, 10), 1,
                       random.nextInt(1, 10));
               //cartaCreada = carta;
               carta.setearPoderes(carta);
               personajes.add(carta);

           } else if (claseACrear == 1 ) {
               Orco carta = new Orco(generadorStrings.generarNombre(), generadorStrings.generarApodo(),
                       generadorFecha.GenerarFechaAleatoria(),1000,random.nextInt(1,10),
                       random.nextInt(1,5),random.nextInt(1,10),1,
                       random.nextInt(1,10));
               //cartaCreada = carta;
               carta.setearPoderes(carta);
               personajes.add(carta);

           } else if (claseACrear == 2) {
               Elfo carta = new Elfo(generadorStrings.generarNombre(), generadorStrings.generarApodo(),
                       generadorFecha.GenerarFechaAleatoria(),1000,random.nextInt(1,10),
                       random.nextInt(1,5),random.nextInt(1,10),1,
                       random.nextInt(1,10));
               //cartaCreada = carta;
               carta.setearPoderes(carta);
               personajes.add(carta);
           }

            //cartaCreada.setearPoderes(cartaCreada);
            //personajes.add(cartaCreada);

            contador++;

        }

        return personajes;

    }

    ArrayList<Personaje> mazo = crearMazo();
    public void mazoToString(){
        for (Personaje carta : mazo){
            System.out.println(carta);
        }
    }

    public void repartirMazo(){
       ArrayList<Personaje>mazoJugadorUno = new ArrayList<Personaje>();
       ArrayList<Personaje>mazoJugadorDos = new ArrayList<Personaje>();

       mazoJugadorUno.add(mazo.get(0));
       mazoJugadorUno.add(mazo.get(1));
       mazoJugadorUno.add(mazo.get(2));
       jugadorUno.setMazo(mazoJugadorUno);
       jugadorUno.setMazoOriginal((ArrayList)mazoJugadorUno.clone());

        //borrar
        /*Acá intente usar un solo array, limpiarlo con el metodo .clear, pero al parecer sobreescribia todo con la segunda seleccion y quedaban los dos mazos iguales */


        mazoJugadorDos.add(mazo.get(3));
        mazoJugadorDos.add(mazo.get(4));
        mazoJugadorDos.add(mazo.get(5));
        jugadorDos.setMazo(mazoJugadorDos);
        jugadorDos.setMazoOriginal((ArrayList)mazoJugadorDos.clone());


    }






    }



