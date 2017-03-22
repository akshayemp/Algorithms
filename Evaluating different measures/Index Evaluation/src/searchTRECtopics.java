import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.queryparser.classic.ParseException;

public class searchTRECtopics {

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
																// split on
																// Description.
		return parts;
	}

	public static void main(String args[]) throws IOException {
		String[] short_queries = getQuery("title", "desc", "Topic:");
		String[] long_queries = getQuery("desc", "smry", "Description:");
		searchQuery(short_queries,"short_query_rank.txt");
		searchQuery(long_queries,"long_query_rank.txt");
		

	}
	public static void searchQuery(String[] queries,String rankFileName) throws IOException{
		easySearch es = new easySearch();
		int qid = -1;
		for(String query : queries){
			++qid;
			if(qid == 0){
				continue;
			}
			
			try {
				es.parseQuery(query);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.err.println("Lucene Error while parsing string: " + query);
				continue;
			}	
			Float[] arrayScores = new Float[es.scores.size()];
			
			for(int i=0;i<es.scores.size();i++){
				arrayScores[i] = es.scores.get(i);
			}
			IndexComparator comparator = new IndexComparator(arrayScores);
			Integer[] indexes = comparator.createIndexArray();
			Arrays.sort(indexes, comparator);
			
			int count = 0;
			for(int index:indexes){
				if(count == 20){
					break;
				}
				try{
				String content = qid+" Q0 "+ es.docNumber.get(index) +" "+(count+1)+" "+ arrayScores[index]+" run-1 "+"\n"; 
				File file = new File("src/"+rankFileName);
				if (!file.exists()) {
					file.createNewFile();
				}

				FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content);
				
				bw.close();
				count++;
				}catch(IndexOutOfBoundsException io){
					continue;
				}
			}
				
		}
		
	}
	
	
}
