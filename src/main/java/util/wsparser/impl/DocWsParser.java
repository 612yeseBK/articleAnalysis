package util.wsparser.impl;

import util.wsparser.WsParser;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.IOException;
import java.io.InputStream;

public class DocWsParser extends WsParser{

	public DocWsParser(InputStream is) {
		super(is);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getContent() throws Exception{
		try {
			if(is==null){
				return "";
			}
			WordExtractor extractor=new WordExtractor(is);
			return extractor.getText();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	
	}

}
