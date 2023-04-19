package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.Model.SlideItem;

public class PintorBitMapItem extends SlideItem  {
	
	private BufferedImage bufferedImage;

	  public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
	    int width = x + (int) (myStyle.getIndent() * scale);
	    int height = y + (int) (myStyle.getLeading() * scale);

	    g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
	        (int) (bufferedImage.getHeight(observer) * scale), observer);
	  }


}
