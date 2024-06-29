package services;

import model.Arret;

import java.util.ArrayList;
import java.util.List;

public class ArretServiceImpl {


    public List<Arret> arrets = new ArrayList<>();

    public void addArret(Arret ligne) {
        arrets.add(ligne);
    }


    public List<Arret> getArretsDisponibles() {
        return arrets;
    }

    public Arret getArret(int ligneId) {
        for (Arret lign : arrets) {
            if (lign.getId() == ligneId) {
                return lign;

            }
        }
        return null;
    }
}
