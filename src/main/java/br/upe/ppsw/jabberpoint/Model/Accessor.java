package br.upe.ppsw.jabberpoint.Model;

import java.io.IOException;

public abstract class Accessor { //classe abstrata com metodos implementados(essa classe ai com return nela)

  public static final String DEMO_NAME = "Apresentação de Demonstração";
  public static final String DEFAULT_EXTENSION = ".xml";

  public static Accessor getDemoAccessor() {
    return new DemoPresentation();
  }

  public Accessor() {} //classe abstrata

  abstract public void loadFile(Presentation presentation, String fileName) throws IOException;

  abstract public void saveFile(Presentation presentation, String fileName) throws IOException;

}
