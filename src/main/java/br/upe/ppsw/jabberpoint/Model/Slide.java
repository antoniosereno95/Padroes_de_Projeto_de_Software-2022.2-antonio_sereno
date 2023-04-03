package br.upe.ppsw.jabberpoint.Model;

import java.util.Vector;

public class Slide {
	
	public final int WIDTH = 1200; //nao precisa ser estatico, So um final ja ta top pra nao deixar o atributo sem modificado
	public final int HEIGHT = 800;
	
	protected TextItem title;
	protected Vector<SlideItem> items;

	public Slide() { 
		items = new Vector<SlideItem>();
	}

	public Vector<SlideItem> getItems() {
		return items;
	}

	public void setItems(Vector<SlideItem> items) {
		this.items = items;
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public void setTitle(TextItem title) {
		this.title = title;
	}

	public void appendSlideItem(SlideItem anItem) {
		items.addElement(anItem);
	}

	public void appendTextItem(int level, String message) {
		appendSlideItem(new TextItem(level, message));
	}
	
	public TextItem getTitle() {
		return title;
	}
	
	public String getTitleText() {
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
	
}