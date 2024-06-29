package model;


import java.util.ArrayList;

public class Ligne {
    private int id;
    private String numero;
    private int nombreKilometres;
    private double tarif;
    private ArrayList<Arret> arrets= new ArrayList<>();
    private Station stationDepart;
    private Station stationArriver;

    public Ligne() {}

    public Ligne(int id, String numero, int nombreKilometres, double tarif, Station stationDepart, Station stationArriver) {
        this.id = id;
        this.numero = numero;
        this.nombreKilometres = nombreKilometres;
        this.tarif = tarif;
        this.stationDepart = stationDepart;
        this.stationArriver = stationArriver;
    }

    @Override
    public String toString() {
        return "Ligne{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", nombreKilometres=" + nombreKilometres +
                ", tarif=" + tarif +
                ", arrets=" + arrets +
                ", stationDepart=" + stationDepart +
                ", stationArriver=" + stationArriver +
                '}';
    }

    public Ligne(int id, String numero, int nombreKilometres, double tarif) {
        this.id = id;
        this.numero = numero;
        this.nombreKilometres = nombreKilometres;
        this.tarif = tarif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNombreKilometres() {
        return nombreKilometres;
    }

    public void setNombreKilometres(int nombreKilometres) {
        this.nombreKilometres = nombreKilometres;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public String getNom() {
        return numero; // Assuming 'numero' is used as the name
    }

    public ArrayList<Arret> getArrets() {
        return arrets;
    }

    public void setArrets(Arret arrets) {
        this.arrets.add(arrets);
    }

    public Station getStationArriver() {
        return stationArriver;
    }

    public void setStationArriver(Station stationArriver) {
        this.stationArriver = stationArriver;
    }

    public Station getStationDepart() {
        return stationDepart;
    }

    public void setStationDepart(Station stationDepart) {
        this.stationDepart = stationDepart;
    }
}