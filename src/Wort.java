import java.util.ArrayList;

public class Wort {

    private String invinitivSpan;
    private String invinitivDeutsch;
    private String [] unregelmaesigeKonjuktion;
    private String wortstamm="";
    private String konjukionsTyp;
    private boolean debugggModer=false;

    private boolean verbF;
    private boolean nomenF;
    private boolean adjektivF;

    private boolean unregelmaessig;

    public static int insgesamtWoerter = 0;


    Wort(String spanisch, String deutsch, char art) {
        invinitivSpan = spanisch;
        invinitivDeutsch = deutsch;
        if ((art == 'n') || (art == 'N')) {
            nomenF = true;
            verbF = false;
            adjektivF = false;
        } else if ((art == 'v') || (art == 'V')) {
            nomenF = false;
            verbF = true;
            adjektivF = false;
        } else if ((art == 'a') || (art == 'A')) {
            nomenF = false;
            verbF = false;
            adjektivF = true;
        } else {
            System.out.println("Fehler, du hast dem Wort keine gültige Wortart zugewiesen. ");
            nomenF = false;
            verbF = false;
            adjektivF = false;
        }  //Test Verb art

        if (verbF) {
            ArrayList<Character> worker = new ArrayList();
            char[] temp=invinitivSpan.toCharArray();

            for (char a:temp) {
              worker.add(a);
            }


            if ((worker.get(worker.size() - 2) == 'a') && (worker.get(worker.size() - 1) == 'r')) {  //ar- verben
                konjukionsTyp="ar";
                if (debugggModer)System.out.println("konjuktionsTyp: "+konjukionsTyp); //test

                worker.remove(worker.size() - 1);
                worker.remove(worker.size() - 1);
                //char[] temp=new char[worker.size()];
                for (int i = 0; i <worker.size() ; i++) {
                   wortstamm+=temp[i]=worker.get(i);
                }
                if (debugggModer)System.out.println("Wortstamm: "+wortstamm); //test

            }

            if ((worker.get(worker.size() - 2) == 'e') && (worker.get(worker.size() - 1) == 'r')) {
                konjukionsTyp="er";
                if (debugggModer)System.out.println("konjuktionsTyp: "+konjukionsTyp); //test

                worker.remove(worker.size() - 1);
                worker.remove(worker.size() - 1);
                //char[] temp=new char[worker.size()];
                for (int i = 0; i <worker.size() ; i++) {
                    wortstamm+=temp[i]=worker.get(i);
                }

                if (debugggModer)System.out.println("Wortstamm: "+wortstamm); //test
            }

            if ((worker.get(worker.size() - 2) == 'i') && (worker.get(worker.size() - 1) == 'r')) {
                konjukionsTyp="ir";
                if (debugggModer)System.out.println("konjuktionsTyp: "+konjukionsTyp); //test

                worker.remove(worker.size() - 1);
                worker.remove(worker.size() - 1);
                //char[] temp=new char[worker.size()];
                for (int i = 0; i <worker.size() ; i++) {
                    wortstamm+=temp[i]=worker.get(i);
                }

                if (debugggModer)System.out.println("Wortstamm: "+wortstamm); //test
            }
        } //Wortstamm erzeugen

        insgesamtWoerter++;
    }
    Wort(String spanisch, String deutsch, char art,boolean unregelmaessig) {
        invinitivSpan = spanisch;
        invinitivDeutsch = deutsch;
        unregelmaesigeKonjuktion=new String[6];
        insgesamtWoerter++;
        wortstamm="Unregelaessig";
    }
    Wort(String spanisch, String deutsch, char art,boolean unregelmaessig,String fistSing,String secSing,String thirdSing,String firstPlu,String secPlu,String thirdPlu) {
        invinitivSpan = spanisch;
        invinitivDeutsch = deutsch;
        unregelmaesigeKonjuktion=new String[6];
        unregelmaesigeKonjuktion[0]=fistSing;
        unregelmaesigeKonjuktion[1]=secSing;
        unregelmaesigeKonjuktion[2]=thirdSing;
        unregelmaesigeKonjuktion[3]=firstPlu;
        unregelmaesigeKonjuktion[4]=secPlu;
        unregelmaesigeKonjuktion[5]=thirdPlu;
        insgesamtWoerter++;
        wortstamm="Unregelaessig";
    }

    public void setUnregelmaesigeKonjuktion(String s,int person, boolean plural){
        if (plural){
            unregelmaesigeKonjuktion[3+person]=s;
        }else{
            unregelmaesigeKonjuktion[person]=s;
        }
    }

    public static int getInsgesamtWoerter() {
        return insgesamtWoerter;
    }

    public String getkonjugirt(int person, boolean plural){
        if (verbF) {
            if (unregelmaessig != true) {
                if (verbF) {
                    if (plural) {
                        if (person == 1) {
                            if (konjukionsTyp == "ar") {
                                return wortstamm + "amos";
                            } else if (konjukionsTyp == "er") {
                                return wortstamm + "emos";
                            } else {
                                return wortstamm + "imos";
                            }
                        } else if (person == 2) {
                            if (konjukionsTyp == "ar") {
                                return wortstamm + "áis";
                            } else if (konjukionsTyp == "er") {
                                return wortstamm + "éis";
                            } else {
                                return wortstamm + "ís";
                            }
                        } else if (person == 3) {
                            if (konjukionsTyp == "ar") {
                                return wortstamm + "an";
                            } else {
                                return wortstamm + "en";
                            }
                        } else {
                            System.out.println("Fehler diese konjuktions form gbit es nicht (" + wortstamm + ")[" + person + "]");
                        }
                    } else {
                        if (person == 1) {
                            return wortstamm + "o";
                        } else if (person == 2) {
                            if (konjukionsTyp == "ar") {
                                return wortstamm + "as";
                            } else if (konjukionsTyp == "es") {
                                return wortstamm + "es";
                            } else {
                                return wortstamm + "es";
                            }
                        } else if (person == 3) {
                            if (konjukionsTyp == "ar") {
                                return wortstamm + "a";
                            } else if (konjukionsTyp == "er") {
                                return wortstamm + "e";
                            } else {
                                return wortstamm + "e";
                            }
                        } else {
                            System.out.println("Fehler diese konjuktions form gbit es nicht (" + wortstamm + ")[" + person + "]");
                        }
                    }
                    return "Fehler";
                } else if (nomenF) {
                    return invinitivSpan;
                } else if (adjektivF) {
                    return invinitivSpan;
                }
                return "Fehler (Kein wort typ)";
            } else {
                if (plural) {
                    return unregelmaesigeKonjuktion[2 + person];
                } else {
                    return unregelmaesigeKonjuktion[person - 1];
                }
            }
        }else if (nomenF){
            return invinitivSpan;
        }else{
            return  invinitivSpan;
        }

    } //konjugieren

    public String getInvinitivDeutsch() {
        return invinitivDeutsch;
    }

    public String getInvinitivSpan() {
        return invinitivSpan;
    }

    public String getKonjukionsTyp() {
        return konjukionsTyp;
    }

    public String getWortstamm() {
        return wortstamm;
    }

    public String toString(){
        String ausgabe="fehler";
        if (unregelmaessig){
            ausgabe=invinitivDeutsch+";"+invinitivSpan+";"+wortstamm+";"+unregelmaesigeKonjuktion[0]+";"+unregelmaesigeKonjuktion[1]+";"+unregelmaesigeKonjuktion[2]+";"+unregelmaesigeKonjuktion[3]+";"+unregelmaesigeKonjuktion[4]+";"+unregelmaesigeKonjuktion[5]+";"+nomenF+";"+verbF+";"+adjektivF+";\n";
        }else {
            ausgabe=invinitivDeutsch+";"+invinitivSpan+";"+wortstamm+";"+getkonjugirt(1,false)+";"+getkonjugirt(2,false)+";"+getkonjugirt(3,false)+";"+getkonjugirt(1,true)+";"+getkonjugirt(2,true)+";"+getkonjugirt(3,true)+";"+nomenF+";"+verbF+";"+adjektivF+";\n";
        }
        return ausgabe;
    }

}