package template.util.wsparser.impl;

import template.util.wsparser.WsParser;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.IOException;
import java.io.InputStream;

public class DocxWsParser extends WsParser {

	public DocxWsParser(InputStream is) {
		super(is);
	}

	@Override
	public String getContent() throws Exception {
		try {
			XWPFDocument xwpf = new XWPFDocument(is);
			XWPFWordExtractor extractor=new XWPFWordExtractor(xwpf);
			return extractor.getText();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	
	}

}
