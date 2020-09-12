import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Daten {


    Daten()  {
        File daten=new File("daten.txt");
        try {
            if (daten.exists()) {
                FileInputStream file = new FileInputStream(daten);
            } else {
                daten.createNewFile();
            }
        }catch (Exception e){
            System.out.println("Fehler beim laden der datei");
        }

    }






}
