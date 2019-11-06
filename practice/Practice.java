package practice;

public class Practice {
	public static void main (String[] args) {
		Character a = new Character(100, 50 ,"勇者");
		Character b = new Magician(50, 100 ,"魔法使い");
		a.introduce();
		b.introduce();
		a.attack(b);
		b.attack(a);
	}
}
