package Codigo;

import java.util.ArrayList;

public class GeneradorPez
{
    ArrayList<Pez> peces;
    
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
                peces.add(new Pez("Bacalao", 10, 60, 10));
                peces.add(new Pez("Salmon", 15, 30, 10));
                peces.add(new Pez("Nada", 0, 10, 0));
                break;
            }
            case 2 ->
            {
                peces.add(new Pez("Bacalao", 10, 50, 10));
                peces.add(new Pez("Salmon", 15, 20, 10));
                peces.add(new Pez("Pulpo", 15, 15, 10));
                peces.add(new Pez("Nada", 0, 15, 0));
                break;
            }
        }
    }
    
    public Pez pescar(int tirosRestantes, int nivel)
    {
        while(tirosRestantes > 0)
        {
            /* Cargo Peces Segun Nivel Jugador */
            cargarPeces(nivel);

            /* Creo Probabilidad 0 - 100 */
            int probabilidad = (int) (Math.random() * 100 + 1);
            int sumaProb = 0; /* Acumulador De Probabilidades */
            
            // System.out.println("Salio: " + probabilidad);

            /* Recorro Array y Acumulo Probabilidades */
            for(Pez pez : peces)
            {
                sumaProb += pez.getProbabilidad();

                /* Verifico Probabilidad Mas Alta y Retorno Pez */
                if(probabilidad < sumaProb)
                {
                    return pez;
                }
            }
        }
        
        /* Retorno Null por si Acaso */
        return null;
    }
}
