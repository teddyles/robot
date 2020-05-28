package robot;


public class UnlandedRobotException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8808058592281751853L;

	public UnlandedRobotException() {
        super("Le robot doit être posé avant tout déplacement");
    }
}
