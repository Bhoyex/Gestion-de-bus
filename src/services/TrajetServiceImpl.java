package services;

import model.Bus;
import model.Ligne;
import model.Trajet;

import java.util.ArrayList;
import java.util.List;

public class TrajetServiceImpl {
    public TrajetServiceImpl() {
    }

    public List<Trajet> trajets = new ArrayList<>();


    public void planifierTrajet(Trajet trajet) {
        trajets.add(trajet);
    }

    public Trajet getTrajet(int TrajetId) {
        for (Trajet trajet : trajets) {
            if (trajet.getId() == TrajetId) {
                return trajet;

            }
        }
        return null;
    }

    public List<Trajet> listTrajets() {
        return trajets;
    }

    public List<Ligne> getLigneDate(String date) {
        List<Trajet> tra = new ArrayList<>();
        List<Ligne> lig = new ArrayList<>();
        for (Trajet lign : trajets) {
            if (lign.getDate() == date) {
                lig.add(lign.getLigne());

            }
        }
        return lig;
    }

    public List<Bus> getBusByLigne(Ligne ligne) {
        List<Bus> buList = new ArrayList<>();
        for (Trajet lign : trajets) {
            if (lign.getLigne().getId() == ligne.getId()) {
                buList.add(lign.getBus());

            }
        }
        return buList;
    }

    public double getTrajetByBus(Bus bus, Ligne ligne) {
       
        for (Trajet lign : trajets) {
            if (lign.getLigne().getId() == ligne.getId() && lign.getBus().getId() == bus.getId()) {
                return ligne.getTarif() * lign.getTicketsVendus();

            }
        }
        return 0;
    }
}
