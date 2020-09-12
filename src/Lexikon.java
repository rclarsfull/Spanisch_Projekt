import java.util.ArrayList;

public class Lexikon {
    int groesse=0;
    ArrayList<Wort> lexikon=new ArrayList<Wort>();

    Lexikon(){}

    public ArrayList<Wort> getLexikon() {
        return lexikon;
    }

    public void addWort(Wort a){
        lexikon.add(a);
        sortAlfabetic();
    }

    public void sortAlfabetic(){
        int counter=lexikon.size();
        Wort ablage;
        for (int i = 0; i <counter ; i++) {
            counter--;
            for (int j = 0; j <lexikon.size()-1 ; j++) {
                char[] temp1=lexikon.get(j).getInvinitivSpan().toCharArray();
                char[] temp2=lexikon.get(j+1).getInvinitivSpan().toCharArray();
                int pos=0;
                while ((temp1[pos]==temp2[pos])&&((pos<temp1.length)&&(pos<temp2.length))) {
                    pos++;
                }
                if (((int)temp1[pos])>((int)temp2[pos])){
                    ablage=lexikon.get(j);
                    lexikon.set(j,lexikon.get(j+1));
                    lexikon.set(j+1,ablage);
                }

            }
        }
    }

    public void saveToTXT(String location, boolean notOverwrite){
        String daten="";
        for (Wort a:
             lexikon) {
            daten+=a.toString();
        }
        SpeichernUndLadenTXT.speichern(daten,location,notOverwrite);
    }

    public void loadeDictonary(String location){
        String[] temp=SpeichernUndLadenTXT.read(location);
        for (int i = 0; i < SpeichernUndLadenTXT.getEinheiten(location,"\n"); i+=13) {
            lexikon.add(SpeichernUndLadenTXT.read(location));
        }

    }
}
