import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SketchVertical extends JPanel {

	int width, height;
	Integer[] pixels;

	public SketchVertical(int width, int height, Integer[] verticalPixel) {
		this.width = width;
		this.height = height;
		this.pixels = verticalPixel;

	}

	public void paintComponent(Graphics g) {
		for (int col = 0; col < width; col++) {
			int verticalLength = pixels[col];
			//g.setColor(new Color(pixels[col], pixels[col], pixels[col]));
			g.drawLine(col, height, col, height - verticalLength);

		}
	}

}
