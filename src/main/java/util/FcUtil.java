package util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 分词工具，获取某个字符串的所有分词
 * @author lr12
 *
 */
public class FcUtil {

	public static List<String> getTokens(String keyword) 
		{
			// TODO Auto-generated method stub
			List<String> tokens = new ArrayList<String>();
			if (StringUtil.isBlank(keyword)) {
				return tokens;
			}
			String text = keyword;
			// 创建分词对象

			// 遍历分词数据

			try {

				Analyzer anal =Constant.Analyzer;
				StringReader reader = new StringReader(text);
				// 分词
				TokenStream ts = anal.tokenStream("", reader);
				ts.reset();
				CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);

				while (ts.incrementToken()) {
					tokens.add(term.toString());
					/*System.out.print(term.toString() + "|");*/
				}
				reader.close();
				ts.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				tokens.clear();
				tokens.add(keyword);
			}

			return tokens;
		
	}
	
	
	public static List<String> getWholeToken(String keyword){
		List<String> tokens = new ArrayList<String>();
		if (StringUtil.isBlank(keyword)) {
			return tokens;
		}
		String text = keyword;
		// 创建分词对象

		// 遍历分词数据

		try {

			IKAnalyzer ikAnalyzer=new IKAnalyzer();
			ikAnalyzer.setUseSmart(true);
			
			StringReader reader = new StringReader(text);
			// 分词
			TokenStream ts = ikAnalyzer.tokenStream("", reader);
			ts.reset();
			CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);

			while (ts.incrementToken()) {
				
				tokens.add(term.toString());
				//System.out.print(term.toString() + "|");
			}
			reader.close();
			ts.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tokens.clear();
			tokens.add(keyword);
		}

		return tokens;
	}
	public static void main(String[] args){
		getTokens("故依法不公开");
	}
}
