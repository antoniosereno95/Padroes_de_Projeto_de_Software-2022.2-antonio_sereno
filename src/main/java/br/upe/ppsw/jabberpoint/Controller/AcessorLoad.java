package br.upe.ppsw.jabberpoint.Controller;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.Model.DemoPresentation;
import br.upe.ppsw.jabberpoint.Model.Presentation;

public interface AcessorLoad {//Interface Segregacion e tambem Silgle Responsibility
	
	public static final String DEMO_NAME = "Apresentação de Demonstração";
	public static final String DEFAULT_EXTENSION = ".xml";

	public static Accessor getDemoAccessor() {
		return new DemoPresentation();
	}

	public void loadFile(Presentation presentation, String fileName) throws IOException;
}
