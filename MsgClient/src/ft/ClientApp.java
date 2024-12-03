package ft;

import java.util.Properties;
import javax.naming.*;
import com.MsgServer.*;
public class ClientApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      try {
    	  //Affichage du message suivant si le code a bien fonctionné
    	  System.out.println("Client APP Started I am the president Mister BERTHE ");
    	 /*Création de l'objet Properties qui est utilisé pour définir des propriétés
    	  *  de configuration qui seront ensuite utilisées pour initialiser le contexte JNDI (`InitialContext`)
    	  */
    	  Properties props = new Properties();
    	  //Configuration du nom de la factory pour le JNDI 
    	  props.put("java.naming.factory.url.pkgs","org.jboss.ejb.client.naming");
    	  // Initialisation du contexte JNDI
    	  InitialContext context = new InitialContext(props);
    	  
    	  //Définition des informations de l'EJB à rechercher par la chaîne de nom
    	  String appName = "";
    	  String moduleName = "MsgFromServerEJB";
    	  String distinctName = "";
    	  String beanName = ExampleServer.class.getSimpleName();
    	  String interfaceName = ExampleServerRemote.class.getName();
    	 // //Construction du nom JNDI de l'EJB
    	  String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
    	 //Affichage du nom JNDI
    	  System.out.println(name);
    	 //Recherche de l'EJB à l'aide du contexte JNDI 
    	  ExampleServerRemote bean = (ExampleServerRemote)context.lookup(name);
    	 // Appel d'une méthode sur l'EJB distant
    	  String msg = bean.getMsg();
    	  //Affichage du message retourné par l'EJB
    	  System.out.println(msg);
      }catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}
