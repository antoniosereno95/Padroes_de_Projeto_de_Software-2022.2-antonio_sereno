package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.View.Style;

public abstract class SlideItem {

	private int level = 0;

	public SlideItem(int lev) {
		level = lev;
	}

	public SlideItem() {
		this(0);
	}

	public int getLevel() {
		return level;
	}

	public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style style);
}
