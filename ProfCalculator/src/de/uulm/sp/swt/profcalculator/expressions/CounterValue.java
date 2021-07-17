package de.uulm.sp.swt.profcalculator.expressions;

import java.util.LinkedList;

import de.uulm.sp.swt.profcalculator.Observer;
import de.uulm.sp.swt.profcalculator.ProfCalculator;
import de.uulm.sp.swt.profcalculator.Subject;
import javafx.application.Platform;

public class CounterValue extends Value implements Runnable, Subject {
	
	private LinkedList<Observer> observerList = new LinkedList<Observer>();

	public CounterValue(ProfCalculator calc) {
		super(0);
		observerList.add(calc);
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (value < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			value++;
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					notifyObservers();
				}
			});
		}
	}

	@Override
	public void register(Observer observer) {
		observerList.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observerList.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observerList.size();i++) {
			observerList.get(i).update();
		}
	}

}
