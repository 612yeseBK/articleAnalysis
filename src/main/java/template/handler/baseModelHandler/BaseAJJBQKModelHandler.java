package template.handler.baseModelHandler;

import template.model.BaseModel.BaseAJJBQKModel;
import template.util.FcUtil;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class BaseAJJBQKModelHandler {
    public BaseAJJBQKModelHandler() {
    }

    public BaseAJJBQKModel jxWsajjbqkModel(List<String> ajjbqk) {
        BaseAJJBQKModel baseAJJBQKModel = new BaseAJJBQKModel();
        if (ajjbqk.size() == 1) {

        } else {
            String ajjbqk_1 = ajjbqk.get(0);
            List<String> tokens = FcUtil.getWholeToken(ajjbqk_1);
            int pre = -1;
            int end = -1;
            int bcend = -1;
            int index1 = tokens.size() < 20 ? tokens.size() : 20;
            for (int i = 0; i < index1; ++i) {  //去看一下第一段有没有
                String bsdl = tokens.get(i);
                if (bsdl.equals("诉称")) {
                    pre = 0;
                    break;
                }
            }
            for (int i = 1; i < ajjbqk.size(); ++i) {
                String bsdl = ajjbqk.get(i);
                List<String> nrtoken = FcUtil.getWholeToken(bsdl);
                int index = nrtoken.size() < 20 ? nrtoken.size() : 20;
                for (int j = 0; j < index; ++j) {
                    String bssld = nrtoken.get(i);
                    String ajnr = bsdl.length() < 40 ? bsdl : bsdl.substring(0, 40);
                    if (ajnr.contains("辩称") /*|| bssld.equals("不服") || bssld.equals("上诉") || bssld.equals("上诉人") || bsdl.indexOf("上诉称") > -1 && bsdl.indexOf("上诉称") < 30*/) {
                        end = (end == -1) ? i : end;  //找到诉称的结束
                        bcend = i;
                        break;
                    }
                }
            }
            String ygscd = "";
            for (int k = pre; k < end; k++) {
                ygscd = ygscd + ajjbqk.get(k);
            }
            String bgscd = "";
            for (int bgbcd_index = end; bgbcd_index < bcend + 1; bgbcd_index++) {
                bgscd = bgscd + ajjbqk.get(bgbcd_index);
            }
            String cmssd = "";
            for (int cmssd_index = bcend + 1; cmssd_index < ajjbqk.size(); cmssd_index++) {
                cmssd = cmssd + ajjbqk.get(cmssd_index);
            }


            baseAJJBQKModel.setBgbcd(bgscd);
            baseAJJBQKModel.setYgscd(ygscd);
            baseAJJBQKModel.setCmssd(cmssd);

        }
        return baseAJJBQKModel;

    }

}