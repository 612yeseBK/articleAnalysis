package template.handler.baseModelHandler;

import template.model.BaseModel.BaseWWModel;
import template.model.another.WswwModel;
import template.util.DateUtil;
import template.util.StringUtil;
import template.util.WwEnum;

import java.util.HashMap;
import java.util.List;

/**
 * description:文尾的处理
 * Created by gaoyw on 2018/12/13.
 */
public class BaseWWModelHandler {
    public BaseWWModelHandler() {
    }

    public BaseWWModel jxWswwModel(List<String> wsww) {
        BaseWWModel baseWWModel = new BaseWWModel();
        WswwModel wswwModel = new WswwModel();
        HashMap<String, String> spzzcyMap = new HashMap();

        for(int i = 0; i < wsww.size(); ++i) {
            String content = wsww.get(i);
            String wwsf = WwEnum.getWw(content);//文尾身份
            if (wwsf != null) {
                int index = content.indexOf(wwsf);
                String wwmc = content.substring(index + wwsf.length(), content.length());  //获取了该身份的人的名字
                String temp = WwEnum.getWw(wwmc);  //有时候几个人的信息连在一起，多以这里的temp依然包含别的人员信息
                if (temp != null) {
                    content = WwEnum.addBlank(content);  //在两个不同职员之间加上空格
                    String[] contentWithBlank = content.split(" ");
                    int length = contentWithBlank.length;

                    for(int j = 0; j < length; ++j) {
                        String s = contentWithBlank[j];
                        wsww.add(s); //将这些信息分隔开后添加到文尾里面
                    }
                } else {
                    if (StringUtil.equals(wwsf, "书记员") && StringUtil.contains(wwmc, "（兼）")) {
                        wwsf = WwEnum.SJYJ.getContent();
                        wwmc = wwmc.substring(0, wwmc.indexOf("（兼）"));
                    } else if (StringUtil.equals(wwsf, "书记员") && StringUtil.contains(wwmc, "（代）")) {
                        wwsf = WwEnum.SJYD.getContent();
                        wwmc = wwmc.substring(0, wwmc.indexOf("（代）"));
                    }
                    spzzcyMap.put(wwmc, wwsf);
                }
            } else if (content.contains("年") && content.contains("月") && content.contains("日")) {  //处理裁判日期的部分
                try {
                    boolean hasWsrq = content.length() > 8;
                    String wsrq = hasWsrq ? DateUtil.convertToCNDate(content) : null;
                    if (wsrq != null) {
                        wsrq = DateUtil.convertToCNDate(wsrq);
                        if (wsrq.indexOf("年") - 4 > -1) {
                            String year = wsrq.substring(wsrq.indexOf("年") - 4, wsrq.indexOf("年"));
                            String month = wsrq.substring(wsrq.indexOf("年") + 1, wsrq.indexOf("月"));
                            String day = wsrq.substring(wsrq.indexOf("月") + 1, wsrq.indexOf("日"));
                            String yearMonth = year + "-" + month;
                            baseWWModel.setCpsj(wsrq);
                            baseWWModel.setYear(year);
                            baseWWModel.setMonth(month);
                            baseWWModel.setDay(day);
                            baseWWModel.setYearAndMonth(yearMonth);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        wswwModel.setSpzzcyMap(spzzcyMap);
        baseWWModel.setSpzzcyMap(spzzcyMap);
        return baseWWModel;
    }
}
