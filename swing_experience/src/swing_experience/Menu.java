package swing_experience;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Menu extends JFrame {

	ImageIcon icon = new ImageIcon(this.getClass().getResource("/Hintergrund_v1_400x400.png"));

	final JLabel label1 = new JLabel("Image and Text", this.icon, SwingConstants.CENTER);

	public Menu() {
		// GUI
		setTitle("Unsre GUI");
		setLocationRelativeTo(null);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Buttons
		final JButton ebutton = new JButton("Ende");
		ebutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				final JFileChooser filechooser = new JFileChooser();
				final FileFilter filter = new FileNameExtensionFilter("Images", "png");
				filechooser.addChoosableFileFilter(filter);
				final int dialog = filechooser.showDialog(getContentPane(), "Datei �ffnen");

				if (dialog == JFileChooser.APPROVE_OPTION) {
					final File file = filechooser.getSelectedFile();

				}
			}
		});

		final JButton sbutton = new JButton("Start");
		sbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // Actions after pressing Button:
				final Playground pg = new Playground(); // builds a Playground frame
				pg.setVisible(true); // makes Playground-frame visible
				dispose(); // destroys current frame

			}
		});

//		final GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		final JScrollPane sp = new JScrollPane();
//		final JList<String> font_list = new JList<>(ge.getAvailableFontFamilyNames());
//		sp.setViewportView(font_list);

		// Menubar
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

		// Layout
		final Container pane = getContentPane();
		pane.setLayout(new FlowLayout());
		pane.add(ebutton);
		pane.add(sbutton);
		pane.add(this.label1);

	}

}
