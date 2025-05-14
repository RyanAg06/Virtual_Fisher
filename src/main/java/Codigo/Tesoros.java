package Codigo;

public abstract class Tesoros
{
    protected String nombre;
    protected int valor, probabilidad, xp;
    
    public Tesoros(String nombre, int probabilidad) {
        this.nombre = nombre;
        this.probabilidad = probabilidad;
    }
    public String getNombre() {
        return nombre;
    }
    public int getProbabilidad() {
        return probabilidad;
    }
    public int getValor() {
        return valor;
    }
    public int getXp() {
        return xp;
    }
}

class Bacalao extends Tesoros
{
    public Bacalao(int probabilidad) {
        super("Bacalao", probabilidad);
        valor = 3;
        xp = 5;
    }
}

class Salmon extends Tesoros
{
    public Salmon(int probabilidad) {
        super("Salmon", probabilidad);
        valor = 5;
        xp = 10;
    }
}

class Tropical extends Tesoros
{
    public Tropical(int probabilidad) {
        super("Tropical", probabilidad);
        valor = 15;
        xp = 25;
    }
}

class Pulpo extends Tesoros
{
    public Pulpo(int probabilidad) {
        super("Pulpo", probabilidad);
        valor = 25;
        xp = 50;
    }
}

class TesoroCustom extends Tesoros
{
    public TesoroCustom(String nombre, int probabilidad, int valor, int xp) {
        super(nombre, probabilidad);
        this.valor = valor;
        this.xp = xp;
    }
}