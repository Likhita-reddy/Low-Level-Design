public class Location {
    private float latitude;
    private float longitude;

    public Location(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getDistance(Location location){
        // Haversine formula to calculate distance between two points on the Earth
        final int R = 6371; // Radius of the Earth in kilometers
        float latDistance = (float) Math.toRadians(location.getLatitude() - this.latitude);
        float lonDistance = (float) Math.toRadians(location.getLongitude() - this.longitude);
        float a = (float) (Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(this.latitude)) * Math.cos(Math.toRadians(location.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2));
        float c = (float) (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a)));
        return R * c; // Distance in kilometers
    }
}
