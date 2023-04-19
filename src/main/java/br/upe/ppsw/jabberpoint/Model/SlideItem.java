package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.View.Style;

public abstract class SlideItem {

	
	
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
  
}
