package libraryUI;

import java.awt.Dimension;

import javax.swing.JPanel;

public class FormPanelDisplay extends JPanel {

	public FormPanelDisplay() {
		Dimension dim = getPreferredSize();

		dim.width = 100;
		setPreferredSize(dim);
	}
}
