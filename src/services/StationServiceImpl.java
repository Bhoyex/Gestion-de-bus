package services;

import model.Ligne;
import model.Station;

import java.util.ArrayList;
import java.util.List;

public class StationServiceImpl {
    public StationServiceImpl() {
    }

    public List<Station> stations = new ArrayList<>();

    public void addStation(Station ligne) {
        stations.add(ligne);
    }


    public List<Station> getStationsDisponibles() {
        // Logique pour obtenir les lignes disponibles à une date donnée
        return stations;
    }
    public Station getStation(int ligneId) {
        for (Station lign : stations) {
            if (lign.getId() == ligneId) {
                return lign;
            }
        }
        return null;
    }
}
