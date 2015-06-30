package telegram.tgbot.types;

import java.util.Map;

public class Document {
	public String file_id, file_name, mime_type;
	public PhotoSize thumb;
	public int file_size;

	public Document(String file_id, PhotoSize thumb) {
		this.file_id = file_id;
		this.thumb = thumb;
	}

	public Document(String file_id, PhotoSize thumb, int file_size) {
		this.file_id = file_id;
		this.thumb = thumb;
		this.file_size = file_size;
	}

	public Document(String file_id, PhotoSize thumb, int file_size, Map<String, String> map) {
		this.file_id = file_id;
		this.thumb = thumb;
		this.file_size = file_size;
		this.file_name = map.containsKey("file_name") ? map.get("file_name") : null;
		this.mime_type = map.containsKey("mime_type") ? map.get("mime_type") : null;
	}

	public Document(String file_id, PhotoSize thumb, Map<String, String> map) {
		this.file_id = file_id;
		this.thumb = thumb;
		this.file_name = map.containsKey("file_name") ? map.get("file_name") : null;
		this.mime_type = map.containsKey("mime_type") ? map.get("mime_type") : null;
	}
}
