import model.Arret;
import model.Bus;
import model.Conducteur;
import model.Ligne;
import model.Station;
import model.Trajet;
import model.TypeBus;
import model.TypePermis;
import model.TypeTrajet;
import services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix ;
        System.out.println("\nMenu Ajout:");
        LigneServiceImpl ligneService = new LigneServiceImpl();
        BusServiceImpl busService = new BusServiceImpl();
        StationServiceImpl stationService= new StationServiceImpl();
        ArretServiceImpl arretService= new ArretServiceImpl();
        ConducteurServiceImpl conducteurService=new ConducteurServiceImpl();
        TrajetServiceImpl trajetService=new TrajetServiceImpl();
        TrajetServiceImpl TrajetService=new TrajetServiceImpl();
            do {
                System.out.println("\nMenu Ajout:");
                System.out.println("1. Ajouter un bus");
                System.out.println("2. Ajouter un arrêt");
                System.out.println("3. Ajouter une trajet");
                System.out.println("4. Ajouter une ligne");
                System.out.println("5. Ajouter un conducteur");
                System.out.println("6. Affecter des arrêts à une ligne");
                System.out.println("7.  Les lignes disponibles à une date ");
                System.out.println("8. Les bus disponibles par ligne");
                System.out.println("9.  Les bus en panne");
                 System.out.println("10. Valider  trajet");
                System.out.println("11. Le  nombre ticket vendu par trajet");
                System.out.println("12.   Le Montant total des tickets vendus par bus et par ligne");
                System.out.println("13. Ajouter un Station");
                System.out.println("14. Quitter");
                System.out.println("Faites un choix");
                choix = scanner.nextInt();
                // Saisir les détails du bus
                switch (choix) {
                    case 1:
                        scanner.nextLine();
                        Bus bus = new Bus();
                        int choixType;
                        System.out.println("Saisir les détails du bus:");
                         System.out.println("Id:");
                        bus.setId(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Immatriculation:");
                        bus.setImmatriculation(scanner.nextLine());
                        do {
                             System.out.println("1 TATA, 2 CAR_RAPIDE,3 DDK");
                            choixType= scanner.nextInt();
                        } while (choixType<1 || choixType>3);
                       
                        if (choixType == 1) {
                            bus.setType(TypeBus.TATA);
                        }
                        if (choixType == 2) {
                            bus.setType(TypeBus.CAR_RAPIDE);
                        }
                        if (choixType==3) {
                            bus.setType(TypeBus.DDK);
                        }
                     
                        System.out.println("Kilometrage:");
                        bus.setKilometrage(scanner.nextInt());
                        System.out.println("Nombre de places:");
                        bus.setNombreDePlaces(scanner.nextInt());
                        bus.setEnService(true);
                      
                        busService.addBus(bus);
                        List<Bus> buses = busService.listBuses();
                        buses.forEach(System.out::println);
                        break;
                    case 2:
                        scanner.nextLine();
                        Arret arret = new Arret();
                        System.out.println("Saisir les détails de l'arret:");
                         System.out.println("Id: ");
                        arret.setId(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Numero: ");
                        arret.setNumero(scanner.nextLine());
                     
                        System.out.println("Nom: ");
                        arret.setNom(scanner.nextLine());
                      
                        arretService.addArret(arret);
                        List<Arret> arrets = arretService.getArretsDisponibles();
                        arrets.forEach(System.out::println);
                        break;
                    case 3:
                        scanner.nextLine();
                        Trajet trajet = new Trajet();
                        System.out.println("Saisir les details de la trajet: ");
                        System.out.println("Id:");
                        trajet.setId(scanner.nextInt());
                          do {
                             System.out.println("1 ALLER, 2 RETOUR");
                            choixType= scanner.nextInt();
                        } while (choixType < 1 || choixType > 2);
                        if (choixType == 1) {
                            trajet.setType(TypeTrajet.ALLER);
                        }
                        if (choixType == 2) {
                            trajet.setType(TypeTrajet.RETOUR);
                        }
                        scanner.nextLine();
                        System.out.println("Date (j/m/a):");
                        trajet.setDate(scanner.nextLine());
                        System.out.println("Nombre de tickets: ");
                        trajet.setNombreDeTickets(scanner.nextInt());
                        System.out.println("Bus: Saisir id d'un bus");
                        int busId = scanner.nextInt();
                        trajet.setBus(busService.getBus(busId));
                        System.out.println("Ligne (Saisir id d'une ligne):");
                        int ligneId = scanner.nextInt();
                        trajet.setLigne(ligneService.getLigne(ligneId));
                        System.out.println("Ligne: Saisir id d'un conducteur");
                        int conducteurId = scanner.nextInt();
                        trajet.setConducteur(conducteurService.getConducteur(conducteurId));
                        trajet.setValider(false);
                        trajet.setTicketsVendus(0);
                        System.out.println(trajet);
                        trajetService.planifierTrajet(trajet);
                        List<Trajet> trajets = TrajetService.listTrajets();
                        trajets.forEach(System.out::println);
                        break;
                    case 4:
                        scanner.nextLine();
                        int choixMen;
                        Ligne ligne = new Ligne();
                        System.out.println("Details de la ligne: ");
                        System.out.println("Id:");
                        ligne.setId(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Numero");
                        ligne.setNumero(scanner.nextLine());
                        System.out.println("Kilometre");
                        ligne.setNombreKilometres(scanner.nextInt());
                        System.out.println("Tarif");
                        ligne.setTarif(scanner.nextDouble());
                        scanner.nextLine();
                        System.out.println("Id Station Depart");
                        ligne.setStationDepart(stationService.getStation(scanner.nextInt()));
                        System.out.println("Id Station Arriver");
                        ligne.setStationArriver(stationService.getStation(scanner.nextInt()) );
                        
                        do {
                            arrets = arretService.getArretsDisponibles();
                            arrets.forEach(System.out::println);
                            System.out.println("Id arret a ajouter");
                             ligne.setArrets(arretService.getArret(scanner.nextInt()));
                            System.out.println("Voulez vous ajouter un arret 1-oui 2-non");
                            choixMen = scanner.nextInt();
                        } while (choixMen==1);
                        
                        ligneService.addLigne(ligne);
                        ligneService.getLignesDisponibles().forEach(System.out::println);
                        break;
                    case 5:
                        scanner.nextLine();
                        Conducteur conducteur = new Conducteur();
                        System.out.println("Saisir les détails de l'arret:");
                         System.out.println("Id: ");
                        conducteur.setId(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Nom: ");
                        conducteur.setNom(scanner.nextLine());
                     
                        System.out.println("PreNom: ");
                        conducteur.setPrenom(scanner.nextLine());
                         System.out.println("Tel: ");
                         conducteur.setTelephone(scanner.nextLine());
                         do {
                             System.out.println("1 LOURD, 2 LEGER");
                            choixType= scanner.nextInt();
                        } while (choixType < 1 || choixType > 2);
                        if (choixType == 1) {
                            conducteur.setTypePermis(TypePermis.LOURD);
                        }
                        if (choixType == 2) {
                           conducteur.setTypePermis(TypePermis.LEGER);
                        }
                        conducteurService.addConducteur(conducteur);
                       
                        conducteurService.listConducteurs().forEach(System.out::println);
                        break;
                    case 6:
                        scanner.nextLine();
                      
                        System.out.println("Saisir les détails :");
                        ligneService.getLignesDisponibles().forEach(System.out::println);
                        System.out.println("Id: ");
                        ligne= ligneService.getLigne(scanner.nextInt());
                        scanner.nextLine();
                        do {
                            arrets = arretService.getArretsDisponibles();
                            arrets.forEach(System.out::println);
                            System.out.println("Id arret a ajouter");
                             ligne.setArrets(arretService.getArret(scanner.nextInt()));
                            System.out.println("Voulez vous ajouter un arret 1-oui 2-non");
                            choixMen = scanner.nextInt();
                        } while (choix==1);
                       
                        break;
                     case 7:
                        scanner.nextLine();
                      
                        System.out.println("Saisir les détails :");
                        System.out.println("Date: ");
                        trajetService.getLigneDate(scanner.nextLine()).forEach(System.out::println);
                       
                        break;
                    case 8:
                        scanner.nextLine();
                         ligneService.getLignesDisponibles().forEach(System.out::println);
                        System.out.println("Id ligne");
                        trajetService.getBusByLigne(ligneService.getLigne(scanner.nextInt())).forEach(System.out::println);
                        break;
                     case 9:
                        scanner.nextLine();
                         busService.getBusesOutOfService().forEach(System.out::println);
                       
                         break;
                    case 10:
                        scanner.nextLine();

                        trajetService.listTrajets().forEach(System.out::println);
                        System.out.println("Id ligne");
                        trajet = trajetService.getTrajet(scanner.nextInt());
                        trajet.setValider(true);
                        System.out.println("Ticket vendu");
                        trajet.setTicketsVendus(scanner.nextInt());
                       
                        break;
                    case 11:
                        scanner.nextLine();
                        trajetService.listTrajets().forEach(System.out::println);
                        System.out.println("Id ligne");
                        trajet = trajetService.getTrajet(scanner.nextInt());
                       System.out.println(trajet.getNombreDeTickets());
                       
                       break;
                    case 12:
                        scanner.nextLine();
                        busService.listBuses().forEach(System.out::println);
                        System.out.println("Id Bus");
                        bus = busService.getBus(scanner.nextInt());
                          ligneService.getLignesDisponibles().forEach(System.out::println);
                        System.out.println("Id Ligne");
                        ligne = ligneService.getLigne(scanner.nextInt());     
                       System.out.println(trajetService.getTrajetByBus(bus, ligne));       
                       break;
                    case 13:
                        scanner.nextLine();
                        Station station = new Station();
                        System.out.println("Saisir les détails de Stztion:");
                         System.out.println("Id: ");
                        station.setId(scanner.nextInt());
                        scanner.nextLine();
                        System.out.println("Numero: ");
                        station.setNumero(scanner.nextLine());
                     
                        System.out.println("Nom: ");
                        station.setNom(scanner.nextLine());
                         System.out.println("Adresse: ");
                        station.setAdresse(scanner.nextLine());
                      
                        stationService.addStation(station);
                        stationService.getStationsDisponibles().forEach(System.out::println);
                        break;
                    default:

                        break;
                }

            }while (choix!=14);
            scanner.close();

        }


}