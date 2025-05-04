package Codigo;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Jugador jugador = new Jugador();
        int opcion;
        
        do
        {
            System.out.println("------------------ MENU -----------------");
            System.out.println("1. Pescar");
            System.out.println("2. Vender");
            System.out.println("3. Tienda");
            System.out.println("4. Salir");
            System.out.print("-> ");
            opcion = Integer.parseInt(in.nextLine());
            
            switch(opcion)
            {
                case 1 ->
                {
                    GeneradorPez generador = new GeneradorPez();
                    Pez pez = generador.pescar(jugador.getTirosRestantes(), jugador.getNivel());
                    System.out.println(pez.getNombre());
                    break;
                }
                case 2 ->
                {
                    
                    break;
                }
            }
        }
        while(opcion != 4);
    }
}
