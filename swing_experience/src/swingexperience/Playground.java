package swingexperience;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Class for running game frame
 *
 * @author christoph.herrmann
 */
public class Playground extends JFrame {

	// Graphic elements
	private final JButton button1;
	private final JButton button2;
	private final JLabel labLev;
	private final JLabel labLocX;
	private final JLabel labLocY;
	private final JLabel labCity;
	private final JLabel labDistance;

	// Variables
	private int level = 1;
	private double locX = 0;
	private double locY = 0;
	private final double distance = 0;
	private City city = null;

	// IMAGES on icons
	// TODO exception if picture not found

	/**
	 * Constructor for Playground frame
	 *
	 * @author christoph.herrmann
	 */
	public Playground() { // Constructor

		this.city = new City("Dresden", 12, 12);
		// this.distance = distanceCalculation(this.locX, this.locY,
		// this.city.getCityLocX(), this.city.getCityLocY());

		// GUI
		setTitle("GeoMaster");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// setResizable(false);

		// Menu bar
		final JMenuBar menu = new JMenuBar();
		final JMenu datei = new JMenu("Datei");
		final JMenu submenu = new JMenu("Submenu");
		final JMenuItem item1 = new JMenuItem("ich bin im sub");
		final JMenuItem abo = new JMenuItem("Link");

		submenu.add(item1);
		datei.add(submenu);
		datei.add(abo);
		datei.addSeparator();
		menu.add(datei);
		setJMenuBar(menu);

		// Labels
		this.labLev = new JLabel("Level: " + Integer.toString(this.level));
		this.labLocX = new JLabel("X: " + Double.toString(this.locX));
		this.labLocY = new JLabel("Y: " + Double.toString(this.locY));
		this.labCity = new JLabel("Gesuchte Stadt: " + this.city.getName());
		this.labDistance = new JLabel("Abstand: " + Double.toString(this.distance));

		// create the buttons
		this.button1 = new JButton("Weiter");
		this.button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel(getLevel() + 1);// set Variable on level higher
				// set label to display new variable from level
				Playground.this.labLev.setText("Level: " + Integer.toString(Playground.this.level));
				// reset coordinates and its labels
				// TODO 0 is no optimal default for "no location selected", better idea? +
				// exception needed if no location is selected + field for its message OR
				// continue button is already free if location is selected
				setLocX(0);
				setLocY(0);
				Playground.this.labLocX.setText("X: " + Double.toString(Playground.this.locX));
				Playground.this.labLocY.setText("Y: " + Double.toString(Playground.this.locY));

			}
		});

		this.button2 = new JButton("Hauptmenü");
		this.button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final MainFrame m = new MainFrame();
				m.setVisible(true); // makes Playground-frame visible
				dispose(); // destroys current frame
			}
		});

		// load the background image and override the paint method of the panel
		// draw pictures (background and map) in panel
		final ImageIcon background = new ImageIcon(getClass().getResource("/Hintergrund_v1_1400x900.png"));

		final JPanel panel = new JPanel() {// create panel
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(background.getImage(), 0, 0, null);
			}
		};

		// the preferred size of the panel comes from the background image
		panel.setPreferredSize(new Dimension(background.getIconWidth(), background.getIconHeight()));

		// set a layout to the panel and add the buttons with layout information
		// each in one cell, horizontally the same size
		panel.setLayout(new GridBagLayout());

		// separate label for map
		final ImageIcon map = new ImageIcon(getClass().getResource("/MapGERv1.png"));
		final JLabel mapLabel = new JLabel(map);
		final ImageIcon pin = new ImageIcon(getClass().getResource("/Pin.png"));
		mapLabel.add(pin);

		panel.add(mapLabel, new GridBagConstraints(0, 0, 1, 5, 0.0, 0.0, GridBagConstraints.NORTH,
				GridBagConstraints.NONE, new Insets(8, 8, 8, 8), 0, 0));

		panel.add(this.labLev, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(8, 8, 8, 8), 0, 0));
		panel.add(this.labLocX, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(8, 8, 8, 8), 0, 0));
		panel.add(this.labCity, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(8, 8, 8, 8), 0, 0));

		panel.add(this.button1, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(8, 8, 8, 8), 0, 0));
		panel.add(this.button2, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(8, 8, 8, 8), 0, 0));

		// panel.add(this.labLocY);
		// panel.add(this.labDistance);

		mapLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				final int x = e.getX();
				final int y = e.getY();
				// System.out.println(x + "," + y);// console

				setLocX(x);// set variable with new cordinate
				setLocY(y);
				// set label with new coordinate from locX
				/*
				 * //TODO condition to keep coordinates on map: if x or y is higher/lower
				 * than ... (= out of map) then stay at coordinates before
				 */
				Playground.this.labLocX.setText("X: " + Double.toString(Playground.this.locX));
				Playground.this.labLocY.setText("Y: " + Double.toString(Playground.this.locY));
				// TODO set distance
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// set a layout in the frame and add the panel (with buttons)
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);

		// let Swing size the frame
		pack();

	}

	// METHODES
	int getLevel() { // Getter
		return this.level;
	}

	void setLevel(final int level) { // Setter
		this.level = level;
	}

	double getlocX() { // Getter
		return this.locX;
	}

	void setLocX(final int locX) { // Setter
		this.locX = locX;
	}

	double getlocY() { // Getter
		return this.locY;
	}

	void setLocY(final int locY) { // Setter
		this.locY = locY;
	}

	/**
	 * Method to calculate distance between city location and actual mouse click location.
	 * Calculation based on pythogoras.
	 *
	 * @author christoph.herrmann
	 */
	static double distanceCalculation(double locX, double locY, double cityLocX, double cityLocY) {
		final double deltaX = Math.abs(locX - cityLocX);
		final double deltaY = Math.abs(locY - cityLocY);
		final double distance = Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
		return distance;

	}

}
