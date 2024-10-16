public class UsaRuta {
    public static void main(String[] args) {
        // Proves per a constructor i getters
        System.out.println("Proves per a constructors:");

        Ruta r1 = new Ruta(5);
        Ruta r2 = new Ruta(5);

        if (r1.getNumUbicacions() == 0 && r2.getNumUbicacions() == 0) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }

        // Proves del mètode afegirUbicacio
        System.out.println("Prova afegirUbicacio:");
        Ubicacio u1 = new Ubicacio(41.3879, 2.16992); // Barcelona
        Ubicacio u2 = new Ubicacio(48.8566, 2.3522); // París
        Ubicacio u3 = new Ubicacio(40.7128, -74.0060); // Nova York
        Ubicacio u4 = new Ubicacio(34.0522, -118.2437); // Los Angeles
        Ubicacio u5 = new Ubicacio(37.7749, -122.4194); // San Francisco

        r1.afegirUbicacio(u1);
        r1.afegirUbicacio(u2);
        r1.afegirUbicacio(u3);
        r1.afegirUbicacio(u4);
        r1.afegirUbicacio(u5);

        r2.afegirUbicacio(u1);
        r2.afegirUbicacio(u2);
        r2.afegirUbicacio(u3);
        r2.afegirUbicacio(u4);
        r2.afegirUbicacio(u5);

        if (r1.getNumUbicacions() == 5 && r2.getNumUbicacions() == 5) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }

        // Proves del mètode setAcabaEnOrigen
        System.out.println("Prova setAcabaEnOrigen:");
        r1.setAcabaEnOrigen(true);
        r1.setAcabaEnOrigen(false);
        r2.setAcabaEnOrigen(true);

        if (!r1.getAcabaEnOrigen() && r2.getAcabaEnOrigen()) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");

        }

        // Proves del mètode calcularDistanciaRuta
        System.out.println("Prova calcularDistanciaRuta:");
        System.out.println(r1.calcularDistanciaRuta());
        System.out.println(r2.calcularDistanciaRuta());

        // Prove del mètode toString
        System.out.println("Prova toString:");
        System.out.println(r1.toString());
        System.out.println(r2.toString());
        if (r1.toString().equals(
                "Ruta => Nombre de ubicacions: 5\n\tUbicacio posicio 0: Ubicacio [latitud=41.3879, longitud=2.16992]\n\tUbicacio posicio 1: Ubicacio [latitud=48.8566, longitud=2.3522]\n\tUbicacio posicio 2: Ubicacio [latitud=40.7128, longitud=-74.006]\n\tUbicacio posicio 3: Ubicacio [latitud=34.0522, longitud=-118.2437]\n\tUbicacio posicio 4: Ubicacio [latitud=37.7749, longitud=-122.4194]")
                && r2.toString().equals(
                        "Ruta => Nombre de ubicacions: 5\n\tLa ruta acaba en el origen:\n\tUbicacio posicio 0: Ubicacio [latitud=41.3879, longitud=2.16992]\n\tUbicacio posicio 1: Ubicacio [latitud=48.8566, longitud=2.3522]\n\tUbicacio posicio 2: Ubicacio [latitud=40.7128, longitud=-74.006]\n\tUbicacio posicio 3: Ubicacio [latitud=34.0522, longitud=-118.2437]\n\tUbicacio posicio 4: Ubicacio [latitud=37.7749, longitud=-122.4194]")) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");

        }

        // Proves del mètode ubicacioMesAlNord
        System.out.println("Prova ubicacioMesAlNord:");
        System.out.println(r1.ubicacioMesAlNord());
        System.out.println(r2.ubicacioMesAlNord());

        if (r1.ubicacioMesAlNord().equals(u2) && r2.ubicacioMesAlNord().equals(u2)) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");

        }
    }
}
