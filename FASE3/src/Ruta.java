import java.util.Arrays;

public class Ruta {
    private Ubicacio[] ubicacions;
    private boolean acabaEnOrigen;
    private int numUbicacions;

    public Ruta(int mida) {
        this.ubicacions = new Ubicacio[mida];
        this.numUbicacions = 0;
        this.acabaEnOrigen = false;
    }

    // Getters i setters
    public Ubicacio getUbicacio(int index) {
        Ubicacio ubicacio = ubicacions[index];
        if (!indexCorrecte(index, getNumUbicacions())) {
            ubicacio = null;
        }
        return ubicacio;
    }

    public void setUbicacio(int index, Ubicacio ubicacio) {
        if (indexCorrecte(index, getNumUbicacions())) {
            ubicacions[index] = ubicacio;
            setAcabaEnOrigen(ubicacions[0].equals(ubicacions[numUbicacions - 1]));
        }
    }

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

    public void setNumUbicacions(int numUbicacions) {
        this.numUbicacions = numUbicacions;
    }

    private static boolean indexCorrecte(int index, int num) {
        return index >= 0 && index < num;
    }

    public void afegirUbicacio(Ubicacio ubicacio) {
        if (getNumUbicacions() < ubicacions.length) {
            setUbicacio(getNumUbicacions(), ubicacio);
            setNumUbicacions(getNumUbicacions() + 1);
            setAcabaEnOrigen(getNumUbicacions() > 1 && getUbicacio(0).equals(ubicacio));

        }
    }

    public double calcularDistanciaRuta() {
        double distancia = 0.0;
        for (int i = 0; i < getNumUbicacions() - 1; i++) {
            distancia += getUbicacio(i).distancia(getUbicacio(i + 1));
        }
        if (getAcabaEnOrigen()) {
            distancia += getUbicacio(getNumUbicacions() - 1).distancia(getUbicacio(0));
        }
        return distancia;
    }

    public Ubicacio ubicacioMesAlNord() {
        Ubicacio mesAlNord = getUbicacio(0);
        for (int i = 1; i < getNumUbicacions(); i++) {
            if (getUbicacio(i).getLatitud() > mesAlNord.getLatitud()) {
                mesAlNord = getUbicacio(i);
            }
        }
        return mesAlNord;
    }

    @Override
    public String toString() {
        return "Ruta{" +
                "ubicacions=" + Arrays.toString(ubicacions) +
                ", acabaEnOrigen=" + acabaEnOrigen +
                ", numUbicacions=" + numUbicacions +
                '}';
    }
}
