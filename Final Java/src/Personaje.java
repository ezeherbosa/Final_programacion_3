import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.time.LocalDate;

public abstract class Personaje{

    private String nombre;
    private String apodo;
    private int diaNac;
    private int mesNac;
    private int anoNac;

    private LocalDate fechaNacimiento;
    private int edad;
    private int salud;
    private int velocidad;
    private int destreza;
    private int fuerza;
    private int nivel;
    private int armadura;
    private double valorAtaque;
    private double efectividadDisparo;
    private int poderDisparo;
    private int poderDefensa;
    private String clase;


    //Creo dos constructores, el primero es para ingresar la fecha a mano, el segundo recibe un localDate y crea el objeto automaticamente.
    public Personaje(String nombre, String apodo, int diaNac, int mesNac, int anoNac, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.diaNac = diaNac;
        this.mesNac = mesNac;
        this.anoNac = anoNac;
        fechaNacimiento = LocalDate.of(this.anoNac, this.mesNac, this.diaNac);
        edad = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
        this.salud = salud;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
    }


    public Personaje(String nombre, String apodo, LocalDate fechaNacimiento, int salud, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
        edad = (int) ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());
        this.salud = salud;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.armadura = armadura;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {

        this.fechaNacimiento = fechaNacimiento;

    }


    public int getDiaNac() {
        return diaNac;
    }

    public void setDiaNac(int diaNac) {
        this.diaNac = diaNac;
    }

    public int getMesNac() {
        return mesNac;
    }

    public void setMesNac(int mesNac) {
        this.mesNac = mesNac;
    }

    public int getAnoNac() {
        return anoNac;
    }

    public void setAnoNac(int anoNac) {
        this.anoNac = anoNac;
    }


    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }


    public double getValorAtaque() {
        return valorAtaque;
    }

    public void setValorAtaque(double valorAtaque) {
        this.valorAtaque = valorAtaque;
    }

    public double getEfectividadDisparo() {
        return efectividadDisparo;
    }

    public void setEfectividadDisparo(double efectividadDisparo) {
        this.efectividadDisparo = efectividadDisparo;
    }

    public int getPoderDisparo() {
        return poderDisparo;
    }

    public void setPoderDisparo(int poderDisparo) {
        this.poderDisparo = poderDisparo;
    }

    public int getPoderDefensa() {
        return poderDefensa;
    }

    public void setPoderDefensa(int poderDefensa) {
        this.poderDefensa = poderDefensa;
    }

    public int calcularPoderDisparo(int destreza, int fuerza, int nivel) {
        return destreza * fuerza * nivel;
    }

    public double calcularEfectividadDisparo() {
        Random random = new Random();
        return (random.nextInt(100) + 1);

    }

    public double calcularValorAtaque(int poderDisparo, double efectividadDisparo) {
        return poderDisparo * efectividadDisparo;
    }

    public int calcularPoderDefensa(int armadura, int velocidad) {
        return armadura * velocidad;
    }

    public void setearPoderes(Personaje personaje) {
        poderDisparo = personaje.calcularPoderDisparo(personaje.getDestreza(), personaje.getFuerza(), personaje.getNivel());
        efectividadDisparo = personaje.calcularEfectividadDisparo() / 100;
        valorAtaque = personaje.calcularValorAtaque(personaje.poderDisparo, personaje.efectividadDisparo);
        poderDefensa = calcularPoderDefensa(personaje.armadura, personaje.velocidad);
    }


    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", apodo='" + apodo + '\'' +
                ", diaNac=" + diaNac +
                ", mesNac=" + mesNac +
                ", anoNac=" + anoNac +
                ", fechaNacimiento=" + fechaNacimiento +
                ", edad=" + edad +
                ", salud=" + salud +
                ", velocidad=" + velocidad +
                ", destreza=" + destreza +
                ", fuerza=" + fuerza +
                ", nivel=" + nivel +
                ", armadura=" + armadura +
                ", valorAtaque=" + valorAtaque +
                ", efectividadDisparo=" + efectividadDisparo +
                ", poderDisparo=" + poderDisparo +
                ", poderDefensa=" + poderDefensa +
                ", clase='" + clase + '\'' +
                '}';
    }


    public abstract double calcularAtaque(Personaje defensor);

}

