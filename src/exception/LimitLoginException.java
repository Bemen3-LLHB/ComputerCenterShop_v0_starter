package exception;

public class LimitLoginException extends Exception {
	private static final long serialVersionUID = 1L;
	private int counter;

	public LimitLoginException(String message, int counter) {
		super(message);
		this.counter = counter;
	}

	@Override
	public String toString() {
		return "Intentos login ha superado el limite " + this.counter + " permitido";
	}

}
