package practice8;

public class Knight extends Character implements Movable{
	public Knight(int hp, int mp, String name){
		super(hp, mp, name);
	}

	public void introduce() {
		if(isDead())return;
		System.out.println(" 名前: "+ name+"HP: "+hp+" MP:"+mp);
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
