package raytracing;

import raytracing.*;

class Ray
{
    private Vec3 A;
    private Vec3 B;

    public Ray()
    {
        this.A = new Vec3();
        this.B = new Vec3();
    }

    public Ray(Vec3 A, Vec3 B)
    {
        this.A = A;
        this.B = B;
    }

    public Vec3 origin() { return this.A; }
    public Vec3 direction() { return this.B; }

    public Vec3 point_at_parameter(float t)
    {
        return this.A.add(this.B.mul(t));
    }


}
