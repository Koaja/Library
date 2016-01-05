package libraryUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {

	private FormPanelAdd formPanelAdd;
	private FormPanelDisplay formPanelDisplay;
	private JButton button;
	private TextPanelAddAuthor textPanelAuthor;

	public MainFrame() {
		setTitle("Library");
		setSize(600, 600);
		// setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		formPanelAdd = new FormPanelAdd();
		formPanelDisplay = new FormPanelDisplay();
		button = new JButton("Add Book");
		textPanelAuthor = new TextPanelAddAuthor();

		add(button, BorderLayout.WEST);
		add(textPanelAuthor, BorderLayout.CENTER);
		add(formPanelAdd, BorderLayout.WEST);
		setVisible(true);
	}

}
