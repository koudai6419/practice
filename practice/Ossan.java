package practice8;

class Ossan extends Character {
	public Ossan (int hp, int mp, String name) {
		super(hp, mp, name);
	}

	@Override
	public void introduce() {
		System.out.println("hp: "+hp+" mp:"+mp+" name: "+ name);
	}

}
