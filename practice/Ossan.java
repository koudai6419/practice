package practice8;

public class Ossan extends Character implements Movable{
	public Ossan (int hp, int mp, String name) {
		super(hp, mp, name);
	}

	@Override
	public void introduce() {
		if(isDead())return;
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

	public void attack(Character target) {
		if(isDead())return;
		System.out.println(name+"の攻撃！");
		target.damage(30);
	}
	public void move(Character target) {
		attack(target);
	}
}
