package br.upe.ppsw.jabberpoint.Model;

import java.util.ArrayList;

public class Presentation {
	
	private String title;
	private ArrayList<Slide> showList = null;

	protected int currentSlideNumber = 0;

	public Presentation() {
		clear();
	}

	public int getSize() {
		return this.showList.size();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String nt) {
		this.title = nt;
	}

	public int getSlideNumber() {
		return currentSlideNumber;
	}

	public void setSlideNumber(int number) {
		this.currentSlideNumber = number;
	}

	public void prevSlide() {
		if (this.currentSlideNumber > 0) {
			setSlideNumber(this.currentSlideNumber - 1);
		}
	}

	public void nextSlide() {
		if (this.currentSlideNumber < (this.showList.size() - 1)) {
			setSlideNumber(this.currentSlideNumber + 1);
		}
	}

	public void clear() {
		this.showList = new ArrayList<Slide>();
		setSlideNumber(-1);
	}

	public void appendPresentacion(Slide slide) {
		this.showList.add(slide);
	}

	public Slide getSlide(int number) {

		if (number < 0 || number >= this.getSize()) {
			return null;
		}
		return (Slide) showList.get(number);

	}

	public Slide getCurrentSlide() {
		return this.getSlide(this.currentSlideNumber);
	}

}
