package telegram.tgbot;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class Bot {

	protected String token;
	public String API_URL = "https://api.telegram.org/bot";

	public Bot(String token) {
		this.token = token;
		this.API_URL = API_URL + token;
	}

	// Request
	private JSONObject request(String url, List<NameValuePair> data) throws UnsupportedOperationException, IOException, JSONException{
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpPost httpPost = new HttpPost(url);
		httpPost.setEntity(new UrlEncodedFormEntity(data, StandardCharsets.UTF_8));
		
		CloseableHttpResponse postResponse = httpclient.execute(httpPost);
		HttpEntity ent = postResponse.getEntity();
		
		JSONObject js;
		try {
			String s = IOUtils.toString(ent.getContent());
			js = new JSONObject(s);
		} finally {
			postResponse.close();
		}
		return js;
	}
	
	// Send Message
	public JSONObject sendMessage(int chat_id, String text, boolean disable_web_page_preview, int reply_to_message_id)
			throws ClientProtocolException, IOException, JSONException {
		
		String url = API_URL + "/sendMessage";
		
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("chat_id", String.valueOf(chat_id)));
		data.add(new BasicNameValuePair("text", text));
		
		if (disable_web_page_preview)
			data.add(new BasicNameValuePair("disable_web_page_preview", String.valueOf(disable_web_page_preview)));
		if (reply_to_message_id != 0)
			data.add(new BasicNameValuePair("reply_to_message_id", String.valueOf(reply_to_message_id)));
		
		return request(url, data);
	}

	public JSONObject sendMessage(int chat_id, String text, int reply_to_message_id)
			throws ClientProtocolException, IOException, JSONException {
		return sendMessage(chat_id, text, false, reply_to_message_id);
	}

	public JSONObject sendMessage(int chat_id, String text, boolean disable_web_page_preview)
			throws ClientProtocolException, IOException, JSONException {
		return sendMessage(chat_id, text, disable_web_page_preview, 0);
	}

	public JSONObject sendMessage(int chat_id, String text)
			throws ClientProtocolException, IOException, JSONException {
		return sendMessage(chat_id, text, false, 0);
	}
	
	// Get Me
	public JSONObject getMe() throws ClientProtocolException, IOException, JSONException {
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpGet httpGet = new HttpGet(API_URL + "/getMe");
		
		CloseableHttpResponse getResponse = httpclient.execute(httpGet);
		HttpEntity ent = getResponse.getEntity();
		
		JSONObject js;
		try {
			js = new JSONObject(IOUtils.toString(ent.getContent()));
		} finally {
			getResponse.close();
		}
		return js;
	}

	// Forward Message
	public JSONObject forwardMessage(int chat_id, int from_chat_id, int message_id) throws ClientProtocolException, IOException, JSONException {

		String url = API_URL + "/forwardMessage";
		
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("chat_id", String.valueOf(chat_id)));
		data.add(new BasicNameValuePair("from_chat_id", String.valueOf(from_chat_id)));
		data.add(new BasicNameValuePair("message_id", String.valueOf(message_id)));
		
		return request(url, data);
	}

	// Get Updates
	public JSONObject getUpdates(int offset, int limit, int timeout) throws ClientProtocolException, IOException, JSONException {
		
		String url = API_URL + "/getUpdates";
		
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		if(offset != 0)
			data.add(new BasicNameValuePair("offset", String.valueOf(offset)));
		if(limit != 100)
			data.add(new BasicNameValuePair("limit", String.valueOf(limit)));
		if(timeout != 0)
			data.add(new BasicNameValuePair("timeout", String.valueOf(timeout)));
		
		return request(url, data);
	}

	public JSONObject getUpdatesWithOffsetAndLimit(int offset, int limit) throws ClientProtocolException, IOException, JSONException {
		return getUpdates(offset, limit, 0);
	}

	public JSONObject getUpdatesWithOffsetAndTimeout(int offset, int timeout) throws ClientProtocolException, IOException, JSONException {
		return getUpdates(offset, 100, timeout);
	}

	public JSONObject getUpdatesWithLimitAndTimeout(int limit, int timeout) throws ClientProtocolException, IOException, JSONException {
		return getUpdates(0, limit, timeout);
	}

	public JSONObject getUpdatesWithOffset(int offset) throws ClientProtocolException, IOException, JSONException {
		return getUpdates(offset, 100, 0);
	}

	public JSONObject getUpdatesWithLimit(int limit) throws ClientProtocolException, IOException, JSONException {
		return getUpdates(0, limit, 0);
	}

	public JSONObject getUpdatesWithtimeout(int timeout) throws ClientProtocolException, IOException, JSONException {
		return getUpdates(0, 100, timeout);
	}

	public JSONObject getUpdates() throws ClientProtocolException, IOException, JSONException {
		return getUpdates(0, 100, 0);
	}
	
	// Set Webhook
	public JSONObject setWebhook(String url) throws UnsupportedOperationException, IOException, JSONException{
		String urrl = API_URL + "/setWebhook";
		List<NameValuePair> data = new ArrayList<NameValuePair>();
		data.add(new BasicNameValuePair("url", url));
		return request(urrl, data);
	}

}
