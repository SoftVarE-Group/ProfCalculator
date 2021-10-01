package de.uulm.sp.swt.profcalculator;

import de.uulm.sp.swt.profcalculator.expressions.Addition;
import de.uulm.sp.swt.profcalculator.expressions.Div;
import de.uulm.sp.swt.profcalculator.expressions.CounterValue;
import de.uulm.sp.swt.profcalculator.expressions.Expression;
import de.uulm.sp.swt.profcalculator.expressions.Multiplication;
import de.uulm.sp.swt.profcalculator.expressions.NecessaryBrackets;
import de.uulm.sp.swt.profcalculator.expressions.Sub;
import de.uulm.sp.swt.profcalculator.expressions.Value;
import de.uulm.sp.swt.profcalculator.gui.*;
import javafx.application.Platform;
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

public class ProfCalculator extends Observer implements EventHandler<ActionEvent> {

	private CounterValue subject = new CounterValue();

	private Expression expression = subject;

	private GUIFactory guiFactory = new TerminalStyleFactory();

	private Label errorLabel = guiFactory.createLabel();

	private TextField inputField = guiFactory.createTextField();

	private Button additionButton = guiFactory.createButton("+");
	private Button subtractionButton = guiFactory.createButton("-");
	private Button multiplicationButton = guiFactory.createButton("*");
	private Button divisionButton = guiFactory.createButton("/");

	private Label resultLabel = guiFactory.createLabel();

	public ProfCalculator() {
		subject.addObserver(this);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Professorial Calculator");
		errorLabel.setTextFill(Color.web("#AA0000"));

		VBox layout = new VBox(10, errorLabel, inputField, additionButton, subtractionButton, multiplicationButton,
				divisionButton, resultLabel);
		layout.setPadding(new Insets(20, 80, 20, 80));
		layout.setStyle(guiFactory.getBackgroundColorStyle());
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
			Button pressedButton = (Button) event.getSource();

			if (pressedButton == additionButton) {
				expression = new Addition(expression, new Value(newValue));
			} else if (pressedButton == subtractionButton) {
				expression = new Sub(expression, new Value(newValue));
			} else if (pressedButton == multiplicationButton) {
				expression = new Multiplication(expression, new Value(newValue));
			} else if (pressedButton == divisionButton) {
				expression = new Div(expression, new Value(newValue));
			}
			
			Logger.getLogger().log(pressedButton.getText() + " " + newValue);
			expression = new NecessaryBrackets(expression);
			updateGUI();
			inputField.requestFocus();
		} catch (NumberFormatException e) {
			errorLabel.setText("\"" + inputField.getText() + "\" is not a valid integer");
		} catch (ArithmeticException e) {
			errorLabel.setText(e.getMessage());
		}
	}

	public void updateGUI() {
		resultLabel.setText(expression.computeEquation());
		inputField.setText("");
		errorLabel.setText("");
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void update() {
		expression = new Value(subject.getState());

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				updateGUI();

			}
		});

	}
}
