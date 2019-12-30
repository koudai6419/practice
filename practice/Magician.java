package practice8;

public class Magician extends Character implements Movable{
	public Magician(int hp, int mp, String name) {
		super(hp, mp, name);
	}
	@Override
	public void introduce() {
		if(isDead())return;
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

	@Override
	public void attack(Character target) {
		if(isDead())return;
		if (hp<50) {
			System.out.println(this.name+"回復魔法");
			hp+=mp/2;
			System.out.println(this.name+"のHP:"+hp);
		}
		magic(target);
//		move(target);
	}

	public void magic(Character target) {
		System.out.println(this.name+"のMP攻撃！");
		target.damage(mp/2);
		mp/=2;
	}
	@Override
	public void move(Character target) {
		attack(target);
	}
}
