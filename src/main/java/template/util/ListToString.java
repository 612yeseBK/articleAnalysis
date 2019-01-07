package template.util;

import java.util.List;

public class ListToString {
	public static String List2String(List<String> list){
		String s="";
		if(list==null)
			return s;
		for(String x:list){
			s+=x.toString()+"\n";
		}
		return s;
	}
}
