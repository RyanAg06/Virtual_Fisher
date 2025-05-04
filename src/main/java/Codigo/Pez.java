package Codigo;

public class Pez
{
    /* Varibales */
    private String nombre;
    private int valor, probabilidad, xp;

    /* Constructor */
    public Pez(String nombre, int valor, int probabilidad, int xp)
    {
        this.nombre = nombre;
        this.valor = valor;
        this.probabilidad = probabilidad;
        this.xp = xp;
    }

    /* Getters */
    public String getNombre() {
        return nombre;
    }
    public int getValor() {
        return valor;
    }
    public int getProbabilidad() {
        return probabilidad;
    }
    public int getXp() {
        return xp;
    }
}
