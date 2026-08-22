package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Sale {
	private Client client;
	//private Product[] products;
	private ArrayList<Product> products = new ArrayList<Product>();
	private Amount amount;
	private LocalDateTime date;
	
	public Sale(Client client, ArrayList<Product> products, Amount amount) {
		super();
		this.client = client;
		this.products = products;
		this.amount = amount;
		this.date = LocalDateTime.now();
	}
	
		

	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		String formattedDate = formatDate();
		return "Sale [client=" + client.getName().toUpperCase() + ", products=" + products.toString() + ", amount=" + amount + ",date=" + formattedDate + "]";
	}

	public String formatDate() {		
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	    String formattedDate = date.format(myFormatObj);
		return formattedDate;
	}
	
	
	
	

}
