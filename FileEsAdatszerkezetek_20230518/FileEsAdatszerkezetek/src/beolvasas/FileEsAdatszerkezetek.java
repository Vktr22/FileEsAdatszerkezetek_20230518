package beolvasas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileEsAdatszerkezetek {

    private List<String> sorok;
    
    public static void main(String[] args) throws IOException {
        new FileEsAdatszerkezetek().feladatok();
    }

    public FileEsAdatszerkezetek() throws IOException {
        sorok = Files.readAllLines(Path.of("fuvar.csv"));
        assert !sorok.isEmpty() : "üres a fájl!";
    }

    public void feladatok() throws IOException {
        feladat1();
        feladat2();
        feladat3();
    }

    private void feladat1() throws IOException {
        System.out.println("--- 1. feladat: sorok száma");
        System.out.printf("A fájlnak fejléccel %d sora van\n", sorok.size());
    }
    
    private void feladat2() {
        System.out.println("--- 2. feladat: az első fuvar adatai");
        /* PROBLÉMA és HASZNÁLAT: */
        //a sor majd a fájlból kap értéket
        String sor = "5240;2016-12-15 23:45:00;900;2,5;10,75;2,45;bankkártya";
        Fuvar fuvar = new Fuvar(sor);
        System.out.println(fuvar);
    }

    private void feladat3() {
        System.out.println("--- 3. feladat: egy véletlenszerű fuvar adatai");
        int sorszam = (int)(Math.random() * sorok.size());
        sorszam = sorszam == 0 ? ++sorszam : sorszam;
        String sor = sorok.get(sorszam);
        Fuvar fuvar = new Fuvar(sor);
        System.out.println(fuvar);
    }

    
    
}
