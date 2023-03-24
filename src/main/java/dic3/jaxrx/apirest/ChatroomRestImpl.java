package dic3.jaxrx.apirest;

import java.util.Random;
import java.util.Vector;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/room")
public class ChatroomRestImpl {
	private static Vector<String> users = new Vector<String>();
	static String message_bi = "";
	
	@Path("/postmessage/{pseudo}/{message}")
	@GET
	public String postMessage(@PathParam("pseudo") String pseudo, @PathParam("message") String message) {
		String messageEntier = pseudo + " : " + message;
		message_bi = messageEntier;
		
		return message_bi;
		
	}
	
	@GET
	@Path("/getMessage")
	public String getMessage() {
		return message_bi;
	}
	
	@GET
	@Path("/subscribe/{pseudo}")
	public boolean subscribe(@PathParam("pseudo") String pseudo) {
		boolean isConnected = false;
		if (!users.contains(pseudo)) {
			users.add(pseudo);
			isConnected = true;
			String message = "Bienvenue!";
			postMessage(pseudo, message);
		}
		
		return isConnected;
		
	}
	
	@GET
	@Path("/unsubscribe/{pseudo}")
	public boolean unsubsribe(@PathParam("pseudo") String pseudo) {
		boolean isDeconnected = false;
		
		if (users.contains(pseudo)) {
			users.remove(pseudo);
			isDeconnected = true;
			postMessage(pseudo, " s'est deconnecté");
		}
		
		return isDeconnected;
		
	}
}
