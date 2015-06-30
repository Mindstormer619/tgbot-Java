package telegram.tgbot.types;

import java.util.Map;

public class Video {
	public String file_id, mime_type, caption;
	public int width, height, duration, file_size;
	public PhotoSize thumb;

	public Video(String file_id, int width, int height, int duration, PhotoSize thumb) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
	}

	public Video(String file_id, int width, int height, int duration, PhotoSize thumb, int file_size) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
		this.file_size = file_size;
	}

	public Video(String file_id, int width, int height, int duration, PhotoSize thumb, int file_size, Map<String, String> map) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
		this.file_size = file_size;
		this.mime_type = map.containsKey("mime_type") ? map.get("mime_type") : null;
		this.caption   = map.containsKey("caption")   ? map.get("caption")   : null;
	}
	
	public Video(String file_id, int width, int height, int duration, PhotoSize thumb, Map<String, String> map) {
		this.file_id = file_id;
		this.width = width;
		this.height = height;
		this.duration = duration;
		this.thumb = thumb;
		this.mime_type = map.containsKey("mime_type") ? map.get("mime_type") : null;
		this.caption   = map.containsKey("caption")   ? map.get("caption")   : null;
	}
}
