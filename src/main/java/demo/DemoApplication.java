package demo;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public Queue speakersQueue() {
		return new Queue("speakers");
	}

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
