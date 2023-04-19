package br.upe.ppsw.jabberpoint.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.Model.Presentation;
import br.upe.ppsw.jabberpoint.View.SlideViewerComponent;

public class KeyController extends KeyAdapter {

	private Presentation presentation;
	private SlideViewerComponent slideViewerComponent;

	public KeyController(Presentation p, SlideViewerComponent slideViewerComponent) {
		this.presentation = p;
		this.slideViewerComponent = slideViewerComponent;
	}

	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
		case KeyEvent.VK_PAGE_DOWN:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
		case KeyEvent.VK_RIGHT:
			presentation.nextSlide();
			this.slideViewerComponent.update();
			break;
		case KeyEvent.VK_PAGE_UP:
		case KeyEvent.VK_UP:
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_BACK_SPACE:
			presentation.prevSlide();
			this.slideViewerComponent.update();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break; 
		default:
			break;
		}
	}

}
