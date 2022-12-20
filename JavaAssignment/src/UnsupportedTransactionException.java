
@SuppressWarnings("serial")
public class UnsupportedTransactionException extends Exception{
	
	
	public UnsupportedTransactionException() {
		super("NO Record for given details ");
	}
    
	public UnsupportedTransactionException(String message) {
		super(message);
	}
}
