package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;
import java.util.Vector;

import br.upe.ppsw.jabberpoint.View.Style;

public class Slide {
	
	/*
	 * 
	//Essa variaveis estaticas devem ser eliminadas de acordo com a prof(Dica de sala de aula)
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	*
	*Essa refatoraçao causou erros nos arquivos Slide, textItem e SlideViewerFrame
	*/
	protected TextItem title;
	protected Vector<SlideItem> items;

	public Slide() { // contrutor todo tronxo
		items = new Vector<SlideItem>();
	}

	/*
	 * Esses dois metodos tem nomes repetidos e assinaturas diferentes mas eles
	 * servem para propositos diferentes, nao configurando a situaçao de overload e
	 * por esse motivo os nomes devem ser especificados -> S do solid.
	 * 
	 * public void append(SlideItem anItem) { items.addElement(anItem); }
	 * 
	 * public void append(int level, String message) { append(new TextItem(level,
	 * message)); }
	 * 
	 * Essa refatoraçao causou erros nos arquivos XMLAcessor e no DemoPresentacion
	 */

	public void appendSlideItem(SlideItem anItem) {
		items.addElement(anItem);
	}

	public void appendTextItem(int level, String message) {
		appendSlideItem(new TextItem(level, message));
	}

	
	
	public String getTitle() {
		return title.getText();
	}

	public void setTitle(String newTitle) {
		title = new TextItem(0, newTitle);
	}

	public SlideItem getSlideItem(int number) {
		return (SlideItem) items.elementAt(number);
	}

	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	public int getSize() {
		return items.size();
	}

	// A classe slide esta deleando aos filhos pra eles se desenharem, e isso é
	// errado.

//------> Daqui pra baixo o codigo faz alteraçoes em tela, e deve ser colocado em um outro arquivo dentro do pacote VIEW  
	public void draw(Graphics g, Rectangle area, ImageObserver view) {
		float scale = getScale(area);

		int y = area.y;

		SlideItem slideItem = this.title;
		Style style = Style.getStyle(slideItem.getLevel());
		slideItem.draw(area.x, y, scale, g, style, view);

		y += slideItem.getBoundingBox(g, view, scale, style).height;

		for (int number = 0; number < getSize(); number++) {
			slideItem = (SlideItem) getSlideItems().elementAt(number);

			style = Style.getStyle(slideItem.getLevel());
			slideItem.draw(area.x, y, scale, g, style, view);

			y += slideItem.getBoundingBox(g, view, scale, style).height;
		}
	}

	private float getScale(Rectangle area) {
		return Math.min(((float) area.width) / ((float) 1200.0), ((float) area.height) / ((float) 800.0));
	}
}
