package practice8;

public class Obasan extends Character {
	public Obasan(int hp, int mp, String name) {
		super(hp, mp, name);
	}

	@Override
	public void introduce() {
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}
}
