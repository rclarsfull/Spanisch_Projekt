import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SpeichernUndLadenTXT {


    public static boolean speichern(String daten,String location,boolean notOverwrite) throws IOException {
       boolean ausgabe=true;
        try {
            FileWriter schreiber = new FileWriter(location, notOverwrite);
            schreiber.write(daten);
            schreiber.close();
        }catch (Exception e){
            System.out.println("fehler bei speichen");
            ausgabe=false;
        }
        return ausgabe;
    }

    public static String read(String location){
        String zeile,ausgabe="";
        try {
            FileReader leser=new FileReader(location);
            BufferedReader bufferedReader=new BufferedReader(leser);
            while ((zeile=bufferedReader.readLine())!= null){
                ausgabe+=zeile;
            }
        }catch(Exception e){
            int l=ausgabe.length();
            ausgabe="ERROR bei laenge: "+l;
        }
        return ausgabe;
    }

    public static int getEinheiten(String location,String trennzeichen){
        String tenp=read(location);
       return tenp.split(trennzeichen).length;

    }


}
