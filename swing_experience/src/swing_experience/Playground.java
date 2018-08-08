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
import javax.swing.JTextField;

public class Playground extends JFrame {

	// Variable
	int level = 1;
	int locX = 0;
	int locY = 0;
	String[] list = {"Dresden", "Pirna", "Meißen", "Chemnitz", "Zwickau"};

	// TODO exception if picture not found + picture in project directory
	ImageIcon icon1 = new ImageIcon("C:\\Users\\christoph.herrmann\\Documents\\Informatics\\Geomaster\\MapGERv1.png");

	ImageIcon icon2 = new ImageIcon(
			"C:\\Users\\christoph.herrmann\\Documents\\Informatics\\Geomaster\\Hintergrund_v1_1400x900.png");

	final JTextField loctext = new JTextField();

	public Playground() { // Constructor

		// GUI
		setTitle("Unsre GUI");
		setLocationRelativeTo(null);
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Labels
		final JLabel labLev = new JLabel(Integer.toString(this.level));
		final JLabel labLocX = new JLabel("X: " + Integer.toString(this.locX));
		final JLabel labLocY = new JLabel("Y: " + Integer.toString(this.locY));
		final JLabel labCity = new JLabel("Gesuchte Stadt: " + this.list[0]);

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
				setLevel(getLevel() + 1);
				labLev.setText(Integer.toString(Playground.this.level));
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
		pane.add(this.loctext);
		pane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				final int x = e.getX();
				final int y = e.getY();
				Playground.this.loctext.setText("X:" + x + " Y:" + y);
				System.out.println(x + "," + y);
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

	int getlocX() { // Getter
		return this.locX;
	}

	void setLocX(final int locX) { // Setter
		this.locX = locX;
	}

	int getlocY() { // Getter
		return this.locY;
	}

	void setLocY(final int locY) { // Setter
		this.locY = locY;
	}

}
