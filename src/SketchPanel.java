import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SketchPanel extends JPanel{
	
    int width,height;
    int[][]pixels;
    
    public SketchPanel(int width,int height,int[][] pixel){
        this.width = width;
        this.height = height;
        this.pixels = pixel;

    }
    
    public void paintComponent(Graphics g){
        for(int row = 0; row < height; row++)
            for(int col = 0; col < width; col++){
                    g.setColor(new Color(pixels[col][row],pixels[col][row],pixels[col][row]));
                    g.fillRect(col, row, 1, 1);
            }
    }
}
