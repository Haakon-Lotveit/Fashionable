package fashionable.model.post;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import fashionable.model.user.ForumUser;

public class PostDAO {
	List<PostDTO> posts;
	Comparator<PostDTO> dateAsc = Comparator.comparing(PostDTO::getTimestamp);
	
	public List<PostDTO> postsByUser(ForumUser user) {
		return posts.stream().filter(post -> post.getAuthorId().equals(user.getUserId())).sorted(dateAsc).collect(toList());
	}
}
