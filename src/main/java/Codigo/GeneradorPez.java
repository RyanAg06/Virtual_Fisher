package Codigo;

import java.util.ArrayList;

public class GeneradorPez
{
    ArrayList<Tesoros> tesoros;
    
    private void cargarPeces(int nivel)
    {
        /* Reinicio Array Cada que Tira */
        tesoros = new ArrayList<>();
        
        /* Selecciono Peces Segun el Nivel */
        switch(nivel)
        {
            /* Orden Probabilidad Mayor a Menor */
            case 1 ->
            {
                tesoros.add(new Bacalao(60));
                tesoros.add(new Salmon(30));
                break;
            }
            case 2 ->
            {
                tesoros.add(new Bacalao(60));
                tesoros.add(new Salmon(20));
                tesoros.add(new Tropical(10));
                break;
            }
            case 3 ->
            {
                tesoros.add(new Bacalao(50));
                tesoros.add(new Salmon(25));
                tesoros.add(new Tropical(15));
                tesoros.add(new Pulpo(10));
                break;
            }
        }
    }
    
    public Tesoros pescar(int nivel)
    {
        /* Cargo Peces Segun Nivel Jugador */
        cargarPeces(nivel);

        /* Creo Probabilidad 0 - 100 */
        int probabilidad = (int) (Math.random() * 100 + 1);
        int sumaProb = 0; /* Acumulador De Probabilidades */

        /* Recorro Array y Acumulo Probabilidades */
        for(Tesoros pez : tesoros)
        {
            sumaProb += pez.getProbabilidad();

            /* Verifico Probabilidad Mas Alta y Retorno Tesoros */
            if(probabilidad < sumaProb)
            {
                System.out.print((pez.getProbabilidad()) + "% -> ");
                return pez;
            }
        }
        
        /* Retorno Null si no Suman 100% */
        return null;
    }
}
