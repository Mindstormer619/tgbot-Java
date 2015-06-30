package telegram.tgbot.types;

import java.util.Map;

public class Contact {
	public String phone_number, first_name, last_name, user_id;
	
	public Contact(Map<String, String> map) {
		this.phone_number = map.containsKey("phone_number") ? map.get("phone_number") : null;
		this.first_name = map.containsKey("first_name") ? map.get("first_name") : null;
		this.last_name = map.containsKey("last_name") ? map.get("last_name") : null;
		this.user_id = map.containsKey("user_id") ? map.get("user_id") : null;
	}
}
