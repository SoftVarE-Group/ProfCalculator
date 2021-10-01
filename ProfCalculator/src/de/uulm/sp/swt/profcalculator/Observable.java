package de.uulm.sp.swt.profcalculator;

import java.util.LinkedList;

import de.uulm.sp.swt.profcalculator.expressions.Value;

public class Observable extends Value {

	private LinkedList<Observer> observers = new LinkedList<>();
	private boolean changed = false;

	public Observable(double value) {
		super(value);

	}

	public void addObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	public void notifyObservers() {
		if (hasChanged()) {
			for (Observer o : observers) {
				o.update();
			}
		}
	}

	public boolean hasChanged() {
		return changed;
	}

	public void setChanged() {
		changed = true;
	}
}
