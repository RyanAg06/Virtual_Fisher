package Codigo;

public class Pulpo extends PezBase
{
    public Pulpo(int probabilidad) {
        super("Pulpo", probabilidad);
    }
    @Override
    public int getValor() {
        return 50;
    }
    @Override
    public int getXp() {
        return 100;
    }
}
