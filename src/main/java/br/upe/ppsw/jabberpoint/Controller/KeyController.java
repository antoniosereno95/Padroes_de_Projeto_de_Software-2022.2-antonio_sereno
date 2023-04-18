package br.upe.ppsw.jabberpoint.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.Model.Presentation;
import br.upe.ppsw.jabberpoint.View.SlideViewerComponent;


//notar que no programa rodando, as keys mapeadas pra sair e pra ajuda soa a mesma CRTL + Shft, tem que arrumar isso ai.
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
      case '+':
        presentation.nextSlide();
        this.slideViewerComponent.update();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case '-':
        presentation.prevSlide();
        this.slideViewerComponent.update();
        break;
      case KeyEvent.VK_ESCAPE:
        System.exit(0);
        break; //mudei a tecla de sair, esc é bem melhor
      default:
        break;
    }
  }

}

