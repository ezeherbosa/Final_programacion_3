import javax.swing.*;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

/*
        Humano h1 = new Humano("asd","pepe",01,12,1930,4,2,7,4,1,8);
        h1.setearPoderes(h1);
        System.out.println(h1.toString());

        System.out.println(  "daño: " +   (h1.Ataque(h1)));

        System.out.println("-----------------");


        Orco o1 = new Orco("orquer","tyu",19,10,0100,4,3,3,1,5,1);
        o1.setearPoderes(o1);
        System.out.println(o1.toString());

        System.out.println(  "daño: " +   (o1.Ataque(o1)));

        System.out.println("-----------------");


        Elfo e1 = new Elfo("elfer","zxc",25,10,1415,3,3,1,5,2,9);
        e1.setearPoderes(e1);
        System.out.println(e1.toString());;
        System.out.println(  "daño: " +   (e1.Ataque(e1)));

/*
        Menu menu = new Menu();


        try{
            menu.iniciaMenu();
        }
        catch (Exception e){
            System.out.println("no se pudo");
        }

*/
        Jugador j1 = new Jugador("eze");
        Jugador j2 = new Jugador("maquina");

        Partida partida = new Partida(j1,j2);

        partida.repartirMazo();


        Combate combate = new Combate();

        SorteoInicio sorteoInicio = new SorteoInicio();
        sorteoInicio.sorteoInicio(j1,j2);

        if (j1.getTurno() == Boolean.TRUE){
            combate.combate(j1,j2);
        } else {
           combate.combate(j2,j1);
        }




        System.out.println("Fin de Partida");










    }




    }
