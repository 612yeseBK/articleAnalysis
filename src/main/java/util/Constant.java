package util;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DocValuesType;
import org.apache.lucene.index.IndexOptions;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class Constant {

	public static long OneDayTime=86400000;
	public static long OneHourTime=3600000;
	
	public static String ProjectName="cpwsqwjs";
	public static final String cl="D://new//cpws//cpws"; 
	public static String IndexPath=cl+"//index";//索引文件
	public static String WsFilePath="resources/ws/";//文书文件存放目录
	public static String beginPath=cl+"/config/begin.ini";
	public static String endPath=cl+"/config/end.ini";
	public static String totalPath=cl+"/config/total.ini";
	
	public static String IndexConfigPath=cl+"/config/indexConfig.ini";//配置文件，保存最新更新索引时间
	public static String IndexLog=cl+"/config/log.ini";
//	public static Version LuceneVersion=Version.LUCENE_5_1_0;
	
	public static int WsnrLength=130;
	public static Analyzer Analyzer=new  IKAnalyzer();
	
	
	public final static String QuanWen="search_qw";
	
	public final static String ZuoZhe="search_zz";
	public final static String WenjianMing="search_wjm";
	public final static String AnJianXuHao="search_ajxh";
	public final static String WenShuJiBiaoBianHao="search_wsjbbh";
	public final static String WenShuNeiRong="search_wsnr";
	
	public static int SearchLength=1000;
	public static int SingleSearchLength=500;
	
	public final static String Index_Ajxh="ajxh";
	public final static String Index_Zz="zz";
	public final static String Index_Wsnr="wsnr";
	public final static String Index_Wsjbbh="wsjbbh";
	public final static String Index_Scrq="scrq";
	public final static String Index_Wswjm="wswjm";
	public final static String Index_Wsmc="wsmc";
	public final static String Index_Wslb="wslb";
	public final static String Index_Sj="sj";
	public final static String Index_Wjlx="wjlx";
	public final static String Index_Ajlx="ajlx";
	public final static String Index_Fy="fy";
	public final static String Index_Scrqsz="scrqsz";
	public final static String Index_Laay="laay";
	public final static String Index_Time="time";
    public final static String Index_Ssjl="ssjl";
	
	
	//以五天为间隔建立索引
	public final static int diff=3;
//	//服务器解析request的默认编码格式，windows为gbk，linux为iso-8859-1
//	public final static String rquestCode="iso-8859-1";
//	//转换成解析的编码,windows用utf-8,linux用GBK
//	public final static String destinateCode="gbk";
	/*public enum SearchWay{
		search_qw,search_zz,search_wjm,search_ajxh,search_wsjbbh,search_wsnr
	}*/

	
	
	//begin
	/*-------author cwm--------*/
	public final static String Index_Ws="ws";  //文首
	public final static String Index_Sscyr="sscyr";  //诉讼参与人
	public final static String Index_Ajjbqk="ajjbqk";  //案件基本情况
	public final static String Index_Cpfxgc="cpfxgc";  //裁判分析过程
	public final static String Index_Cpjg="cpjg";  //裁判结果
	public final static String Index_Ww="ww";  //文尾
	public final static String Index_Fl="fl";  //附录
	
	public final static String Index_Fydm="fydm";//法院代码

	//end
	
	public static final FieldType DOUBLE_FIELD_TYPE_STORED_SORTED = new FieldType();
	static {
	    DOUBLE_FIELD_TYPE_STORED_SORTED.setTokenized(true);
	    DOUBLE_FIELD_TYPE_STORED_SORTED.setOmitNorms(true);
	    DOUBLE_FIELD_TYPE_STORED_SORTED.setIndexOptions(IndexOptions.DOCS);
	    DOUBLE_FIELD_TYPE_STORED_SORTED
	        .setNumericType(FieldType.NumericType.DOUBLE);
	    DOUBLE_FIELD_TYPE_STORED_SORTED.setStored(true);
	    DOUBLE_FIELD_TYPE_STORED_SORTED.setDocValuesType(DocValuesType.NUMERIC);
	    DOUBLE_FIELD_TYPE_STORED_SORTED.freeze();
	}
}
