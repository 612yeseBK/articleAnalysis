package handler.baseModelHandler;

import model.WscpfxgcFtModel;
import model.WscpfxgcModel;
import service.impl.WsAnalyseImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class CpfxgcModelHandler {
    public CpfxgcModelHandler() {
    }

    public WscpfxgcModel jxWscpfxgcModel(List<String> cpfxgc) {
        WscpfxgcModel wscpfxgcModel = new WscpfxgcModel();
        ArrayList<String> contentlist = WsAnalyseImpl.getWholeContent((String)cpfxgc.get(cpfxgc.size() - 1));
        int index = 0;

        for(int i = 0; i < contentlist.size(); ++i) {
            if (((String)contentlist.get(i)).contains("综上")) {
                index = i;
                break;
            }

            if (((String)contentlist.get(i)).contains("依照") || ((String)contentlist.get(i)).contains("依据")) {
                index = i;
            }
        }

        String ftString = "";

        for(int j = index; j < contentlist.size(); ++j) {
            ftString = ftString + (String)contentlist.get(j);
        }

        String[] ftfz = ftString.split("《");
        ArrayList<WscpfxgcFtModel> ftModellist = new ArrayList();
        wscpfxgcModel.setFtModellist(ftModellist);

        for(int j = 0; j < ftfz.length; ++j) {
            String content = ftfz[j];
            if (content.indexOf("》") != -1) {
                WscpfxgcFtModel ftModel = new WscpfxgcFtModel();
                String flftmc = content.substring(0, content.indexOf("》"));
                ftModel.setFlftmc(flftmc);
                String[] tmString = content.split("条");
                HashMap<String, String> ftMap = new HashMap();
                new ArrayList();

                for(int i = 0; i < tmString.length - 1; ++i) {
                    if (!tmString[i + 1].contains("款") && !tmString[i + 1].contains("项") && tmString[i].contains("第")) {
                        ftMap.put(tmString[i].substring(tmString[i].lastIndexOf("第") + 1, tmString[i].length()), "没有款目");
                    } else if (tmString[i].indexOf("第") > -1) {
                        String tm = tmString[i].substring(tmString[i].lastIndexOf("第") + 1, tmString[i].length());
                        String km = "";
                        if (i < tmString.length - 1 && tmString[i + 1].contains("项")) {
                            km = tmString[i + 1].substring(0, tmString[i + 1].lastIndexOf("项") + 1);
                            ftMap.put(tm, km);
                        }

                        if (i < tmString.length - 1 && tmString[i + 1].contains("款")) {
                            km = tmString[i + 1].substring(0, tmString[i + 1].lastIndexOf("款") + 1);
                            ftMap.put(tm, km);
                        }
                    }
                }

                ftModel.setFtMap(ftMap);
                wscpfxgcModel.getFtModellist().add(ftModel);
            }
        }

        String lastContent = (String)contentlist.get(contentlist.size() - 1);
        if (lastContent != null) {
            int jaindex = lastContent.indexOf("如下");
            if (jaindex != -1) {
                String jafslx = lastContent.substring(jaindex - 2, jaindex);
                wscpfxgcModel.setJafslx(jafslx);
            }
        }

        return wscpfxgcModel;
    }
}
