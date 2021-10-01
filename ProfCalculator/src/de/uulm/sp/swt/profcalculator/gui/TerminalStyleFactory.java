package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class TerminalStyleFactory implements GUIFactory {

	final static String BORDER_WIDTH = "2px";

	final static Color LIME = Color.LIME;
	final static Color BLACK = Color.BLACK;
	final static Color WHITE = Color.WHITE;
	final static Color GREY = Color.GREY;

	public final static String WHITE_HEX_CODE = "#ffffff";
	public final static String BLACK_HEX_CODE = "#000000";
	public final static String GREY_HEX_CODE = "#808080";
	public final static String LIME_HEX_CODE = "#00ff00";

	private final static String BACKGROUND_COLOR_STYLE = "-fx-background-color: " + BLACK_HEX_CODE + ";";

	final static int CORNER_RADIUS = 5;

	@Override
	public Label createLabel() {
		Label label = new Label();
		label.setTextFill(LIME);
		return label;
	}

	@Override
	public Button createButton(String title) {
		Button button = new Button(title);
		button.setTextFill(LIME);
		button.setStyle("-fx-border-color: " + WHITE_HEX_CODE + "; -fx-border-width: " + BORDER_WIDTH
				+ "; -fx-background-color: " + BLACK_HEX_CODE + "; -fx-border-radius: " + CORNER_RADIUS
				+ "; -fx-background-radius: " + CORNER_RADIUS + ";");
		return button;
	}

	@Override
	public TextField createTextField() {
		TextField textField = new TextField();
		textField.setStyle("-fx-background-color: " + GREY_HEX_CODE + "; -fx-text-fill: " + LIME_HEX_CODE + ";");
		return textField;
	}

	@Override
	public String getBackgroundColorStyle() {
		return BACKGROUND_COLOR_STYLE;
	}

}
