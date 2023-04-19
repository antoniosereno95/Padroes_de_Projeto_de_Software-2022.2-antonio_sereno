package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.awt.image.ImageObserver;
import java.util.Iterator;
import java.util.List;

import br.upe.ppsw.jabberpoint.Model.BitmapItem;
import br.upe.ppsw.jabberpoint.Model.SlideItem;
import br.upe.ppsw.jabberpoint.Model.TextItem;

public class SlideItemPintor { 
	private SlideItem slideItem;

    public SlideItemPintor(SlideItem slideItem) {
        this.slideItem = slideItem;
    }

    public void Desenha(
        int x, int y, float scale, Graphics g, Style style,
        ImageObserver observer
    ) {
        if (this.slideItem instanceof BitmapItem) {
            int width = x + (int) (style.getIndent() * scale);
            int height = y + (int) (style.getLeading() * scale);
        
            g.drawImage(((BitmapItem) this.slideItem).getBufferedImage(), width, height, (int) (((BitmapItem) this.slideItem).getBufferedImage().getWidth(observer) * scale),
                (int) (((BitmapItem) this.slideItem).getBufferedImage().getHeight(observer) * scale), observer);        

            System.out.println(this.slideItem.getLevel());
        }

        if (this.slideItem instanceof TextItem) {
            System.out.println(this.slideItem.getLevel());
            if (((TextItem) this.slideItem).getText() == null || 
            ((TextItem) this.slideItem).getText().length() == 0) return;
          
            List<TextLayout> layouts = ((TextItem) this.slideItem).getLayouts(g, style, scale);
            Point pen = new Point(x + (int) (style.getIndent() * scale), y + (int) (style.getLeading() * scale));
        
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(style.getColor());
        
            Iterator<TextLayout> it = layouts.iterator();
          
            while (it.hasNext()) {
                TextLayout layout = it.next();
          
                pen.y += layout.getAscent();
                layout.draw(g2d, pen.x, pen.y);
          
                pen.y += layout.getDescent();
            }
        }
    }

    public void setSlideItem(SlideItem slideItem) {
        this.slideItem = slideItem;
    }
}
