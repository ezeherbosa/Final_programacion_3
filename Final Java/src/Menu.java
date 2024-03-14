import java.util.Scanner;

public class Menu {
public void iniciaMenu(){

    Scanner scanner = new Scanner(System.in);

    int opcion;

    System.out.println("prueba de menu");
    System.out.println("opcion 1");
    System.out.println("opcion 2");
    System.out.println("opcion 3");
    System.out.println("opcion 4");
    System.out.println("opcion 5");
    System.out.println("opcion 6");
    System.out.println("");
    System.out.println("opcion n°: ");
    opcion = scanner.nextInt();

    switch (opcion){
        case 1:
            System.out.println("seleccionaste 1"); break;
        case 2:
            System.out.println("seleccionaste 2"); break;
        case 3:
            System.out.println("seleccionaste 3"); break;
        case 4:
            System.out.println("seleccionaste 4"); break;
        case 5:
            System.out.println("seleccionaste 5"); break;
        case 6:
            System.out.println("seleccionaste 6"); break;
        default:
           // iniciaMenu();
    }


}




}
