package zdays.places.websocket;

import org.joda.time.DateTime;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationController {

	@MessageMapping("/broadcast")
	@SendTo("/subscription/redraw")
	public OutputMessage send(Message message) throws Exception {
	    return new OutputMessage(message.getFrom(), message.getText(), new DateTime());
	}
}
