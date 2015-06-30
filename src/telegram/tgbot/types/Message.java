package telegram.tgbot.types;

import java.util.HashMap;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import telegram.tgbot.exceptions.TgApiException;

public class Message {
	public int message_id;
	public Peer from;
	public int date;
	public Peer chat;
	public Peer forward_from;
	public int forward_date;
	public Message reply_to_message;
	public String text;
	public Audio audio;
	public Document document;
	public PhotoSize[] photo;
	public Sticker sticker;
	public Video video;
	public Contact contact;
	public Location location;
	public Peer new_chat_participant;
	public Peer left_chat_participant;
	public String new_chat_title;
	public PhotoSize[] new_chat_photo;
	public boolean delete_chat_photo;
	public boolean group_chat_created;

	protected Peer getPeerFromJson(JSONObject jso) throws JSONException{
		Peer p = null;
		if (jso.has("title")) {
			p = new Peer(jso.getInt("id"), jso.getString("title"));
		} else if(jso.length() > 2){
			HashMap<String, String> m = new HashMap<String, String>();
			Iterator<String> keys = jso.keys();
			String k = null;
			while(keys.hasNext()){
				k = keys.next();
				if(!k.equals("id"))
					m.put(k, jso.getString(k));
			}
			
			p = new Peer(jso.getInt("id"), m);
		} else {
			if (jso.has("title")) {
				p = new Peer(jso.getInt("id"), jso.getString("title"));
			} else {
				HashMap<String, String> m = new HashMap<String, String>();
				m.put("first_name", jso.getString("first_name"));
				p = new Peer(jso.getInt("id"), m);
			}
		}
		return p;
	}
	
	public Message(JSONObject j) throws JSONException, TgApiException {
		if (!j.getBoolean("ok")){
			throw new TgApiException("Error " + j.getInt("error_code") + ": " + j.getString("description"));
		} else {
			JSONObject json = j.getJSONObject("result");
			this.message_id = json.getInt("message_id");
			this.from = getPeerFromJson(json.getJSONObject("from"));
			this.date = json.getInt("date");
			this.chat = getPeerFromJson(json.getJSONObject("chat"));
		}
	}

}
