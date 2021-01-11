import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class SketchHorizontal extends JPanel {

	int width, height;
	Integer[] pixels;

	public SketchHorizontal(int width, int height, Integer[] horizontalPixel) {
		this.width = width;
		this.height = height;
		this.pixels = horizontalPixel;

	}

	public void paintComponent(Graphics g) {
		for (int row = 0; row < height; row++) {
			int verticalLength = pixels[row];
			// g.setColor(new Color(pixels[row], pixels[row], pixels[row]));
			g.drawLine(row, width, row, width - verticalLength);

		}

	}

}
