import javax.swing.JOptionPane;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageDisplay extends JPanel {

	public String imagePath = "loading.gif";

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
		this.repaint();
	}

	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage(imagePath);
		g.drawImage(i, 0, 0, this);
	}

}