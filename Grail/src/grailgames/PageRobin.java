package grailgames;

public class PageRobin extends CowardlyDueler {
	
	public PageRobin() {
		name = "Page Robin";
		attack = "Squeal";
		damage = 20;
		isAlive = true;
		maxHP = 60;
		hp = maxHP;
		xp = 0;
		arenaXP = 0;
	}
	
	@Override
	public Dueler advanceLevel() {
		System.out.println(name + " has advanced to Squire Robin!");
		return (new SquireRobin(maxHP - hp));		
	}

}
