package grailgames;

public interface Advanceable {
	
	/**
	 * Advances the level of a dueler or does nothing if advancement
	 * is not possible (i.e. not valid or maxed out)
	 */
	public void advanceLevel();
}
