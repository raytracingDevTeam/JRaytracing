package raytracing;

public class Vec3
{

    private float x;
    private float y;
    private float z;

    public Vec3() { this.x = 0; this.y = 0; this.z = 0; }

    public Vec3(float x, float y, float z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float x() { return this.x; }
    public float y() { return this.y; }
    public float z() { return this.z; }

    public Vec3 add(Vec3 v2)
    {
        this.x += v2.x();
        this.y += v2.y();
        this.z += v2.z();

        return this;
    }

    public Vec3 sub(Vec3 v2)
    {
        this.x -= v2.x();
        this.y -= v2.y();
        this.z -= v2.z();

        return this;
    }

    public Vec3 mul(Vec3 v2)
    {
        this.x *= v2.x();
        this.y *= v2.y();
        this.z *= v2.z();

        return this;
    }

    public Vec3 div(Vec3 v2)
    {
        this.x /= v2.x();
        this.y /= v2.y();
        this.z /= v2.z();

        return this;
    }

    public Vec3 mul(float k)
    {
        this.x *= k;
        this.y *= k;
        this.z *= k;

        return this;
    }

    public Vec3 div(float k)
    {
        this.x /= k;
        this.y /= k;
        this.z /= k;

        return this;
    }

    public float length()
    {
        return (float)Math.sqrt(this.squared_length());
    }

    public float squared_length()
    {
        return this.x * this.x +
               this.y * this.y +
               this.z * this.z;
    }

    public void make_unit_vector()
    {
        float k = 1.0f / this.length();
        this.mul(k);
    }

    public String toString()
    {
        return String.format("%s %s %s", this.x, this.y, this.z);
    }

    public static Vec3 add(Vec3 v1, Vec3 v2)
    {
        return new Vec3(
            v1.x() + v2.x(),
            v1.y() + v2.y(),
            v1.z() + v2.z()
        );
    }

    public static Vec3 sub(Vec3 v1, Vec3 v2)
    {
        return new Vec3(
            v1.x() - v2.x(),
            v1.y() - v2.y(),
            v1.z() - v2.z()
        );
    }

    public static Vec3 mul(Vec3 v1, Vec3 v2)
    {
        return new Vec3(
            v1.x() * v2.x(),
            v1.y() * v2.y(),
            v1.z() * v2.z()
        );
    }

    public static Vec3 mul(Vec3 v1, float k)
    {
        return new Vec3(
            v1.x() * k,
            v1.y() * k,
            v1.z() * k
        );
    }

    public static Vec3 div(Vec3 v1, Vec3 v2)
    {
        return new Vec3(
            v1.x() / v2.x(),
            v1.y() / v2.y(),
            v1.z() / v2.z()
        );
    }

    public static Vec3 div(Vec3 v1, float k)
    {
        return new Vec3(
            v1.x() / k,
            v1.y() / k,
            v1.z() / k
        );
    }

    public static float dot(Vec3 v1, Vec3 v2)
    {
        return v1.x() * v2.x() + v1.y() * v2.y() + v1.z() * v2.z();
    }

    public static Vec3 cross(Vec3 v1, Vec3 v2)
    {
        return new Vec3(
            v1.y() * v2.z() - v1.z() * v2.y(),
           -v1.x() * v2.z() - v1.z() * v2.x(),
            v1.x() * v2.y() - v1.y() * v2.x()
        );
    }

    public static Vec3 unit_vector(Vec3 v)
    {
        return Vec3.div(v, v.length());
    }

}
