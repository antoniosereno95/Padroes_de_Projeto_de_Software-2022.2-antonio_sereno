package br.upe.ppsw.jabberpoint.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

import javax.swing.JComponent;
import javax.swing.JFrame;

import br.upe.ppsw.jabberpoint.Model.Presentation;
import br.upe.ppsw.jabberpoint.Model.Slide;
import br.upe.ppsw.jabberpoint.Model.SlideItem;

public class SlideViewerComponent extends JComponent {
	
	private static final long serialVersionUID = 227L;
	private static final Color BGCOLOR = Color.white;
	private static final Color COLOR = Color.black;
	private static final String FONTNAME = "Dialog";
	private static final int FONTSTYLE = Font.BOLD;
	private static final int FONTHEIGHT = 10;
	private static final int XPOS = 1100;
	private static final int YPOS = 20;

	private Slide slide;
	private Font labelFont = null;
	private Presentation presentation = null;
	private JFrame frame = null;

	public SlideViewerComponent(Presentation pres, JFrame frame) {
		setBackground(BGCOLOR);
		this.presentation = pres;
		this.labelFont = new Font(FONTNAME, FONTSTYLE, FONTHEIGHT);
		this.frame = frame;
	}

	public void update() { 
		this.slide = presentation.getCurrentSlide();
		
		repaint();
		frame.setTitle(presentation.getTitle());
	}
	
	private float getScale(Rectangle area) {
		return Math.min(((float) area.width) / ((float) 1200.0), ((float) area.height) / ((float) 800.0));
	}

	public void paintComponent(Graphics g) {
		g.setColor(BGCOLOR);
		g.fillRect(0, 0, getSize().width, getSize().height);

		if (presentation.getSlideNumber() < 0 || slide == null) {
			return;
		}

		g.setFont(labelFont);
		g.setColor(COLOR);
		g.drawString("Slide " + (1 + presentation.getSlideNumber()) + " of " + presentation.getSize(), XPOS, YPOS);

		Rectangle area = new Rectangle(0, YPOS, getWidth(), (getHeight() - YPOS));

		SlidePintor slidePintor = new SlidePintor(slide);

		slidePintor.draw(g, area, this);
	}
	
}
