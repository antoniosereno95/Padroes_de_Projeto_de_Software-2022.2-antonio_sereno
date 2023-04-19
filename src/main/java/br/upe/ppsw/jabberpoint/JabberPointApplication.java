package br.upe.ppsw.jabberpoint;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import br.upe.ppsw.jabberpoint.Controller.AcessorLoad;
import br.upe.ppsw.jabberpoint.Controller.XMLAccessor;
import br.upe.ppsw.jabberpoint.Model.Presentation;
import br.upe.ppsw.jabberpoint.View.SlideViewerFrame;
import br.upe.ppsw.jabberpoint.View.Style;
import br.upe.ppsw.jabberpoint.Model.PresentationOK;
import br.upe.ppsw.jabberpoint.Model.PresentationDemo;

@SpringBootApplication
public class JabberPointApplication implements CommandLineRunner {

	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 -";

	public static void main(String[] argv) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(JabberPointApplication.class);
		builder.headless(false);
		builder.web(WebApplicationType.NONE);
		builder.run(argv);
	}

	@Override
	public void run(String... args) throws Exception {
		Style.createStyles();

		Presentation presentation; //Utilização do Padrao Null Object
		AcessorLoad loader = new XMLAccessor(); //Utilização padrao do Factory Method

		// new SlideViewerFrame(JABVERSION, presentation);

		try {
			if (args.length > 1) {
				presentation = new PresentacionOK();
				loader.loadFile(presentation, args[1]);
			} else {
				presentation = new PresentationDemo();
				loader.loadFile(presentation, "");
			} 
			
			presentation.setSlideNumber(0);
			new SlideViewerFrame(JABVERSION, presentation);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, IOERR + ex, JABERR, JOptionPane.ERROR_MESSAGE);
		}
	}

}
