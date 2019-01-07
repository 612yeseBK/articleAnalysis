package template.handler.baseModelHandler;

import template.model.BaseModel.BaseCPFXGCModel;
import template.service.impl.BaseWsAnalyseImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * description:裁判分析过程
 * Created by gaoyw on 2018/12/13.
 */
public class BaseCPFXGCModelHandler {
    public BaseCPFXGCModelHandler() {}

    public BaseCPFXGCModel jxWscpfxgcModel(List<String> cpfxgc) {
        BaseCPFXGCModel baseCPFXGCModel = new BaseCPFXGCModel();
        ArrayList<String> contentlist = BaseWsAnalyseImpl.getWholeContent((cpfxgc.get(cpfxgc.size() - 1)));
        int index = 0;

        for(int i = 0; i < contentlist.size(); ++i) {
            if ((contentlist.get(i)).contains("综上")) {
                index = i;
                break;
            }

            if ((contentlist.get(i)).contains("依照") || (contentlist.get(i)).contains("依据")) {
                index = i;
            }
        }

        String ftString = "";

        for(int j = index; j < contentlist.size(); ++j) {
            ftString = ftString + contentlist.get(j);
        }

        String[] ftfz = ftString.split("《");

        for(int j = 0; j < ftfz.length; ++j) {
            String content = ftfz[j];
            if (content.indexOf("》") != -1) {
                BaseCPFXGCModel.FT ft = new BaseCPFXGCModel().new FT();
                String flftmc = content.substring(0, content.indexOf("》"));  //发条名称
                ft.setFtmc(flftmc);
                String[] tmString = content.split("条");
                HashMap<String, String> ftMap = new HashMap();
                new ArrayList();

                for(int i = 0; i < tmString.length - 1; ++i) {
                    if (!tmString[i + 1].contains("款") && !tmString[i + 1].contains("项") && tmString[i].contains("第")) { //没有款，没有项，包含第
                        ftMap.put(tmString[i].substring(tmString[i].lastIndexOf("第") + 1, tmString[i].length()), "没有款目");  //这里就只记录了法条
                    } else if (tmString[i].indexOf("第") > -1) {  //包含有款或者项的情况
                        String tm = tmString[i].substring(tmString[i].lastIndexOf("第") + 1, tmString[i].length());
                        String km ;
                        if (i < tmString.length - 1 && tmString[i + 1].contains("项")) {  //多少条多少项
                            km = tmString[i + 1].substring(0, tmString[i + 1].lastIndexOf("项") + 1);
                            ftMap.put(tm, km);
                        }
                        if (i < tmString.length - 1 && tmString[i + 1].contains("款")) {  //多少条多少款
                            km = tmString[i + 1].substring(0, tmString[i + 1].lastIndexOf("款") + 1);
                            ftMap.put(tm, km);
                        }
                    }
                }
                ft.setTmkm(ftMap);
                baseCPFXGCModel.getFlft().add(ft);
            }
        }

        String lastContent = contentlist.get(contentlist.size() - 1);
        if (lastContent != null) {
            int jaindex = lastContent.indexOf("如下");
            if (jaindex != -1) {
                String jafslx = lastContent.substring(jaindex - 2, jaindex);
                baseCPFXGCModel.setJafslx(jafslx);
            }
        }
        return baseCPFXGCModel;
    }
}
