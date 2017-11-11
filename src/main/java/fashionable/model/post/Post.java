package fashionable.model.post;

import java.time.LocalDateTime;
import java.util.UUID;

@lombok.Value
public class Post {
	String author;
	LocalDateTime timestamp;
	String thread;
	int sequenceNumber;
	UUID id;
	String status;
	
}
