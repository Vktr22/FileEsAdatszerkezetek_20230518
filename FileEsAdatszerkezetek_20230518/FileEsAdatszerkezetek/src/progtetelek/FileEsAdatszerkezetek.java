package progtetelek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

public class FileEsAdatszerkezetek {

    private List<String> sorok;
    private Fuvar[] fuvarok;
    
    public static void main(String[] args) throws IOException, ParseException {
        new FileEsAdatszerkezetek().feladatok();
    }

    public FileEsAdatszerkezetek() throws IOException {
        sorok = Files.readAllLines(Path.of("fuvar.csv"));
        assert !sorok.isEmpty() : "üres a file!";
        
        /* a fájl 1 soros fejléce miatt -1 a mérete: */
        fuvarok = new Fuvar[sorok.size()-1];
        /* a fájl 1 soros fejléce miatt 1-ről indul: */
        for (int i = 1; i < sorok.size(); i++) {
            fuvarok[i-1] =  new Fuvar(sorok.get(i));
        }
        assert sorok.size()-1 == fuvarok.length : "nincs meg minden fuvar!";
        assert fuvarok[0] != null : "első fuvar hibás";
        assert fuvarok[fuvarok.length-1] != null : "utolsó fuvar hibás";
    }
    
    public void feladatok() throws IOException /*, ParseException */ {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();
        feladat8();
    }

    private void feladat1() throws IOException {
        System.out.println("1. feladat: sorok száma");
        System.out.printf("a fájlnak fejléccel %d sora van\n", sorok.size());
    }

    private void feladat2() /* throws ParseException */ {
        System.out.println("2. feladat: az első fuvar adatai");
        /* PROBLÉMA és HASZNÁLAT: */
        //a sor majd a fájlból kap értéket
        String sor = "5240;2016-12-15 23:45:00;900;2,5;10,75;2,45;bankkártya";
        Fuvar f1 = new Fuvar(sor);
        System.out.println(f1);
    }

    private void feladat3() {
        System.out.println("3. feladat: egy véletlenszerű fuvar adatai");
        int sorszam = (int)(Math.random() * sorok.size());
        sorszam = sorszam == 0 ? ++sorszam : sorszam;
        Fuvar fuvar = new Fuvar(sorok.get(sorszam));
        System.out.printf("A(z) %d. fuvar állapota:\n", sorszam);
        System.out.println(fuvar);
    }

    private void feladat4() {
        System.out.println("4. feladat: milyen dátumú a legnagyobb a távolságú fuvar");
        //progtétel: maxKiválasztás
        //adatszerkezet: fuvarok tárolására alkalmas tömb, kstr inicializálja
        
        /* a tényleges feladat: a progtétel implementálása: */
        //a tétel:
        int index = 0;
        for (int i = 1; i < fuvarok.length; i++) {
            if(fuvarok[i].getTavolsag() > fuvarok[index].getTavolsag()){
                index = i;
            }
        }
        //a válasz:
        System.out.println("távolság: " + fuvarok[index].getTavolsag());
        System.out.println("dátum: " + fuvarok[index].getIndulas());
    }

    private void feladat5() {
        System.out.println("5. feladat: borravalók átlaga");
        //progtétel: összegzés
        //adatszerkezet: fuvarok tárolására alkalmas tömb, kstr inicializálja
        
        /* a tényleges feladat: a progtétel implementálása: */
        //a tétel:
        double osszeg = 0;
        
        /* hagyományos for: */
//        for (int i = 0; i < fuvarok.length; i++) {
//            Fuvar fuvar = fuvarok[i];
//            osszeg += fuvar.getBorravalo();
//        }
        
        /* továbbfejlesztett foreach: */
        for (Fuvar fuvar : fuvarok) {
            osszeg += fuvar.getBorravalo();
        }
        
        //a válasz:
        /* sok tizedes: */
//        System.out.println(osszeg / fuvarok.length);
        /* tizedes pont helyett tizedes vessző: */
//        System.out.printf("%.2f\n", osszeg / fuvarok.length);

        System.out.printf(Locale.ENGLISH, "%.2f\n", osszeg / fuvarok.length);
    }

    private void feladat6() {
        System.out.println("6. feladat: minden fizetés bankkártyás");
        //progtétel: eldöntés
        //adatszerkezet: fuvarok tárolására alkalmas tömb, kstr inicializálja
        
        //a tétel:
        int i = 0, N = fuvarok.length;
        while(i < N && fuvarok[i].getFizetesModja().equals("bankkártya")){
            i++;
        }
        
        //a válasz:
        System.out.println(i >= N ? "igen" : "nem");
    }
        
    private void feladat7() {
        System.out.println("7. feladat: minden készpénzes fizetésnél 0 a borravaló");
        int i = 0, N = fuvarok.length;
        while(i < N && kpNullaBorravaloval(fuvarok[i])){
            i++;
        }

        System.out.println(i >= N ? "igen" : "nem");
    }

    private boolean kpNullaBorravaloval(Fuvar fuvar) {
        boolean kp = fuvar.getFizetesModja().equals("készpénz");
        boolean borravaloNulla = fuvar.getBorravalo() == 0;
        return kp && borravaloNulla;
    }

    private void feladat8() {
        System.out.println("8. feladat: problémás kérdések");
        System.out.println("készpénzes fuvarok listája, konzolon és fájlban?");
        System.out.println("milyen fizetési módok vannak rögzítve?");
        System.out.println("melyik fizetési módból mennyit volt?");
    }
}
