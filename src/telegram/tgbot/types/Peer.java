package telegram.tgbot.types;

import java.util.HashMap;

public class Peer {
	public int id;
	public String first_name, last_name, username, title, type;

	public Peer(int id, HashMap<String, String> map) {
		this.type = "User";
		this.id = id;
		this.first_name = map.get("first_name");
		this.last_name  = map.containsKey("last_name") ? map.get("last_name") : null;
		this.username   = map.containsKey("username")  ? map.get("username")  : null;
	}

	public Peer(int id, String title) {
		this.type = "GroupChat";
		this.id = id;
		this.title = title;
	}
}
