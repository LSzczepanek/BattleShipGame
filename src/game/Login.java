package game;

public class Login {

	public static boolean loginValid(String user, String pass) {
		if (user.equalsIgnoreCase("user") && pass.equals("userpw") && !Game.player1.isTaken) {
			Game.player1.isTaken = true;
			Game.player1.setNick(user);
			return true;
		} else if (user.equalsIgnoreCase("user2") && pass.equals("user2pw") && !Game.player2.isTaken){
			Game.player2.isTaken = true;
			Game.player1.setNick(user);
			return false;
		}else{
			return false;
		}
	}
}
