package util.wsparser.impl;

import util.wsparser.WsParser;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.InputStream;

public class RtfWsParser extends WsParser {

	public RtfWsParser(InputStream is) {
		super(is);
	}

	@Override
	public String getContent() throws Exception {
		RTFEditorKit rtfKit=new RTFEditorKit();
		DefaultStyledDocument dsd=new DefaultStyledDocument();
		try {
			rtfKit.read(is, dsd, 0);
			String tmp=dsd.getText(0, dsd.getLength());
			return new String(tmp.getBytes("iso-8859-1"));
		} catch (Exception e) {
                e.printStackTrace();
                throw e;
		}
		
	}

}
