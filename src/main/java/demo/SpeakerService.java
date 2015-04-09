package demo;

import demo.domain.Speaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SpeakerService {

	private static final Logger logger = LoggerFactory.getLogger(SpeakerService.class);

	@RabbitListener(queues = "speakers")
	public void handleNewSpeaker(Speaker speaker) {
		logger.info("A new speaker has been created --> " + speaker);
	}
}
