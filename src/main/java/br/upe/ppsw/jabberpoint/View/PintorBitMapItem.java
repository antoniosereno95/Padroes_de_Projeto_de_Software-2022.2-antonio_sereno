package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.Model.BitmapItem;
import br.upe.ppsw.jabberpoint.Model.SlideItem;

public class PintorBitMapItem extends Pintor  {
	

	@Override
	public void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item) {
		Style myStyle = Style.getStyle(item.getLevel());

        int width = x + (int) (myStyle.getIndent() * scale);
        int height = y + (int) (myStyle.getLeading() * scale);

        BufferedImage bufferedImage = ((BitmapItem) item).getBufferedImage();
        if (bufferedImage != null) {
            g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale), (int) (bufferedImage.getHeight(observer) * scale), observer);
        }   
		
	}


}
