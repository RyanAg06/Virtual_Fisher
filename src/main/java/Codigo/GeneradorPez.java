package Codigo;

import java.util.ArrayList;

public class GeneradorPez
{
    ArrayList<PezBase> peces;
    
    private void cargarPeces(int nivel)
    {
        /* Reinicio Array Cada que Tira */
        peces = new ArrayList<>();
        
        /* Selecciono Peces Segun el Nivel */
        switch(nivel)
        {
            /* Orden Probabilidad Mayor a Menor */
            case 1 ->
            {
                peces.add(new Bacalao(60));
                peces.add(new Salmon(30));
                break;
            }
            case 2 ->
            {
                peces.add(new Bacalao(60));
                peces.add(new Salmon(20));
                peces.add(new Pulpo(10));
                break;
            }
        }
    }
    
    public PezBase pescar(int nivel)
    {
        /* Cargo Peces Segun Nivel Jugador */
        cargarPeces(nivel);

        /* Creo Probabilidad 0 - 100 */
        int probabilidad = (int) (Math.random() * 100 + 1);
        int sumaProb = 0; /* Acumulador De Probabilidades */

        /* Recorro Array y Acumulo Probabilidades */
        for(PezBase pez : peces)
        {
            sumaProb += pez.getProbabilidad();

            /* Verifico Probabilidad Mas Alta y Retorno PezBase */
            if(probabilidad < sumaProb)
            {
                return pez;
            }
        }
        
        /* Retorno Null si no Suman 100% */
        return null;
    }
}
