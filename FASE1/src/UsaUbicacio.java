public class UsaUbicacio {

    public static void main(String[] args) {
        // Proves per a constructor i getters
        Ubicacio u1 = new Ubicacio(41.3879, 2.16992); // Barcelona
        Ubicacio u2 = new Ubicacio(48.8566, 2.3522); // París
        Ubicacio u11 = new Ubicacio(); // Ubicació amb latitud i longitud 0

        // Test del constructor sense paràmetres
        System.out.println("Prova constructor sense paràmetres:");
        if (u11.getLatitud() != 0 || u11.getLongitud() != 0) {
            System.out.println("Incorrecte!\n");
        } else {
            System.out.println("Correcte!\n");
        }
        
        // Test dels getters
        System.out.println("Prova getters:");
        if (u1.getLatitud() != 41.3879 || u1.getLongitud() != 2.16992 || u2.getLatitud() != 48.8566 || u2.getLongitud() != 2.3522) {
            System.out.println("Incorrecte!\n");
        } else {
            System.out.println("Correcte!\n");
        }   

        // Proves dels setters
        System.out.println("Prova setters:");
        u1.setLatitud(40.4168);
        u1.setLongitud(-3.7038);

        if (u1.getLatitud() != 40.4168 || u1.getLongitud() != -3.7038) {
            System.out.println("Incorrecte!\n");
            
        } else {
            System.out.println("Correcte!\n");
        }
 
        // Prova del mètode toString
        System.out.println("Prova toString:");
        String expectedString = "Ubicacio [latitud=40.4168, longitud=-3.7038]"; // Variable de tipus String amb el resultat esperat
        if (u1.toString().equals(expectedString)) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }
        

        // Prova del mètode copiaUbicacio
        System.out.println("Prova copiaUbicacio:");
        Ubicacio copia = u1.copiaUbicacio();
        if (copia.getLatitud() != u1.getLatitud() || copia.getLongitud() != u1.getLongitud()) {
            System.out.println("Incorrecte!\n");
        } else {
            System.out.println("Correcte!\n");
        }
  
        

        // Prova del mètode equalsUbicacio (a través de distancia, ja que és privat)
        System.out.println("Prova equalsUbicacio a través de distancia:");
        Ubicacio u3 = new Ubicacio(45.323425, -4.2342446); // Ubicació amb 6 i 7 decimals
        Ubicacio u4 = new Ubicacio(45.323425323, -4.234244643); // Ubicació amb 9 i 9 decimals pero diferent respecte u3
        Ubicacio u5 = new Ubicacio(45.323425342, -4.234244635); // Ubicació amb 9 i 9 decimals pero diferent respecte u4
        Ubicacio u6 = new Ubicacio(45.1234, -4.1234); // Ubicació amb 4 i 4 decimals
        Ubicacio u7 = new Ubicacio(45.1234, -4.1234); // Ubicació amb 4 i 4 decimals igual que u7
        Ubicacio u8 = new Ubicacio(45.1, -4.1); // Ubicació amb 1 i 1 decimals
        Ubicacio u9 = new Ubicacio(45.1, -4.1); // Ubicació amb 1 i 1 decimals igual que u8

        if (u3.distancia(u4) == 0  && u4.distancia(u5) == 0 && u6.distancia(u7) == 0 && u8.distancia(u9) == 0) {
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }
        

        // Prova de la distància entre dues ubicacions diferents
        System.out.println("Prova distancia entre dues ubicacions diferents(París-Barcelona):");
        Ubicacio u10 = new Ubicacio(41.3879, 2.16992); // Barcelona
        double distanciaBCNParis = u2.distancia(u10); // Distància entre París i Barcelona
        System.out.printf("Distància entre París i Barcelona: %.2f km%n", distanciaBCNParis);
        if (Math.abs(distanciaBCNParis - 830.0) < 10) { // Aproximadament 830 km(830,61 km segons internet) amb un marge d'error de 10 km
            System.out.println("Correcte!\n");
        } else {
            System.out.println("Incorrecte!\n");
        }
    }
}
