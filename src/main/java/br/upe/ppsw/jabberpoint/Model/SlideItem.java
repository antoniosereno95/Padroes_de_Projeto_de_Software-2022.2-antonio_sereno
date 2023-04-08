package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import br.upe.ppsw.jabberpoint.View.Style;

public abstract class SlideItem {

	
//como é uma classe abstrata, essas coisas deveriam estar aqui mesmo? Sim, essas coisas podem estar ai sim.	
  private int level = 0;

  public SlideItem(int lev) { //contrutor
    this.level = lev; //falta o this
  }

  public SlideItem() { //overload no construtor?(metodo maluco)
    this(0); //this oq?
  }

  public int getLevel() {
    return this.level;
  }
//--final das coisas que o comentario da linha 12 menciona

  
  
  public abstract Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale,
      Style style);

  public abstract void draw(int x, int y, float scale, Graphics g, Style style,
      ImageObserver observer);

}
