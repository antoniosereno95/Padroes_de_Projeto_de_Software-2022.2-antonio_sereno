package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.View.Pintor;

public abstract class SlideItem {

	protected Pintor pintor; // Protected pq como é no mesmo package ai nao da erro.

	private int level = 0;

	public SlideItem(int lev) {
		this.level = lev;
	}

	public SlideItem() {
		this(0);
	}

	public int getLevel() {
		return this.level;
	}

	public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale);

	public void draw(int x, int y, float scale, Graphics g, ImageObserver observer) {
	   
		pintor.draw(x, y, scale, g, observer, this);
	}

}
