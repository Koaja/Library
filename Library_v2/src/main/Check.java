package main;

public class Check {

	public String fixSubmission(String text) {

		String text2[] = text.split(" ");
		String newText = "";
		for (int i = 0; i < text2.length; i++) {
			char ch = text2[i].charAt(0);
			if (Character.isLowerCase(ch)) {
				char newch = Character.toUpperCase(ch);
				newText = newText + text2[i].replace(ch, newch);
			}

		}

		return newText;
	}

	public String toUppercase(String text) {

		return text.toUpperCase();
	}
}
