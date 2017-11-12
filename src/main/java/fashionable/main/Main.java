package fashionable.main;

import java.io.File;
import java.io.IOException;

import fashionable.model.post.CreatePost;
import fashionable.model.post.MakePost;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import lombok.val;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

public class Main {
	public static void main(String[] args) throws Throwable {
		// Set up FreeMarker
		val freemarkerConfiguration = setupFreemarkerDev();
		val freemarkerEngine = new FreeMarkerEngine(freemarkerConfiguration);
		
		// Set up Spark
		Spark.port(8081);
		Spark.get("/hello", (req, res) -> "Spark works just fine");
		
		Spark.get("/test/post", (req, res) -> freemarkerEngine.render(new ModelAndView(new MakePost(req, res), MakePost.TEMPLATE_NAME)));
		Spark.post("/create/post", (req, res) -> freemarkerEngine.render(new ModelAndView(new CreatePost(req, res), CreatePost.TEMPLATE_NAME)));
				
		// It might be neat to have something like this, but that's for later...
		//		pathBuilder.freemarker().path("/...").model(MakePost::new).template(MakePost.TEMPLATE_NAME).get();
	}

	/**
	 * This creates a configuration for freemarker suitable for development.
	 * It is not suitable for production environments.
	 * @return a FreeMarker {@link Configuration} instance suitable for development/debugging.
	 * @throws IOException if anything goes wrong, for example, if it cannot locate the directory for template loading.
	 */
	public static Configuration setupFreemarkerDev() throws IOException {
		Configuration out = new Configuration(Configuration.getVersion()); // Always use newest. This is fine for dev.
		out.setDirectoryForTemplateLoading(new File("src/main/resources/freemarker"));
		out.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		out.setLogTemplateExceptions(true);
		out.setWrapUncheckedExceptions(true);

		return out;
	}
}
