package telegram.tgbot.types;

public class Update {
	public int update_id;
	public Message message;

	public Update(int update_id, Message message) {
		this.update_id = update_id;
		this.message = message;
	}
}
