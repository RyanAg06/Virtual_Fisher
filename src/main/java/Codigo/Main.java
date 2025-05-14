package Codigo;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);    // Creo Scanner
        Jugador jugador = new Jugador();        // Creo Juugador
        Tesoros pez;                            // Creo Pez
        int opcionMenu = 0;                     // Opcion Menu
        long ultimoTiempoPesca = 0;             // Delay de Pesca
        /* Agrego Canas */
        jugador.addCana(new CanaPlastico(true));
        jugador.addCana(new CanaImprovisada(false));
        jugador.addCana(new CanaHierro(false));
        jugador.addCana(new CanaPesada(false));
        
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
            
            /* Pido Opcion del Usuario */
            try
            {
                opcionMenu = Integer.parseInt(in.nextLine());
            }
            catch(NumberFormatException e)
            {
                System.err.println("Solo Ingresa Numeros");
            }
            
            /* Evaluo Opcion */
            switch(opcionMenu)
            {
                case 1 ->
                {
                    long ahora = System.currentTimeMillis(); // Obtengo Milisegundos Actuales

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
                                System.out.println(pez.getNombre()); // Muestro Pez Obtenido
                                jugador.addPeces(pez); // Agrego Pez a Inventario

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
                                    case "Tropical" -> jugador.setPulpo(jugador.getPulpo() + 1);
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
                    break;
                }
                case 2 ->
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
                    break;
                }
                case 3 ->
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
                    break;
                }
                case 4 ->
                {
                    /* Muestro Estadisticas */
                    System.out.println("------------------ ESTADISTICAS -----------------");
                    System.out.println("NIVEL: " + jugador.getNivel());
                    System.out.println("XP: " + jugador.getXp() + "/" + jugador.getXpLimite());
                    System.out.println("DINERO: " + jugador.getDinero() + "$" + "\n");
                    System.out.println("--- INVENTARIO ---");
                    System.out.println("BACALAOS: " + jugador.getBacalao());
                    System.out.println("SALMON: " + jugador.getSalmon());
                    
                    /* Si Nivel es 2 Muestro Contador Tropical */
                    if(jugador.getNivel() >= 2)
                    {
                        System.out.println("TROPICAL: " + jugador.getTropical());
                    }
                    
                    /* Si Nivel es 3 Muestro Contador Pulpo */
                    if(jugador.getNivel() >= 3)
                    {
                        System.out.println("Pulpo: " + jugador.getPulpo() + "\n");
                    }
                    
                    /* Recorro Inventario Canas y Muestro Obtenidos */
                    System.out.println("--- CANAS ---");
                    for(Canas cana : jugador.getCanas())
                    {
                        if(cana.getComprado())
                        {
                            System.out.println(cana.getNombre());
                        }
                    }
                    break;
                }
            }
        }
        while(opcionMenu != 5);
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
