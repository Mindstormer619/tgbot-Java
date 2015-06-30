package telegram.tgbot.types;

public class Sticker {
	public String file_id;
	public int width, height, file_size;
	public PhotoSize thumb;

	public Sticker(String file_id, int width, int height, PhotoSize thumb) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.thumb = thumb;
	}

	public Sticker(String file_id, int width, int height, PhotoSize thumb, int file_size) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.thumb = thumb;
		this.file_size = file_size;
	}

}
