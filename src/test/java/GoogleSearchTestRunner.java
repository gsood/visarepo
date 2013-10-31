import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.junit.Test;

import stories.GoogleSearchEmbedder;


public class GoogleSearchTestRunner {

	@Test
	public void runStories() {
		Embedder embedder = new GoogleSearchEmbedder();
		List<String> storyPaths = new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("src/test/resources"), "**/*.story", "");
		embedder.runStoriesAsPaths(storyPaths);;
	}
}
