package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.Model.Slide;
import br.upe.ppsw.jabberpoint.Model.SlideItem;

public class SlidePintor { 
	
	private Slide slide;

    public SlidePintor(Slide slide) {
        this.slide = slide;
    }

    public void draw(Graphics g, Rectangle area, ImageObserver view) {
        float scale = this.getScale(area);
    
        int y = area.y;
    
        SlideItem slideItem = this.slide.getTitle();

        SlideItemPintor slideItemPintor = new SlideItemPintor(slideItem);

        Style style = Style.getStyle(slideItem.getLevel());

        slideItemPintor.draw(area.x, y, scale, g, style, view);
    
        y += slideItem.getBoundingBox(g, view, scale, style).height;
    
        for (int number = 0; number < this.slide.getSize(); number++) {
          slideItem = (SlideItem) this.slide.getSlideItems().elementAt(number);
            
          slideItemPintor.setSlideItem(slideItem);

          style = Style.getStyle(slideItem.getLevel());

          slideItemPintor.draw(area.x, y, scale, g, style, view);
    
          y += slideItem.getBoundingBox(g, view, scale, style).height;
        }
    }

    private float getScale(Rectangle area) {
        return Math.min(((float) area.width) / ((float) Slide.WIDTH),
            ((float) area.height) / ((float) Slide.HEIGHT));
    }
}
