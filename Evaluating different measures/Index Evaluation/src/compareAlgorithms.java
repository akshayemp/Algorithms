
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.BM25Similarity;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.search.similarities.LMDirichletSimilarity;
import org.apache.lucene.search.similarities.LMJelinekMercerSimilarity;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.FSDirectory;

public class compareAlgorithms {

	private compareAlgorithms() {
	}

	public static String getContentsOfTag(final String str, String tag1, String tag2) {
		String new_str = match(str, "(?s)((?:[^\n][\n]?)+)");
		String match = match(new_str, "<" + tag1 + ">([\\s\\S]*?)<" + tag2 + ">");
		return match;
	}

	public static String match(String content, String pattern) {
		String matched = "";
		Pattern regex = Pattern.compile(pattern);
		final Matcher matcher = regex.matcher(content);
		while (matcher.find()) {
			matched += matcher.group(1);
			matched += " ";
		}
		return matched;
	}

	public static String[] getQuery(String tag1, String tag2, String split_on) throws IOException {
		String text = "";
		String file = "src/topics.51-100";

		InputStream is = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;
		while ((line = br.readLine()) != null) {
			text += line + "\n";
		}

		String content_text = getContentsOfTag(text, tag1, tag2);
		String[] parts = content_text.trim().split(split_on); // 0th index has a
																// space because
																// there's a
																// split on //
																// Description.
		return parts;
	}

	public static void runAlgorithms(String[] queries, Similarity sim, String name) throws IOException, ParseException {
		int qid = -1;
		for (String queryStr : queries) {
			String queryString = queryStr;
			++qid;
			if (qid == 0) {
				continue;
			}
			String index = "src/index";
			IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(index)));
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer();
			searcher.setSimilarity(sim);

			QueryParser parser = new QueryParser("TEXT", analyzer);
			try {
				Query query = parser.parse(queryString);

				System.out.println("Searching for: " + query.toString("TEXT"));

				TopDocs results = searcher.search(query, 1000);

				// Print number of hits
				int numTotalHits = results.totalHits;
				System.out.println(numTotalHits + " total matching documents");

				// Print retrieved results
				ScoreDoc[] hits = results.scoreDocs;
				for (int i = 0; i < hits.length; i++) {
					Document doc = searcher.doc(hits[i].doc);
					String content = "DOCNO: " + doc.get("DOCNO") + "doc=" + hits[i].doc + " score=" + hits[i].score;
					File file = new File("src/" + name + ".txt");
					if (!file.exists()) {
						file.createNewFile();
					}

					FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(content);

					bw.close();
				}

				reader.close();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.err.println("Lucene Error while parsing string: " + queryStr);
				continue;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String[] short_queries = getQuery("title", "desc", "Topic:");
		String[] long_queries = getQuery("desc", "smry", "Description:");
		runAlgorithms(short_queries, new BM25Similarity(), "BM25short_query");
		runAlgorithms(short_queries, new ClassicSimilarity(), "VectorSpaceshort_query");
		runAlgorithms(short_queries, new LMDirichletSimilarity(), "LMDirichletshort_query");
		runAlgorithms(short_queries, new LMJelinekMercerSimilarity((float) 0.7), "LMJelinekMercershort_query");

		runAlgorithms(long_queries, new BM25Similarity(), "BM25long_query");
		runAlgorithms(long_queries, new ClassicSimilarity(), "VectorSpacelong_query");
		runAlgorithms(long_queries, new LMDirichletSimilarity(), "LMDirichletlong_query");
		runAlgorithms(long_queries, new LMJelinekMercerSimilarity((float) 0.7), "LMJelinekMercerlong_query");

	}
}