package dao;

public class ExceptionDAO extends Exception{
	
	private static final long serialVersionUID = -3260432967308413217L;

	public ExceptionDAO (String mensagem) {
		super(mensagem);
	}
}