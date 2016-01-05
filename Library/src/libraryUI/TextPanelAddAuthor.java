package libraryUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanelAddAuthor extends JPanel {
	JTextArea textAreaAuthor;

	public TextPanelAddAuthor() {
		textAreaAuthor = new JTextArea();

		setLayout(new BorderLayout());

		add(new JScrollPane(textAreaAuthor), BorderLayout.WEST);
	}

	public void appendText(String text) {
		textAreaAuthor.append(text);
	}
}
