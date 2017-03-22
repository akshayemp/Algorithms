import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class GenerateIndex {
	
	public GenerateIndex(){}
	
	public GenerateIndex(Analyzer analyzer, boolean useTextOnly) throws Exception {
		indexFile(analyzer, useTextOnly);
	}

	public static File[] readFolder() throws Exception {
		File folder = new File("src/corpus");
		File[] listOfFiles = folder.listFiles();
		return listOfFiles;
	}

	public static void indexFile(Analyzer analyzer, boolean useTextOnly) throws Exception {
		File[] listOfFiles = readFolder();
		String analyzerName = analyzer.getClass().getSimpleName();
		Directory dir = FSDirectory.open(Paths.get("src/indexes_corpus_" + analyzerName));

		IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
		iwc.setOpenMode(OpenMode.CREATE);
		IndexWriter writer = new IndexWriter(dir, iwc);
		System.out.println("Using " + analyzerName);
		for (int i = 0; i < listOfFiles.length; i++) {
			System.out.println("Creating Index for " + listOfFiles[i].getName());
			indexFile(listOfFiles[i].getName(), writer, useTextOnly);
			System.out.println("Successfully created Index for " + listOfFiles[i].getName());
		}
		System.out.println("Indexing of Corpus is completerd.");
		writer.close();
	}

	public static void indexFile(String filename, IndexWriter writer, boolean useTextOnly) throws Exception {
		String text = "";
		String file = "src/corpus/" + filename;

		InputStream is = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
 
		String line;
		while ((line = br.readLine()) != null) {
			text += line + "\n";
			if(line.equals("</DOC>")){
				if (useTextOnly == true) {
					String content_text = getContentsOfTag(text, "TEXT");
					index(writer, content_text);
				} else {
					String content_docno = getContentsOfTag(text, "DOCNO");
					String content_head = getContentsOfTag(text, "HEAD");
					String content_byline = getContentsOfTag(text, "BYLINE");
					String content_dateline = getContentsOfTag(text, "DATELINE");
					String content_text = getContentsOfTag(text, "TEXT");
					index(writer, content_docno, content_head, content_byline, content_dateline, content_text);
				}
			text = "";
			}
		}

	}

	public static void index(IndexWriter writer, String text) throws IOException {
		Document luceneDoc = new Document();
		luceneDoc.add(new TextField("TEXT", text, Field.Store.YES));
		writer.addDocument(luceneDoc);
	}

	public static void index(IndexWriter writer, String docno, String head, String byline, String dateline, String text)
			throws IOException {
		Document luceneDoc = new Document();
		luceneDoc.add(new StringField("DOCNO", docno, Field.Store.YES));
		luceneDoc.add(new TextField("TEXT", text, Field.Store.YES));
		luceneDoc.add(new TextField("HEAD", head, Field.Store.YES));
		luceneDoc.add(new TextField("BYLINE", byline, Field.Store.YES));
		luceneDoc.add(new StringField("DATELINE", dateline, Field.Store.YES));
		writer.addDocument(luceneDoc);
	}

	public static String getContentsOfTag(final String str, String tag) {
		String content = "";
		String p;

		if (tag == "TEXT") {
			p = "([\\s\\S]*?)";
		} else {
			p = "(.+?)";
		}
		String pattern = "<" + tag + ">" + p + "</" + tag + ">";
		Pattern regex = Pattern.compile(pattern);
		final Matcher matcher = regex.matcher(str);
		while (matcher.find()) {
			content += matcher.group(1);
			content += " ";
		}
		return content;
	}

	public static void getStatistics(String indexPath) throws IOException {
		int count = 0;
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(indexPath)));
		System.out.println("Total number of documents in the corpus:" + reader.maxDoc());
		System.out.println("Number of documents containing the term \"new\" for field \"TEXT\":"
				+ reader.docFreq(new Term("TEXT", "new")));
		System.out.println("Number of occurrences of \"new\" in the field\"TEXT\": "
				+ reader.totalTermFreq(new Term("TEXT", "new")));

		Terms vocabulary = MultiFields.getTerms(reader, "TEXT");

		System.out.println("Size of the vocabulary for this field:" + vocabulary.size());
		System.out.println("Number of documents that have at least one term for this field:" + vocabulary.getDocCount());
		System.out.println("Number of tokens for this field:" + vocabulary.getSumTotalTermFreq());

		System.out.println("Number of postings for this field:" + vocabulary.getSumDocFreq());

		TermsEnum iterator = vocabulary.iterator();
		BytesRef byteRef = null;
		System.out.println("\n*******Vocabulary-Start**********");
		while ((byteRef = iterator.next()) != null) {
			String term = byteRef.utf8ToString();
			count = count + 1;
		}
		System.out.println("Number of terms in vocabulary:"+ count);
		System.out.println("\n*******Vocabulary-End**********");
		reader.close();

	}

}