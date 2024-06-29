package services;

import model.Bus;
import model.Conducteur;
import model.Ligne;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BusServiceImpl {


    public BusServiceImpl() {
    }

    public List<Bus> buses = new ArrayList<>();

    public void addBus(Bus bus) {
        buses.add(bus);
    }


    public List<Bus> listBuses() {
        return buses;
    }


    public void decommissionBus(int busId) {
        for (Bus bus : buses) {
            if (bus.getId() == busId) {
                bus.setEnService(false);
                break;
            }
        }
    }
    public Bus getBus(int busId) {
        for (Bus lign : buses) {
            if (lign.getId() == busId) {
                return lign;
            }
        }
        return null;
    }
    public List<Bus> getBusesOutOfService() {
        return buses.stream()
                    .filter(bus -> !bus.isEnService())
                    .collect(Collectors.toList());
    }
}
