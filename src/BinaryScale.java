
//@AUTHOR: GORKEM TOPRAK
//Date: DECEMBER 17, 2020 Thursday

// Why I pick up 127? Just because its a threshold value, so I calculate those values and I found that 127 gave exactly the gorset I wanted.

public class BinaryScale {

	public int[][] pixels = null;

	public void createBinary(int width, int height, int[][][] pixelsForBinary) {

		pixels = new int[width][height];
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				int rez = (pixelsForBinary[col][row][0] + pixelsForBinary[col][row][1] + pixelsForBinary[col][row][2]) / 3;
				if (rez < 127) {
					pixels[col][row] = 0;
				} else {
					pixels[col][row] = 255;
				}
			}
		}

	}

}
