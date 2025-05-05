package Codigo;

public class Bacalao extends PezBase
{
    public Bacalao(int probabilidad) {
        super("Bacalao", probabilidad);
    }
    @Override
    public int getValor() {
        return 10;
    }
    @Override
    public int getXp() {
        return 10;
    }
}
