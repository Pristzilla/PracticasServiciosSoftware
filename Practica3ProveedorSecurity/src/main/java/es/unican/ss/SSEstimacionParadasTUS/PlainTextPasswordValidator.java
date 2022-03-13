package es.unican.ss.SSEstimacionParadasTUS;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;


public class PlainTextPasswordValidator implements PasswordValidationCallback.PasswordValidator {

	PasswordValidationCallback.PlainTextPasswordRequest plainTextPasswordRequest = null;

	public boolean validate(PasswordValidationCallback.Request request) throws
	PasswordValidationCallback.PasswordValidationException {
		plainTextPasswordRequest = (PasswordValidationCallback.PlainTextPasswordRequest) request;
		System.out.println("Voy a validar");
		
		if(plainTextPasswordRequest.getUsername().equals("javi") &&
				plainTextPasswordRequest.getPassword().equals("sara")) {
			return true;
		}
		return false;
	}
}

