public class Ruta {
    private Ubicacio[] ubicacions;
    private boolean acabaEnOrigen;
    private int numUbicacions;

    public Ruta(int mida) {
        if (mida > 0) {
            this.ubicacions = new Ubicacio[mida];
        } else {
            this.ubicacions = new Ubicacio[2];
        }
        this.numUbicacions = 0;
        this.acabaEnOrigen = false;
    }

    public Ruta(int mida, boolean acabaEnOrigen) {
        if (mida > 0) {
            this.ubicacions = new Ubicacio[mida];
        } else {
            this.ubicacions = new Ubicacio[2];
        }
        this.numUbicacions = 0;
        this.acabaEnOrigen = acabaEnOrigen;
    }

    // Getters i setters
    public Ubicacio[] getUbicacions() {
        return ubicacions;
    }

    public void setUbicacions(Ubicacio[] ubicacions) {
        this.ubicacions = ubicacions;
    }

    public boolean getAcabaEnOrigen() {
        return acabaEnOrigen;
    }

    public void setAcabaEnOrigen(boolean acabaEnOrigen) {
        this.acabaEnOrigen = acabaEnOrigen;
    }

    public int getNumUbicacions() {
        return numUbicacions;
    }

    /*
     * public void setNumUbicacions(int numUbicacions) {
     * this.numUbicacions = numUbicacions;
     * }
     */

    public void afegirUbicacio(Ubicacio ubicacio) {
        if (numUbicacions == 0) {
            ubicacions[numUbicacions++] = ubicacio;

        } else if (numUbicacions < ubicacions.length && !(ubicacions[0].equals(ubicacio))) {
            ubicacions[numUbicacions++] = ubicacio;
        }
    }

    public double calcularDistanciaRuta() {
        double distancia = 0.0;
        for (int i = 0; i < numUbicacions - 1; i++) {
            distancia += ubicacions[i].distancia(ubicacions[i + 1]);
        }
        if (getAcabaEnOrigen()) {
            distancia += ubicacions[numUbicacions - 1].distancia(ubicacions[0]);
        }
        return distancia;
    }

    public Ubicacio ubicacioMesAlNord() {
        Ubicacio mesAlNord = ubicacions[0];
        for (int i = 1; i < numUbicacions; i++) {
            if (ubicacions[i].getLatitud() > mesAlNord.getLatitud()) {
                mesAlNord = ubicacions[i];
            }
        }
        return mesAlNord;
    }

    public String toString() {
        String aux = "Ruta => Nombre de ubicacions: " + numUbicacions;

        if (getAcabaEnOrigen()) {
            aux = aux + "\n\tLa ruta acaba en el origen:";
        }

        for (int i = 0; i < numUbicacions; i++) {
            aux = aux + "\n\tUbicacio posicio " + i + ": " + ubicacions[i].toString();
        }
        return aux;
    }
}
