package template.service;

import template.handler.baseModelHandler.*;
import template.model.BaseModel.*;
import template.model.another.WsfdModel;
import org.jdom.JDOMException;
import template.service.impl.BaseModelServiceImpl;
import template.service.impl.BaseWsAnalyseImpl;
import template.util.AjlxEnum;
import template.util.XmlUtil;
import java.io.IOException;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class WsManager {

    private BaseModelService baseModelService = new BaseModelServiceImpl();


    public void dealBase(BaseWsAnalyseImpl wsAnalyse, String wsnr, String inputpath, String outputpath, String filename) throws IOException, JDOMException {
        BaseWSModel baseWSModel = new BaseWSModel();
        BaseWWModel baseWWModel = new BaseWWModel();
        BaseAJJBQKModel baseAJJBQKModel = new BaseAJJBQKModel();
        BaseSSJLModel baseSSJLModel = new BaseSSJLModel();
        BaseCPFXGCModel baseCPFXGCModel = new BaseCPFXGCModel();
        BaseCPJGModel baseCPJGModel = new BaseCPJGModel();
        BaseSSCYRQJModel baseSSCYRQJModel = new BaseSSCYRQJModel();
        WsfdModel wsfdModel = baseModelService.jxWsfdModel(wsnr, wsAnalyse.getWs(), wsAnalyse.getSscyr(), wsAnalyse.getSsjl(), wsAnalyse.getAjjbqk(), wsAnalyse.getCpfxgc(), wsAnalyse.getCpjg(), wsAnalyse.getWw(), wsAnalyse.getFl());
        if (wsAnalyse.getWs() != null) {
            baseWSModel = (new BaseWSModelHandler()).jxWswsModel(wsAnalyse.getWs());
        }

        if (wsAnalyse.getSscyr() != null) {
            baseSSCYRQJModel = (new BaseSSCYRModelHandler()).jxWssscyrModelList(wsAnalyse.getSscyr(), wsAnalyse.getSsjl());
        }

        if (wsAnalyse.getSsjl() != null) {
            baseSSJLModel = (new BaseSSJLModelHandler()).jxWsssjlModel(baseSSCYRQJModel, wsAnalyse.getSsjl());
        }

        if (wsAnalyse.getCpfxgc() != null) {
            baseCPFXGCModel= (new BaseCPFXGCModelHandler()).jxWscpfxgcModel(wsAnalyse.getCpfxgc());
        }

        if (wsAnalyse.getCpjg() != null) {
            baseCPJGModel = (new BaseCPJGModelHandler()).jxWscpjgModel(wsAnalyse, baseSSCYRQJModel, AjlxEnum.MSES);
        }

        if (wsAnalyse.getAjjbqk() != null) {
            baseAJJBQKModel = (new BaseAJJBQKModelHandler()).jxWsajjbqkModel(wsAnalyse.getAjjbqk());
        }

        if (wsAnalyse.getWw() != null) {
            baseWWModel = (new BaseWWModelHandler()).jxWswwModel(wsAnalyse.getWw());
        }

        XmlUtil.buildBaseXML(wsfdModel, baseWSModel, baseSSCYRQJModel, wsAnalyse.getSscyr(), baseSSJLModel, baseAJJBQKModel, baseCPFXGCModel, baseCPJGModel, baseWWModel, outputpath, filename, inputpath, AjlxEnum.MSES);
    }



}
