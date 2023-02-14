package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.View.Style;

public class BitmapItem extends SlideItem {

  private BufferedImage bufferedImage;
  private String imageName;

  protected static final String FILE = "Arquivo ";
  protected static final String NOTFOUND = " não encontrado";

  public BitmapItem(int level, String name) { //construtor
    super(level);

    imageName = name;

    try {
      bufferedImage = ImageIO.read(ResourceUtils.getFile(imageName).getAbsoluteFile());
    } catch (IOException e) {
      System.err.println(FILE + imageName + NOTFOUND);
    }

  }

  public BitmapItem() { //Segundo construtor?
    this(0, null);
  }

  public String getName() {
    return imageName;
  }

  public String toString() {
    return "BitmapItem[" + getLevel() + "," + imageName + "]";
  }
  
  
  

  //------> Daqui pra baixo o codigo faz alteraçoes em tela, e deve ser colocado em um outro arquivo dentro do pacote VIEW
  Style myStyle ;
  public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) { 
	  //pra resolver o problema aqui do acesso aos metodos da classe Style, ou muda a visibilidade da propriedade(nao recomendado),
	  //ou entao faz os metodos get and set de todas as propriedades de todas as classes necessarias e reescreve o codigo com sua 
	  //versao get alguma coisa
    return new Rectangle((int) (myStyle.getIndent() * scale), 0,
        (int) (bufferedImage.getWidth(observer) * scale),
        ((int) (myStyle.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
  }

  public void draw(int x, int y, float scale, Graphics g, Style myStyle, ImageObserver observer) {
    int width = x + (int) (myStyle.getIndent() * scale);
    int height = y + (int) (myStyle.getLeading() * scale);

    g.drawImage(bufferedImage, width, height, (int) (bufferedImage.getWidth(observer) * scale),
        (int) (bufferedImage.getHeight(observer) * scale), observer);
  }

}
