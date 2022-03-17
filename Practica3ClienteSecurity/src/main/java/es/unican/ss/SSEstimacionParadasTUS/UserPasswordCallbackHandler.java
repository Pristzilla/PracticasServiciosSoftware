package es.unican.ss.SSEstimacionParadasTUS;


import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;


public class UserPasswordCallbackHandler implements CallbackHandler{
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for (int i = 0; i < callbacks.length; i++) {
			if (callbacks[i] instanceof NameCallback) {
				((NameCallback)callbacks[i]).setName("javi");
			} else if (callbacks[i] instanceof PasswordCallback) {
				((PasswordCallback)callbacks[i]).setPassword("sara".toCharArray()); } else {
					throw new UnsupportedCallbackException(callbacks[i], "Unsupported callback type");
				} }
	}
}
