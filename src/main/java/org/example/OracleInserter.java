package org.example;

import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;

import static org.example.Oracle.embeddingModel;
import static org.example.Oracle.embeddingStore;

/**
 * Inspired from <a href="https://medium.com/@timju/chromadb-in-java-langchain4j-41ed910cd3e7">ChromaDB in Java (langchain4j 🦜)</a>.
 *
 * @author Loïc Lefèvre
 */
public class OracleInserter {
	/**
	 * Add text.
	 */
	public static void addDocuments(final String text) {
		final TextSegment segment1 = TextSegment.from(text, new Metadata());
		final Embedding embedding1 = embeddingModel.embed(segment1).content();
		embeddingStore.add(embedding1, segment1);
	}

	/**
	 * Add text with metadata.
	 */
	public static void addDocuments(String text, Metadata metadata) {
		final TextSegment segment1 = TextSegment.from(text, metadata);
		final Embedding embedding1 = embeddingModel.embed(segment1).content();
		embeddingStore.add(embedding1, segment1);
	}
}
