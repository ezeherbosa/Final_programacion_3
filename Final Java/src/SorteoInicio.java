import java.util.Random;

public class SorteoInicio {


    public Jugador sorteoInicio(Jugador jugadorUno, Jugador jugadorDos) {
        Random random = new Random();
        int i = random.nextInt(1,3);

        if (i % 2 == 0) {
            jugadorUno.setTurno(Boolean.TRUE);
            jugadorDos.setTurno(Boolean.FALSE);
            return jugadorUno;
        } else {
            jugadorUno.setTurno(Boolean.FALSE);
            jugadorDos.setTurno(Boolean.TRUE);
            return jugadorDos;
        }
    }
}
