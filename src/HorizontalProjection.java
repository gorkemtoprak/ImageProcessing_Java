import java.util.HashMap;

public class HorizontalProjection {

	public Integer[] horizontalPixel;

	public void createVerticalProjection(int height, int width, int[][] pixelsForBinary) {

		// key value tutmak icin
		// yada cift array tutucan biri pozisyon biri count icin
		HashMap<Integer, Integer> histogramHorizantal = new HashMap<Integer, Integer>();

		int countForegroundPixelH = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				countForegroundPixelH += pixelsForBinary[j][i];
			}
			histogramHorizantal.put(i, countForegroundPixelH);
			countForegroundPixelH = 0;
		}

		for (Integer i : histogramHorizantal.keySet()) {
			System.out.println("key: " + i + " | value: " + histogramHorizantal.get(i));
		}

		horizontalPixel = histogramHorizantal.values().toArray(new Integer[0]);
//		for (Integer object : horizontalPixel) {
//			System.out.println(object);
//		}

	}

}
