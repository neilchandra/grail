package grailgames;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public abstract class TrainingCard extends Card {
	
	BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public String toString() {
		return this.name;
	}
}
