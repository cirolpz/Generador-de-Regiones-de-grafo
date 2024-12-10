package tpGrafosMain;

import javax.swing.SwingUtilities;

import tpGrafos.igu.GrafoEditor;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				GrafoEditor editor = new GrafoEditor();
				editor.setVisible(true);
			}
		});
	}
}

