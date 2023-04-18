package br.upe.ppsw.jabberpoint.Controller;

import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.Model.Accessor;
import br.upe.ppsw.jabberpoint.Model.Presentation;
import br.upe.ppsw.jabberpoint.View.SlideViewerComponent;

public class MenuController extends MenuBar {

	private static final long serialVersionUID = 227L;

	private Frame parent;
	private Presentation presentation;
	private SlideViewerComponent slideViewerComponent;

	protected static final String ABOUT = "Sobre";
	protected static final String FILE = "Arquivo";
	protected static final String EXIT = "Sair";
	protected static final String GOTO = "Pular para";
	protected static final String HELP = "Ajuda";
	protected static final String NEW = "Novo";
	protected static final String NEXT = "Próximo";
	protected static final String OPEN = "Abrir";
	protected static final String PAGENR = "Número do Slide?";
	protected static final String PREV = "Anterior";
	protected static final String SAVE = "Salvar";
	protected static final String VIEW = "Visualizar";

	protected static final String TESTFILE = "classpath:test.xml";
	protected static final String SAVEFILE = "classpath:dump.xml";

	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Erro ao carregar";
	protected static final String SAVEERR = "Erro ao salvar";

	// fui obrigado a ja inicializar um SVC aqui, ja que antes era o Presentacion
	// que inicalizava ele quando ia se desnehar em tela
	public MenuController(Frame frame, Presentation pres, SlideViewerComponent svc) {
		this.parent = frame;
		this.presentation = pres;
		this.slideViewerComponent = svc;

		MenuItem menuItem;

		Menu fileMenu = new Menu(FILE);
		fileMenu.add(menuItem = mkMenuItem(OPEN));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();

				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.loadFile(presentation, ResourceUtils.getFile(TESTFILE).getAbsolutePath());
					presentation.setSlideNumber(0);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IOEX + exc, LOADERR, JOptionPane.ERROR_MESSAGE);
				}

				parent.repaint();
			}
		});

		fileMenu.add(menuItem = mkMenuItem(NEW));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.clear();
				parent.repaint();
			}
		});

		fileMenu.add(menuItem = mkMenuItem(SAVE));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Accessor xmlAccessor = new XMLAccessor();
				try {
					xmlAccessor.saveFile(presentation, SAVEFILE);
				} catch (IOException exc) {
					JOptionPane.showMessageDialog(parent, IOEX + exc, SAVEERR, JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		fileMenu.addSeparator();

		fileMenu.add(menuItem = mkMenuItem(EXIT));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				System.exit(0);
			}
		});

		add(fileMenu);

		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(menuItem = mkMenuItem(NEXT));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.nextSlide();
				slideViewerComponent.update();
			}
		});

		viewMenu.add(menuItem = mkMenuItem(PREV));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				presentation.prevSlide();
				slideViewerComponent.update();
			}
		});

		viewMenu.add(menuItem = mkMenuItem(GOTO));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				String pageNumberStr = JOptionPane.showInputDialog((Object) PAGENR);
				int pageNumber = Integer.parseInt(pageNumberStr);
				if (pageNumber > 0 && pageNumber <= presentation.getSize()) {
					presentation.setSlideNumber(pageNumber - 1);
					slideViewerComponent.update();
				} else {
					JOptionPane.showMessageDialog(parent, "Não é possível acessar o slide solicitado.", "Ação inválida",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		add(viewMenu);

		Menu helpMenu = new Menu(HELP);
		helpMenu.add(menuItem = mkMenuItem(ABOUT));

		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				 JOptionPane.showMessageDialog(parent,
					        "JabberPoint é um programa de apresentação de slides básico escrito em Java(tm).\n"
					            + "Ele é disponibilizado como uma cópia livre desde que você mantenha esta informação de splash screen intacta.\n"
					            + "Copyright (c) 1995-now by Ian F. Darwin, ian@darwinsys.com.\n"
					            + "Adaptada por Helaine Barreiros fpara Universidade de Pernambuco, 2021 -- now.\n"
					            + "A cópia original do autor está disponível em http://www.darwinsys.com/",
					        "Sobre JabberPoint", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		setHelpMenu(helpMenu);
	}

	public MenuItem mkMenuItem(String name) {
		return new MenuItem(name);
	}
}
