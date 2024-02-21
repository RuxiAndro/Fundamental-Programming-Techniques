package bll.validators;

import Model.Client;

public class ClientNameValidator implements Validator<Client>{
    /**
     * arunca exceptie daca numele nu e format doar din litere
     * @param client
     */
    @Override
    public void validate(Client client) {
        if(client.getNume().length()==0)
            throw new IllegalArgumentException("Introduceti un nume!");
        if(!client.getNume().matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("Nume invalid!");
    }
}
