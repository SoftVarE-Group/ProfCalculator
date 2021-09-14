package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class BlueFontGUIFactory implements GUIFactory {

	final static Color BLUE = Color.web("#0000AA");

	public final static String BLUE_HEX_CODE = "#0000aa";

	@Override
	public Label createLabel() {
		Label label = new Label();
		label.setTextFill(BLUE);
		return label;
	}

	@Override
	public Button createButton(String title) {
		Button button = new Button(title);
		button.setTextFill(BLUE);
		return button;
	}

	@Override
	public TextField createTextField() {
		TextField textField = new TextField();
		textField.setStyle("-fx-text-fill: " + BLUE_HEX_CODE + ";");
		return textField;
	}

	@Override
	public String getBackgroundColorStyle() {
		// this way the default values are used
		return null;
	}

}
