package mine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class JavaSweeper extends JFrame{
	private Game game;
	
	
	private JPanel panel;
	private JLabel lable;
	private final int COLS = 9;
	private final int ROWS = 9;
	private final int BOMBS = 10;
	private final int IMAGE_SIZE = 50;
	public static void main(String[] args) {
		new JavaSweeper();

	}
	private JavaSweeper() {
		game = new Game(COLS,ROWS, BOMBS);
		game.start();
		setImages();
		initLable();
		initPanel();
		initFrame();
			}
	
	private void initLable() {
		lable = new JLabel("Welcom");
		add(lable, BorderLayout.SOUTH);
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
		
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX() / IMAGE_SIZE;
				int y = e.getY() / IMAGE_SIZE;
				Coord coord = new Coord(x,y);
				if(e.getButton()==MouseEvent.BUTTON1)
					game.pressLeftButton(coord);
				if(e.getButton()==MouseEvent.BUTTON3)
					game.pressRightButton(coord);
				if(e.getButton()==MouseEvent.BUTTON2)
					game.start();
				lable.setText(getMessage());
				panel.repaint();
			}
			
		});
		panel.setPreferredSize(new Dimension(Ranges.getSize().x*IMAGE_SIZE , Ranges.getSize().y*IMAGE_SIZE));
		add(panel);
	}
	
	private String getMessage() {
		switch(game.getState()) {
		case PLAYED: return "Think twice";
		case BOMBER: return "You LOSE!";
		case WINNER: return "Winner, winner yeap!!!";
		default :return null;
		}
		
	}
	private void initFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Java Sweeper");
		setResizable(false);
		setVisible(true);
		setIconImage(getImage("icon"));
		pack();
		setLocationRelativeTo(null);
		}
	
	private void setImages() {
		for (Box box : Box.values()) {
			box.image = getImage(box.name());
		}
	}
	
	
	private Image getImage(String name) {
		String filename = "img/" + name.toLowerCase() + ".png";
		//ImageIcon icon = new ImageIcon (getClass().getResource(filename)); как в мастерклассе, почему то не работает в эклипсе.
		ImageIcon icon = new ImageIcon(filename);
		
		
		
		return icon.getImage();
		
	}
	
}
