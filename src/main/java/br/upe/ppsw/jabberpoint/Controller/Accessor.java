package br.upe.ppsw.jabberpoint.Controller;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.Model.DemoPresentation;
import br.upe.ppsw.jabberpoint.Model.Presentation;

//Essa classe aqui pode virar uma interface depois, ja que os seus metodos sao abstratos e precisao sem implementados quando instacianda em outro local
public abstract class Accessor { //classe abstrata com metodos implementados(essa classe ai com return nela)**(mas é estatica)

  public static final String DEMO_NAME = "Apresentação de Demonstração";
  public static final String DEFAULT_EXTENSION = ".xml";

//  public static Accessor getDemoAccessor() {
//    return new DemoPresentation();
//  }

  public Accessor() {} //classe abstrata

  abstract public void loadFile(Presentation presentation, String fileName) throws IOException;

  abstract public void saveFile(Presentation presentation, String fileName) throws IOException;

}
