/**
 * Clase que representa una ubicación geográfica con latitud y longitud.
 */
public class Ubicacio {

    // Constantes de clase
    private static final double LATITUD_MIN = -90.0;
    private static final double LATITUD_MAX = 90.0;
    private static final double LONGITUD_MIN = -180.0;
    private static final double LONGITUD_MAX = 180.0;
    private static final double TOLERANCIA = 0.0001;
    private static final double RADI_TERRA = 6378.137;
    private static final double PI_TO_RADIANTS = Math.PI / 180;

    // Atributos
    private double latitud;
    private double longitud;

    /**
     * Verifica si un valor está dentro de un rango específico.
     * 
     * @param valor el valor a verificar
     * @param min   el valor mínimo del rango
     * @param max   el valor máximo del rango
     * @return true si el valor está dentro del rango, false en caso contrario
     */
    private static boolean estaDinsDelRange(double valor, double min, double max) {
        return valor >= min && valor <= max;
    }

    /**
     * Verifica si una ubicación es correcta basándose en la latitud y longitud.
     * 
     * @param latitud  la latitud de la ubicación
     * @param longitud la longitud de la ubicación
     * @return true si la ubicación es correcta, false en caso contrario
     */
    private static boolean ubicacioCorrecta(double latitud, double longitud) {
        return estaDinsDelRange(latitud, LATITUD_MIN, LATITUD_MAX)
                && estaDinsDelRange(longitud, LONGITUD_MIN, LONGITUD_MAX);
    }

    /**
     * Constructor de la ubicación con parámetros.
     * 
     * @param latitud  la latitud de la ubicación
     * @param longitud la longitud de la ubicación
     */
    public Ubicacio(double latitud, double longitud) {
        if (ubicacioCorrecta(latitud, longitud)) {
            this.latitud = latitud;
            this.longitud = longitud;
        } else {
            this.latitud = 0;
            this.longitud = 0;
        }
    }

    /**
     * Constructor de la ubicación sin parámetros.
     */
    public Ubicacio() {
        this.latitud = 0;
        this.longitud = 0;
    }

    /**
     * Devuelve la latitud de la ubicación.
     * 
     * @return la latitud de la ubicación
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * Devuelve la longitud de la ubicación.
     * 
     * @return la longitud de la ubicación
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Modifica la latitud de la ubicación.
     * 
     * @param latitud la nueva latitud de la ubicación
     */
    public void setLatitud(double latitud) {
        if (estaDinsDelRange(latitud, LATITUD_MIN, LATITUD_MAX)) {
            this.latitud = latitud;
        }
    }

    /**
     * Modifica la longitud de la ubicación.
     * 
     * @param longitud la nueva longitud de la ubicación
     */
    public void setLongitud(double longitud) {
        if (estaDinsDelRange(longitud, LONGITUD_MIN, LONGITUD_MAX)) {
            this.longitud = longitud;
        }
    }

    /**
     * Devuelve la información de la ubicación con un formato concreto de texto.
     * 
     * @return una cadena de texto con la información de la ubicación
     */
    public String toString() {
        return "Ubicacio [latitud=" + getLatitud() + ", longitud=" + getLongitud() + "]";
    }

    /**
     * Copia los valores de la ubicación actual a una nueva ubicación que tiene
     * asignada una posición de memoria diferente.
     * 
     * @return una nueva instancia de Ubicacio con los mismos valores
     */
    public Ubicacio copiaUbicacio() {
        return new Ubicacio(this.getLatitud(), this.getLongitud());
    }

    /**
     * Compara si dos ubicaciones son iguales.
     * 
     * @param ubicacio la ubicación a comparar
     * @return true si las ubicaciones son iguales, false en caso contrario
     */
    private boolean equalsUbicacio(Ubicacio ubicacio) {
        return Math.abs(this.getLatitud() - ubicacio.getLatitud()) < TOLERANCIA
                && Math.abs(this.getLongitud() - ubicacio.getLongitud()) < TOLERANCIA;
    }

    /**
     * Convierte grados a radianes.
     * 
     * @param graus los grados a convertir
     * @return el valor en radianes
     */
    private static double toRadiants(double graus) {
        return graus * PI_TO_RADIANTS;
    }

    /**
     * Calcula el valor a de la fórmula de Haversine.
     * 
     * @param dlat la diferencia de latitud en radianes
     * @param dlon la diferencia de longitud en radianes
     * @param lat1 la latitud del primer punto en radianes
     * @param lat2 la latitud del segundo punto en radianes
     * @return el valor a de la fórmula de Haversine
     */
    private static double calculateA(double dlat, double dlon, double lat1, double lat2) {
        return Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
    }

    /**
     * Calcula la distancia entre dos puntos con la fórmula de Haversine.
     * 
     * @param a el valor a de la fórmula de Haversine
     * @return la distancia entre los dos puntos en kilómetros
     */
    private static double calculateDistance(double a) {
        return RADI_TERRA * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    /**
     * Calcula la distancia entre dos ubicaciones.
     * 
     * @param ubicacio la otra ubicación
     * @return la distancia entre las dos ubicaciones en kilómetros
     */
    public double distancia(Ubicacio ubicacio) {

        double lat1, lon1, lat2, lon2, dlat, dlon, a, distancia = 0;
        boolean igual = equalsUbicacio(ubicacio);

        if (igual) {
            distancia = 0;
        } else {
            lat1 = toRadiants(this.getLatitud());
            lon1 = toRadiants(this.getLongitud());
            lat2 = toRadiants(ubicacio.getLatitud());
            lon2 = toRadiants(ubicacio.getLongitud());
            dlat = lat2 - lat1;
            dlon = lon2 - lon1;
            a = calculateA(dlat, dlon, lat1, lat2);
            distancia = calculateDistance(a);
        }
        return distancia;
    }
}
