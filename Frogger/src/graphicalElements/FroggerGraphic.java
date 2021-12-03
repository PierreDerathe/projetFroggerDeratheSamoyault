package graphicalElements;

import gameCommons.IFrog;
import util.Direction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import java.util.ArrayList;

public class FroggerGraphic extends JPanel implements IFroggerGraphics, KeyListener {
	private ArrayList<Element> elementsToDisplay;
	private int pixelByCase = 16;
	private int width;
	private int height;
	private IFrog frog;
	private JFrame frame;

	private int timeLeft = 60;

	private String bestScoreFileName = "BestScore.txt";
	private int score = 0;
	private int bestScore = 0;

	private String optionsFileName = "Options.txt";

	BufferedImage colorLane = null;
	BufferedImage colorRoad = null;

	JTextField field = new JTextField();
	JTextField timeField = new JTextField();



	public FroggerGraphic(int width, int height) {
		this.width = width;
		this.height = height;
		elementsToDisplay = new ArrayList<>();

		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(width * pixelByCase, height * pixelByCase));

		JFrame frame = new JFrame("Frogger");
		this.frame = frame;


		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(this);


	}

	public void reset(){
		elementsToDisplay.clear();
		frame.getContentPane().add(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//on essaye de mettre un meilleur rendu graphique
		Graphics2D newGraphism = (Graphics2D) g;
		for (int i = 0; i < height; i++) {
			newGraphism.drawImage(colorRoad, 0, i * pixelByCase, 26 * pixelByCase, pixelByCase, null);
		}
		newGraphism.drawImage(colorLane, 0, (height - 1) * pixelByCase, 26 * pixelByCase, pixelByCase, null);
		for (Element e : elementsToDisplay) {
			g.setColor(e.color);
			g.fillRect(pixelByCase * e.absc, pixelByCase * (height - 1 - e.ord), pixelByCase, pixelByCase - 1);
			Graphics2D newG= (Graphics2D) g;
			//newG.drawImage(e.sprite, pixelByCase*e.absc,pixelByCase*(height-1-e.ord), pixelByCase, pixelByCase,null);
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			frog.move(Direction.up);
			break;
		case KeyEvent.VK_DOWN:
			frog.move(Direction.down);
			break;
		case KeyEvent.VK_LEFT:
			frog.move(Direction.left);
			break;
		case KeyEvent.VK_RIGHT:
			frog.move(Direction.right);
			break;
		case KeyEvent.VK_SPACE:
			frog.launchReset();
		}
	}

	public void clear() {
		this.elementsToDisplay.clear();
	}


	public void add(Element e) {
		this.elementsToDisplay.add(e);
	}

	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	public void endGameScreen(String s) {
		frame.remove(this);
		JLabel label = new JLabel(s);
		label.setFont(new Font("Verdana", 1, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setSize(this.getSize());
		frame.getContentPane().removeAll();
		frame.getContentPane().add(label);
		frame.repaint();

	}

}
