/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author Sirch
 */
public class Gerechten {
    
    private int gerechtNummer;
    private String naam;
    private double prijs;

public Gerechten(int gerechtnummer, String naam){
    this.gerechtNummer = gerechtNummer;
    this.naam = naam;
}

    public Gerechten(int gerechtNummerDb, String naamDb, String prijsDb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


public int getgerechtnummer(){
    return gerechtNummer;
}

public void setgerechtNummer(int gerechtNummer){
    this.gerechtNummer = gerechtNummer;
}

public String getnaam()
    {
        return naam;
    }

    public void setnaam(String naam)
    {
        this.naam = naam;
    }

public double getprijs()
    {
        return prijs;
    }
    
    public void setprijs(double prijs)
    {
        this.prijs = prijs;
    }


}
