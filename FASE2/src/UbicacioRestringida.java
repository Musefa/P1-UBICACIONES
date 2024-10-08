public class UbicacioRestringida {

    // Constantes de clase
    public static final double LATITUD_MIN = -90.0;
    public static final double LATITUD_MAX = 90.0;
    public static final double LONGITUD_MIN = -180.0;
    public static final double LONGITUD_MAX = 180.0;
    private static final double TOLERANCIA = 0.0001;
    private static final double RADI_TERRA = 6378.137;
    private static final double PI_TO_RADIANTS = Math.PI / 180;

    // Atributos de objeto
    private double latitud;
    private double longitud;

    // Atributos de classe
    private static double latIni = LATITUD_MIN / 3;
    private static double lonIni = LONGITUD_MIN / 3;
    private static double latFi = LATITUD_MAX / 3;
    private static double lonFi = LONGITUD_MAX / 3;

    /**
     * Comprueba si la ubicación está dentro de un rango.
     * 
     * @param valor       El valor a comprobar.
     * @param intervalIni El inicio del intervalo.
     * @param intervalFi  El final del intervalo.
     * @return true si el valor está dentro del rango, false en caso contrario.
     */
    private static boolean estaDinsRang(double valor, double intervalIni, double intervalFi) {
        return valor >= intervalIni && valor <= intervalFi;
    }

    /**
     * Comprueba si una ubicación es válida.
     * 
     * @param latitud  La latitud de la ubicación.
     * @param longitud La longitud de la ubicación.
     * @return true si la ubicación es válida, false en caso contrario.
     */
    private static boolean esUbicacioValida(double latitud, double longitud) {
        return estaDinsRang(latitud, LATITUD_MIN, LATITUD_MAX)
                && estaDinsRang(longitud, LONGITUD_MIN, LONGITUD_MAX)
                && estaDinsRang(longitud, getLonIni(), getLonFi())
                && estaDinsRang(latitud, getLatIni(), getLatFi());
    }

    /**
     * Comprueba si una latitud es válida.
     * 
     * @param latitud La latitud a comprobar.
     * @return true si la latitud es válida, false en caso contrario.
     */
    private static boolean esLatitudValida(double latitud) {
        return estaDinsRang(latitud, LATITUD_MIN, LATITUD_MAX)
                && estaDinsRang(latitud, getLatIni(), getLatFi());
    }

    /**
     * Comprueba si una longitud es válida.
     * 
     * @param longitud La longitud a comprobar.
     * @return true si la longitud es válida, false en caso contrario.
     */
    private static boolean esLongitudValida(double longitud) {
        return estaDinsRang(longitud, LONGITUD_MIN, LONGITUD_MAX)
                && estaDinsRang(longitud, getLonIni(), getLonFi());
    }

    /**
     * Comprueba si los nuevos límites están dentro del mapa.
     * 
     * @param newLatIni La nueva latitud inicial.
     * @param newLatFi  La nueva latitud final.
     * @param newLonIni La nueva longitud inicial.
     * @param newLonFi  La nueva longitud final.
     * @return true si los nuevos límites están dentro del mapa, false en caso
     *         contrario.
     */
    private static boolean esAlMapa(double newLatIni, double newLatFi, double newLonIni, double newLonFi) {
        return estaDinsRang(newLatIni, LATITUD_MIN, LATITUD_MAX)
                && estaDinsRang(newLonIni, LONGITUD_MIN, LONGITUD_MAX)
                && estaDinsRang(newLatFi, LATITUD_MIN, LATITUD_MAX)
                && estaDinsRang(newLonFi, LONGITUD_MIN, LONGITUD_MAX);
    }

    /**
     * Constructor de la ubicación con parámetros.
     * 
     * @param latitud  La latitud de la ubicación.
     * @param longitud La longitud de la ubicación.
     */
    public UbicacioRestringida(double latitud, double longitud) {
        // System.out.println(getLimitesRegion()); Se podria imprimir aquí pero he
        // decidido mejor hacerlo en UsaUbicacioRestringida.java para dejar los prints
        // en el testing más limpios
        if (esUbicacioValida(latitud, longitud)) {
            this.latitud = latitud;
            this.longitud = longitud;
        } else {
            this.latitud = this.longitud = 0;
        }
    }

    /**
     * Constructor de la ubicación sin parámetros.
     */
    public UbicacioRestringida() {
        longitud = latitud = 0;
    }

    /**
     * Devuelve la latitud de la ubicación.
     * 
     * @return La latitud de la ubicación.
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * Devuelve la longitud de la ubicación.
     * 
     * @return La longitud de la ubicación.
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * Devuelve la latitud inicial de la región.
     * 
     * @return La latitud inicial de la región.
     */
    public static double getLatIni() {
        return latIni;
    }

    /**
     * Devuelve longitud inicial de la región.
     * 
     * @return La longitud inicial de la región.
     */
    public static double getLonIni() {
        return lonIni;
    }

    /**
     * Devuelve la latitud final de la región.
     * 
     * @return La latitud final de la región.
     */
    public static double getLatFi() {
        return latFi;
    }

    /**
     * Devuelve la longitud final de la región.
     * 
     * @return La longitud final de la región.
     */
    public static double getLonFi() {
        return lonFi;
    }

    /**
     * Modifica la latitud de la ubicación.
     * 
     * @param latitud La nueva latitud.
     */
    public void setLatitud(double latitud) {
        // System.out.println(getLimitesRegion()); Se podria imprimir aquí pero he
        // decidido mejor hacerlo en UsaUbicacioRestringida.java para dejar los prints
        // en el testing más limpios
        if (esLatitudValida(latitud)) {
            this.latitud = latitud;
        }
    }

    /**
     * Modifica la longitud de la ubicación.
     * 
     * @param longitud La nueva longitud.
     */
    public void setLongitud(double longitud) {
        // System.out.println(getLimitesRegion()); Se podria imprimir aquí pero he
        // decidido mejor hacerlo en UsaUbicacioRestringida.java para dejar los prints
        // en el testing más limpios
        if (esLongitudValida(longitud)) {
            this.longitud = longitud;
        }
    }

    /**
     * Devuelve la información de la ubicación con un formato concreto de texto.
     * 
     * @return La información de la ubicación.
     */
    public String toString() {
        return "Ubicacio [Latitud = " + getLatitud() + ", Longitud = " + getLongitud() + "]";
    }

    /**
     * Copia los valores de la ubicación actual a una nueva ubicación que tiene
     * asignada una posición de memoria diferente.
     * 
     * @return Una nueva instancia de UbicacioRestringida con los mismos valores.
     */
    public UbicacioRestringida copiaUbicacio() {
        return new UbicacioRestringida(this.getLatitud(), this.getLongitud());
    }

    /**
     * Compara si dos ubicaciones son iguales.
     * 
     * @param ubicacio La ubicación a comparar.
     * @return true si las ubicaciones son iguales, false en caso contrario.
     */
    private boolean equalsUbicacio(UbicacioRestringida ubicacio) {
        return Math.abs(this.getLatitud() - ubicacio.getLatitud()) < TOLERANCIA
                && Math.abs(this.getLongitud() - ubicacio.getLongitud()) < TOLERANCIA;
    }

    /**
     * Convierte grados a radianes.
     * 
     * @param graus Los grados a convertir.
     * @return Los grados convertidos a radianes.
     */
    private static double toRadiants(double graus) {
        return graus * PI_TO_RADIANTS;
    }

    /**
     * Calcula el valor a de la fórmula de Haversine.
     * 
     * @param dLat La diferencia de latitud.
     * @param dLon La diferencia de longitud.
     * @param lat1 La latitud del primer punto.
     * @param lat2 La latitud del segundo punto.
     * @return El valor a de la fórmula de Haversine.
     */
    private static double calculateA(double dLat, double dLon, double lat1, double lat2) {
        return Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);
    }

    /**
     * Calcula la distancia entre dos puntos con la fórmula de Haversine.
     * 
     * @param a El valor a de la fórmula de Haversine.
     * @return La distancia entre dos puntos.
     */
    private static double calculateDistance(double a) {
        return RADI_TERRA * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

    /**
     * Calcula la distancia entre dos ubicaciones.
     * 
     * @param ubicacio La ubicación a la que se quiere calcular la distancia.
     * @return La distancia entre las dos ubicaciones.
     */
    public double distancia(UbicacioRestringida ubicacio) {
        double lat1, lon1, lat2, lon2, dLat, dLon, a, distancia = 0;
        boolean igual = equalsUbicacio(ubicacio);

        if (igual) {
            distancia = 0;
        } else {
            lat1 = toRadiants(this.getLatitud());
            lon1 = toRadiants(this.getLongitud());
            lat2 = toRadiants(ubicacio.getLatitud());
            lon2 = toRadiants(ubicacio.getLongitud());
            dLat = lat2 - lat1;
            dLon = lon2 - lon1;
            a = calculateA(dLat, dLon, lat1, lat2);
            distancia = calculateDistance(a);
        }

        return distancia;
    }

    /**
     * Método para consultar los límites de la región rectangular.
     * 
     * @return Los límites de la región rectangular.
     */
    public static String getLimitesRegion() {
        return "Limites de la región: Latitud [" + getLatIni() + ", " + getLatFi() + "], Longitud [" + getLonIni()
                + ", " + getLonFi()
                + "]";
    }

    /**
     * Comprueba si la nueva región es más grande que la actual.
     * 
     * @param newLatIni La nueva latitud inicial.
     * @param newLatFi  La nueva latitud final.
     * @param newLonIni La nueva longitud inicial.
     * @param newLonFi  La nueva longitud final.
     * @return true si la nueva región es más grande, false en caso contrario.
     */
    private static boolean regioMesGran(double newLatIni, double newLatFi, double newLonIni, double newLonFi) {
        return newLatIni <= getLatIni() && newLatFi >= getLatFi() && newLonIni <= getLonIni() && newLonFi >= getLonFi();
    }

    /**
     * Método para modificar los límites de la región rectangular.
     * 
     * @param newLatIni La nueva latitud inicial.
     * @param newLatFi  La nueva latitud final.
     * @param newLonIni La nueva longitud inicial.
     * @param newLonFi  La nueva longitud final.
     */
    public static void setLimitesRegion(double newLatIni, double newLatFi, double newLonIni, double newLonFi) {
        // System.out.println(getLimitesRegion()); Se podria imprimir aquí pero he
        // decidido mejor hacerlo en UsaUbicacioRestringida.java para dejar los prints
        // en el testing más limpios
        if (regioMesGran(newLatIni, newLatFi, newLonIni, newLonFi)
                && esAlMapa(newLatIni, newLatFi, newLonIni, newLonFi)) {
            latIni = newLatIni;
            latFi = newLatFi;
            lonIni = newLonIni;
            lonFi = newLonFi;
        }
    }
}
