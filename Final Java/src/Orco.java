import java.time.LocalDate;

public class Orco extends Personaje{

    public Orco(String nombre, String apodo, int diaNac, int mesNac, int anoNac, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(nombre, apodo, diaNac, mesNac, anoNac, salud, velocidad, destreza, fuerza, nivel, armadura);
    }

    public Orco(String nombre, String apodo, LocalDate fechaNacimiento, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(nombre, apodo, fechaNacimiento, salud, velocidad, destreza, fuerza, nivel, armadura);
    }

    public String toString() {
        return "Personaje{" +
                "\n   clase='" + "ORCO" +
                "\n   nombre='" + getNombre() +
                "\n   apodo='" + getApodo() +
                "\n   fechaNacimiento=" + getFechaNacimiento() +
                "\n   edad=" + getEdad() +
                "\n   salud=" + getSalud() +
                "\n   velocidad=" + getVelocidad() +
                "\n   destreza=" + getDestreza() +
                "\n   fuerza=" + getFuerza() +
                "\n   nivel=" + getNivel() +
                "\n   armadura=" + getArmadura() +
                "\n   valorAtaque=" + getValorAtaque() +
                "\n   efectividadDisparo=" + getEfectividadDisparo() +
                "\n   poderDisparo=" + getPoderDisparo() +
                "\n   poderDefensa=" + getPoderDefensa() +
                "\n}";
    }

    @Override
    public double calcularAtaque(Personaje defensor) {
        double danio = (((getValorAtaque()*getEfectividadDisparo() - defensor.getPoderDefensa()/500)*100)*1.1);
        defensor.setSalud((int) (defensor.getSalud()-danio));

        if (defensor.getSalud()<0){                   //para que no queden numeros negativos
            defensor.setSalud(0);
        }
        return danio;
    }
}
