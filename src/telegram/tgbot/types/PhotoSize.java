package telegram.tgbot.types;

public class PhotoSize {
	public String file_id;
	public int width, height, file_size;

	public PhotoSize(String file_id, int width, int height) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
	}

	public PhotoSize(String file_id, int width, int height, int file_size) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.file_size = file_size;
	}
}
