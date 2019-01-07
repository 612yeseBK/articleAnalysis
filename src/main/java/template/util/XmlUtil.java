package template.util;

import java.util.*;

import template.model.BaseModel.*;
import template.model.another.WsfdModel;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
    public class XmlUtil {
        public XmlUtil() {
        }

        public static void buildBaseXML(WsfdModel wsfdModel, BaseWSModel baseWSModel, BaseSSCYRQJModel wssscyrModellist, List<String> sscyr, BaseSSJLModel baseSSJLModel, BaseAJJBQKModel baseAJJBQKModel, BaseCPFXGCModel baseCPFXGCModel, BaseCPJGModel baseCPJGModel, BaseWWModel baseWWModel, String outputpath, String filename, String path, AjlxEnum ajlxEnum){

        }

//        public void BuildXMLDoc(WsfdModel wsfdModel, WswsModel wswsModel, List<WssscyrModel> wssscyrModellist, List<String> sscyr, WsssjlModel wsssjlModel, WsajjbqkModel wsajjbqkModel, List<WsxszjdModel> wsxszjdModellist, WscpfxgcModel wscpfxgcModel, WscpjgModel wscpjgModel, XsPjjgModel xsPjjgModel, WswwModel wswwModel, String outputpath, String filename, String path, AjlxEnum ajlxEnum) throws IOException, JDOMException {
//            new FileUtil();
//            String specialpath = "C:\\Users\\DTLXY\\Desktop\\";
//            if (wsfdModel.getQw() != null) {
//                Element root = (new Element("QW")).setAttribute("value", wsfdModel.getQw());
//                root.setAttribute("nameCN", "ȫ��");
//                Document Doc = new Document(root);
//                Element ssjl;
//                Element dsrqx;
//                Element qsjafs;
//                if (wsfdModel.getWs() != null) {
//                    ssjl = (new Element("WS")).setAttribute("value", wsfdModel.getWs());
//                    ssjl.setAttribute("nameCN", "����");
//                    root.addContent(ssjl);
//                    if (wswsModel.getWszzdw() != null) {
//                        dsrqx = (new Element("WSZZDW")).setAttribute("value", wswsModel.getWszzdw());
//                        dsrqx.setAttribute("nameCN", "����������λ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getJbfy() != null) {
//                        dsrqx = (new Element("JBFY")).setAttribute("value", wswsModel.getJbfy());
//                        dsrqx.setAttribute("nameCN", "���취Ժ");
//                        ssjl.addContent(dsrqx);
//                        if (wswsModel.getFyjb() != null) {
//                            qsjafs = (new Element("FYJB")).setAttribute("value", wswsModel.getFyjb());
//                            qsjafs.setAttribute("nameCN", "��Ժ����");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wswsModel.getXzqhProv() != null) {
//                            qsjafs = (new Element("XZQH_P")).setAttribute("value", wswsModel.getXzqhProv());
//                            qsjafs.setAttribute("nameCN", "��������(ʡ)");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wswsModel.getXzqhCity() != null) {
//                            qsjafs = (new Element("XZQH_C")).setAttribute("value", wswsModel.getXzqhCity());
//                            qsjafs.setAttribute("nameCN", "��������(��)");
//                            dsrqx.addContent(qsjafs);
//                        }
//                    }
//
//                    if (wswsModel.getWsmc() != null) {
//                        dsrqx = (new Element("WSMC")).setAttribute("value", wswsModel.getWsmc());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getAh() != null) {
//                        dsrqx = (new Element("AH")).setAttribute("value", wswsModel.getAh());
//                        dsrqx.setAttribute("nameCN", "����");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getLand() != null) {
//                        dsrqx = (new Element("LAND")).setAttribute("value", wswsModel.getLand());
//                        dsrqx.setAttribute("nameCN", "�������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getAjxz() != null) {
//                        dsrqx = (new Element("AJXZ")).setAttribute("value", wswsModel.getAjxz());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getWszl() != null) {
//                        dsrqx = (new Element("WSZL")).setAttribute("value", wswsModel.getWszl());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getSpcx() != null) {
//                        dsrqx = (new Element("SPCX")).setAttribute("value", wswsModel.getSpcx());
//                        dsrqx.setAttribute("nameCN", "���г���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wswsModel.getAjlx() != null) {
//                        dsrqx = (new Element("AJLX")).setAttribute("value", wswsModel.getAjlx());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//                }
//
//                Element sscyren;
//                Element xjycs;
//                Element ctrxm;
//                Element qklj;
//                Element xmsfTime;
//                int j;
//                Element cfyy;
//                int i;
//                if (wsfdModel.getSscyr() != null) {
//                    ssjl = (new Element("SSCYRQJ")).setAttribute("value", wsfdModel.getSscyr());
//                    ssjl.setAttribute("nameCN", "���ϲ�����ȫ��");
//                    root.addContent(ssjl);
//                    i = 0;
//
//                    while(true) {
//                        if (i >= sscyr.size()) {
//                            if (wscpjgModel != null && wscpjgModel.getBsgssfbg() != null) {
//                                dsrqx = (new Element("SSCYRQJ")).setAttribute("value", wscpjgModel.getBsgssfbg());
//                                dsrqx.setAttribute("nameCN", "���չ�˾�Ƿ���Ϊ����");
//                                ssjl.addContent(dsrqx);
//                            }
//                            break;
//                        }
//
//                        WssscyrModel wssscyrModel = (WssscyrModel)wssscyrModellist.get(i);
//                        sscyren = (new Element("SSCYR")).setAttribute("value", (String)sscyr.get(i));
//                        sscyren.setAttribute("nameCN", "���ϲ�����");
//                        ssjl.addContent(sscyren);
//                        if (wssscyrModel.getSscyr() != null) {
//                            xjycs = (new Element("SSCYRMC")).setAttribute("value", wssscyrModel.getSscyr());
//                            xjycs.setAttribute("nameCN", "���ϲ���������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getSssf() != null) {
//                            xjycs = (new Element("SSSF")).setAttribute("value", wssscyrModel.getSssf());
//                            xjycs.setAttribute("nameCN", "�������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getSsdw() != null) {
//                            xjycs = (new Element("SSDW")).setAttribute("value", wssscyrModel.getSsdw());
//                            xjycs.setAttribute("nameCN", "���ϵ�λ");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getYsssdw() != null) {
//                            xjycs = (new Element("YSSSDW")).setAttribute("value", wssscyrModel.getYsssdw());
//                            xjycs.setAttribute("nameCN", "ԭ�����ϵ�λ");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getXzfagxzt() != null) {
//                            xjycs = (new Element("XZFLGXZT")).setAttribute("value", wssscyrModel.getXzfagxzt());
//                            xjycs.setAttribute("nameCN", "�������ɹ�ϵ����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getDsrlb() != null) {
//                            xjycs = (new Element("DSRLB")).setAttribute("value", wssscyrModel.getDsrlb());
//                            xjycs.setAttribute("nameCN", "���������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getDsrlx() != null) {
//                            xjycs = (new Element("DSRLX")).setAttribute("value", wssscyrModel.getDsrlx());
//                            xjycs.setAttribute("nameCN", "����������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getXb() != null) {
//                            xjycs = (new Element("XB")).setAttribute("value", wssscyrModel.getXb());
//                            xjycs.setAttribute("nameCN", "�Ա�");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getMz() != null) {
//                            xjycs = (new Element("MZ")).setAttribute("value", wssscyrModel.getMz());
//                            xjycs.setAttribute("nameCN", "����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getCsrq() != null) {
//                            xjycs = (new Element("CSRQ")).setAttribute("value", wssscyrModel.getCsrq());
//                            xjycs.setAttribute("nameCN", "��������");
//                            sscyren.addContent(xjycs);
//                            ctrxm = (new Element("Year")).setAttribute("value", wssscyrModel.getYear());
//                            ctrxm.setAttribute("nameCN", "��");
//                            xjycs.addContent(ctrxm);
//                            qklj = (new Element("Month")).setAttribute("value", wssscyrModel.getMonth());
//                            qklj.setAttribute("nameCN", "��");
//                            xjycs.addContent(qklj);
//                            xmsfTime = (new Element("Day")).setAttribute("value", wssscyrModel.getDay());
//                            xmsfTime.setAttribute("nameCN", "��");
//                            xjycs.addContent(xmsfTime);
//                        }
//
//                        if (wssscyrModel.getDsrwhcd() != null) {
//                            xjycs = (new Element("WHCD")).setAttribute("value", wssscyrModel.getDsrwhcd());
//                            xjycs.setAttribute("nameCN", "�Ļ��̶�");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getGj() != null) {
//                            xjycs = (new Element("GJ")).setAttribute("value", wssscyrModel.getGj());
//                            xjycs.setAttribute("nameCN", "����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getHjd() != null) {
//                            xjycs = (new Element("HJSZD")).setAttribute("value", wssscyrModel.getHjd());
//                            xjycs.setAttribute("nameCN", "�������ڵ�");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getDsrdz() != null) {
//                            xjycs = (new Element("DSRDZ")).setAttribute("value", wssscyrModel.getDsrdz());
//                            xjycs.setAttribute("nameCN", "�����˵�ַ");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getZjhm() != null || wssscyrModel.getZjlx() != null) {
//                            xjycs = (new Element("ZJXX")).setAttribute("nameCN", "֤����Ϣ");
//                            if (wssscyrModel.getZjlx() != null) {
//                                ctrxm = (new Element("ZJLX")).setAttribute("value", wssscyrModel.getZjlx());
//                                ctrxm.setAttribute("nameCN", "֤������");
//                                xjycs.addContent(ctrxm);
//                            }
//
//                            if (wssscyrModel.getZjhm() != null) {
//                                ctrxm = (new Element("ZJHM")).setAttribute("value", wssscyrModel.getZjhm());
//                                ctrxm.setAttribute("nameCN", "֤������");
//                                xjycs.addContent(ctrxm);
//                            }
//                        }
//
//                        if (wssscyrModel.getDtqk() != null) {
//                            xjycs = (new Element("DTQK")).setAttribute("value", wssscyrModel.getDtqk());
//                            xjycs.setAttribute("nameCN", "��ͥ���");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (!StringUtil.isBlank(wssscyrModel.getDwxz())) {
//                            xjycs = (new Element("DWXZ")).setAttribute("value", wssscyrModel.getDwxz());
//                            xjycs.setAttribute("nameCN", "��λ����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (!StringUtil.isBlank(wssscyrModel.getFddbr())) {
//                            xjycs = (new Element("FDDBR")).setAttribute("value", wssscyrModel.getFddbr());
//                            xjycs.setAttribute("nameCN", "��λ����������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (!StringUtil.isBlank(wssscyrModel.getGzdw()) || !StringUtil.isBlank(wssscyrModel.getDsrzw())) {
//                            xjycs = (new Element("DWZWFZ")).setAttribute("nameCN", "��λְ�����");
//                            sscyren.addContent(xjycs);
//                            if (!StringUtil.isBlank(wssscyrModel.getDsrzw()) && wssscyrModel.getDsrzw() != null) {
//                                ctrxm = (new Element("ZW")).setAttribute("value", wssscyrModel.getDsrzw());
//                                ctrxm.setAttribute("nameCN", "ְ��");
//                                xjycs.addContent(ctrxm);
//                            }
//
//                            if (!StringUtil.isBlank(wssscyrModel.getGzdw())) {
//                                ctrxm = (new Element("DWMC")).setAttribute("value", wssscyrModel.getGzdw());
//                                ctrxm.setAttribute("nameCN", "��λ����");
//                                xjycs.addContent(ctrxm);
//                            }
//
//                            if (!StringUtil.isBlank(wssscyrModel.getGzdwxz())) {
//                                ctrxm = (new Element("DWXZ")).setAttribute("value", wssscyrModel.getGzdwxz());
//                                ctrxm.setAttribute("nameCN", "��λ����");
//                                xjycs.addContent(ctrxm);
//                            }
//                        }
//
//                        if (wssscyrModel.getDsrsfzh() != null) {
//                            xjycs = (new Element("DSRSFZH")).setAttribute("value", wssscyrModel.getDsrsfzh());
//                            xjycs.setAttribute("nameCN", "�������Ƿ��ٻ�");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getTshy() != null) {
//                            xjycs = (new Element("TSHY")).setAttribute("value", wssscyrModel.getTshy());
//                            xjycs.setAttribute("nameCN", "������ҵ");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getBglx() != null) {
//                            xjycs = (new Element("BGLX")).setAttribute("value", wssscyrModel.getBglx());
//                            xjycs.setAttribute("nameCN", "��������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getJtsgzr() != null) {
//                            xjycs = (new Element("JTSFZR")).setAttribute("value", wssscyrModel.getJtsgzr());
//                            xjycs.setAttribute("nameCN", "��ͨ�¹�����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getZzjgdm() != null) {
//                            xjycs = (new Element("ZZJGDM")).setAttribute("value", wssscyrModel.getZzjgdm());
//                            xjycs.setAttribute("nameCN", "��֯��������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getXzglfw() != null) {
//                            xjycs = (new Element("XZGLFW")).setAttribute("value", wssscyrModel.getXzglfw());
//                            xjycs.setAttribute("nameCN", "��������Χ");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getZrrsf() != null) {
//                            xjycs = (new Element("ZRRSF")).setAttribute("value", wssscyrModel.getZrrsf());
//                            xjycs.setAttribute("nameCN", "��Ȼ�����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getIsBhr() != null) {
//                            xjycs = (new Element("SFBHR")).setAttribute("value", wssscyrModel.getIsBhr());
//                            xjycs.setAttribute("nameCN", "�Ƿ񱻺���");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getMsssygrlx() != null) {
//                            xjycs = (new Element("FDMSSSYGRLX")).setAttribute("value", wssscyrModel.getMsssygrlx());
//                            xjycs.setAttribute("nameCN", "������������ԭ�������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getXszrablity() != null) {
//                            xjycs = (new Element("XSZRNL")).setAttribute("value", wssscyrModel.getXszrablity());
//                            xjycs.setAttribute("nameCN", "������������");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getHxkyqfz() != null) {
//                            xjycs = (new Element("HXKYQNFZ")).setAttribute("value", wssscyrModel.getHxkyqfz());
//                            xjycs.setAttribute("nameCN", "���̿������ڷ���");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getJskyqfz() != null) {
//                            xjycs = (new Element("JSKYQNFZ")).setAttribute("value", wssscyrModel.getJskyqfz());
//                            xjycs.setAttribute("nameCN", "���Ϳ������ڷ���");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        if (wssscyrModel.getXjycs() != null) {
//                            xjycs = (new Element("XJYCS")).setAttribute("value", wssscyrModel.getXjycs());
//                            xjycs.setAttribute("nameCN", "���Ѻ����");
//                            sscyren.addContent(xjycs);
//                        }
//
//                        Iterator var56;
//                        if (wssscyrModel.getQzcsList() != null) {
//                            for(var56 = wssscyrModel.getQzcsList().iterator(); var56.hasNext(); sscyren.addContent(qklj)) {
//                                QzcsModel qzcsModel = (QzcsModel)var56.next();
//                                qklj = (new Element("QZCS")).setAttribute("nameCN", "ǿ�ƴ�ʩ");
//                                if (qzcsModel.getQzcsCategory() != null) {
//                                    xmsfTime = (new Element("QZCSZL")).setAttribute("value", qzcsModel.getQzcsCategory());
//                                    xmsfTime.setAttribute("nameCN", "ǿ�ƴ�ʩ����");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qzcsModel.getQzcsTime() != null) {
//                                    xmsfTime = (new Element("QZCSZXSJ")).setAttribute("value", qzcsModel.getQzcsTime());
//                                    xmsfTime.setAttribute("nameCN", "ǿ�ƴ�ʩִ��ʱ��");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qzcsModel.getQzcsDw() != null) {
//                                    xmsfTime = (new Element("QZCSZXDW")).setAttribute("value", qzcsModel.getQzcsDw());
//                                    xmsfTime.setAttribute("nameCN", "ǿ�ƴ�ʩִ�е�λ");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qzcsModel.getQscsReason() != null) {
//                                    xmsfTime = (new Element("QZCSYYFZ")).setAttribute("nameCN", "ǿ�ƴ�ʩԭ����");
//
//                                    for(j = 0; j < qzcsModel.getQscsReason().size(); ++j) {
//                                        if (qzcsModel.getQscsReason() != null) {
//                                            cfyy = (new Element("QZCSYY")).setAttribute("value", (String)qzcsModel.getQscsReason().get(0));
//                                            cfyy.setAttribute("nameCN", "ǿ�ƴ�ʩԭ��");
//                                            xmsfTime.addContent(cfyy);
//                                            break;
//                                        }
//                                    }
//
//                                    qklj.addContent(xmsfTime);
//                                }
//                            }
//                        }
//
//                        if (wssscyrModel.getQkqkList() != null) {
//                            for(var56 = wssscyrModel.getQkqkList().iterator(); var56.hasNext(); sscyren.addContent(qklj)) {
//                                QkqkModel qkqkModel = (QkqkModel)var56.next();
//                                qklj = (new Element("QKLJ")).setAttribute("nameCN", "ǰ���Ӽ�");
//                                if (qkqkModel.getQklb() != null) {
//                                    xmsfTime = (new Element("QKLB")).setAttribute("value", qkqkModel.getQklb());
//                                    xmsfTime.setAttribute("nameCN", "ǰ�����");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qkqkModel.getCfTime() != null) {
//                                    xmsfTime = (new Element("CFSJ")).setAttribute("value", qkqkModel.getCfTime());
//                                    xmsfTime.setAttribute("nameCN", "����ʱ��");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qkqkModel.getCfReason() != null) {
//                                    xmsfTime = (new Element("CFYYZ")).setAttribute("nameCN", "����ԭ����");
//
//                                    for(j = 0; j < qkqkModel.getCfReason().size(); ++j) {
//                                        if (qkqkModel.getCfReason() != null) {
//                                            cfyy = (new Element("CFYY")).setAttribute("value", (String)qkqkModel.getCfReason().get(0));
//                                            cfyy.setAttribute("nameCN", "����ԭ��");
//                                            xmsfTime.addContent(cfyy);
//                                            break;
//                                        }
//                                    }
//                                }
//
//                                if (qkqkModel.getCfdw() != null) {
//                                    xmsfTime = (new Element("CFDW")).setAttribute("value", qkqkModel.getCfdw());
//                                    xmsfTime.setAttribute("nameCN", "������λ");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qkqkModel.getCfxs() != null) {
//                                    xmsfTime = (new Element("CFXS")).setAttribute("value", qkqkModel.getCfxs());
//                                    xmsfTime.setAttribute("nameCN", "������ʽ");
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qkqkModel.getCfxq() != null) {
//                                    xmsfTime = (new Element("CFXQZ")).setAttribute("nameCN", "����������");
//                                    Iterator var43 = qkqkModel.getCfxq().iterator();
//
//                                    while(var43.hasNext()) {
//                                        String xq = (String)var43.next();
//                                        Element cfxq = (new Element("CFXQ")).setAttribute("value", xq);
//                                        cfxq.setAttribute("nameCN", "��������");
//                                        xmsfTime.addContent(cfxq);
//                                    }
//
//                                    qklj.addContent(xmsfTime);
//                                }
//
//                                if (qkqkModel.getXmsfTime() != null) {
//                                    xmsfTime = (new Element("XMSFRQ")).setAttribute("value", qkqkModel.getXmsfTime());
//                                    xmsfTime.setAttribute("nameCN", "�����ͷ�����");
//                                    qklj.addContent(xmsfTime);
//                                }
//                            }
//                        }
//
//                        ++i;
//                    }
//                }
//
//                int i;
//                Iterator var35;
//                int j;
//                ArrayList xgr;
//                Element wzzm;
//                if (wsfdModel.getSsjl() != null) {
//                    ssjl = (new Element("SSJL")).setAttribute("value", wsfdModel.getSsjl());
//                    ssjl.setAttribute("nameCN", "���ϼ�¼");
//                    if (wsssjlModel.getAy() != null) {
//                        dsrqx = (new Element("AY")).setAttribute("value", wsssjlModel.getAy());
//                        dsrqx.setAttribute("nameCN", "����");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getAjly() != null) {
//                        dsrqx = (new Element("AJLY")).setAttribute("value", wsssjlModel.getAjly());
//                        dsrqx.setAttribute("nameCN", "������Դ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getAjsj() != null) {
//                        dsrqx = (new Element("AJSJ")).setAttribute("value", wsssjlModel.getAjsj());
//                        dsrqx.setAttribute("nameCN", "�����漰");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getKtsl() != null) {
//                        dsrqx = (new Element("KTSL")).setAttribute("value", wsssjlModel.getKtsl());
//                        dsrqx.setAttribute("nameCN", "��ͥ����");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getKtrq() != null) {
//                        for(i = 0; i < wsssjlModel.getKtrq().size(); ++i) {
//                            if (wsssjlModel.getKtrq().get(i) != null) {
//                                qsjafs = (new Element("KTRQ")).setAttribute("value", (String)wsssjlModel.getKtrq().get(i));
//                                qsjafs.setAttribute("nameCN", "��ͥ����");
//                            }
//                        }
//                    }
//
//                    if (wsssjlModel.getQsah() != null) {
//                        for(i = 0; i < wsssjlModel.getQsah().size(); ++i) {
//                            qsjafs = (new Element("QSAH")).setAttribute("value", (String)wsssjlModel.getQsah().get(i));
//                            qsjafs.setAttribute("nameCN", "ǰ�󰸺�");
//                            ssjl.addContent(qsjafs);
//                        }
//                    }
//
//                    if (wsssjlModel.getKtslxx() != null) {
//                        dsrqx = (new Element("KTSLXX")).setAttribute("value", wsssjlModel.getKtslxx());
//                        if (wsssjlModel.getKtslxx().contains("������") && wsssjlModel.getBgkslyy() != null) {
//                            qsjafs = (new Element("BGKSLYY")).setAttribute("value", wsssjlModel.getBgkslyy());
//                            qsjafs.setAttribute("nameCN", "����������ԭ��");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        dsrqx.setAttribute("nameCN", "��ͥ������Ϣ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getWzay() != null) {
//                        dsrqx = (new Element("WZAY")).setAttribute("value", wsssjlModel.getWzay());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getJcy() != null) {
//                        dsrqx = (new Element("CTSPY")).setAttribute("nameCN", "��ͥ����Ա");
//                        qsjafs = (new Element("JCYFZ")).setAttribute("nameCN", "���Ա����");
//                        sscyren = (new Element("JS")).setAttribute("value", wsssjlModel.getJs());
//                        sscyren.setAttribute("nameCN", "��ɫ");
//                        xjycs = (new Element("JCY")).setAttribute("value", wsssjlModel.getJcy());
//                        xjycs.setAttribute("nameCN", "���Ա");
//                        qsjafs.addContent(sscyren);
//                        qsjafs.addContent(xjycs);
//                        dsrqx.addContent(qsjafs);
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getSsxz() != null) {
//                        dsrqx = (new Element("SSXZ")).setAttribute("value", wsssjlModel.getSsxz());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getJcyjyyqsl() != null) {
//                        dsrqx = (new Element("JCYJYYQSL")).setAttribute("value", wsssjlModel.getJcyjyyqsl());
//                        dsrqx.setAttribute("nameCN", "���Ժ������������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getSnft() != null) {
//                        dsrqx = (new Element("SNFT")).setAttribute("value", wsssjlModel.getSnft());
//                        dsrqx.setAttribute("nameCN", "���귨ͥ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getWsssjlZkjl() != null) {
//                        dsrqx = (new Element("ZKXX")).setAttribute("nameCN", "ָ����Ϣ");
//
//                        for(i = 0; i < wsssjlModel.getWsssjlZkjl().size(); ++i) {
//                            sscyren = (new Element("ZKJL")).setAttribute("nameCN", "ָ�ؼ�¼");
//                            ArrayList<WsssjlZkzmModel> zkzmModellist = ((WsssjlZkjlModel)wsssjlModel.getWsssjlZkjl().get(i)).getZkzmModelist();
//                            xgr = ((WsssjlZkjlModel)wsssjlModel.getWsssjlZkjl().get(i)).getXgr();
//
//                            for(j = 0; j < zkzmModellist.size(); ++j) {
//                                if (zkzmModellist != null && ((WsssjlZkzmModel)zkzmModellist.get(j)).getWzzm() != null) {
//                                    xmsfTime = (new Element("ZKZM")).setAttribute("value", ((WsssjlZkzmModel)zkzmModellist.get(j)).getZkzm());
//                                    xmsfTime.setAttribute("nameCN", "ָ������");
//                                    wzzm = (new Element("WZZM")).setAttribute("value", ((WsssjlZkzmModel)zkzmModellist.get(j)).getWzzm());
//                                    wzzm.setAttribute("nameCN", "��������");
//                                    if (((WsssjlZkzmModel)zkzmModellist.get(j)).getZmdm() != null) {
//                                        cfyy = (new Element("ZMDM")).setAttribute("value", ((WsssjlZkzmModel)zkzmModellist.get(j)).getZmdm());
//                                        cfyy.setAttribute("nameCN", "��������");
//                                        xmsfTime.addContent(cfyy);
//                                    }
//
//                                    xmsfTime.addContent(wzzm);
//                                    sscyren.addContent(xmsfTime);
//                                }
//                            }
//
//                            for(j = 0; j < xgr.size(); ++j) {
//                                if (xgr != null && !((String)xgr.get(j)).contains("���Ժ")) {
//                                    xmsfTime = (new Element("XGR")).setAttribute("value", (String)xgr.get(j));
//                                    xmsfTime.setAttribute("nameCN", "�����");
//                                    sscyren.addContent(xmsfTime);
//                                }
//                            }
//
//                            dsrqx.addContent(sscyren);
//                        }
//
//                        if (dsrqx.getChild("ZKJL") != null) {
//                            ssjl.addContent(dsrqx);
//                        }
//                    }
//
//                    if (wsssjlModel.getQszay() != null) {
//                        dsrqx = (new Element("QSZAY")).setAttribute("value", wsssjlModel.getQszay());
//                        dsrqx.setAttribute("nameCN", "����������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getJysyjycx() != null) {
//                        dsrqx = (new Element("JYSYJYCX")).setAttribute("value", wsssjlModel.getJysyjycx());
//                        dsrqx.setAttribute("nameCN", "�������ü��׳���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getAydm() != null) {
//                        dsrqx = (new Element("AYDM")).setAttribute("value", wsssjlModel.getAydm());
//                        dsrqx.setAttribute("nameCN", "���ɴ���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getXzxwzl() != null) {
//                        dsrqx = (new Element("XZXWZL")).setAttribute("value", wsssjlModel.getXzxwzl());
//                        dsrqx.setAttribute("nameCN", "������Ϊ����");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getXzqqxwzl() != null) {
//                        dsrqx = (new Element("XZQQXWZL")).setAttribute("value", wsssjlModel.getXzqqxwzl());
//                        dsrqx.setAttribute("nameCN", "������Ȩ��Ϊ����");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getXzesqsah() != null) {
//                        dsrqx = (new Element("QSAH")).setAttribute("value", wsssjlModel.getXzesqsah());
//                        dsrqx.setAttribute("nameCN", "ǰ�󰸺�");
//                        if (wsssjlModel.getQsland() != null) {
//                            qsjafs = (new Element("QSLAND")).setAttribute("value", wsssjlModel.getQsland());
//                            qsjafs.setAttribute("nameCN", "ǰ���������");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQsfyjc() != null) {
//                            qsjafs = (new Element("QSFYJC")).setAttribute("value", wsssjlModel.getQsfyjc());
//                            qsjafs.setAttribute("nameCN", "ǰ��Ժ���");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQsahsxh() != null) {
//                            qsjafs = (new Element("QSAHSXH")).setAttribute("value", wsssjlModel.getQsahsxh());
//                            qsjafs.setAttribute("nameCN", "ǰ�󰸺�˳���");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getXsesqsah() != null || wsssjlModel.getQsfy() != null || wsssjlModel.getQscpsj() != null) {
//                        dsrqx = (new Element("AJYLYSLJGD")).setAttribute("nameCN", "������������������");
//                        if (wsssjlModel.getXsesqsah() != null) {
//                            qsjafs = (new Element("QSAH")).setAttribute("value", wsssjlModel.getXsesqsah());
//                            qsjafs.setAttribute("nameCN", "ǰ�󰸺�");
//                            if (wsssjlModel.getQsland() != null) {
//                                sscyren = (new Element("QSLAND")).setAttribute("value", wsssjlModel.getQsland());
//                                sscyren.setAttribute("nameCN", "ǰ���������");
//                                qsjafs.addContent(sscyren);
//                            }
//
//                            if (wsssjlModel.getQsfyjc() != null) {
//                                sscyren = (new Element("QSFYJC")).setAttribute("value", wsssjlModel.getQsfyjc());
//                                sscyren.setAttribute("nameCN", "ǰ��Ժ���");
//                                qsjafs.addContent(sscyren);
//                            }
//
//                            if (wsssjlModel.getQsahsxh() != null) {
//                                sscyren = (new Element("QSAHSXH")).setAttribute("value", wsssjlModel.getQsahsxh());
//                                sscyren.setAttribute("nameCN", "ǰ�󰸺�˳���");
//                                qsjafs.addContent(sscyren);
//                            }
//
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQsfy() != null) {
//                            qsjafs = (new Element("QSFY")).setAttribute("value", wsssjlModel.getQsfy());
//                            qsjafs.setAttribute("nameCN", "ǰ��Ժ");
//                            if (wsssjlModel.getFyjb() != null) {
//                                sscyren = (new Element("FYJB")).setAttribute("value", wsssjlModel.getFyjb());
//                                sscyren.setAttribute("nameCN", "��Ժ����");
//                                qsjafs.addContent(sscyren);
//                            }
//
//                            if (wsssjlModel.getBzfymc() != null) {
//                                sscyren = (new Element("BZFYMC")).setAttribute("value", wsssjlModel.getBzfymc());
//                                sscyren.setAttribute("nameCN", "��׼��Ժ����");
//                                qsjafs.addContent(sscyren);
//                            }
//
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQscpsj() != null) {
//                            qsjafs = (new Element("QSCPSJ")).setAttribute("value", wsssjlModel.getQscpsj());
//                            qsjafs.setAttribute("nameCN", "ǰ�����ʱ��");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQspj() != null) {
//                            qsjafs = (new Element("QSPJ")).setAttribute("value", wsssjlModel.getQspj());
//                            qsjafs.setAttribute("nameCN", "ǰ���о�");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQswszl() != null) {
//                            qsjafs = (new Element("QSWSZL")).setAttribute("value", wsssjlModel.getQswszl());
//                            qsjafs.setAttribute("nameCN", "ǰ����������");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQsgsjg() != null) {
//                            qsjafs = (new Element("QSGSJG")).setAttribute("value", wsssjlModel.getQsgsjg());
//                            qsjafs.setAttribute("nameCN", "ǰ���߻���");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQssj() != null) {
//                            qsjafs = (new Element("QSSJ")).setAttribute("value", wsssjlModel.getQssj());
//                            qsjafs.setAttribute("nameCN", "ǰ����");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQsajyl() != null) {
//                            qsjafs = (new Element("QSAJYL")).setAttribute("value", wsssjlModel.getQsajyl());
//                            qsjafs.setAttribute("nameCN", "ǰ�󰸼�����");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsssjlModel.getQsjafs() != null) {
//                            qsjafs = (new Element("QSJAFS")).setAttribute("value", wsssjlModel.getQsjafs());
//                            qsjafs.setAttribute("nameCN", "ǰ��᰸��ʽ");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getSshksfw() != null) {
//                        dsrqx = (new Element("SSHKSFW")).setAttribute("value", wsssjlModel.getSshksfw());
//                        dsrqx.setAttribute("nameCN", "���߻��߷�Χ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getLarq() != null) {
//                        dsrqx = (new Element("LARQ")).setAttribute("value", wsssjlModel.getLarq());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getYsajsycx() != null) {
//                        dsrqx = (new Element("YSAJSYCX")).setAttribute("value", wsssjlModel.getYsajsycx());
//                        dsrqx.setAttribute("nameCN", "һ�󰸼����ó���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getJyzpt() != null) {
//                        dsrqx = (new Element("JYZPT")).setAttribute("value", wsssjlModel.getJyzpt());
//                        dsrqx.setAttribute("nameCN", "����ת��ͨ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getSpzz() != null) {
//                        dsrqx = (new Element("SPZZ")).setAttribute("value", wsssjlModel.getSpzz());
//                        dsrqx.setAttribute("nameCN", "������֯");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getYsajly() != null) {
//                        dsrqx = (new Element("YSAJLY")).setAttribute("value", wsssjlModel.getYsajly());
//                        dsrqx.setAttribute("nameCN", "һ�󰸼���Դ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getGsjg() != null) {
//                        dsrqx = (new Element("GSJG")).setAttribute("value", wsssjlModel.getGsjg());
//                        dsrqx.setAttribute("nameCN", "���߻���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getGsah() != null) {
//                        dsrqx = (new Element("GSAH")).setAttribute("value", wsssjlModel.getGsah());
//                        dsrqx.setAttribute("nameCN", "���߰���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getSlrq() != null) {
//                        dsrqx = (new Element("SLRQ")).setAttribute("value", wsssjlModel.getSlrq());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getQsrq() != null) {
//                        dsrqx = (new Element("QSRQ")).setAttribute("value", wsssjlModel.getQsrq());
//                        dsrqx.setAttribute("nameCN", "��������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getSqcsrq() != null) {
//                        dsrqx = (new Element("SQCSRQ")).setAttribute("value", wsssjlModel.getSqcsrq());
//                        dsrqx.setAttribute("nameCN", "���볷������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getBgzyldct() != null) {
//                        dsrqx = (new Element("BGZYLDCT")).setAttribute("value", wsssjlModel.getBgzyldct());
//                        dsrqx.setAttribute("nameCN", "������Ҫ�쵼��ͥ");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    HashMap map;
//                    Map.Entry entry;
//                    if (wsssjlModel.getQxrxx() != null && !wsssjlModel.getQxrxx().isEmpty()) {
//                        dsrqx = new Element("DXRQX");
//                        dsrqx.setAttribute("nameCN", "������ȱϯ");
//                        map = wsssjlModel.getQxrxx();
//                        var35 = map.entrySet().iterator();
//
//                        while(var35.hasNext()) {
//                            entry = (Map.Entry)var35.next();
//                            if (entry.getKey() != null) {
//                                ctrxm = (new Element("XM")).setAttribute("value", (String)entry.getKey());
//                                ctrxm.setAttribute("nameCN", "����");
//                                if (entry.getValue() != null) {
//                                    qklj = (new Element("SSDW")).setAttribute("value", (String)entry.getValue());
//                                    qklj.setAttribute("nameCN", "���ϵ�λ");
//                                    ctrxm.addContent(qklj);
//                                }
//
//                                dsrqx.addContent(ctrxm);
//                            }
//                        }
//
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsssjlModel.getCtrxx() != null && !wsssjlModel.getCtrxx().isEmpty()) {
//                        dsrqx = new Element("CTDSRXX");
//                        dsrqx.setAttribute("nameCN", "��ͥ��������Ϣ");
//                        map = wsssjlModel.getCtrxx();
//                        var35 = map.entrySet().iterator();
//
//                        while(var35.hasNext()) {
//                            entry = (Map.Entry)var35.next();
//                            if (entry.getKey() != null) {
//                                ctrxm = (new Element("CTRXM")).setAttribute("value", (String)entry.getKey());
//                                ctrxm.setAttribute("nameCN", "��ͥ������");
//                                if (entry.getValue() != null) {
//                                    qklj = (new Element("SSDW")).setAttribute("value", (String)entry.getValue());
//                                    qklj.setAttribute("nameCN", "���ϵ�λ");
//                                    ctrxm.addContent(qklj);
//                                }
//
//                                dsrqx.addContent(ctrxm);
//                            }
//                        }
//
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    root.addContent(ssjl);
//                }
//
//                int i;
//                if (wsfdModel.getAjjbqk() != null && wsfdModel.getAjjbqk() != null) {
//                    ssjl = (new Element("AJJBQK")).setAttribute("value", wsfdModel.getAjjbqk());
//                    ssjl.setAttribute("nameCN", "�����������");
//                    root.addContent(ssjl);
//                    List bhrbh;
//                    if (wsajjbqkModel.getQsdl() != null) {
//                        dsrqx = (new Element("QSDL")).setAttribute("value", wsajjbqkModel.getQsdl());
//                        dsrqx.setAttribute("nameCN", "ǰ�����");
//                        ssjl.addContent(dsrqx);
//                        if (wsajjbqkModel.getQsygscd() != null) {
//                            qsjafs = (new Element("QSYGSCD")).setAttribute("value", wsajjbqkModel.getQsygscd());
//                            qsjafs.setAttribute("nameCN", "ǰ��ԭ���߳ƶ�");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getQsbgbcd() != null) {
//                            qsjafs = (new Element("QSBGBCD")).setAttribute("value", wsajjbqkModel.getQsbgbcd());
//                            qsjafs.setAttribute("nameCN", "ǰ�󱻸��ƶ�");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getQsfsscd() != null) {
//                            qsjafs = (new Element("QSFSSCD")).setAttribute("value", wsajjbqkModel.getQsfsscd());
//                            qsjafs.setAttribute("nameCN", "ǰ�����߳ƶ�");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getQspjd() != null) {
//                            qsjafs = (new Element("QSPJD")).setAttribute("value", wsajjbqkModel.getQspjd());
//                            qsjafs.setAttribute("nameCN", "ǰ���о���");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getQssld() != null) {
//                            bhrbh = wsajjbqkModel.getQssld();
//
//                            for(i = 0; i < bhrbh.size(); ++i) {
//                                xjycs = (new Element("QSSLD")).setAttribute("value", (String)bhrbh.get(i));
//                                xjycs.setAttribute("nameCN", "ǰ�������");
//                                dsrqx.addContent(xjycs);
//                            }
//                        }
//                    }
//
//                    if (wsajjbqkModel.getYgscd() != null) {
//                        dsrqx = (new Element("YGSCD")).setAttribute("value", wsajjbqkModel.getYgscd());
//                        dsrqx.setAttribute("nameCN", "ԭ���߳ƶ�");
//                        ssjl.addContent(dsrqx);
//                        if (wsajjbqkModel.getSsqqjeList() != null && wsajjbqkModel.getSsqqjeList().size() > 0) {
//                            qsjafs = (new Element("SSJE")).setAttribute("nameCN", "��ͨ�¹�ԭ���߳����Ͻ��");
//                            dsrqx.addContent(qsjafs);
//                            var35 = wsajjbqkModel.getSsqqjeList().iterator();
//
//                            while(var35.hasNext()) {
//                                PjjeModel je = (PjjeModel)var35.next();
//                                ctrxm = (new Element("SSJESL")).setAttribute("value", je.getValue());
//                                ctrxm.setAttribute("nameCN", "���");
//                                qsjafs.addContent(ctrxm);
//                                if (je.getCategorys() != null && je.getCategorys().size() > 0) {
//                                    Iterator var41 = je.getCategorys().iterator();
//
//                                    while(var41.hasNext()) {
//                                        String lx = (String)var41.next();
//                                        wzzm = (new Element("SSJELX")).setAttribute("value", lx);
//                                        wzzm.setAttribute("nameCN", "����");
//                                        ctrxm.addContent(wzzm);
//                                    }
//                                }
//
//                                if (je.getJsfs() != null) {
//                                    qklj = (new Element("JSFF")).setAttribute("value", je.getJsfs());
//                                    qklj.setAttribute("nameCN", "���㷽��");
//                                    ctrxm.addContent(qklj);
//                                }
//
//                                if (je.getKssj() != null) {
//                                    qklj = (new Element("KSSJ")).setAttribute("value", je.getKssj());
//                                    qklj.setAttribute("nameCN", "��ʼʱ��");
//                                    ctrxm.addContent(qklj);
//                                }
//
//                                if (je.getJssj() != null) {
//                                    qklj = (new Element("JSSJ")).setAttribute("value", je.getJssj());
//                                    qklj.setAttribute("nameCN", "����ʱ��");
//                                    ctrxm.addContent(qklj);
//                                }
//                            }
//                        }
//                    }
//
//                    if (wsajjbqkModel.getBgbcd() != null) {
//                        dsrqx = (new Element("BGBCD")).setAttribute("value", wsajjbqkModel.getBgbcd());
//                        dsrqx.setAttribute("nameCN", "�����ƶ�");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsajjbqkModel.getFsscd() != null) {
//                        dsrqx = (new Element("FSSCD")).setAttribute("value", wsajjbqkModel.getFsscd());
//                        dsrqx.setAttribute("nameCN", "�����߳ƶ�");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsajjbqkModel.getFsbcd() != null) {
//                        dsrqx = (new Element("FSBCD")).setAttribute("value", wsajjbqkModel.getFsbcd());
//                        dsrqx.setAttribute("nameCN", "���߱�ƶ�");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsajjbqkModel.getDsryjd() != null) {
//                        dsrqx = (new Element("DSRYJD")).setAttribute("value", wsajjbqkModel.getDsryjd());
//                        dsrqx.setAttribute("nameCN", "�����������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    List cmssdlist;
//                    if (wsajjbqkModel.getZjd() != null) {
//                        cmssdlist = wsajjbqkModel.getZjd();
//
//                        for(i = 0; i < cmssdlist.size(); ++i) {
//                            sscyren = (new Element("ZJD")).setAttribute("value", (String)cmssdlist.get(i));
//                            sscyren.setAttribute("nameCN", "֤�ݶ�");
//                            ssjl.addContent(sscyren);
//                        }
//                    }
//
//                    if (wsajjbqkModel.getCmssd() != null) {
//                        cmssdlist = wsajjbqkModel.getCmssd();
//
//                        for(i = 0; i < cmssdlist.size(); ++i) {
//                            sscyren = (new Element("CMSSD")).setAttribute("value", (String)cmssdlist.get(i));
//                            sscyren.setAttribute("nameCN", "������ʵ��");
//                            if (wsajjbqkModel.getSgxq() != null) {
//                                xjycs = (new Element("SGXQ")).setAttribute("value", wsajjbqkModel.getSgxq());
//                                xjycs.setAttribute("nameCN", "�¹�����");
//                                sscyren.addContent(xjycs);
//                                if (wsajjbqkModel.getSgsj() != null) {
//                                    ctrxm = (new Element("SGSJ")).setAttribute("value", wsajjbqkModel.getSgsj());
//                                    ctrxm.setAttribute("nameCN", "�¹�ʱ��");
//                                    xjycs.addContent(ctrxm);
//                                }
//
//                                if (wsajjbqkModel.getSgdd() != null) {
//                                    ctrxm = (new Element("SGDD")).setAttribute("value", wsajjbqkModel.getSgdd());
//                                    ctrxm.setAttribute("nameCN", "�¹ʵص�");
//                                    xjycs.addContent(ctrxm);
//                                }
//                            }
//
//                            if (wsajjbqkModel.getJdcglr() != null) {
//                                xjycs = (new Element("JDCGLR")).setAttribute("value", wsajjbqkModel.getJdcglr());
//                                xjycs.setAttribute("nameCN", "������������");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getJdcsyr() != null) {
//                                xjycs = (new Element("JDCSYR")).setAttribute("value", wsajjbqkModel.getJdcsyr());
//                                xjycs.setAttribute("nameCN", "������������");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getGajgrdyj() != null) {
//                                xjycs = (new Element("GAJGRDYJ")).setAttribute("value", wsajjbqkModel.getGajgrdyj());
//                                xjycs.setAttribute("nameCN", "���������϶����");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getShrjzd() != null) {
//                                xjycs = (new Element("SHRJZD")).setAttribute("value", wsajjbqkModel.getShrjzd());
//                                xjycs.setAttribute("nameCN", "�ܺ��˾�ס��");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getShrzy() != null) {
//                                xjycs = (new Element("SHRZY")).setAttribute("value", wsajjbqkModel.getShrzy());
//                                xjycs.setAttribute("nameCN", "�ܺ���ְҵ");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getSftb() != null) {
//                                xjycs = (new Element("SFTB")).setAttribute("value", wsajjbqkModel.getSftb());
//                                xjycs.setAttribute("nameCN", "�Ƿ�Ͷ��");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getTbxz() != null) {
//                                xjycs = (new Element("TBXZ")).setAttribute("value", wsajjbqkModel.getTbxz());
//                                xjycs.setAttribute("nameCN", "Ͷ������");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getSfzbxqn() != null) {
//                                xjycs = (new Element("SFZBXQN")).setAttribute("value", wsajjbqkModel.getSfzbxqn());
//                                xjycs.setAttribute("nameCN", "�Ƿ��ڱ�������");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getSfxqpf() != null) {
//                                xjycs = (new Element("SFXQPF")).setAttribute("value", wsajjbqkModel.getSfxqpf());
//                                xjycs.setAttribute("nameCN", "�Ƿ������⸶");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getShangQing() != null) {
//                                xjycs = (new Element("SQ")).setAttribute("value", wsajjbqkModel.getShangQing());
//                                xjycs.setAttribute("nameCN", "����");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getRealPay() != null) {
//                                xjycs = (new Element("SJZCQK")).setAttribute("value", wsajjbqkModel.getRealPay());
//                                xjycs.setAttribute("nameCN", "ʵ��֧�����");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getIdentifyContent() != null) {
//                                xjycs = (new Element("XGJD")).setAttribute("value", wsajjbqkModel.getIdentifyContent());
//                                xjycs.setAttribute("nameCN", "��ؼ���");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            if (wsajjbqkModel.getJdsfkk() != null) {
//                                xjycs = (new Element("JDSFKK")).setAttribute("value", wsajjbqkModel.getJdsfkk());
//                                xjycs.setAttribute("nameCN", "�����Ƿ�ɿ�");
//                                sscyren.addContent(xjycs);
//                            }
//
//                            ssjl.addContent(sscyren);
//                        }
//                    }
//
//                    if (wsajjbqkModel.getXzsszyd() != null) {
//                        dsrqx = (new Element("XZSSZYD")).setAttribute("value", wsajjbqkModel.getXzsszyd());
//                        dsrqx.setAttribute("nameCN", "�������������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsajjbqkModel.getBsdl() != null) {
//                        dsrqx = (new Element("BSDL")).setAttribute("value", wsajjbqkModel.getBsdl());
//                        dsrqx.setAttribute("nameCN", "�������");
//                        ssjl.addContent(dsrqx);
//                        if (wsajjbqkModel.getSsrscd() != null) {
//                            qsjafs = (new Element("SSRSCD")).setAttribute("value", wsajjbqkModel.getSsrscd());
//                            qsjafs.setAttribute("nameCN", "�������߳ƶ�");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getBssrbcd() != null) {
//                            bhrbh = wsajjbqkModel.getBssrbcd();
//
//                            for(i = 0; i < bhrbh.size(); ++i) {
//                                xjycs = (new Element("BSSRBCD")).setAttribute("value", (String)bhrbh.get(i));
//                                xjycs.setAttribute("nameCN", "�������˱�ƶ�");
//                                dsrqx.addContent(xjycs);
//                            }
//                        }
//
//                        if (wsajjbqkModel.getBszjd() != null) {
//                            bhrbh = wsajjbqkModel.getBszjd();
//
//                            for(i = 0; i < bhrbh.size(); ++i) {
//                                xjycs = (new Element("BSZJD")).setAttribute("value", (String)bhrbh.get(i));
//                                xjycs.setAttribute("nameCN", "����֤�ݶ�");
//                                dsrqx.addContent(xjycs);
//                            }
//                        }
//
//                        if (wsajjbqkModel.getBssld() != null) {
//                            bhrbh = wsajjbqkModel.getBssld();
//
//                            for(i = 0; i < bhrbh.size(); ++i) {
//                                xjycs = (new Element("BSSLD")).setAttribute("value", (String)bhrbh.get(i));
//                                xjycs.setAttribute("nameCN", "���������");
//                                dsrqx.addContent(xjycs);
//                            }
//                        }
//                    }
//
//                    if (wsajjbqkModel.getZkdl() != null) {
//                        dsrqx = (new Element("ZKDL")).setAttribute("value", wsajjbqkModel.getZkdl());
//                        dsrqx.setAttribute("nameCN", "ָ�ض���");
//                        ssjl.addContent(dsrqx);
//                        if (wsajjbqkModel.getZkss() != null) {
//                            qsjafs = (new Element("ZKSS")).setAttribute("value", wsajjbqkModel.getZkss());
//                            qsjafs.setAttribute("nameCN", "ָ����ʵ");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getZkzj() != null) {
//                            qsjafs = (new Element("ZKZJ")).setAttribute("value", wsajjbqkModel.getZkzj());
//                            qsjafs.setAttribute("nameCN", "ָ��֤��");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getZkyj() != null) {
//                            qsjafs = (new Element("ZKYJ")).setAttribute("value", wsajjbqkModel.getZkyj());
//                            qsjafs.setAttribute("nameCN", "ָ�����");
//                            dsrqx.addContent(qsjafs);
//                        }
//                    }
//
//                    if (wsajjbqkModel.getBhdl() != null) {
//                        dsrqx = (new Element("BHDL")).setAttribute("value", wsajjbqkModel.getBhdl());
//                        dsrqx.setAttribute("nameCN", "�绤����");
//                        ssjl.addContent(dsrqx);
//                        if (wsajjbqkModel.getBgrbc() != null) {
//                            bhrbh = wsajjbqkModel.getBgrbc();
//
//                            for(i = 0; i < bhrbh.size(); ++i) {
//                                xjycs = (new Element("BGRBC")).setAttribute("value", (String)bhrbh.get(i));
//                                xjycs.setAttribute("nameCN", "�����˱��");
//                                dsrqx.addContent(xjycs);
//                            }
//                        }
//
//                        if (wsajjbqkModel.getBhrbh() != null) {
//                            bhrbh = wsajjbqkModel.getBhrbh();
//
//                            for(i = 0; i < bhrbh.size(); ++i) {
//                                xjycs = (new Element("BHRBH")).setAttribute("value", (String)bhrbh.get(i));
//                                xjycs.setAttribute("nameCN", "�绤�˱绤");
//                                dsrqx.addContent(xjycs);
//                            }
//                        }
//                    }
//
//                    if (wsajjbqkModel.getFdmsssqqd() != null) {
//                        dsrqx = (new Element("FDMSSSQQD")).setAttribute("value", wsajjbqkModel.getFdmsssqqd());
//                        dsrqx.setAttribute("nameCN", "�����������������");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsajjbqkModel.getXsbssld() != null) {
//                        dsrqx = (new Element("BSSLD")).setAttribute("value", wsajjbqkModel.getXsbssld());
//                        dsrqx.setAttribute("nameCN", "���������");
//                        ssjl.addContent(dsrqx);
//                        if (wsxszjdModellist != null) {
//                            for(i = 0; i < wsxszjdModellist.size(); ++i) {
//                                WsxszjdModel wsxszjdmodel = (WsxszjdModel)wsxszjdModellist.get(i);
//                                xjycs = new Element("ZJFZ");
//                                xjycs.setAttribute("nameCN", "֤�ݷ���");
//                                dsrqx.addContent(xjycs);
//                                if (wsxszjdmodel.getRdss() != null) {
//                                    ctrxm = (new Element("RDSS")).setAttribute("value", wsxszjdmodel.getRdss());
//                                    ctrxm.setAttribute("nameCN", "�϶���ʵ");
//                                    xjycs.addContent(ctrxm);
//                                }
//
//                                if (wsxszjdmodel.getZjjl() != null) {
//                                    List<String> zjjllist = wsxszjdmodel.getZjjl();
//
//                                    for(j = 0; j < zjjllist.size(); ++j) {
//                                        xmsfTime = (new Element("ZJJL")).setAttribute("value", (String)zjjllist.get(j));
//                                        xmsfTime.setAttribute("nameCN", "֤�ݼ�¼");
//                                        xjycs.addContent(xmsfTime);
//                                    }
//                                }
//                            }
//                        }
//                    }
//
//                    if (wsajjbqkModel.getXsqssld() != null) {
//                        dsrqx = (new Element("QSSLD")).setAttribute("value", wsajjbqkModel.getXsqssld());
//                        dsrqx.setAttribute("nameCN", "ǰ�������");
//                        ssjl.addContent(dsrqx);
//                        if (wsajjbqkModel.getQscmssyzj() != null) {
//                            qsjafs = (new Element("QSCMSSYZJ")).setAttribute("value", wsajjbqkModel.getQscmssyzj());
//                            qsjafs.setAttribute("nameCN", "ǰ�������ʵ��֤��");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wsajjbqkModel.getQscpyzypjjg() != null) {
//                            qsjafs = (new Element("QSCPYZYPJJG")).setAttribute("value", wsajjbqkModel.getQscpyzypjjg());
//                            qsjafs.setAttribute("nameCN", "ǰ�����Ҫּ���о����");
//                            dsrqx.addContent(qsjafs);
//                        }
//                    }
//
//                    if (wsajjbqkModel.getSsssbhyj() != null) {
//                        dsrqx = (new Element("SSSSBHYJ")).setAttribute("value", wsajjbqkModel.getSsssbhyj());
//                        dsrqx.setAttribute("nameCN", "�������߱绤���");
//                        ssjl.addContent(dsrqx);
//                    }
//
//                    if (wsajjbqkModel.getGsjgctyj() != null) {
//                        dsrqx = (new Element("JCJGYJ")).setAttribute("value", wsajjbqkModel.getGsjgctyj());
//                        dsrqx.setAttribute("nameCN", "���������");
//                        ssjl.addContent(dsrqx);
//                    }
//                }
//
//                if (wsfdModel.getCpfxgc() != null) {
//                    ssjl = (new Element("CPFXGC")).setAttribute("value", wsfdModel.getCpfxgc());
//                    ssjl.setAttribute("nameCN", "���з�������");
//                    root.addContent(ssjl);
//                    if (wscpfxgcModel != null) {
//                        if (wscpfxgcModel.getJafslx() != null) {
//                            dsrqx = (new Element("JAFSLX")).setAttribute("value", wscpfxgcModel.getJafslx());
//                            dsrqx.setAttribute("nameCN", "�᰸��ʽ����");
//                            ssjl.addContent(dsrqx);
//                        }
//
//                        if (wscpfxgcModel.getSfjgxzfy() != null) {
//                            dsrqx = (new Element("SFJGXZFY")).setAttribute("value", wscpfxgcModel.getSfjgxzfy());
//                            dsrqx.setAttribute("nameCN", "�Ƿ񾭹���������");
//                            ssjl.addContent(dsrqx);
//                        }
//
//                        if (wscpfxgcModel.getXzxwwfbj() != null) {
//                            dsrqx = (new Element("XZXWWFBJ")).setAttribute("value", wscpfxgcModel.getXzxwwfbj());
//                            dsrqx.setAttribute("nameCN", "������ΪΥ������");
//                            ssjl.addContent(dsrqx);
//                        }
//
//                        if (wscpfxgcModel.getXzpc() != null) {
//                            dsrqx = (new Element("SFTQXZPC")).setAttribute("value", wscpfxgcModel.getXzpc());
//                            dsrqx.setAttribute("nameCN", "�Ƿ����������⳥");
//                            ssjl.addContent(dsrqx);
//                        }
//
//                        if (wscpfxgcModel.getKtqsqchss() != null) {
//                            dsrqx = (new Element("KTQSQCHSS")).setAttribute("value", wscpfxgcModel.getKtqsqchss());
//                            dsrqx.setAttribute("nameCN", "��ͥǰ���볷������");
//                            ssjl.addContent(dsrqx);
//                        }
//
//                        if (wscpfxgcModel.getFtModellist() != null) {
//                            ArrayList<WscpfxgcFtModel> ftModellist = wscpfxgcModel.getFtModellist();
//
//                            for(i = 0; i < ftModellist.size(); ++i) {
//                                sscyren = (new Element("FLFTMC")).setAttribute("value", ((WscpfxgcFtModel)ftModellist.get(i)).getFlftmc());
//                                sscyren.setAttribute("nameCN", "���ɷ�������");
//                                if (((WscpfxgcFtModel)ftModellist.get(i)).getFtMap() != null) {
//                                    Map<String, String> ftMap = ((WscpfxgcFtModel)ftModellist.get(i)).getFtMap();
//
//                                    for(Iterator var47 = ftMap.entrySet().iterator(); var47.hasNext(); sscyren.addContent(xmsfTime)) {
//                                        Map.Entry<String, String> entry = (Map.Entry)var47.next();
//                                        xmsfTime = (new Element("TM")).setAttribute("value", (String)entry.getKey());
//                                        xmsfTime.setAttribute("nameCN", "��Ŀ");
//                                        if (entry.getValue() != "û�п�Ŀ") {
//                                            wzzm = (new Element("KM")).setAttribute("value", (String)entry.getValue());
//                                            wzzm.setAttribute("nameCN", "��Ŀ");
//                                            xmsfTime.addContent(wzzm);
//                                        }
//                                    }
//                                }
//
//                                ssjl.addContent(sscyren);
//                            }
//                        }
//
//                        if (wscpfxgcModel.getFdlxModel() != null || wscpfxgcModel.getFdlxModel() != null) {
//                            dsrqx = (new Element("LXQK")).setAttribute("nameCN", "�������");
//                            ArrayList zdlxModel;
//                            if (wscpfxgcModel.getFdlxModel() != null) {
//                                zdlxModel = wscpfxgcModel.getFdlxModel();
//
//                                for(i = 0; i < zdlxModel.size(); ++i) {
//                                    xjycs = (new Element("FDLXQJ")).setAttribute("nameCN", "�����������");
//                                    if (((WscpfxgcFdlxModel)wscpfxgcModel.getFdlxModel().get(i)).getXgr() != null) {
//                                        xgr = ((WscpfxgcFdlxModel)wscpfxgcModel.getFdlxModel().get(i)).getXgr();
//
//                                        for(j = 0; j < xgr.size(); ++j) {
//                                            xmsfTime = (new Element("XGR")).setAttribute("value", (String)xgr.get(j));
//                                            xmsfTime.setAttribute("nameCN", "�����");
//                                            xjycs.addContent(xmsfTime);
//                                        }
//                                    }
//
//                                    ctrxm = (new Element("QJ")).setAttribute("value", ((WscpfxgcFdlxModel)zdlxModel.get(i)).getQj());
//                                    ctrxm.setAttribute("nameCN", "���");
//                                    xjycs.addContent(ctrxm);
//                                    ArrayList<String> lxqjlbList = ((WscpfxgcFdlxModel)zdlxModel.get(i)).getLxqjlb();
//
//                                    for(int k = 0; k < lxqjlbList.size(); ++k) {
//                                        wzzm = (new Element("LXQJLB")).setAttribute("value", (String)lxqjlbList.get(k));
//                                        wzzm.setAttribute("nameCN", "�����������");
//                                        xjycs.addContent(wzzm);
//                                    }
//
//                                    dsrqx.addContent(xjycs);
//                                }
//                            }
//
//                            if (wscpfxgcModel.getZdlxModel() != null) {
//                                zdlxModel = wscpfxgcModel.getZdlxModel();
//
//                                for(i = 0; i < zdlxModel.size(); ++i) {
//                                    xjycs = (new Element("ZDLXQJ")).setAttribute("nameCN", "�ö��������");
//                                    xgr = ((WscpfxgcZdlxModel)wscpfxgcModel.getZdlxModel().get(i)).getXgr();
//
//                                    for(j = 0; j < xgr.size(); ++j) {
//                                        xmsfTime = (new Element("XGR")).setAttribute("value", (String)xgr.get(j));
//                                        xmsfTime.setAttribute("nameCN", "�����");
//                                        xjycs.addContent(xmsfTime);
//                                    }
//
//                                    qklj = (new Element("QJ")).setAttribute("value", ((WscpfxgcZdlxModel)zdlxModel.get(i)).getQj());
//                                    qklj.setAttribute("nameCN", "���");
//                                    xjycs.addContent(qklj);
//                                    ArrayList<String> lxqjlbList = ((WscpfxgcZdlxModel)zdlxModel.get(i)).getLxqjlb();
//
//                                    for(j = 0; j < lxqjlbList.size(); ++j) {
//                                        cfyy = (new Element("LXQJLB")).setAttribute("value", (String)lxqjlbList.get(j));
//                                        cfyy.setAttribute("nameCN", "�����������");
//                                        xjycs.addContent(cfyy);
//                                    }
//
//                                    dsrqx.addContent(xjycs);
//                                }
//                            }
//
//                            if (dsrqx.getChild("ZDLXQJ") != null) {
//                                ssjl.addContent(dsrqx);
//                            }
//                        }
//
//                        if (wscpfxgcModel.getGtfz() != null) {
//                            dsrqx = (new Element("GTFZ")).setAttribute("value", wscpfxgcModel.getGtfz());
//                            dsrqx.setAttribute("nameCN", "��ͬ����");
//                            ssjl.addContent(dsrqx);
//                        }
//
//                        if (wscpfxgcModel.getBgrtyrzcx() != null) {
//                            dsrqx = (new Element("BGRTYRZCX")).setAttribute("value", wscpfxgcModel.getBgrtyrzcx());
//                            dsrqx.setAttribute("nameCN", "������ͬ���������");
//                            ssjl.addContent(dsrqx);
//                        }
//                    }
//                }
//
//                if (ajlxEnum != null && ajlxEnum.getAjlx().contains("����")) {
//                    buildXspjjg(wsfdModel, xsPjjgModel, root);
//                } else {
//                    buildPjjg(root, wsfdModel, wscpjgModel);
//                }
//
//                if (wsfdModel.getWw() != null) {
//                    ssjl = (new Element("WW")).setAttribute("value", wsfdModel.getWw());
//                    ssjl.setAttribute("nameCN", "��β");
//                    root.addContent(ssjl);
//                    if (wswwModel.getSpzzcyMap() != null) {
//                        Map<String, String> spzzcyMap = wswwModel.getSpzzcyMap();
//                        Iterator var61 = spzzcyMap.entrySet().iterator();
//
//                        while(var61.hasNext()) {
//                            Map.Entry<String, String> entry = (Map.Entry)var61.next();
//                            xjycs = (new Element("SPZZCY")).setAttribute("nameCN", "������֯��Ա");
//                            ctrxm = (new Element("SPRYXM")).setAttribute("value", (String)entry.getKey());
//                            ctrxm.setAttribute("nameCN", "������Ա����");
//                            xjycs.addContent(ctrxm);
//                            qklj = (new Element("SPRYJS")).setAttribute("value", (String)entry.getValue());
//                            qklj.setAttribute("nameCN", "������Ա��ɫ");
//                            xjycs.addContent(qklj);
//                            ssjl.addContent(xjycs);
//                        }
//                    }
//
//                    if (wswwModel.getWsrq() != null) {
//                        dsrqx = (new Element("CPSJ")).setAttribute("value", wswwModel.getWsrq());
//                        dsrqx.setAttribute("nameCN", "����ʱ��");
//                        ssjl.addContent(dsrqx);
//                        if (wswwModel.getYear() != null) {
//                            qsjafs = (new Element("Year")).setAttribute("value", wswwModel.getYear());
//                            qsjafs.setAttribute("nameCN", "�᰸���");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wswwModel.getWsrq() != null) {
//                            qsjafs = (new Element("JANYR")).setAttribute("value", wswwModel.getWsrq());
//                            qsjafs.setAttribute("nameCN", "�᰸������");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wswwModel.getYearAndMonth() != null) {
//                            qsjafs = (new Element("JANY")).setAttribute("value", wswwModel.getYearAndMonth());
//                            qsjafs.setAttribute("nameCN", "�᰸����");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wswwModel.getMonth() != null) {
//                            qsjafs = (new Element("Month")).setAttribute("value", wswwModel.getMonth());
//                            qsjafs.setAttribute("nameCN", "��");
//                            dsrqx.addContent(qsjafs);
//                        }
//
//                        if (wswwModel.getDay() != null) {
//                            qsjafs = (new Element("Day")).setAttribute("value", wswwModel.getDay());
//                            qsjafs.setAttribute("nameCN", "��");
//                            dsrqx.addContent(qsjafs);
//                        }
//                    }
//                }
//
//                if (wsfdModel.getFl() != null) {
//                    ssjl = (new Element("FL")).setAttribute("value", wsfdModel.getFl());
//                    ssjl.setAttribute("nameCN", "��¼");
//                    root.addContent(ssjl);
//                }
//
//                Format format = Format.getPrettyFormat();
//                XMLOutputter XMLOut = new XMLOutputter(format);
//                XMLOut.output(Doc, new FileOutputStream(outputpath + "//" + filename + ".xml"));
//            }
//
//        }
//
//        public static void buildPjjg(Element root, WsfdModel wsfdModel, WscpjgModel wscpjgModel) {
//            if (wsfdModel.getCpjg() != null) {
//                Element cpjg = (new Element("CPJG")).setAttribute("value", wsfdModel.getCpjg());
//                cpjg.setAttribute("nameCN", "���н��");
//                root.addContent(cpjg);
//                Element cslx;
//                if (wscpjgModel.getJafs() != null) {
//                    cslx = (new Element("JAFS")).setAttribute("value", wscpjgModel.getJafs());
//                    cslx.setAttribute("nameCN", "�᰸��ʽ");
//                    cpjg.addContent(cslx);
//                }
//
//                if (wscpjgModel.getPcsxsfzq() != null) {
//                    cslx = (new Element("PCSFSXZQ")).setAttribute("value", wscpjgModel.getPcsxsfzq());
//                    cslx.setAttribute("nameCN", "ͬʱ������Ȩ���뱣�չ�˾���⳥˳��");
//                    cpjg.addContent(cslx);
//                }
//
//                Element pjjg;
//                Iterator var7;
//                Element pjje;
//                Element je;
//                Element ssqx;
//                if (wscpjgModel.getPjjgList() != null && wscpjgModel.getPjjgList().size() > 0) {
//                    Iterator var14 = wscpjgModel.getPjjgList().iterator();
//
//                    label231:
//                    while(true) {
//                        PjjgnrModel pjjgnrModel;
//                        do {
//                            do {
//                                if (!var14.hasNext()) {
//                                    break label231;
//                                }
//
//                                pjjgnrModel = (PjjgnrModel)var14.next();
//                                pjjg = (new Element("JTPJJG")).setAttribute("value", pjjgnrModel.getPjjgnr());
//                                pjjg.setAttribute("nameCN", "������ж�");
//                                cpjg.addContent(pjjg);
//                                Map.Entry entry;
//                                if (pjjgnrModel.getQlr() != null) {
//                                    var7 = pjjgnrModel.getQlr().entrySet().iterator();
//
//                                    while(var7.hasNext()) {
//                                        entry = (Map.Entry)var7.next();
//                                        if (!StringUtil.isBlank((String)entry.getKey())) {
//                                            pjje = (new Element("QLR")).setAttribute("value", (String)entry.getKey());
//                                            pjje.setAttribute("nameCN", "Ȩ����");
//                                            pjjg.addContent(pjje);
//                                            if (!StringUtil.isBlank((String)entry.getValue())) {
//                                                je = (new Element("QLRSSDW")).setAttribute("value", (String)entry.getValue());
//                                                je.setAttribute("nameCN", "���ϵ�λ");
//                                                pjje.addContent(je);
//                                            }
//                                        }
//                                    }
//                                }
//
//                                if (pjjgnrModel.getYwr() != null) {
//                                    var7 = pjjgnrModel.getYwr().entrySet().iterator();
//
//                                    while(var7.hasNext()) {
//                                        entry = (Map.Entry)var7.next();
//                                        if (!StringUtil.isBlank((String)entry.getKey())) {
//                                            pjje = (new Element("YWR")).setAttribute("value", (String)entry.getKey());
//                                            pjje.setAttribute("nameCN", "������");
//                                            pjjg.addContent(pjje);
//                                            if (!StringUtil.isBlank((String)entry.getValue())) {
//                                                je = (new Element("YWRSSDW")).setAttribute("value", (String)entry.getValue());
//                                                je.setAttribute("nameCN", "���ϵ�λ");
//                                                pjje.addContent(je);
//                                            }
//                                        }
//                                    }
//                                }
//
//                                if (!StringUtil.isBlank(pjjgnrModel.getPjzxqx())) {
//                                    ssqx = (new Element("PJZXQX")).setAttribute("value", pjjgnrModel.getPjzxqx());
//                                    ssqx.setAttribute("nameCN", "�о�ִ������");
//                                    pjjg.addContent(ssqx);
//                                }
//                            } while(pjjgnrModel.getPjjeList() == null);
//                        } while(pjjgnrModel.getPjjeList().size() <= 0);
//
//                        var7 = pjjgnrModel.getPjjeList().iterator();
//
//                        while(true) {
//                            PjjeModel jemodel;
//                            do {
//                                do {
//                                    do {
//                                        do {
//                                            if (!var7.hasNext()) {
//                                                continue label231;
//                                            }
//
//                                            jemodel = (PjjeModel)var7.next();
//                                        } while(jemodel == null);
//                                    } while(StringUtil.isBlank(jemodel.getValue()));
//
//                                    pjje = (new Element("PJJE")).setAttribute("nameCN", "�о����");
//                                    pjjg.addContent(pjje);
//                                    je = (new Element("JE")).setAttribute("value", jemodel.getValue());
//                                    je.setAttribute("nameCN", "���");
//                                    pjje.addContent(je);
//                                } while(jemodel.getCategorys() == null);
//                            } while(jemodel.getCategorys().size() <= 0);
//
//                            Iterator var11 = jemodel.getCategorys().iterator();
//
//                            while(var11.hasNext()) {
//                                String s = (String)var11.next();
//                                if (!StringUtil.isBlank(s)) {
//                                    Element jezl = (new Element("JELX")).setAttribute("value", s);
//                                    jezl.setAttribute("nameCN", "�������");
//                                    pjje.addContent(jezl);
//                                }
//                            }
//                        }
//                    }
//                }
//
//                if (wscpjgModel.getSsfModel() != null && !StringUtil.isBlank(wscpjgModel.getSsfModel().getSsfjl())) {
//                    WsCpjgssfModel ssfModel = wscpjgModel.getSsfModel();
//                    Element ajslf = (new Element("SSFCD")).setAttribute("nameCN", "���Ϸѳе�");
//                    cpjg.addContent(ajslf);
//                    pjjg = (new Element("SSFCDJL")).setAttribute("value", wscpjgModel.getSsfModel().getSsfjl());
//                    pjjg.setAttribute("nameCN", "���Ϸѳе���¼");
//                    ajslf.addContent(pjjg);
//                    if (ssfModel.getSsfjeModels() != null && ssfModel.getSsfjeModels().size() > 0) {
//                        var7 = ssfModel.getSsfjeModels().iterator();
//
//                        while(var7.hasNext()) {
//                            WsCpjgssfjeModel jeModel = (WsCpjgssfjeModel)var7.next();
//                            if (!StringUtil.isBlank(jeModel.getValue())) {
//                                pjje = (new Element("SSFJE")).setAttribute("value", jeModel.getValue());
//                                pjje.setAttribute("nameCN", "���Ϸѽ��");
//                                pjjg.addContent(pjje);
//                                if (!StringUtil.isBlank(jeModel.getCategory())) {
//                                    je = (new Element("SSFZL")).setAttribute("value", jeModel.getCategory());
//                                    je.setAttribute("nameCN", "���Ϸ�����");
//                                    pjjg.addContent(je);
//                                }
//                            }
//                        }
//                    }
//
//                    if (ssfModel.getSsfcdModels() != null && ssfModel.getSsfcdModels().size() > 0) {
//                        var7 = ssfModel.getSsfcdModels().iterator();
//
//                        while(var7.hasNext()) {
//                            WscpjgssfcdModel cdModel = (WscpjgssfcdModel)var7.next();
//                            if (!StringUtil.isBlank(cdModel.getCdr())) {
//                                pjje = (new Element("SSFCDR")).setAttribute("value", cdModel.getCdr());
//                                pjje.setAttribute("nameCN", "�е���");
//                                pjjg.addContent(pjje);
//                                if (!StringUtil.isBlank(cdModel.getCdje())) {
//                                    je = (new Element("SSFCDJE")).setAttribute("value", cdModel.getCdje());
//                                    je.setAttribute("nameCN", "�е����");
//                                    pjje.addContent(je);
//                                }
//
//                                if (!StringUtil.isBlank(cdModel.getCdfs())) {
//                                    je = (new Element("SSFCDFS")).setAttribute("value", cdModel.getCdfs());
//                                    je.setAttribute("nameCN", "�е���ʽ");
//                                    pjje.addContent(je);
//                                }
//
//                                if (!StringUtil.isBlank(cdModel.getCdrdw())) {
//                                    je = (new Element("SSFCDDW")).setAttribute("value", cdModel.getCdrdw());
//                                    je.setAttribute("nameCN", "�е��˵�λ");
//                                    pjje.addContent(je);
//                                }
//                            }
//                        }
//                    }
//                }
//
//                if (wscpjgModel.getSfzcssqq() != null) {
//                    cslx = (new Element("SFZCSSQQ")).setAttribute("value", wscpjgModel.getSfzcssqq());
//                    cslx.setAttribute("nameCN", "�Ƿ�֧����������");
//                    cpjg.addContent(cslx);
//                }
//
//                if (wscpjgModel.getSbsf() != null) {
//                    cslx = (new Element("SBSF")).setAttribute("value", wscpjgModel.getSbsf());
//                    cslx.setAttribute("nameCN", "ʤ�߷�");
//                    cpjg.addContent(cslx);
//                }
//
//                if (wscpjgModel.getSffhcs() != null) {
//                    cslx = (new Element("SFFHCS")).setAttribute("value", wscpjgModel.getSffhcs());
//                    cslx.setAttribute("nameCN", "�Ƿ񷢻�����");
//                    cpjg.addContent(cslx);
//                }
//
//                if (wscpjgModel.getFhcsyy() != null) {
//                    cslx = (new Element("FHCSYY")).setAttribute("value", wscpjgModel.getFhcsyy());
//                    cslx.setAttribute("nameCN", "��������ԭ��");
//                    cpjg.addContent(cslx);
//                }
//
//                Iterator var17;
//                String s;
//                if (wscpjgModel.getJabde() != null) {
//                    cslx = (new Element("JABDE")).setAttribute("nameCN", "�᰸��Ľ��");
//                    cpjg.addContent(cslx);
//                    var17 = wscpjgModel.getJabde().iterator();
//
//                    while(var17.hasNext()) {
//                        s = (String)var17.next();
//                        ssqx = (new Element("JABDE_JE")).setAttribute("value", s + "Ԫ");
//                        ssqx.setAttribute("nameCN", "���");
//                        cslx.addContent(ssqx);
//                    }
//                }
//
//                if (wscpjgModel.getJabdze() != null) {
//                    cslx = (new Element("JABDZE")).setAttribute("value", wscpjgModel.getJabdze());
//                    cslx.setAttribute("nameCN", "�᰸����ܶ�");
//                    cpjg.addContent(cslx);
//                }
//
//                if (!StringUtil.isBlank(wscpjgModel.getKssz())) {
//                    cslx = (new Element("KSSZ")).setAttribute("value", wscpjgModel.getKssz());
//                    cslx.setAttribute("nameCN", "��������");
//                    cpjg.addContent(cslx);
//                }
//
//                if (!StringUtil.isBlank(wscpjgModel.getSstjcl())) {
//                    cslx = (new Element("SSTJCL")).setAttribute("value", wscpjgModel.getSstjcl());
//                    cslx.setAttribute("nameCN", "�����ύ����");
//                    cpjg.addContent(cslx);
//                }
//
//                if (!StringUtil.isBlank(wscpjgModel.getSsqx())) {
//                    cslx = (new Element("SSQX")).setAttribute("value", wscpjgModel.getSsqx());
//                    cslx.setAttribute("nameCN", "��������");
//                    cpjg.addContent(cslx);
//                }
//
//                if (wscpjgModel.getCsrjh() != null && wscpjgModel.getCsrjh().size() > 0) {
//                    cslx = (new Element("CSRJH")).setAttribute("nameCN", "�����˼���");
//                    cpjg.addContent(cslx);
//                    var17 = wscpjgModel.getCsrjh().iterator();
//
//                    while(var17.hasNext()) {
//                        s = (String)var17.next();
//                        if (!StringUtil.isBlank(s)) {
//                            ssqx = (new Element("CSR")).setAttribute("value", s);
//                            ssqx.setAttribute("nameCN", "������");
//                            cslx.addContent(ssqx);
//                        }
//                    }
//                }
//
//                if (!StringUtil.isBlank(wscpjgModel.getCslx())) {
//                    cslx = (new Element("CSLX")).setAttribute("value", wscpjgModel.getCslx());
//                    cslx.setAttribute("nameCN", "��������");
//                    cpjg.addContent(cslx);
//                }
//
//                if (!StringUtil.isBlank(wscpjgModel.getSftcgxyy())) {
//                    cslx = (new Element("TCGXQYY")).setAttribute("value", wscpjgModel.getSftcgxyy());
//                    cslx.setAttribute("nameCN", "�Ƿ������ϽȨ����");
//                    cpjg.addContent(cslx);
//                }
//            }
//
//        }
//
//        public static void buildXspjjg(WsfdModel wsfdModel, XsPjjgModel pjjgModel, Element root) {
//            if (wsfdModel.getCpjg() != null) {
//                Element pjjg = (new Element("PJJG")).setAttribute("value", wsfdModel.getCpjg());
//                pjjg.setAttribute("nameCN", "�о����");
//                root.addContent(pjjg);
//                Element ysxsbf;
//                if (!StringUtil.isBlank(pjjgModel.getTcgxyy())) {
//                    ysxsbf = (new Element("SFTCGXQYY")).setAttribute("value", pjjgModel.getTcgxyy());
//                    ysxsbf.setAttribute("nameCN", "�����ϽȨ����");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getJafs())) {
//                    ysxsbf = (new Element("JAFS")).setAttribute("value", pjjgModel.getJafs());
//                    ysxsbf.setAttribute("nameCN", "�᰸��ʽ");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getYsxsbfpjjg())) {
//                    ysxsbf = (new Element("YSXSBFPJJG")).setAttribute("value", pjjgModel.getYsxsbfpjjg());
//                    ysxsbf.setAttribute("nameCN", "һ�����²����о����");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getFdmscpjg())) {
//                    ysxsbf = (new Element("FDMSBFCPJG")).setAttribute("value", pjjgModel.getFdmscpjg());
//                    ysxsbf.setAttribute("nameCN", "�������²��ֲ��н��");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                Element yzpjjg;
//                if (pjjgModel.getPjjgfzModels() != null && pjjgModel.getPjjgfzModels().size() > 0) {
//                    Iterator var16 = pjjgModel.getPjjgfzModels().iterator();
//
//                    label388:
//                    while(true) {
//                        XspjjgfzModel fzModel;
//                        Element fz;
//                        Element yz;
//                        Element hx;
//                        Element lb;
//                        Element fj;
//                        Element lb;
//                        Iterator var22;
//                        do {
//                            do {
//                                while(true) {
//                                    if (!var16.hasNext()) {
//                                        break label388;
//                                    }
//
//                                    fzModel = (XspjjgfzModel)var16.next();
//                                    Element hx;
//                                    if (StringUtil.isBlank(fzModel.getEslxjg()) && StringUtil.isBlank(fzModel.getEslxjg())) {
//                                        fz = (new Element("XSPJJGFZ")).setAttribute("nameCN", "�����о��������");
//                                        pjjg.addContent(fz);
//                                        if (fzModel.getSscyr() != null) {
//                                            yzpjjg = (new Element("SSCYR")).setAttribute("value", fzModel.getSscyr());
//                                            yzpjjg.setAttribute("nameCN", "���ϲ�����");
//                                            fz.addContent(yzpjjg);
//                                        }
//
//                                        Element lb;
//                                        if (fzModel.getDzpf() != null) {
//                                            Iterator var19 = fzModel.getDzpf().iterator();
//
//                                            while(var19.hasNext()) {
//                                                PfModel pf = (PfModel)var19.next();
//                                                lb = (new Element("DZPF")).setAttribute("value", pf.getPfnr());
//                                                lb.setAttribute("nameCN", "�����з�");
//                                                fz.addContent(lb);
//                                                if (pf.getZm() != null) {
//                                                    yz = (new Element("ZM")).setAttribute("value", pf.getZm().getZm());
//                                                    yz.setAttribute("nameCN", "����");
//                                                    lb.addContent(yz);
//                                                }
//
//                                                if (pf.getZx() != null) {
//                                                    yz = (new Element("ZX")).setAttribute("nameCN", "����");
//                                                    lb.addContent(yz);
//                                                    if (pf.getZx().getZxlb() != null) {
//                                                        hx = (new Element("ZXLB")).setAttribute("value", pf.getZx().getZxlb());
//                                                        hx.setAttribute("nameCN", "�������");
//                                                        yz.addContent(hx);
//                                                    }
//
//                                                    if (pf.getZx().getZxxq() != null) {
//                                                        hx = (new Element("ZXQX")).setAttribute("value", pf.getZx().getZxxq());
//                                                        hx.setAttribute("nameCN", "��������");
//                                                        yz.addContent(hx);
//                                                    }
//                                                }
//
//                                                if (pf.getFjxList() != null) {
//                                                    Iterator var24 = pf.getFjxList().iterator();
//
//                                                    label308:
//                                                    while(true) {
//                                                        while(true) {
//                                                            FjxModel fjx;
//                                                            do {
//                                                                if (!var24.hasNext()) {
//                                                                    break label308;
//                                                                }
//
//                                                                fjx = (FjxModel)var24.next();
//                                                                lb = (new Element("FJX")).setAttribute("nameCN", "������");
//                                                                lb.addContent(lb);
//                                                            } while(fjx.getLb() == null);
//
//                                                            fj = (new Element("FJXLB")).setAttribute("value", fjx.getLb());
//                                                            fj.setAttribute("nameCN", "���������");
//                                                            lb.addContent(fj);
//                                                            if (!StringUtil.equals(fjx.getLb(), "����") && !StringUtil.equals(fjx.getLb(), "û�ո��˲��ֲƲ�")) {
//                                                                if (StringUtil.equals(fjx.getLb(), "��������Ȩ��") && fjx.getQx() != null) {
//                                                                    lb = (new Element("QX")).setAttribute("value", fjx.getQx());
//                                                                    lb.setAttribute("nameCN", "����");
//                                                                    fj.addContent(lb);
//                                                                }
//                                                            } else {
//                                                                if (fjx.getSe() != null) {
//                                                                    lb = (new Element("SE")).setAttribute("value", fjx.getSe());
//                                                                    lb.setAttribute("nameCN", "����");
//                                                                    fj.addContent(lb);
//                                                                }
//
//                                                                if (fjx.getBz() != null) {
//                                                                    lb = (new Element("BZ")).setAttribute("value", fjx.getBz());
//                                                                    lb.setAttribute("nameCN", "����");
//                                                                    fj.addContent(lb);
//                                                                }
//                                                            }
//                                                        }
//                                                    }
//                                                }
//
//                                                if (pf.getHx() != null) {
//                                                    yz = (new Element("HX")).setAttribute("nameCN", "����");
//                                                    lb.addContent(yz);
//                                                    if (pf.getHx().getZxlb() != null) {
//                                                        hx = (new Element("HXLB")).setAttribute("value", pf.getHx().getZxlb());
//                                                        hx.setAttribute("nameCN", "�������");
//                                                        yz.addContent(hx);
//                                                    }
//
//                                                    if (pf.getHx().getZxxq() != null) {
//                                                        hx = (new Element("QX")).setAttribute("value", pf.getHx().getZxxq());
//                                                        hx.setAttribute("nameCN", "��������");
//                                                        yz.addContent(hx);
//                                                    }
//                                                }
//
//                                                if (pf.getPjjglx() != null) {
//                                                    yz = (new Element("PJJGLX")).setAttribute("value", pf.getPjjglx());
//                                                    yz.setAttribute("nameCN", "�о��������");
//                                                    lb.addContent(yz);
//                                                }
//                                            }
//                                        }
//
//                                        if (fzModel.getZxpf() != null) {
//                                            yzpjjg = (new Element("ZXPF")).setAttribute("value", fzModel.getZxpf().getPfnr());
//                                            yzpjjg.setAttribute("nameCN", "ִ���з�");
//                                            fz.addContent(yzpjjg);
//                                            if (fzModel.getZxpf().getZx() != null) {
//                                                hx = (new Element("ZX")).setAttribute("nameCN", "����");
//                                                yzpjjg.addContent(hx);
//                                                if (fzModel.getZxpf().getZx().getZxlb() != null) {
//                                                    lb = (new Element("ZXLB")).setAttribute("value", fzModel.getZxpf().getZx().getZxlb());
//                                                    lb.setAttribute("nameCN", "�������");
//                                                    hx.addContent(lb);
//                                                }
//
//                                                if (fzModel.getZxpf().getZx().getZxxq() != null) {
//                                                    lb = (new Element("ZXQX")).setAttribute("value", fzModel.getZxpf().getZx().getZxxq());
//                                                    lb.setAttribute("nameCN", "��������");
//                                                    hx.addContent(lb);
//                                                }
//                                            }
//
//                                            if (fzModel.getZxpf().getFjxList() != null) {
//                                                var22 = fzModel.getZxpf().getFjxList().iterator();
//
//                                                label330:
//                                                while(true) {
//                                                    while(true) {
//                                                        FjxModel fjx;
//                                                        do {
//                                                            if (!var22.hasNext()) {
//                                                                break label330;
//                                                            }
//
//                                                            fjx = (FjxModel)var22.next();
//                                                            yz = (new Element("FJX")).setAttribute("nameCN", "������");
//                                                            yzpjjg.addContent(yz);
//                                                        } while(fjx.getLb() == null);
//
//                                                        hx = (new Element("FJXLB")).setAttribute("value", fjx.getLb());
//                                                        hx.setAttribute("nameCN", "���������");
//                                                        yz.addContent(hx);
//                                                        if (!StringUtil.equals(fjx.getLb(), "����") && !StringUtil.equals(fjx.getLb(), "û�ո��˲��ֲƲ�")) {
//                                                            if (StringUtil.equals(fjx.getLb(), "��������Ȩ��") && fjx.getQx() != null) {
//                                                                lb = (new Element("QX")).setAttribute("value", fjx.getQx());
//                                                                lb.setAttribute("nameCN", "����");
//                                                                hx.addContent(lb);
//                                                            }
//                                                        } else {
//                                                            if (fjx.getSe() != null) {
//                                                                lb = (new Element("SE")).setAttribute("value", fjx.getSe());
//                                                                lb.setAttribute("nameCN", "����");
//                                                                hx.addContent(lb);
//                                                            }
//
//                                                            if (fjx.getBz() != null) {
//                                                                lb = (new Element("BZ")).setAttribute("value", fjx.getBz());
//                                                                lb.setAttribute("nameCN", "����");
//                                                                hx.addContent(lb);
//                                                            }
//                                                        }
//                                                    }
//                                                }
//                                            }
//
//                                            if (fzModel.getZxpf().getHx() != null) {
//                                                hx = (new Element("HX")).setAttribute("nameCN", "����");
//                                                yzpjjg.addContent(hx);
//                                                if (fzModel.getZxpf().getHx().getZxlb() != null) {
//                                                    lb = (new Element("HXLB")).setAttribute("value", fzModel.getZxpf().getHx().getZxlb());
//                                                    lb.setAttribute("nameCN", "�������");
//                                                    hx.addContent(lb);
//                                                }
//
//                                                if (fzModel.getZxpf().getHx().getZxxq() != null) {
//                                                    lb = (new Element("QX")).setAttribute("value", fzModel.getZxpf().getHx().getZxxq());
//                                                    lb.setAttribute("nameCN", "��������");
//                                                    hx.addContent(lb);
//                                                }
//                                            }
//
//                                            if (fzModel.getZxpf().getPjjglx() != null) {
//                                                hx = (new Element("PJJGLX")).setAttribute("value", fzModel.getZxpf().getPjjglx());
//                                                hx.setAttribute("nameCN", "�о��������");
//                                                yzpjjg.addContent(hx);
//                                            }
//                                        }
//
//                                        if (fzModel.getPjzzm() != null) {
//                                            ZmModel pjzzmModel = fzModel.getPjzzm();
//                                            if (pjzzmModel.getZm() != null) {
//                                                hx = (new Element("PJZZM")).setAttribute("value", pjzzmModel.getZm());
//                                                hx.setAttribute("nameCN", "�о�������");
//                                                fz.addContent(hx);
//                                            }
//                                        }
//
//                                        if (fzModel.getXqksrq() != null || fzModel.getXqjsrq() != null) {
//                                            yzpjjg = (new Element("XQQZRQ")).setAttribute("nameCN", "������ֹ����");
//                                            fz.addContent(yzpjjg);
//                                            if (fzModel.getXqksrq() != null) {
//                                                hx = (new Element("XQKSRQ")).setAttribute("value", fzModel.getXqksrq());
//                                                hx.setAttribute("nameCN", "���ڿ�ʼ����");
//                                                yzpjjg.addContent(hx);
//                                            }
//
//                                            if (fzModel.getXqjsrq() != null) {
//                                                hx = (new Element("XQJSRQ")).setAttribute("value", fzModel.getXqjsrq());
//                                                hx.setAttribute("nameCN", "���ڽ�������");
//                                                yzpjjg.addContent(hx);
//                                            }
//                                        }
//
//                                        if (fzModel.getXqzdbf() != null) {
//                                            yzpjjg = (new Element("XQZDBF")).setAttribute("value", fzModel.getXqzdbf());
//                                            yzpjjg.setAttribute("nameCN", "�����۵ְ취");
//                                            fz.addContent(yzpjjg);
//                                        }
//
//                                        if (fzModel.getMzhwzsf() != null) {
//                                            yzpjjg = (new Element("MZHWZSF")).setAttribute("value", fzModel.getMzhwzsf());
//                                            yzpjjg.setAttribute("nameCN", "����������ͷ�");
//                                            fz.addContent(yzpjjg);
//                                        }
//
//                                        if (fzModel.getSzbf() != null) {
//                                            yzpjjg = (new Element("SZBF")).setAttribute("value", fzModel.getSzbf());
//                                            yzpjjg.setAttribute("nameCN", "���ﲢ��");
//                                            fz.addContent(yzpjjg);
//                                        }
//
//                                        if (fzModel.getHblx() != null) {
//                                            yzpjjg = (new Element("HBLX")).setAttribute("value", fzModel.getHblx());
//                                            yzpjjg.setAttribute("nameCN", "�ϲ�����");
//                                            fz.addContent(yzpjjg);
//                                        }
//                                        break;
//                                    }
//
//                                    fz = (new Element("XSPJJGFZ")).setAttribute("nameCN", "�����о��������");
//                                    pjjg.addContent(fz);
//                                    if (fzModel.getSscyr() != null) {
//                                        yzpjjg = (new Element("SSCYR")).setAttribute("value", fzModel.getSscyr());
//                                        yzpjjg.setAttribute("nameCN", "���ϲ�����");
//                                        fz.addContent(yzpjjg);
//                                    }
//
//                                    yzpjjg = (new Element("BSPJJG")).setAttribute("nameCN", "�����о����");
//                                    fz.addContent(yzpjjg);
//                                    if (!StringUtil.isBlank(fzModel.getEslxjg())) {
//                                        hx = (new Element("ESLXJG")).setAttribute("value", fzModel.getEslxjg());
//                                        hx.setAttribute("nameCN", "�������̽��");
//                                        yzpjjg.addContent(hx);
//                                    }
//
//                                    if (!StringUtil.isBlank(fzModel.getEslxjg())) {
//                                        hx = (new Element("ESSLJG")).setAttribute("value", fzModel.getEssljg());
//                                        hx.setAttribute("nameCN", "����������");
//                                        yzpjjg.addContent(hx);
//                                    }
//                                }
//                            } while(fzModel.getYzpf() == null);
//                        } while(fzModel.getYzpf().size() <= 0);
//
//                        yzpjjg = (new Element("YZPJJG")).setAttribute("nameCN", "ԭ���о����");
//                        fz.addContent(yzpjjg);
//                        var22 = fzModel.getYzpf().iterator();
//
//                        while(var22.hasNext()) {
//                            PfModel yzpf = (PfModel)var22.next();
//                            yz = (new Element("YZPF")).setAttribute("value", yzpf.getPfnr());
//                            yz.setAttribute("nameCN", "ԭ���з�");
//                            yzpjjg.addContent(yz);
//                            if (yzpf.getZm() != null) {
//                                hx = (new Element("YZZM")).setAttribute("value", yzpf.getZm().getZm());
//                                hx.setAttribute("nameCN", "����");
//                                yz.addContent(hx);
//                            }
//
//                            if (yzpf.getZx() != null) {
//                                hx = (new Element("ZX")).setAttribute("nameCN", "����");
//                                yz.addContent(hx);
//                                if (yzpf.getZx().getZxlb() != null) {
//                                    lb = (new Element("ZXLB")).setAttribute("value", yzpf.getZx().getZxlb());
//                                    lb.setAttribute("nameCN", "�������");
//                                    hx.addContent(lb);
//                                }
//
//                                if (yzpf.getZx().getZxxq() != null) {
//                                    lb = (new Element("ZXQX")).setAttribute("value", yzpf.getZx().getZxxq());
//                                    lb.setAttribute("nameCN", "��������");
//                                    hx.addContent(lb);
//                                }
//                            }
//
//                            if (yzpf.getFjxList() != null) {
//                                Iterator var27 = yzpf.getFjxList().iterator();
//
//                                label383:
//                                while(true) {
//                                    while(true) {
//                                        FjxModel fjx;
//                                        do {
//                                            if (!var27.hasNext()) {
//                                                break label383;
//                                            }
//
//                                            fjx = (FjxModel)var27.next();
//                                            fj = (new Element("FJX")).setAttribute("nameCN", "������");
//                                            yz.addContent(fj);
//                                        } while(fjx.getLb() == null);
//
//                                        lb = (new Element("FJXLB")).setAttribute("value", fjx.getLb());
//                                        lb.setAttribute("nameCN", "���������");
//                                        fj.addContent(lb);
//                                        Element bz;
//                                        if (!StringUtil.equals(fjx.getLb(), "����") && !StringUtil.equals(fjx.getLb(), "û�ո��˲��ֲƲ�")) {
//                                            if (StringUtil.equals(fjx.getLb(), "��������Ȩ��") && fjx.getQx() != null) {
//                                                bz = (new Element("QX")).setAttribute("value", fjx.getQx());
//                                                bz.setAttribute("nameCN", "����");
//                                                lb.addContent(bz);
//                                            }
//                                        } else {
//                                            if (fjx.getSe() != null) {
//                                                bz = (new Element("SE")).setAttribute("value", fjx.getSe());
//                                                bz.setAttribute("nameCN", "����");
//                                                lb.addContent(bz);
//                                            }
//
//                                            if (fjx.getBz() != null) {
//                                                bz = (new Element("BZ")).setAttribute("value", fjx.getBz());
//                                                bz.setAttribute("nameCN", "����");
//                                                lb.addContent(bz);
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//
//                            if (yzpf.getHx() != null) {
//                                hx = (new Element("HX")).setAttribute("nameCN", "����");
//                                yz.addContent(hx);
//                                if (yzpf.getHx().getZxlb() != null) {
//                                    lb = (new Element("HXLB")).setAttribute("value", yzpf.getHx().getZxlb());
//                                    lb.setAttribute("nameCN", "�������");
//                                    hx.addContent(lb);
//                                }
//
//                                if (yzpf.getHx().getZxxq() != null) {
//                                    lb = (new Element("QX")).setAttribute("value", yzpf.getHx().getZxxq());
//                                    lb.setAttribute("nameCN", "��������");
//                                    hx.addContent(lb);
//                                }
//                            }
//                        }
//                    }
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getDfdmspccl())) {
//                    ysxsbf = (new Element("DFDMSPCDCL")).setAttribute("value", pjjgModel.getDfdmspccl());
//                    ysxsbf.setAttribute("nameCN", "�Ը��������⳥�Ĵ���");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                Iterator var17;
//                String s;
//                if (pjjgModel.getFdmspjfzModel() != null && !StringUtil.isBlank(pjjgModel.getFdmspjfzModel().getNr())) {
//                    ysxsbf = (new Element("FDMSPJJGFZ")).setAttribute("value", pjjgModel.getFdmspjfzModel().getNr());
//                    ysxsbf.setAttribute("nameCN", "���������о��������");
//                    pjjg.addContent(ysxsbf);
//                    if (pjjgModel.getFdmspjfzModel().getBcje() != null) {
//                        var17 = pjjgModel.getFdmspjfzModel().getBcje().iterator();
//
//                        while(var17.hasNext()) {
//                            s = (String)var17.next();
//                            yzpjjg = (new Element("PCJE")).setAttribute("value", s);
//                            yzpjjg.setAttribute("nameCN", "�⳥���");
//                            ysxsbf.addContent(yzpjjg);
//                        }
//                    }
//
//                    if (pjjgModel.getFdmspjfzModel().getBpcr() != null) {
//                        var17 = pjjgModel.getFdmspjfzModel().getBpcr().iterator();
//
//                        while(var17.hasNext()) {
//                            s = (String)var17.next();
//                            yzpjjg = (new Element("BPCR")).setAttribute("value", s);
//                            yzpjjg.setAttribute("nameCN", "���⳥��");
//                            ysxsbf.addContent(yzpjjg);
//                        }
//                    }
//
//                    if (pjjgModel.getFdmspjfzModel().getPcr() != null) {
//                        var17 = pjjgModel.getFdmspjfzModel().getPcr().iterator();
//
//                        while(var17.hasNext()) {
//                            s = (String)var17.next();
//                            yzpjjg = (new Element("PCR")).setAttribute("value", s);
//                            yzpjjg.setAttribute("nameCN", "�⳥��");
//                            ysxsbf.addContent(yzpjjg);
//                        }
//                    }
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getKssz())) {
//                    ysxsbf = (new Element("KSSZ")).setAttribute("value", pjjgModel.getKssz());
//                    ysxsbf.setAttribute("nameCN", "��������");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getSsqx())) {
//                    ysxsbf = (new Element("SSQX")).setAttribute("value", pjjgModel.getSsqx());
//                    ysxsbf.setAttribute("nameCN", "��������");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getSstjcl())) {
//                    ysxsbf = (new Element("SSTJCL")).setAttribute("value", pjjgModel.getSstjcl());
//                    ysxsbf.setAttribute("nameCN", "�����ύ����");
//                    pjjg.addContent(ysxsbf);
//                }
//
//                if (pjjgModel.getCsrjh() != null && pjjgModel.getCsrjh().size() > 0) {
//                    ysxsbf = (new Element("CSRJH")).setAttribute("nameCN", "�����˼���");
//                    pjjg.addContent(ysxsbf);
//                    var17 = pjjgModel.getCsrjh().iterator();
//
//                    while(var17.hasNext()) {
//                        s = (String)var17.next();
//                        yzpjjg = (new Element("CSR")).setAttribute("value", s);
//                        yzpjjg.setAttribute("nameCN", "������");
//                        ysxsbf.addContent(yzpjjg);
//                    }
//                }
//
//                if (!StringUtil.isBlank(pjjgModel.getCslx())) {
//                    ysxsbf = (new Element("CSLX")).setAttribute("value", pjjgModel.getCslx());
//                    ysxsbf.setAttribute("nameCN", "��������");
//                    pjjg.addContent(ysxsbf);
//                }
//            }
//
//        }
    }

