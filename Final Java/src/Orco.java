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
                "clase='" + "ORCO" + '\'' +
                " nombre='" + getNombre() + '\'' +
                ", apodo='" + getApodo() + '\'' +
                ", fechaNacimiento=" + getFechaNacimiento() +
                ", edad=" + getEdad() +
                ", salud=" + getSalud() +
                ", velocidad=" + getVelocidad() +
                ", destreza=" + getDestreza() +
                ", fuerza=" + getFuerza() +
                ", nivel=" + getNivel() +
                ", armadura=" + getArmadura() +
                ", valorAtaque=" + getValorAtaque() +
                ", efectividadDisparo=" + getEfectividadDisparo() +
                ", poderDisparo=" + getPoderDisparo() +
                ", poderDefensa=" + getPoderDefensa() +
                '}';
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
