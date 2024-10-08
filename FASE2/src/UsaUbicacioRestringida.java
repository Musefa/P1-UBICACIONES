public class UsaUbicacioRestringida {

    public static void main(String[] args) {
        System.out.println(UbicacioRestringida.getLimitesRegion() + "\n");
        // Proves per a constructor i getters
        System.out.println("Proves per a constructors:");

        UbicacioRestringida u10 = new UbicacioRestringida(35.0, 65.0);
        UbicacioRestringida u11 = new UbicacioRestringida(-35.0, -65.0);
        UbicacioRestringida u12 = new UbicacioRestringida(); // Ubicació amb latitud i longitud 0

        if (u10.getLatitud() == 0.0 && u10.getLongitud() == 0.0 && u11.getLatitud() == 0.0
                && u11.getLongitud() == 0.0 && u12.getLatitud() == 0.0 && u12.getLongitud() == 0.0) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");

        }

        // Test del metode setLimitesRegion
        System.out.println("Prova setLimitesRegion:");
        System.out.println(UbicacioRestringida.getLimitesRegion());
        UbicacioRestringida.setLimitesRegion(-70.0, 70.0, -110.0, 110.0);
        System.out.println(UbicacioRestringida.getLimitesRegion());
        UbicacioRestringida.setLimitesRegion(-45.0, 45.0, -90.0, 90.0);
        System.out.println(UbicacioRestringida.getLimitesRegion());
        UbicacioRestringida.setLimitesRegion(-80.0, 80.0, -150.0, 150.0);
        System.out.println(UbicacioRestringida.getLimitesRegion());

        if (UbicacioRestringida.getLimitesRegion()
                .equals("Limites de la región: Latitud [-80.0, 80.0], Longitud [-150.0, 150.0]")) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");

        }

        // Test dels getters
        System.out.println("Prova getters:");
        UbicacioRestringida u1 = new UbicacioRestringida(41.3879, 2.16992); // Barcelona
        UbicacioRestringida u2 = new UbicacioRestringida(48.8566, 2.3522); // París
        if (u1.getLatitud() != 41.3879 || u1.getLongitud() != 2.16992 || u2.getLatitud() != 48.8566
                || u2.getLongitud() != 2.3522) {
            System.out.println("Incorrecte!\n");
        } else {
            System.out.println("Correcte!\n");
        }

        // Proves dels setters
        System.out.println("Prova setters:");
        System.out.println(UbicacioRestringida.getLimitesRegion());
        u1.setLatitud(-80.1); // Fora del límit inferior
        if (u1.getLatitud() == 41.3879) {
            System.out.println("Correcte!");
        } else {
            System.out.println("Incorrecte!");
        }

        u1.setLatitud(80.1); // Fora del límit superior
        if (u1.getLatitud() == 41.3879) {
            System.out.println("Correcte!");
        } else {
            System.out.println("Incorrecte!");
        }

        u1.setLatitud(41.3879); // Dins del límit
        if (u1.getLatitud() == 41.3879) {
            System.out.println("Correcte!");
        } else {
            System.out.println("Incorrecte!");
        }

        u1.setLongitud(-150.1); // Fora del límit inferior
        if (u1.getLongitud() == 2.16992) {
            System.out.println("Correcte!");
        } else {
            System.out.println("Incorrecte!");
        }

        u1.setLongitud(150.1); // Fora del límit superior
        if (u1.getLongitud() == 2.16992) {
            System.out.println("Correcte!");
        } else {
            System.out.println("Incorrecte!");
        }

        u1.setLongitud(2.16992); // Dins del límit
        if (u1.getLongitud() == 2.16992) {
            System.out.println("Correcte! \n");
        } else {
            System.out.println("Incorrecte! \n");
        }

        // Prova del mètode toString
        System.out.println("Prova toString:");
        String expectedString = "Ubicacio [Latitud = 41.3879, Longitud = 2.16992]"; // Variable de tipus String amb el
        // resultat esperat
        if (u1.toString().equals(expectedString)) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }

        // Prova del mètode copiaUbicacio
        System.out.println("Prova copiaUbicacio:");
        UbicacioRestringida copia = u1.copiaUbicacio();
        if (copia.getLatitud() != u1.getLatitud() || copia.getLongitud() != u1.getLongitud()) {
            System.out.println("Incorrecte!\n");
        } else {
            System.out.println("Correcte!\n");
        }

        // Prova del mètode equalsUbicacio (a través de distancia, ja que és privat)
        System.out.println("Prova equalsUbicacio a través de distancia:");
        UbicacioRestringida u3 = new UbicacioRestringida(45.323425, -4.2342446); // Ubicació amb 6 i 7 decimals
        UbicacioRestringida u4 = new UbicacioRestringida(45.323425323, -4.234244643); // Ubicació amb 9 i 9 decimals
                                                                                      // pero diferent respecte u3
        UbicacioRestringida u5 = new UbicacioRestringida(45.323425342, -4.234244635); // Ubicació amb 9 i 9 decimals
                                                                                      // pero diferent respecte u4
        UbicacioRestringida u6 = new UbicacioRestringida(45.1234, -4.1234); // Ubicació amb 4 i 4 decimals
        UbicacioRestringida u7 = new UbicacioRestringida(45.1234, -4.1234); // Ubicació amb 4 i 4 decimals igual que u7
        UbicacioRestringida u8 = new UbicacioRestringida(45.1, -4.1); // Ubicació amb 1 i 1 decimals
        UbicacioRestringida u9 = new UbicacioRestringida(45.1, -4.1); // Ubicació amb 1 i 1 decimals igual que u8

        if (u3.distancia(u4) == 0 && u4.distancia(u5) == 0 && u6.distancia(u7) == 0 && u8.distancia(u9) == 0) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }

        // Prova de la distància entre dues ubicacions diferents
        System.out.println("Prova distancia entre dues ubicacions diferents(París-Barcelona):");
        System.out.println("Barcelona: " + u1.toString() + ", París: " + u2.toString());
        double distanciaBCNParis = u1.distancia(u2); // Distància entre París i Barcelona
        System.out.printf("Distància entre París i Barcelona: %.2f km%n", distanciaBCNParis);
        if (Math.abs(distanciaBCNParis - 830.0) < 10) { // Aproximadament 830 km(830,61 km segons internet) amb un marge
                                                        // d'error de 10 km
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }
    }
}