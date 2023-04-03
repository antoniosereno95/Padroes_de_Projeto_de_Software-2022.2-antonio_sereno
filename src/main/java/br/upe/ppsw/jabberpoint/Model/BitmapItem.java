package br.upe.ppsw.jabberpoint.Model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.util.ResourceUtils;

import br.upe.ppsw.jabberpoint.View.BitmapItemDraw;
import br.upe.ppsw.jabberpoint.View.Style;

public class BitmapItem extends SlideItem {

	private BufferedImage bufferedImage;
	private String imageName;

	protected static final String FILE = "Arquivo ";
	protected static final String NOTFOUND = " não encontrado";

	public BitmapItem(int level, String name) {
		super(level);

		setImageName(name);

		try {
			bufferedImage = ImageIO.read(new File(getImageName()));
		} catch (IOException e) {
			System.err.println(FILE + getImageName() + NOTFOUND);
		}

		pintor = new BitmapItemDraw();
	}

	public BitmapItem() {
		this(0, null);
	}

	public String toString() {
		return "BitmapItem[" + getLevel() + "," + getImageName() + "]";
	}

	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale) {

	    Style myStyle = Style.getStyle(getLevel());

	    return new Rectangle((int) (myStyle.getIndent() * scale), 0,
	        (int) (bufferedImage.getWidth(observer) * scale),
	        ((int) (myStyle.getLeading() * scale)) + (int) (bufferedImage.getHeight(observer) * scale));
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
  
}
