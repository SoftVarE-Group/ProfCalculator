package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LargeRedFontGUIFactory implements GUIFactory {
	
	final static Font FONT = new Font("Arial", 24);
	final static Color RED = Color.web("#FF0000");

	@Override
	public Label createLabel() {
		Label label = new Label();
		label.setTextFill(RED);
		label.setFont(FONT);
		return label;
	}

	@Override
	public Button createButton(String title) {
		Button button = new Button(title);
		button.setTextFill(RED);
		button.setFont(FONT);
		return button;
	}

	@Override
	public TextField createTextField() {
		TextField tf = new TextField();
		tf.setStyle("-fx-text-inner-color: red;");
		tf.setFont(FONT);
		return tf;
	}

}
