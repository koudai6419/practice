package practice8;

import practice8.Character.Movable;

public class Magician extends Character implements Movable{
	public Magician(int hp, int mp, String name) {
		super(hp, mp, name);
	}
	@Override
	public void introduce() {
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

	public void attack(Movable target) {
		move(target);
	}

	public void magic(Character target) {
		System.out.println(name+"のMP攻撃！");
		target.damage(mp/2);
		mp/=2;
	}

	public void move(Movable target) {
		System.out.println("チャージショット！！");
		damage(30);
	}
}
