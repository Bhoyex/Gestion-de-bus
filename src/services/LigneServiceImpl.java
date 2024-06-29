package services;

import model.Bus;
import model.Ligne;

import java.util.ArrayList;
import java.util.List;

public class LigneServiceImpl {
    public LigneServiceImpl() {
    }

    public List<Ligne> lignes = new ArrayList<>();

    public void addLigne(Ligne ligne) {
        lignes.add(ligne);
    }


    public List<Ligne> getLignesDisponibles() {
        // Logique pour obtenir les lignes disponibles à une date donnée
        return lignes;
    }

    public Ligne getLigne(int ligneId) {
        for (Ligne lign : lignes) {
            if (lign.getId() == ligneId) {
                return lign;

            }
        }
        return null;
    }
    
}
