package src;

public class Ubicacio {

    private static final int PRECISION = 10000;
    private static final double RADI_TERRA = 6378.137;
    private static final double PI_TO_RADIANTS = Math.PI / 180;
    private double latitud;
    private double longitud;

    public Ubicacio(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String toString() {
        return "Ubicacio [latitud=" + getLatitud() + ", longitud=" + getLongitud() + "]";
    }

    public Ubicacio copiaUbicacio() {
        return new Ubicacio(this.getLatitud(), this.getLongitud());
    }

    private double precisioXifres(double valor) {
        return Math.round(valor * PRECISION) / (double) PRECISION;
    }

    public boolean equalsUbicacio(Ubicacio ubicacio) {
        return precisioXifres(this.getLatitud()) == precisioXifres(ubicacio.getLatitud())
                && precisioXifres(this.getLongitud()) == precisioXifres(ubicacio.getLongitud());
    }

    private double toRadiants(double graus) {
        return graus * PI_TO_RADIANTS;
    }

    private double calculateA(double dlat, double dlon, double lat1, double lat2) {
        return Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);
    }

    private double calculateDistance(double a) {
        return RADI_TERRA * 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    }

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
