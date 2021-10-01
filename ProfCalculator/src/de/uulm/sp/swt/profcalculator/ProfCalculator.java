package de.uulm.sp.swt.profcalculator;

import de.uulm.sp.swt.profcalculator.expressions.Addition;
import de.uulm.sp.swt.profcalculator.expressions.Div;
import de.uulm.sp.swt.profcalculator.expressions.Expression;
import de.uulm.sp.swt.profcalculator.expressions.Multiplication;
import de.uulm.sp.swt.profcalculator.expressions.NecessaryBrackets;
import de.uulm.sp.swt.profcalculator.expressions.Sub;
import de.uulm.sp.swt.profcalculator.expressions.Value;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProfCalculator	extends Application implements EventHandler<ActionEvent> {

	private final static Value DEFAULT_VALUE = new Value(0);

	private Expression expression = DEFAULT_VALUE;

	private Label errorLabel = new Label();

	private TextField inputField = new TextField();

	private Button additionButton = new Button("+");
	private Button subtractionButton = new Button("-");
	private Button multiplicationButton = new Button("*");
	private Button divisionButton = new Button("/");

	private Label resultLabel = new Label();

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Professorial Calculator");
		errorLabel.setTextFill(Color.web("#AA0000"));

		VBox layout = new VBox(10, errorLabel, inputField, additionButton, subtractionButton, multiplicationButton, divisionButton, resultLabel);
		layout.setPadding(new Insets(20, 80, 20, 80));
		Scene scene = new Scene(layout);

		stage.setScene(scene);
		stage.show();
		additionButton.setOnAction(this);
		subtractionButton.setOnAction(this);
		multiplicationButton.setOnAction(this);
		divisionButton.setOnAction(this);
		
		updateGUI();
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			double newValue = Double.parseDouble(inputField.getText());
			if (event.getSource() == additionButton) {
				expression = new Addition(expression, new Value(newValue));
			} else if (event.getSource() == subtractionButton) {
				expression = new Sub(expression, new Value(newValue));
			} else if (event.getSource() == multiplicationButton) {
				expression = new Multiplication(expression, new Value(newValue));
			} else if (event.getSource() == divisionButton) {
				expression = new Div(expression, new Value(newValue));
			}
			expression = new NecessaryBrackets(expression);
			updateGUI();
			inputField.requestFocus();
		} catch (NumberFormatException e) {
			errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
		}catch (ArithmeticException e) {
			errorLabel.setText(e.getMessage());
		}
	}

	private void updateGUI() {
		resultLabel.setText(expression.computeEquation());
		inputField.setText("");
		errorLabel.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
