public class Ruta {
    private Ubicacio[] ubicacions;
    private boolean acabaEnOrigen;
    private int numUbicacions;

    /**
     * Constructor de la classe Ruta.
     * 
     * @param mida Mida inicial de l'array d'ubicacions.
     */
    public Ruta(int mida) {
        if (mida > 0) {
            this.ubicacions = new Ubicacio[mida];
        } else {
            this.ubicacions = new Ubicacio[2];
        }
        this.numUbicacions = 0;
        this.acabaEnOrigen = false;
    }

    /**
     * Constructor de la classe Ruta.
     * 
     * @param mida          Mida inicial de l'array d'ubicacions.
     * @param acabaEnOrigen Indica si la ruta acaba en l'origen.
     */
    public Ruta(int mida, boolean acabaEnOrigen) {
        if (mida > 0) {
            this.ubicacions = new Ubicacio[mida];
        } else {
            this.ubicacions = new Ubicacio[2];
        }
        this.numUbicacions = 0;
        this.acabaEnOrigen = acabaEnOrigen;
    }

    /**
     * Obté l'array d'ubicacions.
     * 
     * @return Array d'ubicacions.
     */
    public Ubicacio[] getUbicacions() {
        return ubicacions;
    }

    /**
     * Estableix l'array d'ubicacions.
     * 
     * @param ubicacions Array d'ubicacions.
     */
    public void setUbicacions(Ubicacio[] ubicacions) {
        this.ubicacions = ubicacions;
    }

    /**
     * Indica si la ruta acaba en l'origen.
     * 
     * @return true si la ruta acaba en l'origen, false en cas contrari.
     */
    public boolean getAcabaEnOrigen() {
        return acabaEnOrigen;
    }

    /**
     * Estableix si la ruta acaba en l'origen.
     * 
     * @param acabaEnOrigen true si la ruta acaba en l'origen, false en cas
     *                      contrari.
     */
    public void setAcabaEnOrigen(boolean acabaEnOrigen) {
        this.acabaEnOrigen = acabaEnOrigen;
    }

    /**
     * Obté el nombre d'ubicacions.
     * 
     * @return Nombre d'ubicacions.
     */
    public int getNumUbicacions() {
        return numUbicacions;
    }

    /**
     * Afegeix una nova ubicació a la ruta.
     * 
     * @param ubicacio Ubicació a afegir.
     */
    public void afegirUbicacio(Ubicacio ubicacio) {
        if (numUbicacions == 0) {
            ubicacions[numUbicacions++] = ubicacio.copiaUbicacio();

        } else if (numUbicacions < ubicacions.length && !(ubicacions[0].equals(ubicacio))) {
            ubicacions[numUbicacions++] = ubicacio.copiaUbicacio();
        }
    }

    /**
     * Consulta una ubicació en una posició específica.
     * 
     * @param posicio Posició de la ubicació a consultar.
     * @return Ubicació en la posició especificada, o null si la posició és
     *         invàlida.
     */
    public Ubicacio consultarUbicacio(int posicio) {
        Ubicacio ubicacio = null;
        if (posicio >= 0 && posicio < numUbicacions) {
            ubicacio = ubicacions[posicio].copiaUbicacio();
        }
        return ubicacio;
    }

    /**
     * Modifica una ubicació en una posició específica.
     * 
     * @param posicio  Posició de la ubicació a modificar.
     * @param ubicacio Nova ubicació.
     */
    public void modificarUbicacio(int posicio, Ubicacio ubicacio) {
        if (posicio >= 0 && posicio < numUbicacions) {
            ubicacions[posicio] = ubicacio;
        }
    }

    /**
     * Calcula la distància total de la ruta.
     * 
     * @return Distància total de la ruta.
     */
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

    /**
     * Obté la ubicació més al nord de la ruta.
     * 
     * @return Ubicació més al nord.
     */
    public Ubicacio ubicacioMesAlNord() {
        Ubicacio mesAlNord = ubicacions[0];
        for (int i = 1; i < numUbicacions; i++) {
            if (ubicacions[i].getLatitud() > mesAlNord.getLatitud()) {
                mesAlNord = ubicacions[i].copiaUbicacio();
            }
        }
        return mesAlNord;
    }

    /**
     * Torna una representació en cadena de la ruta.
     * 
     * @return Representació en cadena de la ruta.
     */
    public String toString() {
        String aux = "Ruta => Nombre d'ubicacions: " + numUbicacions;

        if (getAcabaEnOrigen()) {
            aux = aux + "\n\tLa ruta acaba en l'origen:";
        }

        for (int i = 0; i < numUbicacions; i++) {
            aux = aux + "\n\tUbicacio posicio " + i + ": " + ubicacions[i].toString();
        }
        return aux;
    }
}
