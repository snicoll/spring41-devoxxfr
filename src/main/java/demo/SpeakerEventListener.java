package demo;

import demo.domain.Speaker;

import org.springframework.amqp.rabbit.core.RabbitMessageOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Service;

@Service
@RepositoryEventHandler(Speaker.class)
public class SpeakerEventListener {

	private final RabbitMessageOperations messageOperations;

	@Autowired
	public SpeakerEventListener(RabbitMessageOperations messageOperations) {
		this.messageOperations = messageOperations;
	}

	@HandleAfterCreate
	public void onNewSpeaker(Speaker speaker) {
		messageOperations.convertAndSend("speakers", speaker);
	}
}
