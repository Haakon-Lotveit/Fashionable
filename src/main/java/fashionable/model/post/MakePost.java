package fashionable.model.post;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;

@lombok.extern.slf4j.Slf4j
public class MakePost {
	public static final String TEMPLATE_NAME = "testpost.ftm";

	public MakePost(Request req, Response res) {
		log.debug("Creating new MakePost");
	}
	
	public static Route route(Configuration freemarker) {
		return (req, res) -> {
			try (Writer sw = new StringWriter()) {
				Template template = freemarker.getTemplate(TEMPLATE_NAME);
				template.process(new MakePost(req, res), sw);
				return sw.toString();
			}
			catch(IOException ioe) {
				System.err.println("Fucked up: " + ioe);
				throw new RuntimeException(ioe);
			}
		};
	}
}
