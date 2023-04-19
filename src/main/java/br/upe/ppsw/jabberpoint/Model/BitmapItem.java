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

	public BitmapItem(int level, String name) { 
		super(level);

		setImageName(name);

		try {
			bufferedImage = ImageIO.read(ResourceUtils.getFile(imageName).getAbsoluteFile());
		} catch (IOException e) {
			System.err.println(FILE + getImageName() + NOTFOUND);
		}

	}

	public BitmapItem() { 
		this(0, null);
	}

	public String getName() {
		return imageName;
	}

	public String toString() {
		return "BitmapItem[" + getLevel() + "," + getImageName() + "]";
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

	public static String getFile() {
		return FILE;
	}

	public static String getNotfound() {
		return NOTFOUND;
	}

	public Rectangle getBoundingBox(Graphics g, ImageObserver observer, float scale, Style myStyle) {

		return new Rectangle((int) (myStyle.getIndent() * scale), 0,
				(int) (getBufferedImage().getWidth(observer) * scale),
				((int) (myStyle.getLeading() * scale)) + (int) (getBufferedImage().getHeight(observer) * scale));
	}

}
