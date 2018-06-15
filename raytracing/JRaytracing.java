package raytracing;

import raytracing.*;

public class JRaytracing
{

    public static void main(String[] argv)
    {
        Image image = new Image(4, 2, "test.ppm");

        Vec3 origin = new Vec3();
        Vec3 horizontal = new Vec3(4.0f, 0.0f, 0.0f);
        Vec3 vertical = new Vec3(0.0f, 2.0f, 0.0f);
        Vec3 lower_left_corner = new Vec3(-2.0f, -1.0f, -1.0f);

        for (int j = image.height() - 1; j >=0; --j)
        {
            for (int i = 0; i <= image.width(); ++i)
            {
                float u = ((float)i) / (float)image.width();
                float v = ((float)j) / (float)image.height();

                Vec3 direction = lower_left_corner.add(Vec3.mul(horizontal, u)).add(Vec3.mul(vertical, v));

                Ray ray = new Ray(
                    origin,
                    direction
                );

                Color c = JRaytracing.color(ray);

                image.addPixelColor(c);
            }
        }

        image.write();
    }


    public static Color color(Ray ray)
    {
        Vec3 unit_direction = Vec3.unit_vector(ray.direction());
        float t = 0.5f * (unit_direction.y() + 1.0f);

        if (JRaytracing.hit_sphere(new Vec3(0.0f, 0.0f, -1.0f), 0.5f, ray))
            return new Color(1.0f, 0.0f, 0.0f);

        Color white = new Color(1.0f, 1.0f, 1.0f);
        Color blue = new Color(0.3f, 0.5f, 1.0f);
        white = white.mul(1.0f - t);
        blue = blue.mul(t);
        Color result = white.add(blue);
        return result;
    }


    public static boolean hit_sphere(Vec3 center, float radius, Ray r)
    {
        Vec3 oc = Vec3.sub(r.origin(), center);
        System.out.println(oc);

        float a = Vec3.dot(r.direction(), r.direction());
        System.out.println(a);

        float b = 2.0f * Vec3.dot(oc, r.direction());
        System.out.println(b);

        float c = Vec3.dot(oc, oc) - radius * radius;
        System.out.println(c);

        float discriminant = b * b - 4 * a * c;

        if (discriminant > 0)
            System.out.println(discriminant);

        return discriminant > 0;
    }

}
