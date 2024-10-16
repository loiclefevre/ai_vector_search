package org.example;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingMatch;

import java.util.List;

/**
 * Inspired from <a href="https://medium.com/@timju/chromadb-in-java-langchain4j-41ed910cd3e7">ChromaDB in Java (langchain4j 🦜)</a>.
 *
 * @author Loïc Lefèvre
 */
public class Main {
	public static void main(String[] args) {
		OracleInserter.addDocuments("I like football.");
		OracleInserter.addDocuments("The weather is good today.");

		List<EmbeddingMatch<TextSegment>> search = OracleSearcher.search("What is your favorite sport?", 1);
		// Prints:
		// Score: 0,807478
		// Result: I like football.
		System.out.printf("Score: %f\nResult: %s\n", search.getFirst().score(), search.getFirst().embedded().text());
	}
}