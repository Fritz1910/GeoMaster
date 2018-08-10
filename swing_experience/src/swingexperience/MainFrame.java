package swingexperience;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

/**
 * @author christoph.herrmann
 *
 */
public class MainFrame extends JFrame {

	private final JButton button1;
	private final JButton button2;

	/**
	 * Main Class
	 *
	 * @author christoph.herrmann
	 *
	 */
	public static void main(String[] args) {
		// set the look and feel to the operating system
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		// create and show the main frame
		final MainFrame frame = new MainFrame();
		frame.setVisible(true);
	}

	/**
	 * Constructor for MainFrame
	 *
	 * @author christoph.herrmann
	 *
	 */
	public MainFrame() {
		// configure the main frame
		setTitle("GeoMaster");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setResizable(false);

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

		// create the buttons
		this.button1 = new JButton("Spiel Starten");
		this.button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // Actions after pressing Button:
				final Playground pg = new Playground(); // builds a Playground frame
				pg.setVisible(true); // makes Playground-frame visible
				dispose(); // destroys current frame
			}
		});
		this.button2 = new JButton("Beenden");
		this.button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// load the background image and override the paint method of the panel
		final ImageIcon background = new ImageIcon(getClass().getResource("/Hintergrund_v1_400x400.png"));
		final JPanel panel = new JPanel() {
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
		panel.add(this.button1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(8, 8, 8, 8), 0, 0));
		panel.add(this.button2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(8, 8, 8, 8), 0, 0));

		// set a layout in the frame and add the panel (with buttons)
		setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);

		// let Swing size the frame
		pack();
	}

}