package Codigo;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Jugador jugador = new Jugador();
        Pez pez;
        int opcion = 0;
        long ultimoTiempoPesca = 0;
        
        /* MENU */
        do
        {
            System.out.println("------------------ MENU -----------------");
            System.out.println("1. Pescar");
            System.out.println("2. Vender");
            System.out.println("3. Tienda");
            System.out.println("4. Inventario");
            System.out.println("5. Salir");
            System.out.print("-> ");
            
            /* Evaluo en Caso que Usuario No Ingrese un Numero */
            try
            {
                opcion = Integer.parseInt(in.nextLine());
            }
            catch(NumberFormatException e)
            {
                System.err.println("Solo Ingresa Numeros");
            }
            
            switch(opcion)
            {
                case 1 ->
                {
                    long ahora = System.currentTimeMillis(); // Obtengo Milisegundos Actuales

                    if((ahora - ultimoTiempoPesca) >= jugador.getCooldown() * 1000)
                    {
                        /* Genero Pez */
                        GeneradorPez generador = new GeneradorPez();
                        pez = generador.pescar(jugador.getNivel());
                        System.out.println(pez.getNombre()); // Muestro Pez Obtenido
                        jugador.addPeces(pez); // Agrego Pez a Inventario

                        /* Sumo Contadores */
                        switch(pez.getNombre())
                        {
                            case "Bacalao" -> jugador.setBacalao(jugador.getBacalao() + 1);
                            case "Salmon" -> jugador.setSalmon(jugador.getSalmon() + 1);
                            case "Nada" -> System.out.println("Suerte la Proxima");
                        }
                        ultimoTiempoPesca = ahora;
                    }
                    else
                    {
                        System.out.println("Debes esperar " + jugador.getCooldown() + " Segundos");
                        System.out.println("Cooldown: " + (ahora - ultimoTiempoPesca));
                    }
                    break;
                }
                case 2 ->
                {
                    int ganancia = 0; // Acumulador de Ganancias
                    
                    /* Recorro Inventario y sumo Ganancias */
                    for(Pez pezVenta : jugador.getInventario())
                    {
                        ganancia += pezVenta.getValor();
                    }
                    if(ganancia == 0)
                    {
                        System.out.println("NO HAY NADA QUE VENDER");
                    }
                    else
                    {
                        jugador.clearPeces(); // Vacio Inventario
                        jugador.setDinero(jugador.getDinero() + ganancia); // Sumo Dinero
                        System.out.println("PECES VENDIDOS CORRECTAMENTE");
                    }
                    break;
                }
                case 4 ->
                {
                    System.out.println("------------------ INVENTARIO -----------------");
                    System.out.println("DINERO: " + jugador.getDinero());
                    System.out.println("BACALAOS: " + jugador.getBacalao());
                    System.out.println("SALMON: " + jugador.getSalmon());
                    break;
                }
            }
        }
        while(opcion != 5);
    }
}
