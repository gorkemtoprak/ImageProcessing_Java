import java.util.ArrayList;
import java.util.HashMap;

public class VerticalProjection {

	public Integer[] verticalPixel;

	public void createVerticalProjection(int height, int width, int[][] pixelsForBinary) {

		HashMap<Integer, Integer> histogramVertical = new HashMap<Integer, Integer>();

		int countForegroundPixelV = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				countForegroundPixelV += pixelsForBinary[i][j];
			}
			histogramVertical.put(i, countForegroundPixelV);
			countForegroundPixelV = 0;
		}

//		for (Integer i : histogramVertical.keySet()) {
//			System.out.println("key: " + i + " | value: " + histogramVertical.get(i));
//		}

		verticalPixel = histogramVertical.values().toArray(new Integer[0]);
//		for (Integer object : pixelsForHorizantal2) {
//			System.out.println(object);
//		}

	}

}
