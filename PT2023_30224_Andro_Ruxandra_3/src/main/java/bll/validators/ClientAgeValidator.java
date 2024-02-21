package bll.validators;

import Model.Client;


public class ClientAgeValidator implements Validator<Client> {
	private static final int MIN_AGE = 18;
	private static final int MAX_AGE = 80;

	/**
	 * arunca o exceptie daca varsta e in afara intervalului
	 * @param t clientul
	 */
	public void validate(Client t) {
		if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
			throw new IllegalArgumentException("Clientul nu are varsta potrivita!");
		}

	}

}
