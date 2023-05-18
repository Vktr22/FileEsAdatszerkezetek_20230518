package progtetelek;

import java.text.NumberFormat;
import java.text.ParseException;

public class Fuvar {
    private int id;
    private String indulas;
    private int idotartam;
    private double tavolsag;
    private double viteldij;
    private double borravalo;
    private String fizetesModja;

    /* fájl 1 sora:
    5240;2016-12-15 23:45:00;900;2,5;10,75;2,45;bankkártya
    */
    public Fuvar(String sor) /* throws ParseException */ {
        /* cseréljük: , --> . */
        sor = sor.replace(',', '.');
        
        /* gyári parszolás */
//        NumberFormat nf = NumberFormat.getInstance();
//        Number num = nf.parse("2,5");
//        double d = num.doubleValue();
        
        String[] s = sor.split(";");
        
        
        this.id = Integer.parseInt(s[0]);
        this.indulas = s[1];
        this.idotartam = Integer.parseInt(s[2]);
        
        this.tavolsag = Double.parseDouble(s[3]);
        /* gyári parszolás használata: */
//        num = nf.parse(s[3]);
//        this.tavolsag = num.doubleValue();
        
        this.viteldij = Double.parseDouble(s[4]);
//        num = nf.parse(s[4]);
//        this.viteldij = num.doubleValue();
        
        this.borravalo = Double.parseDouble(s[5]);
//        num = nf.parse(s[5]);
//        this.borravalo = num.doubleValue();
        
        this.fizetesModja = s[6];
    }
    
    public Fuvar(int id, String indulas, int idotartam, double tavolsag, double viteldij, double borravalo, String fizetesModja) {
        this.id = id;
        this.indulas = indulas;
        this.idotartam = idotartam;
        this.tavolsag = tavolsag;
        this.viteldij = viteldij;
        this.borravalo = borravalo;
        this.fizetesModja = fizetesModja;
    }

    public int getId() {
        return id;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getIdotartam() {
        return idotartam;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getViteldij() {
        return viteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetesModja() {
        return fizetesModja;
    }

    @Override
    public String toString() {
        return "Fuvar{" + "id=" + id + ", indulas=" + indulas + ", idotartam=" + idotartam + ", tavolsag=" + tavolsag + ", viteldij=" + viteldij + ", borravalo=" + borravalo + ", fizetesModja=" + fizetesModja + '}';
    }
}
