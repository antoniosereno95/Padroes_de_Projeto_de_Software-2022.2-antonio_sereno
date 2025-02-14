package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
		this.text = string;
	}

	public TextItem() {
		this(0, EMPTYTEXT);
	}

	public String getText() {
		return this.text == null ? "" : this.text;
	}

	public String toString() {
		return "TextItem[" + this.getLevel() + "," + this.getText() + "]";
	}

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

	public List<TextLayout> getLayouts(Graphics g, Style s, float scale) {
		List<TextLayout> layouts = new ArrayList<TextLayout>();

		AttributedString attrStr = getAttributedString(s, scale);
		Graphics2D g2d = (Graphics2D) g;

		FontRenderContext frc = g2d.getFontRenderContext();
		LineBreakMeasurer measurer = new LineBreakMeasurer(attrStr.getIterator(), frc);

		float wrappingWidth = ((float) 1200.0 - s.getIndent()) * scale;

		while (measurer.getPosition() < getText().length()) {
			TextLayout layout = measurer.nextLayout(wrappingWidth);
			layouts.add(layout);
		}

		return layouts;
	}

	public AttributedString getAttributedString(Style style, float scale) {
		AttributedString attrStr = new AttributedString(getText());

		attrStr.addAttribute(TextAttribute.FONT, style.getFont(scale), 0, text.length());

		return attrStr;
	}

}
