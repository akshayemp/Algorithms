import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;

public class IndexComparision {
	public static void main(String args[]){
		Analyzer standardAnalyzer = new StandardAnalyzer();
		Analyzer keywordAnalyzer = new KeywordAnalyzer();
		Analyzer simpleAnalyzer = new SimpleAnalyzer();
		Analyzer stopAnalyzer = new StopAnalyzer();
		
		try {
			GenerateIndex standardAnalyzerGenerateIndex = new GenerateIndex(standardAnalyzer, false);
			standardAnalyzerGenerateIndex.getStatistics("src/indexes_corpus_"+ standardAnalyzer.getClass().getSimpleName());
			
			GenerateIndex keywordAnalyzerGenerateIndex = new GenerateIndex(keywordAnalyzer, true);
			keywordAnalyzerGenerateIndex.getStatistics("src/indexes_corpus_"+ keywordAnalyzer.getClass().getSimpleName());
			
			GenerateIndex simpleAnalyzerGenerateIndex = new GenerateIndex(simpleAnalyzer, true);
			simpleAnalyzerGenerateIndex.getStatistics("src/indexes_corpus_"+ simpleAnalyzer.getClass().getSimpleName());
			
			GenerateIndex stopAnalyzerGenerateIndex = new GenerateIndex(stopAnalyzer, true);
			stopAnalyzerGenerateIndex.getStatistics("src/indexes_corpus_"+ stopAnalyzer.getClass().getSimpleName());	
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
