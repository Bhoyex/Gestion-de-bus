package model;

public class Bus {
    private int id;
    private String immatriculation;
    private TypeBus type;
    private int kilometrage;
    private int nombreDePlaces;
    private boolean enService;

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", immatriculation='" + immatriculation + '\'' +
                ", type='" + type + '\'' +
                ", kilometrage=" + kilometrage +
                ", nombreDePlaces=" + nombreDePlaces +
                ", enService=" + enService +
                '}';
    }

    public Bus() {}

    public Bus(int id, String immatriculation, TypeBus type, int kilometrage, int nombreDePlaces, boolean enService) {
        this.id = id;
        this.immatriculation = immatriculation;
        this.type = type;
        this.kilometrage = kilometrage;
        this.nombreDePlaces = nombreDePlaces;

        this.enService = enService;
    }

    public Bus(String immatriculation, String marque, int prix, int nombrePlaces, Object ligne, boolean enService) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public TypeBus getType() {
        return type;
    }

    public void setType(TypeBus type) {
        this.type = type;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getNombreDePlaces() {
        return nombreDePlaces;
    }

    public void setNombreDePlaces(int nombreDePlaces) {
        this.nombreDePlaces = nombreDePlaces;
    }

    public boolean isEnService() {
        return enService;
    }

    public void setEnService(boolean enService) {
        this.enService = enService;
    }
}
