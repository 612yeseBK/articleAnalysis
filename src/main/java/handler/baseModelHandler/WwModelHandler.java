package handler.baseModelHandler;

import model.WswwModel;
import util.DateUtil;
import util.StringUtil;
import util.WwEnum;

import java.util.HashMap;
import java.util.List;

/**
 * description:文尾的处理
 * Created by gaoyw on 2018/12/13.
 */
public class WwModelHandler {
    public WwModelHandler() {
    }

    public WswwModel jxWswwModel(List<String> wsww) {
        WswwModel wswwModel = new WswwModel();
        HashMap<String, String> spzzcyMap = new HashMap();

        for(int i = 0; i < wsww.size(); ++i) {
            String content = (String)wsww.get(i);
            String wwsf = WwEnum.getWw(content);
            String year;
            if (wwsf != null) {
                int index = content.indexOf(wwsf);
                String wwmc = content.substring(index + wwsf.length(), content.length());
                year = WwEnum.getWw(wwmc);
                if (year != null) {
                    content = WwEnum.addBlank(content);
                    String[] contentWithBlank = content.split(" ");
                    String[] var19 = contentWithBlank;
                    int var20 = contentWithBlank.length;

                    for(int var13 = 0; var13 < var20; ++var13) {
                        String s = var19[var13];
                        wsww.add(s);
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
            } else if (content.contains("年") || content.contains("月") || content.contains("日")) {
                try {
                    boolean hasWsrq = content.length() > 8;
                    String wsrq;
                    if (!hasWsrq) {
                        wsrq = null;
                    } else {
                        wsrq = DateUtil.convertToCNDate(content);
                    }

                    if (wsrq != null) {
                        wsrq = DateUtil.convertToCNDate(wsrq);
                        if (wsrq.indexOf("年") - 4 > -1) {
                            year = wsrq.substring(wsrq.indexOf("年") - 4, wsrq.indexOf("年"));
                            String month = wsrq.substring(wsrq.indexOf("年") + 1, wsrq.indexOf("月"));
                            String day = wsrq.substring(wsrq.indexOf("月") + 1, wsrq.indexOf("日"));
                            String yearMonth = year + "-" + month;
                            wswwModel.setWsrq(wsrq);
                            wswwModel.setYear(year);
                            wswwModel.setMonth(month);
                            wswwModel.setDay(day);
                            wswwModel.setYearAndMonth(yearMonth);
                        }
                    }
                } catch (Exception var15) {
                    ;
                }
            }
        }

        wswwModel.setSpzzcyMap(spzzcyMap);
        return wswwModel;
    }
}
