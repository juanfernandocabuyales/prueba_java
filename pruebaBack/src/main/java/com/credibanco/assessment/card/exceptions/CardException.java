package com.credibanco.assessment.card.exceptions;

public class CardException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CardException() {
        super();
    }

    public CardException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

    public CardException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    public CardException(String arg0) {
        super(arg0);
    }

    public CardException(Throwable arg0) {
        super(arg0);
    } 
}
