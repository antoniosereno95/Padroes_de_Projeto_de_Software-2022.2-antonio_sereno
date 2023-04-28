package br.upe.ppsw.jabberpoint.Controller;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.Model.DemoPresentation;
import br.upe.ppsw.jabberpoint.Model.Presentation;

//INTERFACE TEM Q TA EM UM PACKAGE EXCLUSIVO
public interface AcessorLoad {// Interface Segregacion e tambem Silgle Responsibility

	public static final String DEMO_NAME = "Apresentação de Demonstração";
	public static final String DEFAULT_EXTENSION = ".xml";

	public void loadFile(Presentation presentation, String fileName) throws IOException;
}
