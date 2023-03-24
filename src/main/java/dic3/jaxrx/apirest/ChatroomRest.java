package dic3.jaxrx.apirest;

public interface ChatroomRest {
	String postMessage(String pseudo ,String message);
	boolean subscribe(String pseudo);
	boolean unsubsribe(String pseudo);
}
