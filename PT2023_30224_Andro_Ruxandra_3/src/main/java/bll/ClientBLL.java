package bll;

import DataAccess.AbstractDAO;
import bll.validators.*;
import DataAccess.ClientDAO;
import Model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * initializeaza validatoarele si clasa de acces la baza de date
     */
    public ClientBLL() {
        validators=new ArrayList<Validator<Client>>();
        validators.add(new ClientAgeValidator());
        validators.add(new ClientNameValidator());
        validators.add(new EmailValidator());

        clientDAO=new ClientDAO();
    }

   /* public Client findById(int id){
        Client client= ClientDAO.findByIdClient(id);
        if(client==null)
            throw new IllegalArgumentException("The client with id =" + id + " was not found!");
        return client;
    }*/

    public Client findById(int id)
    {
        Client client=clientDAO.findById(id);
        if(client==null)
            throw new IllegalArgumentException("Clientul cu id-ul %d "+id+" nu exista !");
        return client;
    }

    public void insert(Client client){
        for(Validator validator:validators){
            validator.validate(client);
        }
        clientDAO.insert(client);
    }



    public void update(Client client,int id){
        Client actualClient=clientDAO.findById(id);
        if(actualClient==null)
            throw new IllegalArgumentException("Clientul nu exista!");
        for(Validator validator:validators){
            validator.validate(client);
        }
        clientDAO.update(client,id);
    }



    /**
     * sterge clientul dupa id din bd
     * @param id
     */
   public void delete(int id){
        clientDAO.delete(id);
    }


    /**
     * gaseste toti clientii
     * @return lista completa pentru tabel
     */
    public List<Client> findAll(){
        return clientDAO.findAll();
    }
}
