package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.List;

import br.upe.ppsw.jabberpoint.Model.SlideItem;
import br.upe.ppsw.jabberpoint.Model.TextItem;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.font.TextLayout;
import java.util.Iterator;



public class PintorTextItem extends Pintor {

	@Override
	public void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item) {
		TextItem text = (TextItem) item;

		Style myStyle = Style.getStyle(text.getLevel());

		if (text == null || text.getText().length() == 0) {
			return;
		}

		List<TextLayout> layouts = text.getLayouts(g, myStyle, scale);

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

}
