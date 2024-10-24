package uk.org.okapibarcode.backend;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.jupiter.api.Test;
import uk.org.okapibarcode.graphics.Color;
import uk.org.okapibarcode.output.Java2DRenderer;

/**
 * @author Ayakura Yuki
 * @date 2024/05/19-15:11
 */
public class Code49Test {

    @Test
    public void testEncode() throws IOException {
        Code49 code49 = new Code49();
        code49.setContent("overcontact binary");
        System.out.println(code49.getEncodeInfo());

        BufferedImage image = new BufferedImage(code49.getWidth(), code49.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Java2DRenderer renderer = new Java2DRenderer(g2d, 1, Color.WHITE, Color.BLACK);
        renderer.render(code49);
        ImageIO.write(image, "png", new File("src/test/resources/test.png"));
    }

}
