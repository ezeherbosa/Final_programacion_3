import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Partida {

    Jugador jugadorUno;
    Jugador jugadorDos;



    protected String nombre;
    protected String apodo;
    protected int anio;
    protected int mes;
    protected int dia;
    protected int velocidad;
    protected int destreza;
    protected int fuerza;
    protected int armadura;




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




    public ArrayList<Personaje> crearMazoAutomatico(){
        Random random = new Random();
        int contador = 0;
        GeneradorStrings generadorStrings = new GeneradorStrings();
        GeneradorFecha generadorFecha = new GeneradorFecha();
        ArrayList<Personaje> personajes = new ArrayList<Personaje>();


        while (contador < 6){

            int claseACrear = random.nextInt(3);

           if (claseACrear == 0) {
               Humano carta = new Humano(generadorStrings.generarNombre(), generadorStrings.generarApodo(),
                       generadorFecha.GenerarFechaAleatoria(), 1000, random.nextInt(1, 10),
                       random.nextInt(1, 5), random.nextInt(1, 10), 1,
                       random.nextInt(1, 10));

               carta.setearPoderes(carta);
               personajes.add(carta);

           } else if (claseACrear == 1 ) {
               Orco carta = new Orco(generadorStrings.generarNombre(), generadorStrings.generarApodo(),
                       generadorFecha.GenerarFechaAleatoria(),1000,random.nextInt(1,10),
                       random.nextInt(1,5),random.nextInt(1,10),1,
                       random.nextInt(1,10));

               carta.setearPoderes(carta);
               personajes.add(carta);

           } else if (claseACrear == 2) {
               Elfo carta = new Elfo(generadorStrings.generarNombre(), generadorStrings.generarApodo(),
                       generadorFecha.GenerarFechaAleatoria(),1000,random.nextInt(1,10),
                       random.nextInt(1,5),random.nextInt(1,10),1,
                       random.nextInt(1,10));

               carta.setearPoderes(carta);
               personajes.add(carta);
           }

           contador++;

        }

        return personajes;

    }

    protected ArrayList<Personaje> mazo = crearMazoAutomatico();
    public void mazoToString(){
        for (Personaje carta : mazo){
            System.out.println(carta);
        }
    }

    public void repartirMazo(ArrayList<Personaje> mazo){

        ArrayList<Personaje>mazoJugadorUno = new ArrayList<Personaje>();
        ArrayList<Personaje>mazoJugadorDos = new ArrayList<Personaje>();


        int indice = numeroRandomDeArray(mazo);
            mazoJugadorUno.add(mazo.get(indice));
            mazo.remove(mazo.get(indice));


            indice = numeroRandomDeArray(mazo);
            mazoJugadorUno.add(mazo.get(indice));
            mazo.remove(mazo.get(indice));

            indice = numeroRandomDeArray(mazo);
            mazoJugadorUno.add(mazo.get(indice));
            mazo.remove(mazo.get(indice));


       jugadorUno.setMazo(mazoJugadorUno);
       jugadorUno.setMazoOriginal((ArrayList)mazoJugadorUno.clone());


        mazoJugadorDos.add(mazo.get(0));
        mazoJugadorDos.add(mazo.get(1));
        mazoJugadorDos.add(mazo.get(2));
        jugadorDos.setMazo(mazoJugadorDos);
        jugadorDos.setMazoOriginal((ArrayList)mazoJugadorDos.clone());



    }




    public Personaje crearPersonajeManual() throws InputNumericaExeption {



        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nIndique clase de guerrero a crear, presione:\n" +
                "1) Elfo\n" +
                "2) Humano\n" +
                "3) Orco\n");
        int opcion = inputControlado(1, 3, "Opcion");


        solicitarDatos();



        if (opcion == 1){
                Elfo elfo = new Elfo(nombre,apodo,dia,mes,anio,1000,velocidad,destreza,fuerza,1,armadura);
                elfo.setearPoderes(elfo);
                return elfo;
            }

        else if (opcion == 2) {
            Humano humano = new Humano(nombre, apodo, dia, mes, anio, 1000, velocidad, destreza, fuerza, 1, armadura);
            humano.setearPoderes(humano);
            return humano;
        }
        else if (opcion == 3){
                Orco orco = new Orco(nombre,apodo,dia,mes,anio,1000,velocidad,destreza,fuerza,1,armadura);
                orco.setearPoderes(orco);
                return orco;
        }


       return null;
       //ACA NO DEBERIA RETORNAR NULL, PERO ESTA CONTROLADA LA RUTINA, NO VA LLEGAR NUNCA ACÁ

    }



    protected boolean confirmaDatos(String opcion){
        opcion.toLowerCase();
        //System.out.println(opcion);

        while ((!opcion.equals("s")) && (!opcion.equals("n"))){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese una opcion valida (S/N)");
            opcion = scanner.nextLine().toLowerCase();
        }

        if (opcion.equals("s")){
            return Boolean.TRUE;
        }
        else return Boolean.FALSE;
    }


    public void crearMazoManual(){

        ArrayList<Personaje> personajes = new ArrayList<>();

        while (personajes.size()<=5) {
            try {
                personajes.add(crearPersonajeManual());


                System.out.println("\nResta crear "+ (6 - personajes.size()) + " personajes.\n");


            } catch (InputNumericaExeption e) {
                throw new RuntimeException(e);
            }
        }

        repartirMazo(personajes);

    }


    protected int ingresoInt(){
        Scanner scanner = new Scanner(System.in);
        int valorIngresado=0;

        boolean validar = false;
        while (!validar) {
            try {
                //System.out.print("Ingrese un numero: ");
                valorIngresado = scanner.nextInt();
                validar = true;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("debe ingresar un numero");
            }
        }

        return valorIngresado;
    }



    protected int inputControlado(int valorMin, int valorMax, String nombreVariable){

        Scanner scanner = new Scanner(System.in);
        System.out.print(nombreVariable+": ");

       //valida que ingrese int
       int valorIngresado = ingresoInt();


        //luego valida entero

            if ((valorIngresado > valorMin) && (valorIngresado < valorMax)){
                return valorIngresado;
            }

            while ((valorIngresado < valorMin) || (valorIngresado > valorMax)){
                System.out.print("seleccione un numero entre "+valorMin+" y " + valorMax + ".\n"+nombreVariable+": ");
                valorIngresado = ingresoInt();
            }


        return valorIngresado;

    }



    protected void solicitarDatos(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nDatos del Guerrero: ");
        System.out.print("Nombre: ");
        this.nombre = scanner.nextLine();

        System.out.print("Apodo: ");
        this.apodo = scanner.nextLine();

        this.anio = inputControlado(2024-300,2024,"Año");
        this.mes = inputControlado(1,12,"Mes");
        this.dia = inputControlado(1,30,"Dia");
        this.velocidad = inputControlado(1,10,"Velocidad");
        this.destreza = inputControlado(1,5,"Destreza");
        this.fuerza = inputControlado(1,10,"Fuerza");
        this.armadura = inputControlado(1,10,"Armadura");




        System.out.print("\n\nConfirma creacion de personaje? S/N  ");

        Boolean confirmarPersonaje = confirmaDatos(scanner.nextLine());

        if (confirmarPersonaje){
            System.out.println("Datos registrados correctamente.");
        }else {
            System.out.println("\nIngrese nuevamente los datos: \n");
            solicitarDatos();
        }

    }



    protected int numeroRandomDeArray(ArrayList array){
        Random random = new Random();

       return random.nextInt(array.size());
    }


    }



