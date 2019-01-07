package template.service;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public interface BaseWsAnalyse {

    /**
     * 初始化
     */
    void init();

    /**
     * 划分文首的内容
     */
    void hfWs();

    /**
     * 划分诉讼参与人信息
     */
    void hfSscyr();


    /**
     * 划分案件基本情况
     */
    void hfAjjbqk();

    /**
     * 划分诉讼记录
     */
    void hfSsjl();
    /**
     * 划分裁判分析过程
     */
    void hfCpfxgc();

    /**
     * 划分裁判结果
     */
    void hfCpjg();

    /**
     * 划分文尾
     */
    void hfWw();

    /**
     * 划分附录
     */
    void hfFl();
}
