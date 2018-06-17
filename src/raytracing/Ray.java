package raytracing;

public class Ray
{
    private Vec3 origin;
    private Vec3 direction;

    public Ray() {}

    public Ray(Vec3 origin, Vec3 direction)
    {
        this.origin = origin;
        this.direction = direction;
    }

    public Vec3 origin() { return origin; }
    public Vec3 direction() { return direction; }

    public Vec3 point_at_parameter(float t)
    {
        return Vec3.add(origin, Vec3.mul(direction, t));
    }

}
