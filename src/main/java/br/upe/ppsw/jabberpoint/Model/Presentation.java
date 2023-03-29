package br.upe.ppsw.jabberpoint.Model;

import java.util.ArrayList;

import br.upe.ppsw.jabberpoint.View.SlideViewerComponent;

public class Presentation {

	private String title;
	private ArrayList<Slide> showList = null;
	/* ->Vou retirar a instancia do SlideViewer do Model presnetacion por que um modelo nao deve 
	 * ter que saber se desenhar, existe um componenete na View que sera responsavel por essa logica
	 * private SlideViewerComponent slideViewComponent = null;
	 */
	private int currentSlideNumber = 0;

	//construtor vazio
	public Presentation() {
		this.slideViewComponent = null;
		clear();
	}
	
	public Presentation(SlideViewerComponent slideViewerComponent) { // denovo override no construtor?
		this.slideViewComponent = slideViewerComponent;
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

	public void setShowView(SlideViewerComponent slideViewerComponent) {
		this.slideViewComponent = slideViewerComponent;
	}

	public int getSlideNumber() {
		return currentSlideNumber;
	}

	public void setSlideNumber(int number) {
		this.currentSlideNumber = number;
		if (slideViewComponent != null) {
			slideViewComponent.update(this, getCurrentSlide());
		}
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

	public void clear() { // sem declaraçao de visibilidade(euq q coloquei como public)
		this.showList = new ArrayList<Slide>();
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
		this.showList.add(slide);
	}

	public Slide getSlide(int number) {
		if (number < 0 || number >= this.getSize()) { // inverter esse if pfv
			return null;
		}
		return (Slide) showList.get(number);
	}

	public Slide getCurrentSlide() {
		return this.getSlide(this.currentSlideNumber);
	}

	public void exit(int n) {
		System.exit(n);
	}
}
