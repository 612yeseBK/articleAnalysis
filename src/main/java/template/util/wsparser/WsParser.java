package template.util.wsparser;

import java.io.InputStream;

public abstract class WsParser {
	protected InputStream is;

	public WsParser(InputStream is){
		this.is=is;
	}
	
	public abstract String getContent() throws Exception;
}
