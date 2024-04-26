import java.util.Random;



public class GeneradorStrings {

    Random random = new Random();

    public String generarNombre(){

        String[] listaNombres = {
                "Aldric", "Eleanor", "Gareth", "Isolde", "Luther",
                "Matilda", "Oswald", "Rowena", "Theobald", "Winifred",
                "Aeliana", "Caelum", "Eldarian", "Faelon", "Lorelei",
                "Nimrodel", "Quenarion", "Sylvaris", "Thalorin", "Ysolde",
                "Grommash", "Thrall", "Durotan", "Gul'dan", "Azog",
                "Lurtz", "Uruk", "Ghorbash", "Sharn gro-Mak", "Mogakh",
                "Aurelia", "Cyrus", "Seraphina", "Caspian", "Isabeau",
                "Oberon", "Titania", "Eowyn", "Legolas", "Gimli",
                "Arwen", "Frodo", "Galadriel", "Elrond", "Boromir",
                "Artemis", "Apollo", "Persephone", "Zeus", "Athena",
                "Hades", "Achilles", "Hera", "Odysseus", "Circe",
                "Gideon", "Thalia", "Aldwin", "Ceridwen", "Morgana",
                "Lucius", "Dante", "Octavia", "Rufus", "Aurelius",
                "Isadora", "Lysander", "Cassius", "Valeria", "Maximus",
                "Aurelius", "Titus", "Corvus", "Viviana", "Caius",
                "Gaius", "Aquila", "Ravenna", "Aloysius", "Euphemia",
                "Clementine", "Peregrine", "Melisandre", "Oliviana", "Ignatius",
                "Leocadia", "Crispin", "Eulalia", "Emeric", "Balthazar",
                "Zephyrine", "Endymion", "Eudora", "Gwendolyn", "Quintus"
        };



        String nombre = listaNombres[random.nextInt(0, listaNombres.length)];

        return nombre;
    }




    public String generarApodo(){
        String[] listaApodos = {
                "Che", "Guacho", "Flaco", "Morocho", "Rubia",
                "Tano", "Colo", "Pibe", "Gordo", "Chino",
                "Chiqui", "Nene", "Pelado", "Negra", "Pitu",
                "Gringo", "Pela", "Moncho", "Chiquito", "Rulo",
                "Turco", "Pochi", "Cholo", "Chuchi", "Palomo",
                "Chapa", "Rata", "Chavo", "Titi", "Rengo",
                "Coco", "China", "Cachito", "Pepe", "Mona",
                "Cuervo", "Chiquito", "Luli", "Orejón", "Nona",
                "Nito", "Cacho", "Chucky", "Beto", "Piojo",
                "Fideo", "Charly", "Chiquis", "Yaya", "Toto",
                "Tata", "Kuki", "Cuca", "Chinito", "Coti",
                "Pichu", "Chabela", "Rana", "Coki", "Pato",
                "Tuty", "Kiko", "Nany", "Chiche", "Ponja",
                "Fefe", "Chiquito", "Tito", "Coki", "Chavo",
                "Kuki", "Chispa", "Chino", "Chicho", "Cordobes",
                "Chelo", "Chona", "Chuli", "Cuqui", "Fido",
                "Gigi", "Huguinho", "Jorgito", "Kike", "Lulu",
                "Mimi", "Nono", "Paco", "Quique", "Roli",
                "Santi", "Tano", "Uli", "Vivi", "Wally",
                "Xuxa", "Yoli", "Zafa", "Zizi", "Coco"
        };

        String apodo = listaApodos[random.nextInt(0, listaApodos.length)];

        return apodo;


    }



}
