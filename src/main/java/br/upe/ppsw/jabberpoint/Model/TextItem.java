package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextAttribute;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.ImageObserver;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.upe.ppsw.jabberpoint.View.Style;

public class TextItem extends SlideItem {

  private String text;

  private static final String EMPTYTEXT = "No Text Given";

  public TextItem(int level, String string) {
    super(level);
    text = string;
  }

  public TextItem() { //aqui ta errado falta o void
    this(0, EMPTYTEXT);//oq porra é isso, um segundo contrutor?
  }

  public String getText() {
    return text == null ? "" : text;
  }

  public String toString() {
	    return "TextItem[" + getLevel() + "," + getText() + "]";
	  }


	  
	  
	  
  
  //-->Esses aqui sao metodos que foram implementados por conta da extends SlideItems
  public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {
    List<TextLayout> layouts = getLayouts(g, myStyle, scale);

    int xsize = 0, ysize = (int) (myStyle.getLeading() * scale);

    Iterator<TextLayout> iterator = layouts.iterator();

    while (iterator.hasNext()) {
      TextLayout layout = iterator.next();
      Rectangle2D bounds = layout.getBounds();

      if (bounds.getWidth() > xsize) {
        xsize = (int) bounds.getWidth();
      }

      if (bounds.getHeight() > 0) {
        ysize += bounds.getHeight();
      }
      ysize += layout.getLeading() + layout.getDescent();
    }

    return new Rectangle((int) (myStyle.getIndent() * scale), 0, xsize, ysize);
  }
 
  //metodo Draw de desneho em tela, esse metodo deve ser colocado em um novo arquivo e posto no packege VIEW!!!
  public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver o) {
    if (text == null || text.length() == 0) {
      return;
    }

    List<TextLayout> layouts = getLayouts(g, myStyle, scale);
    Point pen = new Point(x + (int) (myStyle.getIndent() * scale), y + (int) (myStyle.getLeading() * scale));

    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(myStyle.getColor());

    Iterator<TextLayout> it = layouts.iterator();

    while (it.hasNext()) {
      TextLayout layout = it.next();

      pen.y += layout.getAscent();
      layout.draw(g2d, pen.x, pen.y);

      pen.y += layout.getDescent();
    }
  }

  //Esse metodo aqui eu nao sei onde ele deveria estar, mas ele é utilizado dentro dos metodos que a classe implementa da interface SlideItems
  private List<TextLayout> getLayouts(Graphics g, Style s, float scale) {
	    List<TextLayout> layouts = new ArrayList<TextLayout>();

	    AttributedString attrStr = getAttributedString(s, scale);
	    Graphics2D g2d = (Graphics2D) g;

	    FontRenderContext frc = g2d.getFontRenderContext();
	    LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);

	    float wrappingWidth = (Slide.WIDTH - s.getIndent()) * scale;

	    while (measurer.getPosition() < getText().length()) {
	      TextLayout layout = measurer.nextLayout(wrappingWidth);
	      layouts.add(layout);
	    }

	    return layouts;
	  }

	
  	//Esse metodo aqui eu nao sei onde ele deveria estar, mas ele é utilizado dentro dos metodo getLayouts
	public AttributedString getAttributedString(Style style, float scale) { //esse nome ta errado
	    AttributedString attrStr = new AttributedString(getText());

	    attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());

	    return attrStr;
	}

		
  
}
