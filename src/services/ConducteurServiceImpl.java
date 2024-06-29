package services;

import model.Conducteur;
import model.Ligne;

import java.util.ArrayList;
import java.util.List;

public class ConducteurServiceImpl{
    public List<Conducteur> conducteurs = new ArrayList<>();

    public ConducteurServiceImpl() {
    }


    public void addConducteur(Conducteur conducteur) {
        conducteurs.add(conducteur);
    }


    public List<Conducteur> listConducteurs() {
        return conducteurs;
    }
    public Conducteur getConducteur(int conducteurId) {
        for (Conducteur lign : conducteurs) {
            if (lign.getId() == conducteurId) {
                return lign;
            }
        }
        return null;
    }
}
