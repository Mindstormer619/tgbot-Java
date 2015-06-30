package telegram.tgbot.types;

public class Audio {
	public String file_id, mime_type;
	public int duration, file_size;

	public Audio(String file_id, int duration) {
		this.file_id = file_id;
		this.duration = duration;
	}

	public Audio(String file_id, int duration, String mime_type) {
		this.file_id = file_id;
		this.duration = duration;
		this.mime_type = mime_type;
	}

	public Audio(String file_id, int duration, int file_size) {
		this.file_id = file_id;
		this.duration = duration;
		this.file_size = file_size;
	}

	public Audio(String file_id, int duration, String mime_type, int file_size) {
		this.file_id = file_id;
		this.duration = duration;
		this.mime_type = mime_type;
		this.file_size = file_size;
	}
}
