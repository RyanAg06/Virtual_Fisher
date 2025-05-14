package Codigo;

public abstract class Canas
{
    protected String nombre;
    protected int tirosRestantes;
    protected boolean comprado = false;
    
    public Canas(String nombre, boolean comprado) {
        this.nombre = nombre;
        this.comprado = comprado;
    }
    public int getGirosRestantes() {
        return tirosRestantes;
    }
    public String getNombre() {
        return nombre;
    }
    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }
    public boolean getComprado() {
        return comprado;
    }
    public abstract String getEstado();
}

class CanaPlastico extends Canas
{
    public CanaPlastico(boolean comprado) {
        super("Cana de Plastico", comprado);
        tirosRestantes = 1;
    }
    @Override
    public String getEstado() {
        return "OBTENIDO";
    }
}
class CanaImprovisada extends Canas
{
    public CanaImprovisada(boolean comprado) {
        super("Cana Improvisada", comprado);
        tirosRestantes = 2;
    }
    @Override
    public String getEstado() {
        if(comprado)
        {
            return "OBTENIDO";
        }
        else
        {
            return "500$";
        }
    }
}
class CanaHierro extends Canas
{
    public CanaHierro(boolean comprado) {
        super("Cana de Hierro", comprado);
        tirosRestantes = 3;
    }
    @Override
    public String getEstado() {
        if(comprado)
        {
            return "OBTENIDO";
        }
        else
        {
            return "1000$";
        }
    }
}
class CanaPesada extends Canas
{
    public CanaPesada(boolean comprado) {
        super("Cana Pesada", comprado);
        tirosRestantes = 4;
    }
    @Override
    public String getEstado() {
        if(comprado)
        {
            return "OBTENIDO";
        }
        else
        {
            return "2500$";
        }
    }
}