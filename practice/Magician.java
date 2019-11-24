package practice;

public class Magician extends Character {
	public Magician(int hp, int mp, String name) {
		super(hp, mp, name);
	}
	@Override
	public void introduce() {
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

	public void attack(Character target) {
		magic(target);
	}

	public void magic(Character target) {
		System.out.println(name+"のMP攻撃！");
		target.damage(mp/2);
		mp/=2;
	}

	public void move() {
		System.out.println("チャージショット！！");
		damage(30);
	}
}
