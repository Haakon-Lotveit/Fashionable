package fashionable.model.post;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;
import spark.QueryParamsMap;
import spark.Request;
import spark.Response;

@Slf4j
public class CreatePost {
	public static final String TEMPLATE_NAME = "create-post.ftm";
	
	public CreatePost(Request request, Response response) {
		log.debug("Told to create new post. Ain't gon' do shit tho");
		log.debug("Here's the body:\n{}", request.body());
		String post = request.queryMap().get("forum-post").value();
		log.debug("POST: {}", post);
	}
}
