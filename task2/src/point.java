public class point {
    float x;
    float y;

    point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }

    public float getDistanceToCentre(point center) {
        float distance = (float) Math.sqrt(Math.pow(this.x - center.getX(), 2)+Math.pow(this.y - center.getY(), 2));
        return distance;
    }
}
