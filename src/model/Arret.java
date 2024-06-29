package model;

import java.util.Objects;

public class Arret {
    private int id;
    private String numero;
    private String nom;

    public Arret() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arret arret = (Arret) o;
        return id == arret.id && Objects.equals(numero, arret.numero) && Objects.equals(nom, arret.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, nom);
    }

    @Override
    public String toString() {
        return "Arret{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }

    public Arret(int id, String numero, String nom) {
        this.id = id;
        this.numero = numero;
        this.nom = nom;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
