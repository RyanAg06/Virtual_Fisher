package Codigo;

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Jugador jugador = new Jugador();            // Creo Jugador
        
        /* Cargar Datos Jugador */
        File save = new File("C:\\Users\\"+ System.getProperty("user.name") +"\\AppData\\Roaming\\virtual_fisher_save.bin");
        jugador = cargar(jugador, save);
        
        Scanner in = new Scanner(System.in);        // Creo Scanner
        Jugar jugar = new Jugar(jugador);           // Creo Jugar
        Tienda tienda = new Tienda(jugador, in);    // Creo Tienda
        int opcionMenu = 0;                         // Opcion Menu
        
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
                    jugar.pescar();
                    break;
                }
                case 2 ->
                {
                    tienda.vender();
                    break;
                }
                case 3 ->
                {                    
                    tienda.menuCanas();
                    break;
                }
                case 4 ->
                {
                    jugador.mostrarEstadisticas();
                    break;
                }
                case 5 ->
                {
                    guardar(jugador, save);
                }
            }
        }
        while(opcionMenu != 5);
    }
    
    /* Cargar Datos Jugador */
    private static Jugador cargar(Jugador jugador, File save)
    {
        try
        {
            /* Verifico si Existe el Archivo */
            if(save.exists())
            {
                System.out.println("Cargando Variables");
                FileInputStream fis = new FileInputStream(save);
                ObjectInputStream lector;
                while(fis.available() > 0)
                {
                    lector = new ObjectInputStream(fis);
                    Jugador datos = (Jugador) lector.readObject();
                    return datos;
                }
            }
            else
            {
                System.out.println("El Archivo no Existe");
                FileOutputStream fos = new FileOutputStream(save);
                ObjectOutputStream escritor = new ObjectOutputStream(fos);
                escritor.writeObject(jugador);
                fos.close();
                escritor.close();
                return new Jugador();
            }
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.println("Error al Cargar Variables: " + e);
        }
        return null;
    }
    
    /* Guardar Datos Jugador */
    private static void guardar(Jugador jugador, File save)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(save);
            ObjectOutputStream escritor = new ObjectOutputStream(fos);
            escritor.writeObject(jugador);
            fos.close();
            escritor.close();
            System.out.println("Datos Guardados");
        }
        catch(IOException e)
        {
            System.out.println("Error al Guardar");
        }
    }
}
