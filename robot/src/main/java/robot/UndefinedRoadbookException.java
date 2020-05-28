package robot;

public class UndefinedRoadbookException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5576550274153253615L;

	public UndefinedRoadbookException() {
        super("Aucun road book défini");
    }
}
