package Codigo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Binarios
{
    public void escribir()
    {
        try
        {
            File archivo = new File("C:\\Users\\%username%\\AppData\\Roaming\\wallet.bin");
            FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream escribir = new ObjectOutputStream(fos);
        }
        catch(Exception e) {}
    }
}
