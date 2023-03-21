package br.upe.ppsw.jabberpoint.Model;

import java.util.ArrayList;

import br.upe.ppsw.jabberpoint.View.SlideViewerComponent;

public class Presentation {

	private String title;
	private ArrayList<Slide> showList = null;
	private SlideViewerComponent slideViewComponent = null;
	private int currentSlideNumber = 0;

	public Presentation() {
		slideViewComponent = null;
		clear();
	}

	public Presentation(SlideViewerComponent slideViewerComponent) { // denovo override no construtor?
		this.slideViewComponent = slideViewerComponent;
		clear();
	}

	public int getSize() {
		return showList.size();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String nt) {
		title = nt;
	}

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	public int getSlideNumber() {
		return currentSlideNumber;
	}

	public void setSlideNumber(int number) {
		currentSlideNumber = number;
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
	}

	public void prevSlide() {
		if (currentSlideNumber > 0) {
			setSlideNumber(currentSlideNumber - 1);
		}
	}

	public void nextSlide() {
		if (currentSlideNumber < (showList.size() - 1)) {
			setSlideNumber(currentSlideNumber + 1);
		}
	}

	public void clear() { // sem declaraçao de visibilidade(euq q coloquei como public)
		showList = new ArrayList<Slide>();
		setSlideNumber(-1);
	}

	/*
	 * Apesar de nao estar ferindo nenhum principio SOLID esse metodo Append de
	 * Presentacion é massivamente utilizado e como existem outros metodos append de
	 * outras classes, irei especiaficar essse nome assim como fiz an classe Slide
	 * 
	 * public void append(Slide slide) { showList.add(slide); } Essa refatoraçao
	 * caisou erros em XMLAcessor e em DemoPresentaciosn onde o metodo é utilizado
	 * para adicionar Slides a apresnetaçao
	 *
	 * -->basicamente essa mudança foi feita para que possamos saber de qual metodo
	 * append estamos nos referenciando sem ter que clicar no crtl e depois no
	 * metodo, ou seja, melhorar entendidmento do codigo e leitura do mesmo.
	 */
	public void appendPresentacion(Slide slide) {
		showList.add(slide);
	}

	public Slide getSlide(int number) {
		if (number < 0 || number >= getSize()) { // inverter esse if pfv
			return null;
		}
		return (Slide) showList.get(number);
	}

	public Slide getCurrentSlide() {
		return getSlide(currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}
}
