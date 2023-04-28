package br.upe.ppsw.jabberpoint.Controller;

import java.io.IOException;

import br.upe.ppsw.jabberpoint.Model.Presentation;

//INTERFACE TEM Q TA EM UM PACKAGE EXCLUSIVO
public interface AcessorSave {// Interface Segregacion e tambem Silgle Responsibility

	public void saveFile(Presentation presentation, String fileName) throws IOException;
}
