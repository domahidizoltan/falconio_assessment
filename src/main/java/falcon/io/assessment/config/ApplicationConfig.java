package falcon.io.assessment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import falcon.io.assessment.message.MessageRepository;
import falcon.io.assessment.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class ApplicationConfig {

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public MessageService messageService(MessageRepository messageRepository) {
        return new MessageService(messageRepository, clock(), objectMapper);
    }

}
