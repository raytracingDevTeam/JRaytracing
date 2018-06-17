package raytracing;

import java.util.logging.Level;
import java.util.logging.Logger;


public class JRaytracing
{

    private static final Logger LOG = Logger.getLogger(JRaytracing.class.getName());

    public static void main(String[] argv)
    {
        LOG.setLevel(Level.OFF);

        Image image = new Image(200, 100, "test.ppm");

        Vec3 origin = new Vec3();
        Vec3 horizontal = new Vec3(4.0f, 0.0f, 0.0f);
        Vec3 vertical = new Vec3(0.0f, 2.0f, 0.0f);
        Vec3 lower_left_corner = new Vec3(-2.0f, -1.0f, -1.0f);

        for (int j = image.height() - 1; j >=0; --j)
        {
            for (int i = 0; i < image.width(); ++i)
            {
                float u = ((float)i) / ((float)image.width());
                float v = ((float)j) / ((float)image.height());

                LOG.finest("UV: [" + u + ", " + v + "]");

                Vec3 a = Vec3.mul(horizontal, u);
                Vec3 b = Vec3.mul(vertical, v);
                Vec3 direction = Vec3.add(lower_left_corner, a);
                direction = Vec3.add(direction, b);

                Ray ray = new Ray(origin, direction);

                Color c = JRaytracing.color(ray);

                image.addPixelColor(c);
            }
        }

        image.write();
    }


    public static Color color(Ray ray)
    {
        ray.direction().make_unit_vector();
        float t = 0.5f * (ray.direction().y() + 1.0f);

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

        float a = Vec3.dot(r.direction(), r.direction());
        float b = 2.0f * Vec3.dot(oc, r.direction());
        float c = Vec3.dot(oc, oc) - radius * radius;

        float discriminant = b * b - 4 * a * c;

        return discriminant > 0;
    }

}
