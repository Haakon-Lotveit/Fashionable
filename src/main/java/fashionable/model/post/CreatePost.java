package fashionable.model.post;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;

import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.UrlEncoded;

import fashionable.model.user.ForumUser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;

@Data @Slf4j
public class CreatePost {
	public static final String TEMPLATE_NAME = "create-post.ftm";
	public static final String FORUM_POST_KEY = "forum-post";

	PostDTO post;
	
	public CreatePost(Request request, Response response) {
		MultiMap<String> map = new MultiMap<>();
		UrlEncoded.decodeTo(request.body(), map, StandardCharsets.UTF_8);
		String forumPost = map.getString(FORUM_POST_KEY);
		
		PostDTO created = new PostDTO(
				UUID.randomUUID(),
				ForumUser.TEST_USER.getUserId(), 
				LocalDateTime.now(), 
				"NO THREAD", 
				forumPost, 
				PostStatus.OK);
		
		log.info("Created post: {}", created);
		
		this.post = created;
	}
}
