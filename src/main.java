import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;



public class main {

    public static void main(String[] args) throws IOException {

        String ort="test.txt";

        Wort test1=new Wort("bailar","tanzen",'v');
        Wort test2=new Wort("comer","essen",'v');
        Wort test3=new Wort("escribir","schreiben",'v');
        ArrayList<Wort> liste=new ArrayList<Wort>();
        liste.add(test1);
        liste.add(test2);
        liste.add(test3);

String text="";
        for (Wort a:
             liste) {
            System.out.println(a.toString());
            text+=a.toString();
        }

SpeichernUndLadenTXT.speichern(text,ort,true);


    }
}
