package swing_experience;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;

public class Playground extends JFrame {

	// Variables
	int level = 1;
	double locX = 0;
	double locY = 0;
	double distance = 0;
	private City city = null;

	// IMAGES on icons
	// TODO exception if picture not found
	ImageIcon icon1 = new ImageIcon(this.getClass().getResource("/MapGERv1.png"));
	ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/Hintergrund_v1_1400x900.png"));

	public Playground() { // Constructor

		this.city = new City("Dresden", 12, 12);
		this.distance = distanceCalculation(this.locX, this.locY, this.city.getCityLocX(), this.city.getCityLocY());

		// GUI
		setTitle("GeoMaster");
		setLocationRelativeTo(null);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Labels
		final JLabel labLev = new JLabel("Level: " + Integer.toString(this.level));
		final JLabel labLocX = new JLabel("X: " + Double.toString(this.locX));
		final JLabel labLocY = new JLabel("Y: " + Double.toString(this.locY));
		final JLabel labCity = new JLabel("Gesuchte Stadt: " + this.city.getName());
		final JLabel labDistance = new JLabel("Abstand: " + Double.toString(this.distance));

		final JLabel label1 = new JLabel(this.icon1);
		label1.setLocation(0, 0);
		final JLabel label2 = new JLabel(this.icon2);
		label1.setLocation(0, 0);

		// Buttons
		final JButton cbutton = new JButton("Weiter");
		cbutton.setSize(12, 12);
		cbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setLevel(getLevel() + 1);// set Variable on level higher
				// set label to display new variable from level
				labLev.setText("Level: " + Integer.toString(Playground.this.level));
				// reset coordinates and its labels
				// TODO 0 is no optimal default for "no location selected", better idea? +
				// exception needed if no location is selected + field for its message OR
				// continue button is already free if location is selected
				setLocX(0);
				setLocY(0);
				labLocX.setText("X: " + Double.toString(Playground.this.locX));
				labLocY.setText("Y: " + Double.toString(Playground.this.locY));

			}
		});

		final JButton mbutton = new JButton("Hauptmenü");
		mbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				final Menu m = new Menu();
				m.setVisible(true); // makes Playground-frame visible
				dispose(); // destroys current frame
			}
		});

		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		final JScrollPane sp = new JScrollPane();
		final JList<String> font_list = new JList<>(ge.getAvailableFontFamilyNames());
		sp.setViewportView(font_list);

		// Menubar
		final JMenuBar menu = new JMenuBar();
		final JMenu datei = new JMenu("Datei");
		final JMenu submenu = new JMenu("Submenu");
		final JMenuItem item1 = new JMenuItem("ich bin im sub");
		final JMenuItem abo = new JMenuItem("Abonniert mich =)");

		submenu.add(item1);
		datei.add(submenu);
		datei.add(abo);
		datei.addSeparator();
		menu.add(datei);
		setJMenuBar(menu);

		// Layout
		final Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		// pane.add(label2);
		// pane.add(label1);
		pane.add(cbutton);
		pane.add(mbutton);
		pane.add(labLev);
		pane.add(labLocX);
		pane.add(labLocY);
		pane.add(labCity);
		pane.add(labDistance);
		pane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				final int x = e.getX();
				final int y = e.getY();
				System.out.println(x + "," + y);// console

				setLocX(x);// set variable with new cordinate
				setLocY(y);
				// set label with new coordinate from locX
				/*
				 * //TODO condition to keep coordinates on map: if x or y is higher/lower
				 * than ... (= out of map) then stay at coordinates before
				 */
				labLocX.setText("X: " + Double.toString(Playground.this.locX));
				labLocY.setText("Y: " + Double.toString(Playground.this.locY));

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

	}

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

	static double distanceCalculation(double locX, double locY, double cityLocX, double cityLocY) {
		final double deltaX = Math.abs(locX - cityLocX);
		final double deltaY = Math.abs(locY - cityLocY);
		final double distance = Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
		return distance;

	}

}
