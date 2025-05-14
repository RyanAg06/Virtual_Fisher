package Codigo;

public class Jugar
{
    private Jugador jugador;
    private long ultimoTiempoPesca = 0;                 // Delay de Pesca
    
    public Jugar(Jugador jugador)
    {
        this.jugador = jugador;
    }
    
    /* Metodo Pescar */
    public void pescar()
    {
        Tesoros pez;    // Creo Pez
        long ahora = System.currentTimeMillis();    // Obtengo Milisegundos Actuales

        /* Verifico si Cooldown Acabo */
        if((ahora - ultimoTiempoPesca) >= jugador.getCooldown() * 1000)
        {
            /* Pesca N Veces */
            for(int a  = 0; a < jugador.getCanas().get(jugador.getIndexCana()).getGirosRestantes(); a++)
            {
                /* Genero Tesoros */
                GeneradorPez generador = new GeneradorPez();
                pez = generador.pescar(jugador.getNivel());

                /* Si es Null no Atrapo Nada */
                if(pez == null)
                {
                    System.out.println("Suerte la Proxima");
                }
                else
                {
                    System.out.println(pez.getNombre());    // Muestro Pez Obtenido
                    jugador.addPeces(pez);                  // Agrego Pez a Inventario

                    /* Agrego XP */
                    jugador.setXp(jugador.getXp() + pez.getXp());
                    if(jugador.getXp() >= jugador.getXpLimite())
                    {
                        jugador.setXp(jugador.getXp() - jugador.getXpLimite());
                        jugador.subirNivel();
                    }

                    /* Sumo Contadores */
                    switch(pez.getNombre())
                    {
                        case "Bacalao" -> jugador.setBacalao(jugador.getBacalao() + 1);
                        case "Salmon" -> jugador.setSalmon(jugador.getSalmon() + 1);
                        case "Tropical" -> jugador.setTropical(jugador.getTropical()+ 1);
                        case "Pulpo" -> jugador.setPulpo(jugador.getPulpo() + 1);
                    }
                }
            }
            ultimoTiempoPesca = ahora;
        }
        else
        {
            System.out.println("Debes esperar " + jugador.getCooldown() + " Segundos");
            System.out.println("Cooldown: " + (ahora - ultimoTiempoPesca));
        }
    }
}
