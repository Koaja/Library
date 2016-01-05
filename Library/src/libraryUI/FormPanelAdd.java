package libraryUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanelAdd extends JPanel {

	private JLabel bookTitleLabel;
	private JLabel bookAuthorLabel;

	private JTextField bookTitleTextField;
	private JTextField bookAuthorTextField;

	private JButton addBook;

	private FormListener formListener;

	public FormPanelAdd() {
		Dimension dim = getPreferredSize();

		dim.width = 250;
		setPreferredSize(dim);

		// labels
		bookTitleLabel = new JLabel("Book Title: ");
		bookAuthorLabel = new JLabel("Author: ");

		// text fields
		bookTitleTextField = new JTextField(10);
		bookAuthorTextField = new JTextField(10);

		// button
		addBook = new JButton("Add Book");

		addBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String bookTitle = bookTitleLabel.getText();
				String bookAuthor = bookAuthorLabel.getText();

				FormEvent ev = new FormEvent(this, bookTitle, bookAuthor);

				if (formListener != null) {
					formListener.formEventOccurred(ev);
				}
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Book");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.NONE;
		// the anchor method positions the content "inside" it's container
		gc.anchor = GridBagConstraints.LINE_END;
		add(bookTitleLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(bookTitleTextField, gc);

		///////////////////// Second Row //////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(bookAuthorLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(bookAuthorTextField, gc);

		///////////////////// Third Row //////////////////////////////////
		gc.weightx = 1;
		gc.weighty = 8;
		gc.gridx = 1;
		gc.gridy = 2;
		// at the top-left corner of it's container
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(addBook, gc);
	}
}
