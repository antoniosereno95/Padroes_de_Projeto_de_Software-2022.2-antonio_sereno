package br.upe.ppsw.jabberpoint.Model;

import java.io.FileNotFoundException;
import org.springframework.util.ResourceUtils;

public class DemoPresentation extends Accessor { // Classe sem erros ate entao

	public void loadFile(Presentation presentation, String unusedFilename) throws FileNotFoundException {

		presentation.setTitle("Apresentação de Demonstração");

		Slide slide;
		slide = new Slide();

		slide.setTitle("JabberPoint");
		slide.appendTextItem(1, "Ferramenta de Apresentação de Slides");
		slide.appendTextItem(2, "Copyright (c) 1996-now: Ian Darwin");
		slide.appendTextItem(2, "Copyright (c) 2021-now:");
		slide.appendTextItem(2, "Helaine Barreiros");
		slide.appendTextItem(4, "JabberPoint execução de demonstração sem arquivos persistidos");
		slide.appendTextItem(4, "exibição de apresentação com dados apenas em memória");
		slide.appendTextItem(1, "Navegação:");
		slide.appendTextItem(3, "Próximo slide: PgDn ou Enter");
		slide.appendTextItem(3, "Slide Anterior: PgUp ou up-arrow");
		slide.appendTextItem(3, "Parar: q ou Q");
		presentation.appendPresentacion(slide);

		slide = new Slide();
		slide.setTitle("Demonstração dos níveis e estilos de uma apresentação");
		slide.appendTextItem(1, "Nível 1");
		slide.appendTextItem(2, "Nível 2");
		slide.appendTextItem(1, "Novamente um item de Nível 1");
		slide.appendTextItem(1, "Nível 1 tem Estilo número 1");
		slide.appendTextItem(2, "Nível 2 tem Estilo número 2");
		slide.appendTextItem(3, "Este é um ítem de Nível 3");
		slide.appendTextItem(4, "E este é um ítem de Nível 4");
		presentation.appendPresentacion(slide);

		slide = new Slide();
		slide.setTitle("Terceiro Slide");
		slide.appendTextItem(1, "Para abrir uma nova apresentação,");
		slide.appendTextItem(2, "utilize o menu File->Open.");
		slide.appendTextItem(1, " ");
		slide.appendTextItem(1, "Fim da Apresentação");
		slide.appendSlideItem(new BitmapItem(1, ResourceUtils.getFile("classpath:JabberPoint.jpg").getAbsolutePath()));
		presentation.appendPresentacion(slide);
	}

	public void saveFile(Presentation presentation, String unusedFilename) {
		throw new IllegalStateException("Não é possível salvar arquivo na versão demo!");
	}

}
