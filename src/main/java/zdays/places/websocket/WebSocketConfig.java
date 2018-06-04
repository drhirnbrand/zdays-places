package zdays.places.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	private static final Logger LOG = LoggerFactory.getLogger(WebSocketConfig.class);
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		LOG.info("configuring message broker");
		config.enableSimpleBroker("/subscription");
		config.setApplicationDestinationPrefixes("/places");
	}

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		LOG.info("configuring stomp endpoints");
		registry.addEndpoint("/broadcast");
		registry.addEndpoint("/broadcast").withSockJS();
	}
}
