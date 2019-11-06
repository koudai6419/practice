package practice;

public class Character {
	public int hp;
	public int mp;
	public String name;

//	コンストラクタ
	public Character(int hp, int mp, String name){
		this.hp = hp;
		this.mp = mp;
		this.name = name;
	}

//	インスタンスメソッド
	public void introduce() {
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

	public void attack(Character target) {
		System.out.println(name+"の攻撃！");
		target.damage(10);
	}

	public void damage(int atk) {
		this.hp-=atk;
		System.out.println(name+"は攻撃された! HP:"+hp);
	}
}
