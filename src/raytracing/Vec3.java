package raytracing;

public class Vec3
{
    private float e[] = new float[3];

    public Vec3() { e[0] = 0.0f; e[1] = 0.0f; e[2] = 0.0f; }

    public Vec3(float x, float y, float z)
    {
        e[0] = x;
        e[1] = y;
        e[2] = z;
    }

    public float x() { return e[0]; }
    public float y() { return e[1]; }
    public float z() { return e[2]; }

    public float length() { return (float)Math.sqrt(squared_length()); }
    public float squared_length() { return x() * x() + y() * y() + z() * z(); }

    public void make_unit_vector()
    {
        float k = 1.0f / length();
        e[0] *= k;
        e[1] *= k;
        e[2] *= k;
    }

    public String toString()
    {
        return String.format("%2.3f %2.3f %2.3f", x(), y(), z());
    }

    public static Vec3 add(Vec3 a, Vec3 b)
    {
        return new Vec3(a.x() + b.x(), a.y() + b.y(), a.z() + b.z());
    }

    public static Vec3 sub(Vec3 a, Vec3 b)
    {
        return new Vec3(a.x() - b.x(), a.y() - b.y(), a.z() - b.z());
    }

    public static Vec3 mul(Vec3 a, Vec3 b)
    {
        return new Vec3(a.x() * b.x(), a.y() * b.y(), a.z() * b.z());
    }

    public static Vec3 mul(Vec3 a, float b)
    {
        return new Vec3(a.x() * b, a.y() * b, a.z() * b);
    }

    public static Vec3 div(Vec3 a, Vec3 b)
    {
        return new Vec3(a.x() / b.x(), a.y() / b.y(), a.z() / b.z());
    }

    public static Vec3 div(Vec3 a, float b)
    {
        return new Vec3(a.x() / b, a.y() / b, a.z() / b);
    }

    public static float dot(Vec3 a, Vec3 b)
    {
        return a.x() * b.x() + a.y() * b.y() + a.z() * b.z();
    }

    public static Vec3 cross(Vec3 a, Vec3 b)
    {
        return new Vec3(
                a.y() * b.z() - a.z() * b.y(),
                a.x() * b.z() - b.x() * a.z(),
                a.x() * b.y() - a.y() * b.x()
        );
    }

    public static Vec3 unit_vector(Vec3 v)
    {
        return Vec3.mul(v, v.length());
    }
}
