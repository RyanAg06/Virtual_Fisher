package Codigo;

public class Salmon extends PezBase
{
    public Salmon(int probabilidad) {
        super("Salmon", probabilidad);
    }
    @Override
    public int getValor() {
        return 30;
    }
    @Override
    public int getXp() {
        return 30;
    }
}
