package main;

import model.Amount;

public interface Payable {
	
	public boolean pay(Amount amount);

}
