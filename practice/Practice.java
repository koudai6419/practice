/*
・それぞれの職業クラスとCharacterと継承関係にない適当なクラスでMovableインターフェースを継承しよう。
・moveメソッドをオーバーライドしてattackさせたり好きな行動をさせよう。
・Movableを継承していればCharacterと継承関係になくてもmoveがきちんと呼べるのを確認しよう。
以上の項目がわからなかった。*/

package practice8;

public class Practice {
	public static void main(String[] args) {
		System.out.println("RPG開始");
		Character[][] Characters = new Character[2][2];
		Characters[0][0] = new Knight(100, 50, "騎士");
		Characters[0][1] = new Magician(50, 80, "魔法使い");
		Characters[1][0] = new Ossan(70, 30, "おっさん");
		Characters[1][1] = new Obasan(60, 30, "おばさん");
		//		Characters[1][1] = (Movable)new Onepiece(60, 30, "ルフィ");

		Movable[][] moves = new Movable[2][2];
		moves[0][0] = new Knight(100, 50, "騎士");
		moves[0][1] = new Magician(50, 80, "魔法使い");
		moves[1][0] = new Ossan(200, 30, "おっさん");
		//		moves[1][1] = new Obasan(60, 30, "おばさん");
		moves[1][1] = new Onepiece();


		//----------------------------以下は森山先生の答えを見て書いたコード

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves[i].length; j++) {
				moves[i][j].introduce();
			}
		}

		System.out.println("//////////////戦闘開始/////////////////");

		int winner = -1;
		while (winner == -1) {
			for (int i = 0; i < moves.length; i++) {
				for (int j = 0; j < moves.length; j++) {
					Movable target;
					do {
						target = moves[(i - 1) * -1][(int) (Math.random() * moves[i].length)];
					} while (!(target instanceof Character));
					moves[i][j].move((Character) target);
				}
			}

			for (int i = 0; i < moves.length; i++) {
				int moves_hp = 0;
				for (int j = 0; j < moves[i].length; j++) {
					if(moves[i][j] instanceof Character)moves_hp += ((Character)moves[i][j]).get_hp();
				}
				if (moves_hp <= 0)winner = (i - 1) * -1;
			}
		}

		System.out.println("---------------以下のパーティの勝ちです---------------");
		for (int i = 0; i < moves[winner].length; i++) {
			moves[winner][i].introduce();
		}



		//------------------自作コード　攻撃相手は順番どおり、ランダムに相手を選ぶコードは出来なかった。、
		/*for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				moves[i][j].introduce();
				if (moves[i][j] instanceof Character) {
					moves[i][j].move((Character) moves[i][j]);
				}
			}
		}
		System.out.println("終了");*/
		//--------------ここまで



		/*//-----乱数を使ってチーム同士で攻撃させようとしたが出来なかった。以下は前回を参照して作成したコード
				java.util.Random r = new java.util.Random();
				boolean isFinished = false;
				int turn = 0;

				while(!isFinished) {
					Movable player, enemy;
					do {
						player = moves[turn%2][r.nextInt(2)];
						enemy = moves[(turn%2-1)*-1][r.nextInt(2)];
					}while(((Character) player).isDead() || ((Character) enemy).isDead());
					if(player instanceof Character) {
						player.move((Character) enemy);
					}
					for(int i=0;i<2;i++) {
						for(int j=0;j<2;j++) {
							moves[i][j].introduce();
							if(moves[i][j] instanceof Character) {
								moves[i][j].move((Character) moves[i][j]);
							}
						}
					}
					boolean temp=true;
					for(int i=0;i<2;i++) {
						if(!((Character) moves[0][i]).isDead()) temp=false;
					}
					if(temp) {
						System.out.println("敵の勝ち");
						isFinished=true;
					}
					temp=true;
					for(int i=0;i<2;i++) {
						if(!((Character) moves[1][i]).isDead()) temp=false;
					}
					if(temp) {
						System.out.println("味方の勝ち");
						isFinished=true;
					}
					System.out.println("=========="+turn+"ターン==========");
					turn++;
				}
		//--------------ここまで
		*/

		/*----------------------------------------------
		Movable型の変数をCharacter型の変数へ代入して、配列にすることで、以下のメソッドを使用できるのではないか？　以下は自作したコード
				Character[][] cs = new Character[2][2];
				cs[0][0]=(Character)moves[0][0];
				cs[0][1]=(Character)moves[1][1];
				for(int i=0; i<2; i++) {
					cs[0][i].introduce();
				}
				for(int i=0;i<2;i++) {
					for(int j=0;j<2;j++) {
						cs[i][j].introduce();
						if(cs[i][j] instanceof Character) {
							moves[i][j].move((Character) moves[i][j]);
						}
					}
				}
		型の不一致: Onepiece から Character には変換できません、と表示されて無理だった。
		-------------------------------------------------ここまで
		*/

	}
}