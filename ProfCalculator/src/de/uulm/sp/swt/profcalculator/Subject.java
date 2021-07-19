package de.uulm.sp.swt.profcalculator;

public interface Subject {
	void register(Observer observer);
	void unregister(Observer observer);
	void notifyObservers();
}
