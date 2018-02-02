package mine;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame{
	private Game game;
	
	
	private JPanel panel;
	private final int COLS = 9;
	private final int ROWS = 9;
	private final int IMAGE_SIZE = 50;
	public static void main(String[] args) {
		new JavaSweeper();

	}
	private JavaSweeper() {
		game = new Game(COLS,ROWS);
		setImages();
		initPanel();
		initFrame();
		
		
	}
	
	private void initPanel() {
		
		panel = new JPanel()
		{
			@Override
			protected void paintComponent (Graphics g) {
				super.paintComponents(g);
				for(Coord coord : Ranges.getAllCoords()) {
				
					g.drawImage((Image)game.getBox(coord).image, coord.x*IMAGE_SIZE, coord.y*IMAGE_SIZE, this);
				}
			}
			
		};
		panel.setPreferredSize(new Dimension(Ranges.getSize().x*IMAGE_SIZE , Ranges.getSize().y*IMAGE_SIZE));
		add(panel);
	}
	
	private void initFrame() {
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Java Sweeper");
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setIconImage(getImage("icon"));
		}
	
	private void setImages() {
		for (Box box : Box.values()) {
			box.image = getImage(box.name());
		}
	}
	
	
	private Image getImage(String name) {
		String filename = "res/"+"img/" + name.toLowerCase() + ".png";
		//ImageIcon icon = new ImageIcon (getClass().getResource(filename)); как в мастерклассе, почему то не работает в эклипсе.
		ImageIcon icon = new ImageIcon(filename);
		
		
		
		return icon.getImage();
		
	}
	
}
