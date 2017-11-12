package fashionable.model.post;

import java.time.LocalDateTime;
import java.util.UUID;

import fashionable.model.user.ForumUser;

@lombok.Value
public class PostDTO {
	UUID id;
	UUID authorId;
	LocalDateTime timestamp;
	String thread;
	String rawContent;
	PostStatus status;
}
