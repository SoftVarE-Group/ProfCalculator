package de.uulm.sp.swt.profcalculator.expressions;

import de.uulm.sp.swt.profcalculator.Logger;
import de.uulm.sp.swt.profcalculator.Observable;

//subject
public class CounterValue extends Observable implements Runnable {

	public CounterValue() {
		super(0);

		new Thread(this).start();
	}

	public double getState() {
		return value;
	}

	@Override
	public void run() {
		while (value < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			value++;
			Logger.getLogger().log("Value increased: " + value);
			setChanged();
			notifyObservers();
		}
	}

}
