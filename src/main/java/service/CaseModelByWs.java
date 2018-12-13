package service;

import model.*;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public interface CaseModelByWs {
    boolean isWzws();

    WsfdModel jxWsfdModel(String var1, List<String> var2, List<String> var3, String var4, List<String> var5, List<String> var6, List<String> var7, List<String> var8, List<String> var9);

    WswsModel jxWswsModel(List<String> var1);

    List<WssscyrModel> jxWssscyrModelList(List<String> var1, List<String> var2);

    List<WsajjbqkModel> jxWsajjbqkModel(List<String> var1);

    WscpfxgcModel jxWscpfxgcModel(List<String> var1);

    WscpjgModel jxWscpjgModel(List<String> var1);

    WswwModel jxWswwModel(List<String> var1);
}
