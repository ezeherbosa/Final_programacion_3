public class Main {

    public static void main(String[] args) {

        Archivos archivador = new Archivos();
        Menu menu = new Menu();
        String log;

        log = "\n-WORLD OF COMBAT 3 ULTIMATE-\n";

        System.out.println(log);
        Archivos.anotar(archivador.horaInicio()+"\n"+ log);

        menu.iniciaMenu();

        archivador.persistir(String.valueOf(archivador.precarga));
    }
 }
