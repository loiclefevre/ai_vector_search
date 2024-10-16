package org.example;

import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.store.embedding.EmbeddingMatch;
import dev.langchain4j.store.embedding.EmbeddingSearchRequest;

import java.util.List;

import static org.example.Oracle.embeddingModel;
import static org.example.Oracle.embeddingStore;

/**
 *  Inspired from <a href="https://medium.com/@timju/chromadb-in-java-langchain4j-41ed910cd3e7">ChromaDB in Java (langchain4j 🦜)</a>.
 *
 * @author Loïc Lefèvre
 */
public class OracleSearcher {
	public static List<EmbeddingMatch<TextSegment>> search(String query, int maxResults) {
		final EmbeddingSearchRequest embeddingSearchRequest = EmbeddingSearchRequest.builder()
				.queryEmbedding(embeddingModel.embed(query).content())
				.maxResults(maxResults)
				.minScore(0.0)
				.build();
		return embeddingStore.search(embeddingSearchRequest).matches();
	}
}
