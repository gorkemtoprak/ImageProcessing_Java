import java.awt.GridLayout;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

//@AUTHOR: GORKEM TOPRAK
//Date: DECEMBER 17, 2020 Thursday

public class ImageProcessing {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a txt name: ");
		String fileName = scan.nextLine();

		ReadFile readFile = new ReadFile();
		readFile.readFile(fileName + ".txt");

		int width = readFile.width;
		int height = readFile.height;

		int[][][] pixelsForOriginal = readFile.pixels;

		// This is for grey scale image
		GreyScale greyScale = new GreyScale();
		greyScale.createGrayScale(width, height, pixelsForOriginal);
		int[][] pixelsForGrayscale = greyScale.pixels;

		// This is for binary scale image
		BinaryScale binaryScale = new BinaryScale();
		binaryScale.createBinary(width, height, pixelsForOriginal);
		int[][] pixelsForBinary = binaryScale.pixels;
		
		BinaryScaleSegmentation binaryScale2 = new BinaryScaleSegmentation();
		binaryScale2.createBinary(width, height, pixelsForOriginal);
		int[][] pixelsForBinaryS = binaryScale2.pixels;

//		for (int i = 0; i < pixelsForBinaryS.length; i++) {
//		    for (int j = 0; j < pixelsForBinaryS[i].length; j++) {
//		        System.out.print(pixelsForBinaryS[i][j] + " ");
//		    }
//		    System.out.println();
//		}

		// This is for vertical image
		VerticalProjection verticalProjection = new VerticalProjection();
		verticalProjection.createVerticalProjection(width, height, pixelsForBinaryS);
		Integer[] pixelsForVertical = verticalProjection.verticalPixel;

		// This is for horizontal image
		HorizontalProjection horizontalProjection = new HorizontalProjection();
		horizontalProjection.createVerticalProjection(width, height, pixelsForBinaryS);
		Integer[] pixelsForHorizantal = horizontalProjection.horizontalPixel;

		final JFrame frame = new JFrame("Gorkem Toprak HW3");
		frame.setSize(1200, 1200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 1));

		JTabbedPane tabbedpane = new JTabbedPane(JTabbedPane.TOP);

		OriginalSketchPanel tab1 = new OriginalSketchPanel(width, height, pixelsForOriginal);
		SketchPanel tab2 = new SketchPanel(width, height, pixelsForGrayscale);
		SketchPanel tab3 = new SketchPanel(width, height, pixelsForBinary);
		SketchVertical tab4 = new SketchVertical(width, height, pixelsForVertical);
		SketchHorizontal tab5 = new SketchHorizontal(width, height, pixelsForHorizantal);


		tabbedpane.addTab("Original", tab1);
		tabbedpane.addTab("Grey Scale", tab2);
		tabbedpane.addTab("Binary Scale", tab3);
		tabbedpane.addTab("Vertical", tab4);
		tabbedpane.addTab("Horizontal", tab5);
		tabbedpane.addTab("Tab6", new JLabel("tab6"));

		frame.getContentPane().add(tabbedpane);

	}

}
