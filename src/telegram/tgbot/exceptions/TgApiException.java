package telegram.tgbot.exceptions;

public class TgApiException extends Exception {
	private static final long serialVersionUID = 1L;

	public TgApiException(String message) {
		super(message);
	}
}
