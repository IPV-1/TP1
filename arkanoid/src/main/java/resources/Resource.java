package resources;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.exceptions.GameException;

public class Resource {

	public static Sprite getSprite(String fileName) {
		BufferedImage image;

		try {
			image = ImageIO.read(Resource.class.getResource(fileName));
		}
		catch(Exception e) {
			throw new GameException("The resource '" + fileName + "' was not found");
		}

		return new Sprite(image);
	}
	
}
