package br.upe.ppsw.jabberpoint.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import br.upe.ppsw.jabberpoint.Model.Presentation;


//notar que no programa rodando, as keys mapeadas pra sair e pra ajuda soa a mesma CRTL + Shft, tem que arrumar isso ai.
public class KeyController extends KeyAdapter {

  private Presentation presentation;

  public KeyController(Presentation p) {
    presentation = p;
  }

  public void keyPressed(KeyEvent keyEvent) {
    switch (keyEvent.getKeyCode()) {
      case KeyEvent.VK_PAGE_DOWN:
      case KeyEvent.VK_DOWN:
      case KeyEvent.VK_ENTER:
      case '+':
        presentation.nextSlide();
        break;
      case KeyEvent.VK_PAGE_UP:
      case KeyEvent.VK_UP:
      case '-':
        presentation.prevSlide();
        break;
      case 'q':
      case 'Q':
        System.exit(0);
        break; // fix?
      default:
        break;
    }
  }

}

