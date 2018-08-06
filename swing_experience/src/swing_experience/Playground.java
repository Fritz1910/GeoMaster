package swing_experience;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class Playground extends JFrame {

	// Variable
	int level = 1;
	String[] list = {"Dresden", "Pirna", "Meißen", "Chemnitz", "Zwickau"};

	// TODO exception if picture not found + picture in project directory
	ImageIcon icon = new ImageIcon("C:\\Users\\christoph.herrmann\\Documents\\Informatics\\Geomaster\\MapGERv1.png",
			"a pretty but meaningless splat");

	public Playground() { // Constructor

		final JLabel labLev = new JLabel(Integer.toString(this.level));
		final JLabel labCity = new JLabel("Gesuchte Stadt: " + this.list[0]);

		final JLabel label1 = new JLabel("Image and Text", this.icon, SwingConstants.LEFT);
		label1.setLocation(30, 40);

		// GUI
		setTitle("Unsre GUI");
		setLocationRelativeTo(null);
		setSize(400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Buttons
		final JButton cbutton = new JButton("Weiter");
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
		pane.add(cbutton);
		pane.add(mbutton);
		pane.add(labLev);
		pane.add(labCity);
		pane.add(label1);

	}

	int getLevel() { // Getter
		return this.level;
	}

	void setLevel(final int level) { // Setter
		this.level = level;

	}

}
