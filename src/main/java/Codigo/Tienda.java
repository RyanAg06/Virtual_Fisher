package Codigo;

import java.util.Scanner;

public class Tienda
{
    /* Variables */
    private final Jugador jugador;
    private Scanner in = null;
    
    /* Constructor */
    public Tienda(Jugador jugador, Scanner in)
    {
        this.jugador = jugador;
        this.in = in;
    }
    public void vender()
    {
        int ganancia = 0; // Acumulador de Ganancias
                    
        /* Recorro Inventario y sumo Ganancias */
        for(Tesoros pezVenta : jugador.getInventario())
        {
            ganancia += pezVenta.getValor();
        }

        /* Verifico si Vendio Peces */
        if(ganancia == 0)
        {
            System.out.println("NO HAY NADA QUE VENDER");
        }
        else
        {
            jugador.clearPeces();                               // Vacio Inventario
            jugador.setDinero(jugador.getDinero() + ganancia);  // Sumo Dinero
            System.out.println("PECES VENDIDOS CORRECTAMENTE");
        }
    }
    public void menuCanas()
    {
        /* Tienda Canas */
        int opcionCana = 0;

        /* Tienda Canas */
        do
        {
            System.out.println("------------------ CANAS -----------------");
            System.out.println("1. Cana de Plastico        " + jugador.getCanas().get(0).getEstado());
            System.out.println("2. Cana Improvisada        " + jugador.getCanas().get(1).getEstado());
            System.out.println("3. Cana de Hierro          " + jugador.getCanas().get(2).getEstado());
            System.out.println("4. Cana Pesada             " + jugador.getCanas().get(3).getEstado());
            System.out.println("5. Salir");
            System.out.print("->");

            /* Pido Opcion del Usuario */
            try
            {
                opcionCana = Integer.parseInt(in.nextLine());
            }
            catch(NumberFormatException e)
            {
                System.out.println("Solo Ingresa Numeros");
            }

            /* Entro al Caso Seleccionado */
            switch(opcionCana)
            {
                case 1 ->
                {
                    comprarCana(jugador, 0, 0);
                    break;
                }
                case 2 ->
                {
                    comprarCana(jugador, 500, 1);
                    break;
                }
                case 3 ->
                {
                    comprarCana(jugador, 1000, 2);
                    break;
                }
                case 4 ->
                {
                    comprarCana(jugador, 2500, 3);
                    break;
                }
                case 5 ->
                {
                    System.out.println("Saliendo...");
                    break;
                }
            }
        }
        while(opcionCana != 5);
    }
    
    /* Metodo Comprar Canas */
    private static void comprarCana(Jugador jugador, int precio, int index)
    {
        /* Primero Verifico si Tiene Dinero Suficiente Y NO esta Comprado */
        if(jugador.getDinero() >= precio && jugador.getCanas().get(index).getComprado() == false)
        {
            jugador.setDinero(jugador.getDinero() - precio);    // Resto Dinero
            jugador.getCanas().get(index).setComprado(true);    // Cambio Estado a Comprado
            jugador.setIndexCana(index);                        // Selecciono la Cana
            System.out.println("Comprado!");
            System.out.println("Seleccionada Correctamente");
        }
        /* Verifico Si Esta Comprada */
        else if(jugador.getCanas().get(index).getComprado())
        {
            jugador.setIndexCana(index);                        // Selecciono Cana
            System.out.println("Seleccionada Correctamente");
        }
        /* Si no esta Comprada Muestro Cuando le Falta */
        else
        {
            System.out.println("Aun Necesitas " + (precio - jugador.getDinero()));
        }
    }
}
