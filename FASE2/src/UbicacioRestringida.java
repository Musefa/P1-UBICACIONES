public class UbicacioRestringida {

    // Constants
    public static final double LATITUD_MIN = -90.0;
    public static final double LATITUD_MAX = 90.0;
    public static final double LONGITUD_MIN = -180.0;
    public static final double LONGITUD_MAX = 180.0;
    private static final double TOLERANCIA = 0.0001;
    private static final double RADI_TERRA = 6378.137;
    private static final double PI_TO_RADIANTS = Math.PI / 180;

    // Atributs objecte
    private double latitud;
    private double longitud;

    // Atributs de classe
    private static double latIni;
    private static double lonIni;
    private static double latFi;
    private static double lonFi;

    // Comprueba si la ubicación está dentro de un rango
    public static boolean estaDinsRang(double valor, double intervalIni, double intervalFi) {
        return valor >= intervalIni && valor <= intervalFi;
    }

    public static boolean esUbicacioValida(double latitud, double longitud) {
        return estaDinsRang(latitud, LATITUD_MIN, LATITUD_MAX) && estaDinsRang(longitud, LONGITUD_MIN, LONGITUD_MAX)
                && estaDinsRang(longitud, lonIni, lonFi) && estaDinsRang(latitud, latIni, latFi);
    }

    // Constructor de la ubicació
    public UbicacioRestringida(double latitud, double longitud) {
        if (esUbicacioValida(latitud, longitud)) {
            this.latitud = latitud;
            this.longitud = longitud;
        } else {
            this.latitud = this.longitud = 0;
        }
    }

    // Constructor de la ubicació sense paràmetres
    public UbicacioRestringida() {
        longitud = latitud = 0;
    }

    // Retorna la latitud de la ubicació
    public double getLatitud() {
        return latitud;
    }

    // Retorna la longitud de la ubicació
    public double getLongitud() {
        return longitud;
    }

    // Modifica la latitud de la ubicació
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    // Modifica la longitud de la ubicació
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    // Retorna la informació de la ubicació amb un format concret de text
    public String toString() {
        return "Ubicacio [latitud=" + getLatitud() + ", longitud=" + getLongitud() + "]";
    }

    // Copia els valors de la ubicació actual a una nova ubicació que té assignada
    // una posicion de memoria diferent
    public UbicacioRestringida copiaUbicacio() {
        return new UbicacioRestringida(this.getLatitud(), this.getLongitud());
    }

    // Compara si dues ubicacions són iguals
    private boolean equalsUbicacio(UbicacioRestringida ubicacio) {
        return Math.abs(this.getLatitud() - ubicacio.getLatitud()) < TOLERANCIA // Si la diferencia es menor que la
                                                                                // tolerancia llavors son iguals
                && Math.abs(this.getLongitud() - ubicacio.getLongitud()) < TOLERANCIA;
    }

    // Converteix graus a radians
    private static double toRadiants(double graus) {
        return graus * PI_TO_RADIANTS;
    }

    // Calcula el valor a de la fórmula de Haversine
    private static double calculateA(double dlat, double dlon, double lat1, double lat2) {
        return Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
    }

    // Calcula la distància entre dos punts amb la fórmula de Haversine
    private static double calculateDistance(double a) {
        return RADI_TERRA * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    // Calcula la distància entre dues ubicacions
    public double distancia(UbicacioRestringida ubicacio) {

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
