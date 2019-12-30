package practice8;

public abstract class Character {
	protected int hp;
	public int mp;
	public String name;

//	コンストラクタ
	public Character(int hp, int mp, String name){
		this.hp = hp;
		this.mp = mp;
		this.name = name;
	}

	public int get_hp() {
		return hp;
	}

//	インスタンスメソッド
	public void introduce() {
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

	/*public void attack(Character target) {
		System.out.println(name+"の攻撃！");
		target.damage(30);
	}*/

	public void damage(int atk) {
		this.hp-=atk;
		System.out.println(name+"は"+atk+"ポイント攻撃された! HP:"+hp);
		if(this.hp<=0) {
			System.out.println(this.name+"は死亡した");
		}
	}

	public abstract void attack(Character target);

	public boolean isDead() {
		return hp<=0;
	}
}
