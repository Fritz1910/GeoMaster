package swing_experience;

import java.awt.EventQueue;

public class Main {

	int counter = 0; // Variable

	void setCounter(int counter) { // Setter
		this.counter = counter;
	}

	int getCounter() { // Getter
		return this.counter;
	}

	// ------------------------MAIN--------------------------------
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				final Menu m = new Menu();
				m.setVisible(true);
			}
		});
	}

}
