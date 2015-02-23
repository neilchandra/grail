package grailgames;

public interface ActUponDueler {
	/**
	 * Performs the desired action of the Training Card on a Dueler
	 * @param dealer - the Dueler to be "trained"
	 */
	public void actUpon(Dueler dueler);
}
