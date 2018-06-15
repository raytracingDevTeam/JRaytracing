package raytracing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;

import raytracing.Color;

class Image
{
    private int width;
    private int height;
    private ArrayList<String> content_lines;
    private String file_path;

    public Image(int width, int height, String file_path)
    {
        this.width = width;
        this.height = height;
        this.file_path = file_path;
        this.content_lines = new ArrayList<String>();

        this.content_lines.add("P3");
        this.content_lines.add("" + this.width + " " + this.height);
        this.content_lines.add("255");
    }

    public int height() { return this.height; }
    public int width() { return this.width; }
    public String filePath() { return this.file_path; }

    public void addPixelColor(Color color)
    {
        String pixel_color = String.format("%d %d %d", color.ired(), color.igreen(), color.iblue());

        this.content_lines.add(pixel_color);
    }

    public void write()
    {
        try
        {
            Path path = Paths.get(this.filePath());
            Files.write(path, this.content_lines);
        }
        catch (IOException ioe) {}

    }

}
