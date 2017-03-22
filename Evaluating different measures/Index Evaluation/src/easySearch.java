import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.LeafReaderContext;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.PostingsEnum;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.similarities.ClassicSimilarity;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

public class easySearch {

	public static ArrayList<Float> scores = new ArrayList<Float>();
	public static ArrayList docNumber = new ArrayList();

	public static void main(String[] args) throws ParseException, IOException {
		parseQuery("New York");
	}

	public static void parseQuery(String queryString) throws IOException, ParseException {
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get("src/index")));
		IndexSearcher searcher = new IndexSearcher(reader);

		/**
		 * Get query terms from the query string
		 */

		// Get the preprocessed query terms
		Analyzer analyzer = new StandardAnalyzer();
		QueryParser parser = new QueryParser("TEXT", analyzer);
		Query query = parser.parse(queryString);
		Set<Term> queryTerms = new LinkedHashSet<Term>();
		searcher.createNormalizedWeight(query, false).extractTerms(queryTerms);

		findScores(reader, searcher, queryTerms);

	}
	
	public static void calculateRelevance(HashMap<String,ArrayList<Integer>> term_freq
			,ArrayList<Integer> docArray,HashMap<Integer,Double> doc_info, float maxDoc,ArrayList<Integer> dfArray){
		Iterator it1 = term_freq.entrySet().iterator();
		float[] queryRelevance = new float[docArray.size()];
		
		int i  = 0;
		while(it1.hasNext()){	
			Map.Entry pair = (Map.Entry) it1.next();
			ArrayList<Integer> value = (ArrayList<Integer>) pair.getValue();
			System.out.println(pair.getKey());
			for(int j=0;j< docArray.size();j++){
				double idf = Math.log10(1 + ((float) maxDoc / (float) dfArray.get(i)));
				int docNo = docArray.get(j); 
				try{
				float term_rel =  (float) ((value.get(j) / doc_info.get(docNo)) * idf);
				queryRelevance[j] += term_rel;
				System.out.println("Term Relevance for : "+docNo+" "+term_rel);
				}catch(IndexOutOfBoundsException io){
					continue;
				}
			}
			i++;
		}
		
		for(int k = 0; k<docArray.size();k++){
			System.out.println("Query Relevance for doc("+docArray.get(k)+") = " + queryRelevance[k]);
			scores.add(queryRelevance[k]);
		}
		docNumber = docArray;
		
	}

	public static void findScores(IndexReader reader, IndexSearcher searcher, Set<Term> queryTerms) throws IOException {
		List<LeafReaderContext> leafContexts = reader.getContext().reader().leaves();
		HashMap<Integer,Double> doc_info = new HashMap<Integer,Double>();
		// Processing each segment
		double queryScore = 0;
		
			double term_rel = 0;
			ArrayList<Integer> docArray = new ArrayList<Integer>();
			ArrayList<Integer> freqArray = new ArrayList<Integer>();
			ArrayList<Integer> dfArray = new ArrayList<Integer>();
			HashMap<String,ArrayList<Integer>> term_freq= new HashMap<String,ArrayList<Integer>>();
			for (int i = 0; i < leafContexts.size(); i++) {
				
				// Get document length
				LeafReaderContext leafContext = leafContexts.get(i);
				int startDocNo = leafContext.docBase;
				int numberOfDoc = leafContext.reader().maxDoc();
				for (int docId = 0; docId < numberOfDoc; docId++) {
					ClassicSimilarity dSimi = new ClassicSimilarity();
					float normDocLeng = dSimi.decodeNormValue(leafContext.reader().getNormValues("TEXT").get(docId));
					// Get length of the document
					double docLeng = 1 / (normDocLeng * normDocLeng);
					doc_info.put(docId, docLeng);
					docArray.add(docId);
				}

				int df =0;
				for (Term term : queryTerms) {
					df = reader.docFreq(new Term("TEXT", term.text()));
					dfArray.add(df);
					PostingsEnum de = MultiFields.getTermDocsEnum(leafContext.reader(), "TEXT",
							new BytesRef(term.text()));

					int doc;
					int c = 0;
			
					if (de != null) {
						while ((doc = de.nextDoc()) != PostingsEnum.NO_MORE_DOCS) {
							c = de.freq();
							freqArray.add(c);
						}
						term_freq.put(term.text(), freqArray);
					}
					
				}
				
			}
			calculateRelevance(term_freq,docArray, doc_info,reader.maxDoc(),dfArray);
		}
	}