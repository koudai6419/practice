/*
・それぞれの職業クラスとCharacterと継承関係にない適当なクラスでMovableインターフェースを継承しよう。
・moveメソッドをオーバーライドしてattackさせたり好きな行動をさせよう。
・Movableを継承していればCharacterと継承関係になくてもmoveがきちんと呼べるのを確認しよう。
以上の項目がわからなかった。*/

package practice8;

public class Practice {
	public static void main (String[] args) {
		System.out.println("RPG開始");
		Character[][] Movable= new Character[2][3];
		Movable[0][0] = new Character(100, 50 ,"勇者");
		Movable[0][1] = new Magician(50, 100 ,"魔法使い");
		Movable[1][0] = new Ossan(70, 30 ,"おっさん");
		Movable[1][1] = new Obasan(60, 30 ,"おばさん");
//		Movable[1][2] = new Onepiece(60, 30 ,"ルフィ");


		System.out.println("練習");
		((Magician)Movable[0][1]).move();
		Onepiece.move();

		java.util.Random r = new java.util.Random();
		boolean isFinished = false;
		int turn =0;
		while(!isFinished) {
			Character player, enemy;
			do {
				player = Movable[turn%2][r.nextInt(2)];
				enemy = Movable[(turn%2-1)*-1][r.nextInt(2)];
			}while(player.isDead() || enemy.isDead());
			player.attack(enemy);

			boolean temp=true;
			for(int i=0;i<2;i++) {
				if(!Movable[0][i].isDead()) temp=false;
			}
			if(temp) {
				System.out.println("敵の勝ち");
				isFinished=true;
			}
			temp=true;
			for(int i=0;i<2;i++) {
				if(!Movable[1][i].isDead()) temp=false;
			}
			if(temp) {
				System.out.println("味方の勝ち");
				isFinished=true;
			}
			System.out.println("=========="+turn+"ターン==========");
			turn++;
		}
	}
}