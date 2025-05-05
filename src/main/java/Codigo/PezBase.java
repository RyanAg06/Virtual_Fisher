package Codigo;

import java.io.Serializable;

public abstract class PezBase implements Serializable
{
    /* Varibales */
    private String nombre;
    private int valor, probabilidad, xp;

    /* Constructor */
    public PezBase(String nombre, int probabilidad)
    {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }

    /* Getters */
    public String getNombre() {
        return nombre;
    }
    public int getProbabilidad() {
        return probabilidad;
    }
    public abstract int getValor();
    public abstract int getXp();
}
