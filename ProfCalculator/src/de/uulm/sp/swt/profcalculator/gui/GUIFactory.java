package de.uulm.sp.swt.profcalculator.gui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public interface GUIFactory {

	Label createLabel();

	Button createButton(String title);
	
	TextField createTextField();

}