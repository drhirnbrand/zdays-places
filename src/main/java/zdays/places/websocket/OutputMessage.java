package zdays.places.websocket;

import org.joda.time.DateTime;

public class OutputMessage extends Message {

	private DateTime dateTime;

	public OutputMessage(String from, String text, DateTime time) {
		setFrom(from);
		setText(text);
		this.dateTime = time;
		// TODO Auto-generated constructor stub
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(DateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}
