import template.handler.baseModelHandler.*;
import template.model.BaseModel.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import template.service.impl.BaseWsAnalyseImpl;
import template.util.FileUtil;

import java.io.IOException;

/**
 * description:
 * Created by gaoyw on 2018/12/17.
 */
public class testModel {
    private static Logger log = org.apache.log4j.Logger.getLogger(testModel.class);

    @Test
    public void test1() throws IOException {
        BaseWsAnalyseImpl baseWsAnalyseImpl = new BaseWsAnalyseImpl(FileUtil.getContent("E:\\myspace\\毕业设计\\工程部分\\文书分析的案例\\11338.docx"),"11338.docx");
        log.info("文首："+baseWsAnalyseImpl.getWs());
        log.info("诉讼参与人："+baseWsAnalyseImpl.getSscyr());
        log.info("诉讼记录："+baseWsAnalyseImpl.getSsjl());
        log.info("案件基本情况："+baseWsAnalyseImpl.getAjjbqk());
        log.info("裁判分析过程："+baseWsAnalyseImpl.getCpfxgc());
        log.info("裁判结果："+baseWsAnalyseImpl.getCpjg());
        log.info("文尾："+baseWsAnalyseImpl.getWw());
        BaseWSModel baseWSModel = (new BaseWSModelHandler()).jxWswsModel(baseWsAnalyseImpl.getWs());
        BaseWWModel baseWWModel= (new BaseWWModelHandler()).jxWswwModel(baseWsAnalyseImpl.getWw());
        BaseCPFXGCModel baseCPFXGCModel = (new BaseCPFXGCModelHandler()).jxWscpfxgcModel(baseWsAnalyseImpl.getCpfxgc());
        BaseSSCYRQJModel baseSSCYRQJModel = (new BaseSSCYRModelHandler()).jxWssscyrModelList(baseWsAnalyseImpl.getSscyr(),baseWsAnalyseImpl.getSsjl());
        BaseSSJLModel baseSSJLModel = (new BaseSSJLModelHandler()).jxWsssjlModel(baseSSCYRQJModel,baseWsAnalyseImpl.getSsjl());
        BaseAJJBQKModel baseAJJBQKModel = new BaseAJJBQKModelHandler().jxWsajjbqkModel(baseWsAnalyseImpl.getAjjbqk());
        log.info(baseWSModel);
        log.info(baseWWModel);
        log.info(baseCPFXGCModel);
        log.info(baseSSJLModel);
        log.info(baseSSCYRQJModel);
        log.info(baseAJJBQKModel);

    }

    @Test
    public void test2(){
        System.out.println(System.getProperty("user.dir"));
    }
}
