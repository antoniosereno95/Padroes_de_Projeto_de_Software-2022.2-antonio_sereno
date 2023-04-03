package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.Model.SlideItem;

public class SlideDraw extends Pintor {

	@Override
	public void draw(int x, int y, float scale, Graphics g, ImageObserver view, SlideItem item) {
		// TODO Auto-generated method stub
		
			    SlideItem slideItem = this.title;

			    slideItem.draw(area.x, y, scale, g, view);

			    y += slideItem.getBoundingBox(g, view, scale).height;

			    for (int number = 0; number < getSize(); number++) {
			      slideItem = (SlideItem) getSlideItems().elementAt(number);

			      slideItem.draw(area.x, y, scale, g, view);

			      y += slideItem.getBoundingBox(g, view, scale).height;
			    }
			  
	}

}
