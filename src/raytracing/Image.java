package raytracing;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import raytracing.Color;

class Image
{
    private static final Logger LOG = Logger.getLogger(Image.class.getName());

    private int width;
    private int height;
    private ArrayList<String> content_lines;
    private String file_path;

    public Image(int width, int height, String file_path)
    {
        LOG.setLevel(Level.OFF);

        this.width = width;
        this.height = height;
        this.file_path = file_path;
        this.content_lines = new ArrayList<String>();

        LOG.info("Created image with: (" + this.width + ", " + this.height + ") stored at: " + this.file_path);

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
        LOG.info("Pixel with color: " + pixel_color);

        this.content_lines.add(pixel_color);
    }

    public void write()
    {
        try
        {
            Path path = Paths.get(this.filePath());
            Files.write(path, this.content_lines);

            LOG.info("Image written on disk at: " + this.file_path);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public int pixel_count() { return content_lines.size(); }

}
