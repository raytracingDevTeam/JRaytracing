package raytracing;

class Color
{

    private float red;
    private float green;
    private float blue;

    public Color(int red, int green, int blue)
    {
        this.red = (float)red / 255.0f;
        this.green = (float)green / 255.0f;
        this.blue = (float)blue / 255.0f;
    }

    public Color(float red, float green, float blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public float red() { return this.red; }
    public float green() { return this.green; }
    public float blue() { return this.blue; }

    public int ired() { return (int)(this.red * 255.9f); }
    public int igreen() { return (int)(this.green * 255.9); }
    public int iblue() { return (int)(this.blue * 255.9); }

    public Color mul(float k)
    {
        this.red *= k;
        this.green *= k;
        this.blue *= k;

        return this;
    }

    public Color add(Color c)
    {
        this.red += c.red();
        this.green += c.green();
        this.blue += c.blue();

        return this;
    }

    public String toString()
    {
        return String.format("[%d, %d, %d]", this.ired(), this.igreen(), this.iblue());
    }

}
