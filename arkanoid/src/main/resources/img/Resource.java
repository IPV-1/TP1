package img;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import com.uqbar.vainilla.appearances.Sprite;
import com.uqbar.vainilla.exceptions.GameException;

public class Resource {

	public static Sprite getSprite(String fileName) {
		return Resource.getSprite(".", fileName);
	}
	
	/**
	 * filePackage needs to be inside Resource's package.
	 * If there is more than one level of packages, it needs to be written as
	 * package/subPackage
	 */
	public static Sprite getSprite(String filePackage, String fileName) {
		BufferedImage image;
		String filePath;
		filePath = filePackage + "/" + fileName;
		try {
			image = ImageIO.read(Resource.class.getResource(filePath));
		}
		catch(Exception e) {
			throw new GameException("The resource '" + filePath + "' was not found");
		}

		return new Sprite(image);
	}
	
}
