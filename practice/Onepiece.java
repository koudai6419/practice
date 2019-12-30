package practice8;

public class Onepiece implements Movable{
	/*public int hp;
	public int mp;
	public String name;

	public Onepiece(int hp, int mp, String name) {
		this.hp = hp;
		this.mp = mp;
		this.name = name;
	}*/

	public void introduce() {
		System.out.println("名前はインターフェースのルフィ");
	}

	public void move(Character target) {
		System.out.println("ルフィのチャージショット！！");
		target.damage(50);
	}

	/*public void damage(int atk) {
		this.hp-=atk;
		System.out.println(name+"は攻撃された! HP:"+hp);
	}*/
}
