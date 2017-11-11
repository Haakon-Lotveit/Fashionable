package fashionable.main;

import java.io.File;
import java.io.IOException;

import fashionable.view.testpages.makepost.MakePost;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import spark.Spark;

public class Main {
	public static void main(String[] args) throws Throwable {
		// Set up FreeMarker
		Configuration freemarker = setupFreemarker();
		
		// Set up Spark
		Spark.port(8081);
		Spark.get("/hello", (req, res) -> "Spark works just fine");
		Spark.get("/testposting", MakePost.route(freemarker));
	}
	
	public static Configuration setupFreemarker() throws IOException {
		// Everything here is for development, none of this is for an actual program in maintenance.
		Configuration out = new Configuration(Configuration.getVersion()); // Always use newest. This is fine for dev.
		out.setDirectoryForTemplateLoading(new File("src/main/resources/freemarker"));
		out.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		out.setLogTemplateExceptions(true);
		out.setWrapUncheckedExceptions(true);
		
		return out;
	}
}
