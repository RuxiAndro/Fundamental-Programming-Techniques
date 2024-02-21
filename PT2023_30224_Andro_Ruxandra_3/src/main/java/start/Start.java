package start;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Model.Client;
import Model.Product;
import Presentation.Controller;
import bll.ClientBLL;
import bll.ProductBLL;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class Start {
	protected static final Logger LOGGER = Logger.getLogger(Start.class.getName());

	public static void main(String[] args) throws SQLException {

		/*Client c=new Client("Ruxi","ruxi@yahoo.com",20);
		ClientBLL clientBLL=new ClientBLL();
		int id=clientBLL.insertClient(c);
		if(id>0)
			clientBLL.findById(id);
		try {
			clientBLL.findById(1);
		} catch (Exception ex) {
			LOGGER.log(Level.INFO, ex.getMessage());
		}

		Client c2=new Client("Mara","Mara@yahoo.com",20);
		ClientBLL clientBLL2=new ClientBLL();
		int id2=clientBLL2.insertClient(c2);
		System.out.println(c);
		System.out.println(c2);*/

		Client c1=new Client("Razvi","razvan123@yahoo.com",19);
		ClientBLL clientBLL1=new ClientBLL();
		//clientBLL1.insert(c1);
		System.out.println(c1);

		Client c3=new Client("Kati","kati@yahoo.com",48);
		ClientBLL clientBLL3=new ClientBLL();
		//clientBLL3.insert(c3);


		System.out.println(c3);

		Client c4=new Client("Darius","darius@yahoo.com",21);
		ClientBLL clientBLL4=new ClientBLL();
		//clientBLL4.insert(c4);

		System.out.println(c4);
		Client c5=new Client("Andra","andra@yahoo.com",19);
		System.out.println(clientBLL4.findAll());


		//clientBLL4.update(c5,159);
	//	clientBLL4.delete(155);
	/*	for(int i=0;i<=154;i++)
			clientBLL4.delete(i);*/

		Product p1=new Product("carnati",100,10);
		Product p2=new Product("cacao",150,2);

		ProductBLL productBLL1=new ProductBLL();
		//System.out.println(productBLL1.findById(1));
		//productBLL1.insert(p1);
		//productBLL1.update(p2,1);

		new Controller();

		// obtain field-value pairs for object through reflection
		//ReflectionExample.retrieveProperties(clientBLL);

	}

}
