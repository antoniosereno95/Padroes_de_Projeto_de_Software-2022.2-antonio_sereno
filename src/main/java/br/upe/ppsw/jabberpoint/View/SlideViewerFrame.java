package br.upe.ppsw.jabberpoint.View;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import br.upe.ppsw.jabberpoint.Controller.KeyController;
import br.upe.ppsw.jabberpoint.Controller.MenuController;
import br.upe.ppsw.jabberpoint.Model.Presentation;

public class SlideViewerFrame extends JFrame {

	private static final long serialVersionUID = 3227L;

	private static final String JABTITLE = "Jabberpoint 1.6";

	public SlideViewerFrame(String title, Presentation presentation) {
		super(title);

		SlideViewerComponent slideViewerComponent = new SlideViewerComponent(presentation, this);

		setupWindow(slideViewerComponent, presentation);
		slideViewerComponent.update();
	}

	public void setupWindow(SlideViewerComponent slideViewerComponent, Presentation presentation) {
		setTitle(JABTITLE);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		getContentPane().add(slideViewerComponent);
		addKeyListener(new KeyController(presentation));
		setMenuBar(new MenuController(this, presentation, slideViewerComponent));
		setSize(new Dimension(1200, 800));

		setVisible(true);
	}

}
