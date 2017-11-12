package fashionable.model.post;

import spark.Request;
import spark.Response;

@lombok.extern.slf4j.Slf4j
public class MakePost {
	public static final String TEMPLATE_NAME = "testpost.ftm";

	public MakePost(Request req, Response res) {
		log.debug("Creating new MakePost");
	}
	
}
