package cours7;

import java.io.IOException;

import javax.swing.*;

public class testVisualisation {

	public static void main(String[] args) {
		
		JEditorPane output = new JEditorPane();
		output.setContentType( "text/html" );
		output.setEditable( false );
		String str = "https://www.lemonde.fr/";
		try {
		output.setPage( str);
		} catch (IOException e) {}

		JFrame fen = new JFrame(str);
		fen.setSize(800, 600);
		fen.getContentPane().add(output);
		fen.getContentPane().add(new JScrollPane(output));
		fen.setVisible(true);

	}

}