package service;

import handler.baseModelHandler.*;
import model.*;
import service.impl.BaseCaseModelByWs;
import service.impl.WsAnalyseImpl;
import util.AjlxEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class WsManager {

    private BaseCaseModelByWs baseCaseModelByWs = new BaseCaseModelByWs();


    public void jxMses(WsAnalyseImpl wsAnalyse, String wsnr, String inputpath, String outputpath, String filename) throws IOException, JDOMException {
        new WsfdModel();
        WswsModel wswsModel = new WswsModel();
        WswwModel wswwModel = new WswwModel();
        WsssjlModel wsssjlModel = new WsssjlModel();
        List<WssscyrModel> wssscyrModellist = new ArrayList();
        WscpjgModel wscpjgModel = new WscpjgModel();
        WscpfxgcModel wscpfxgcModel = new WscpfxgcModel();
        WsajjbqkModel wsajjbqkModel = new WsajjbqkModel();
        WsfdModel wsfdModel = this.baseCaseModelByWs.jxWsfdModel(wsnr, wsAnalyse.getWs(), wsAnalyse.getSscyr(), wsAnalyse.getSsjl(), wsAnalyse.getAjjbqk(), wsAnalyse.getCpfxgc(), wsAnalyse.getCpjg(), wsAnalyse.getWw(), wsAnalyse.getFl());
        if (wsAnalyse.getWs() != null) {
            wswsModel = (new WsModelHandler()).jxWswsModel(wsAnalyse.getWs());
        }

        if (wsAnalyse.getSscyr() != null) {
            wssscyrModellist = (new SscyrModelHandler()).jxWssscyrModelList(wsAnalyse.getSscyr(), wsAnalyse.getSsjl());
        }

        if (wsAnalyse.getSsjl() != null) {
            wsssjlModel = (new SsjlModelHandler()).jxWsssjlModel((List)wssscyrModellist, wsAnalyse.getSsjl());
        }

        if (wsAnalyse.getCpfxgc() != null) {
            wscpfxgcModel = (new CpfxgcModelHandler()).jxWscpfxgcModel(wsAnalyse.getCpfxgc());
        }

        if (wsAnalyse.getCpjg() != null) {
            wscpjgModel = (new CpjgModelHandler()).jxWscpjgModel(wsAnalyse, (List)wssscyrModellist, AjlxEnum.MSES);
        }

        if (wsAnalyse.getAjjbqk() != null) {
            wsajjbqkModel = (new AjjbqkModelHandler()).jxWsajjbqkModel(wsAnalyse.getAjjbqk());
        }

        if (wsAnalyse.getWw() != null) {
            wswwModel = (new WwModelHandler()).jxWswwModel(wsAnalyse.getWw());
        }

        this.xmlUtil.BuildXMLDoc(wsfdModel, wswsModel, (List)wssscyrModellist, wsAnalyse.getSscyr(), wsssjlModel, wsajjbqkModel, (List)null, wscpfxgcModel, wscpjgModel, (XsPjjgModel)null, wswwModel, outputpath, filename, inputpath, AjlxEnum.MSES);
    }
}
