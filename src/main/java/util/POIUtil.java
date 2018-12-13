package util;

import util.wsparser.WsParser;
import util.wsparser.impl.DocWsParser;
import util.wsparser.impl.DocxWsParser;
import util.wsparser.impl.RtfWsParser;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.*;

public class POIUtil {
	/**去除格式内容
	 * get the content string of byteArray(a file binary byte array)
	 * @throws Exception 
	 */
	public static String getContentString(byte[] wsnr,String title) throws Exception{
		String suffix=getSuffix(title).toLowerCase();
		suffix=suffix.trim();

		try {
			InputStream is=new ByteArrayInputStream(wsnr);
			String result="";
			if("doc".equals(suffix.trim())){
				
				result = getDocContentString(is);
			
			}else if("docx".equals(suffix)){
			
			    System.out.println("docx");
				result =  getDocxContentString(is);
	
			}else if("rtf".equals(suffix)){
			
		      
				result =  getRtfContentString(is);
				
			}
			
			is.close();
			if(result!=null){
				
				result=result.replaceAll(" ", "");
				result=result.replaceAll("\r", "");
				result=result.replaceAll("\n", "");
			}
				
			return result;
		}catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("doc or docx error");
			throw e;
		} 
	}
	/**
	 * 未去除格式内容
	 * @return
	 * @throws Exception 
	 */
	public static String getWqcGString(byte[] wsnr,String title) throws Exception{
		String suffix=getSuffix(title).toLowerCase();
		InputStream is=new ByteArrayInputStream(wsnr);
		WsParser parser = null;
		String temp = new String(wsnr);
		try {
			if(StringUtil.equals(temp.substring(0, 5), "{\\rtf") && !StringUtil.equals("rtf", suffix)){
				//rtf 特殊处理
				parser=new RtfWsParser(is);
			}
			else if("doc".equals(suffix)){
				parser=new DocWsParser(is);
			}else if("docx".equals(suffix)){
				parser=new DocxWsParser(is);
			}else if("rtf".equals(suffix)){
				parser=new RtfWsParser(is);
			}
			is.close();
			if(parser==null){
				return null;
			}
			return parser.getContent();
		}catch (OfficeXmlFileException e) {
			
			parser=new DocxWsParser(new ByteArrayInputStream(wsnr));
			return parser.getContent();
			//e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * get the content string of byteArray(a file binary byte array)
	 */
	public static String getContent(byte[] wsnr,String title) throws Exception{
		if(title!=null)
			title=StringUtil.trim(title);
		String suffix=getSuffix(title).toLowerCase();
		InputStream is=new ByteArrayInputStream(wsnr);
		WsParser parser = null;
		String temp = new String(wsnr);
		try {
			if(StringUtil.equals(temp.substring(0, 5), "{\\rtf") && !StringUtil.equals("rtf", suffix)){
				//rtf 特殊处理
				parser=new RtfWsParser(is);
			}
			else if("doc".equals(suffix)){
				parser=new DocWsParser(is);
			}else if("docx".equals(suffix)){
				parser=new DocxWsParser(is);
			}else if("rtf".equals(suffix)){
				parser=new RtfWsParser(is);
			}
			is.close();
			if(parser==null){
				return null;
			}
			return parser.getContent();
		}catch (OfficeXmlFileException e) {
			
			parser=new DocxWsParser(new ByteArrayInputStream(wsnr));
			return parser.getContent();
			//e.printStackTrace();
		}
		catch (Exception e) {
			//e.printStackTrace();
			throw e;
		}
		
	}
	/**
	 * get the content of a file of which suffix belongs to .doc and .docx and .rtf;
	 * @param file
	 * @return
	 */
	public static String getContentString(File file){
		String filename=file.getName();
		String suffix=getSuffix(filename);
		try {
			FileInputStream fis=new FileInputStream(file);
			String result="";
			if("doc".equals(suffix)){
				result= getDocContentString(fis);
			}else if("docx".equals(suffix)){
				result=  getDocxContentString(fis);
			}else if("rtf".equals(suffix)){
				result=  getRtfContentString(fis);
			}
			fis.close();
			return result;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		} 
		return null;
		
	}
	
	/**
	 * tranform content of *.doc to string 
	 * @throws Exception 
	 */
	public static String getDocContentString(InputStream fis) throws Exception {
		try {
			if(fis==null){
				System.out.println("wsnr is null;");
				return "";
			}
			//System.out.println("doc++++++++++++++++++++");
			WordExtractor extractor=new WordExtractor(fis);
			
			return extractor.getText();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	/**
	 * tranform content of *.docx to string 
	 * @throws Exception 
	 */
	public static String getDocxContentString(InputStream fis) throws Exception{
	//	System.out.println("------do nothing to docx-----");
		System.out.println("Docx;");
		try {
			if(fis==null){
				System.out.println("wsnr is null;");
				return "";
			}
			XWPFDocument xwpf = new XWPFDocument(fis);
			XWPFWordExtractor extractor=new XWPFWordExtractor(xwpf);
			return extractor.getText();
		}  catch (Exception e) {
            throw e;
		}
	}
	
	/**
	 * tranform content of *.rtf to string 
	 */
	public static String getRtfContentString  (InputStream fis) throws Exception{
		RTFEditorKit rtfKit=new RTFEditorKit();
		DefaultStyledDocument dsd=new DefaultStyledDocument();
		try {
			rtfKit.read(fis, dsd, 0);
			String tmp=dsd.getText(0, dsd.getLength());
			return new String(tmp.getBytes("iso-8859-1"),"gbk");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} 
		
		
	}
	
	public static String getSuffix(String filename){
		int posb=filename.lastIndexOf('.');
		return filename.substring(posb+1);
	}
}
