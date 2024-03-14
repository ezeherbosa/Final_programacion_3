import java.util.ArrayList;

public class Jugador {
    private String nombreJugador;

    private ArrayList<Personaje> mazo = new ArrayList<>();
    private ArrayList<Personaje> mazoOriginal = new ArrayList<>();

    private Boolean turno;

    public Jugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        turno = null;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public ArrayList<Personaje> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList mazo) {
        this.mazo = mazo;
    }


    public ArrayList<Personaje> getMazoOriginal() {
        return mazoOriginal;
    }

    public void setMazoOriginal(ArrayList<Personaje> mazoOriginal) {
        this.mazoOriginal = mazoOriginal;
    }

    public Boolean getTurno() {
        return turno;
    }

    public Boolean setTurno(Boolean turno) {
        this.turno = turno;
        return turno;
    }


    public void mazoToString() {
        for (Personaje carta : mazo) {
            System.out.println(carta);
        }
    }

    public void imprimirMazoOriginal() {
        System.out.println(" << Heroes >> ");
        for (Personaje carta : mazoOriginal){
            System.out.println("Nombre: "+ carta.getNombre());
            System.out.println("Alias: "+ carta.getApodo());
            System.out.println("clase: "+ carta.getClass() );
            System.out.println("Nacimiento: "+ carta.getFechaNacimiento());
            System.out.println("Edad: "+ carta.getEdad());
            System.out.println("-------");
        }

                /*
                "Nombre: " + mazoOriginal.get(2).getNombre() +
                "Alias: " + mazoOriginal.get(2).getApodo() +
                "Clase: " + mazoOriginal.get(2).getClass() +
                "Edad: " + mazoOriginal.get(2).getEdad() +
                "Fecha nac: " + mazoOriginal.get(2).getFechaNacimiento() +
                "--" + */






    }

    @Override
    public String toString() {
        return "Jugador{" +
                "mazoOriginal=" + mazoOriginal +
                '}';
    }
}
