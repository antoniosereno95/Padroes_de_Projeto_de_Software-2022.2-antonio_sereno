package br.upe.ppsw.jabberpoint.Model;


import java.util.Vector;

public class Slide {
	
	/*
	 * 
	//Essa variaveis estaticas devem ser eliminadas de acordo com a prof(Dica de sala de aula)
	public final static int WIDTH = 1200;
	public final static int HEIGHT = 800;
	*
	*Essa refatoraçao causou erros nos arquivos Slide, textItem e SlideViewerFrame
	*/
	protected TextItem title;
	protected Vector<SlideItem> items;

	public Slide() { // contrutor todo tronxo
		items = new Vector<SlideItem>();
	}

	/*
	 * Esses dois metodos tem nomes repetidos e assinaturas diferentes mas eles
	 * servem para propositos diferentes, nao configurando a situaçao de overload e
	 * por esse motivo os nomes devem ser especificados -> S do solid.
	 * 
	 * public void append(SlideItem anItem) { items.addElement(anItem); }
	 * 
	 * public void append(int level, String message) { append(new TextItem(level,
	 * message)); }
	 * 
	 * Essa refatoraçao causou erros nos arquivos XMLAcessor e no DemoPresentacion
	 */

	public void appendSlideItem(SlideItem anItem) {
		items.addElement(anItem);
	}

	public void appendTextItem(int level, String message) {
		appendSlideItem(new TextItem(level, message));
	}
	
	public TextItem getTitle() {
		return title;
	}
	/*
	 *  O metodo getTitle estava retornando uam string mas o atributo title é um TextItem.
	 *  Mas como o metodo getText() tranforma o title em string, eu decidi manter seu funcionamento
	 *  padrao so que em outro metodo espéficico para retornar uma string
	 *  Principio S do solid Single Responsability
	 *  Utilizei a tatica do Dechamps "se vc nao consegue dar um nome especifco para a funcionalidade do metodo
	 *   ou classe, talvez seja por conta que esse metodo ou classe faz mais de um servico, oq fere o S do solid"
	 */
	
	public String getTitleText() {
		return title.getText();
	}

	public void setTitle(String newTitle) {
		title = new TextItem(0, newTitle);
	}

	public SlideItem getSlideItem(int number) {
		return (SlideItem) items.elementAt(number);
	}

	public Vector<SlideItem> getSlideItems() {
		return items;
	}

	public int getSize() {
		return items.size();
	}

	
	// A classe slide esta delegando aos filhos pra eles se desenharem, e isso é
	// errado.
	/*
	 * Aqui eu transferi o metodo Draw que desenha em tela e deveria estar acloplado a um codigo Slide que desneha em tela,
	 * e a classe que faz isso é a SlideViwerComponent, que é exatamente onde o metodo estava sendo utilizado
	 */
	
}
