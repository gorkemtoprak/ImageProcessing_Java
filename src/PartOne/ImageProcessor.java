package PartOne;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JTabbedPane;

// @AUTHOR: GORKEM TOPRAK
// Date: DECEMBER 12, 2020 Saturday

public class ImageProcessor {
	
	private short pixel[][];
	private int width, height;
	private BufferedImage image;
	private String type = "2"; //I gave it by hand at random as I couldn't figure out how to get the type here.
	private String maxValue = "255"; //I gave it by hand at random as I couldn't figure out how to get the max value here.

	
	public ImageProcessor() {
		try {
			readPixels();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void readPixels() throws IOException{
		
		  try {
	            File input = new File("licencePlate.jpeg");
	            File outputFile = new File("licencePlate.txt");
	            FileOutputStream fos = new FileOutputStream(outputFile);

	            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
	            if (outputFile.createNewFile()) {
	                System.out.println("Your file has been created named: " + outputFile.getName());
	            } else {
	                System.out.println("Your file already exists.");
	            }
	            image = ImageIO.read(input);
	            width = image.getWidth();
	            height = image.getHeight();
	            writer.write(type);
	            writer.newLine();
	            writer.write(width + " " + height);
	            writer.newLine();
	            writer.write(maxValue);
	            writer.newLine();

	            System.out.println("Width: " + width + " Height: " + height);

	            int count = 0;

	            for(int i=0; i<height; i++) {
	                for(int j=0; j<width; j++) {
	                    count++;
	                    Color color = new Color(image.getRGB(j, i));
	                    writer.write(color.getRed() + " " + color.getGreen() + " " + color.getBlue() + " ");
	                  // System.out.println("Red Value: " + color.getRed() + " Green Value: " + color.getGreen() + " Blue Value: " + color.getBlue());
	                }
	            }
	            writer.close();

	        } catch (Exception e) {

	        }
	}

	
	public static void main(String[] args) {
		new ImageProcessor();
	}

}
