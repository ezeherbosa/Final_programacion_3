public class ComprobarTurno {
    public Jugador comprobarTurno(Jugador j1,Jugador j2){
        if (j1.getTurno() == Boolean.TRUE){
            return j1;
        }
        else return j2;
    }
}
