package br.upe.ppsw.jabberpoint.View;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.Model.SlideItem;

public abstract class Pintor {
    
	public abstract void draw(int x, int y, float scale, Graphics g, ImageObserver observer, SlideItem item);
    
}
