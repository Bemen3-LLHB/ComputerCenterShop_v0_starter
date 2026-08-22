package model;

import java.text.DecimalFormat;

public class Amount {
	private double value;	
	private String currency="€";
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Amount(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return df.format(value) + currency;
	}
	
	

	
}
