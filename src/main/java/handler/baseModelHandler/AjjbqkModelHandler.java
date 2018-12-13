package handler.baseModelHandler;

import model.WsajjbqkModel;
import util.FcUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class AjjbqkModelHandler {
    public AjjbqkModelHandler() {
    }

    public WsajjbqkModel jxWsajjbqkModel(List<String> ajjbqk) {
        WsajjbqkModel wsajjbqkModel = new WsajjbqkModel();
        if (ajjbqk.size() == 1) {
            wsajjbqkModel.setBsdl((String)ajjbqk.get(0));
            List<String> bssldlist = new ArrayList();
            bssldlist.add(ajjbqk.get(0));
            wsajjbqkModel.setBssld(bssldlist);
        } else {
            String ajjbqk_1 = (String)ajjbqk.get(0);
            int qsindex = false;
            List<String> tokens = FcUtil.getWholeToken(ajjbqk_1);
            int pre = -1;
            int end = -1;
            int index1 = false;
            int index1;
            if (tokens.size() < 20) {
                index1 = tokens.size();
            } else {
                index1 = 20;
            }

            int i;
            String bsdl;
            for(i = 0; i < index1; ++i) {
                bsdl = (String)tokens.get(i);
                if (bsdl.equals("原审") || bsdl.equals("前审") || bsdl.equals("查明") || bsdl.equals("一审") || bsdl.equals("诉称") || bsdl.equals("原判")) {
                    pre = 0;
                    break;
                }
            }

            String qsdl;
            int i;
            if (pre == 0) {
                int i;
                String bssld;
                for(i = 1; i < ajjbqk.size(); ++i) {
                    bsdl = (String)ajjbqk.get(i);
                    List<String> nrtoken = FcUtil.getWholeToken(bsdl);
                    int index = false;
                    int index;
                    if (nrtoken.size() < 20) {
                        index = nrtoken.size();
                    } else {
                        index = 20;
                    }

                    for(i = 0; i < index; ++i) {
                        bssld = (String)nrtoken.get(i);
                        if (bssld.equals("不服") || bssld.equals("上诉") || bssld.equals("上诉人") || bsdl.indexOf("上诉称") > -1 && bsdl.indexOf("上诉称") < 30) {
                            end = i;
                            break;
                        }
                    }

                    if (end > -1) {
                        break;
                    }
                }

                if (end == -1) {
                    end = ajjbqk.size() - 1;
                }

                qsdl = "";

                for(i = 0; i < end; ++i) {
                    if (i != end - 1) {
                        qsdl = qsdl + (String)ajjbqk.get(i) + " ";
                    } else {
                        qsdl = qsdl + (String)ajjbqk.get(i);
                    }
                }

                wsajjbqkModel.setQsdl(qsdl);
                bsdl = "";

                for(int i = end; i < ajjbqk.size(); ++i) {
                    if (i != ajjbqk.size() - 1) {
                        bsdl = bsdl + (String)ajjbqk.get(i) + " ";
                    } else {
                        bsdl = bsdl + (String)ajjbqk.get(i);
                    }
                }

                wsajjbqkModel.setBsdl(bsdl);
                List<Integer> bsindex = new ArrayList();
                List<String> bssrbcdlist = new ArrayList();

                String ajnr;
                for(i = end; i < ajjbqk.size(); ++i) {
                    boolean b = true;

                    for(int j = 0; j < bsindex.size(); ++j) {
                        if (i == ((Integer)bsindex.get(j)).intValue()) {
                            b = false;
                            break;
                        }
                    }

                    if (b) {
                        String ajnr = (String)ajjbqk.get(i);
                        ajnr = ajnr;
                        if (ajnr.length() > 40) {
                            ajnr = ajnr.substring(0, 40);
                        }

                        if (ajnr.contains("辩称") || ajnr.contains("答辩")) {
                            bssrbcdlist.add(ajnr);
                            bsindex.add(i);
                        }
                    }
                }

                if (bssrbcdlist.size() > 0) {
                    wsajjbqkModel.setBssrbcd(bssrbcdlist);
                }

                String ssrscd = "";

                int j;
                String qsygscd;
                int i;
                int qspjdpre;
                for(int i = end; i < ajjbqk.size(); ++i) {
                    boolean b = true;

                    for(i = 0; i < bsindex.size(); ++i) {
                        if (i == ((Integer)bsindex.get(i)).intValue()) {
                            b = false;
                            break;
                        }
                    }

                    if (b) {
                        ajnr = (String)ajjbqk.get(i);
                        List<String> nrtoken = FcUtil.getWholeToken(ajnr);
                        int index = false;
                        if (nrtoken.size() < 30) {
                            qspjdpre = nrtoken.size();
                        } else {
                            qspjdpre = 30;
                        }

                        boolean ssr = true;

                        for(j = 0; j < qspjdpre; ++j) {
                            qsygscd = (String)nrtoken.get(j);
                            if (qsygscd.equals("审理") || qsygscd.equals("查明")) {
                                ssr = false;
                                break;
                            }
                        }

                        if (ssr) {
                            for(j = 0; j < qspjdpre; ++j) {
                                qsygscd = (String)nrtoken.get(j);
                                if (qsygscd.equals("不服") || qsygscd.equals("上诉") || qsygscd.equals("上诉人") || ajnr.indexOf("上诉称") > -1 && ajnr.indexOf("上诉称") < 30) {
                                    ssrscd = ssrscd + ajnr + " ";
                                    bsindex.add(i);
                                    break;
                                }
                            }
                        }
                    }
                }

                if (ssrscd != "") {
                    wsajjbqkModel.setSsrscd(ssrscd);
                }

                bssld = "";
                List<String> bssldlist = new ArrayList();

                for(i = end; i < ajjbqk.size(); ++i) {
                    boolean b = true;

                    for(qspjdpre = 0; qspjdpre < bsindex.size(); ++qspjdpre) {
                        if (i == ((Integer)bsindex.get(qspjdpre)).intValue()) {
                            b = false;
                            break;
                        }
                    }

                    if (b) {
                        bssld = bssld + (String)ajjbqk.get(i) + " ";
                    } else if (!bssld.equals("")) {
                        bssldlist.add(bssld);
                        bssld = "";
                    }
                }

                wsajjbqkModel.setBssld(bssldlist);
                String[] qsdllast = ((String)ajjbqk.get(end - 1)).split("。");
                int qspjindex = -1;

                int i;
                int i;
                for(qspjdpre = 0; qspjdpre < qsdllast.length; ++qspjdpre) {
                    if (qsdllast[qspjdpre].contains("综上") || qsdllast[qspjdpre].contains("依照") || qsdllast[qspjdpre].contains("依据")) {
                        int zs = qsdllast[qspjdpre].indexOf("综上");
                        j = qsdllast[qspjdpre].indexOf("依照");
                        i = qsdllast[qspjdpre].indexOf("依据");
                        i = 0;
                        if (zs != -1) {
                            i = zs;
                        }

                        if (j != -1) {
                            i = i < j ? i : j;
                        }

                        if (i != -1) {
                            i = i < i ? i : i;
                        }

                        if (qsdllast[qspjdpre].indexOf("判决") > i || qsdllast[qspjdpre].indexOf("裁定") > i) {
                            qspjindex = qspjdpre;
                            break;
                        }
                    }
                }

                if (qspjindex == -1) {
                    for(qspjdpre = 0; qspjdpre < qsdllast.length; ++qspjdpre) {
                        if (qsdllast[qspjdpre].contains("判决") || qsdllast[qspjdpre].contains("裁定")) {
                            qspjindex = qspjdpre;
                            break;
                        }
                    }
                }

                qspjdpre = end;
                if (qspjindex > -1) {
                    String qspjd = "";

                    for(j = qspjindex; j < qsdllast.length; ++j) {
                        qspjd = qspjd + qsdllast[j] + "。";
                    }

                    qspjdpre = end - 1;
                    wsajjbqkModel.setQspjd(qspjd);
                }

                List<Integer> exindex = new ArrayList();
                String qsbgbcd = "";

                String qsfsscd;
                for(i = 0; i < qspjdpre; ++i) {
                    qsfsscd = (String)ajjbqk.get(i);
                    if (qsfsscd.indexOf("辩称") > -1 && qsfsscd.indexOf("辩称") < 30) {
                        qsbgbcd = qsbgbcd + qsfsscd + " ";
                        exindex.add(i);
                    }
                }

                if (qsbgbcd != "") {
                    wsajjbqkModel.setQsbgbcd(qsbgbcd);
                }

                qsygscd = "";

                String qssld;
                int index;
                int i;
                for(i = 0; i < qspjdpre; ++i) {
                    qssld = (String)ajjbqk.get(i);
                    List<String> nrtoken = FcUtil.getWholeToken(qssld);
                    int index = false;
                    if (nrtoken.size() < 20) {
                        i = nrtoken.size();
                    } else {
                        i = 20;
                    }

                    for(index = 0; index < i; ++index) {
                        String content = (String)nrtoken.get(index);
                        if (content.equals("诉讼") || content.equals("诉称") || content.equals("诉至") || content.equals("诉讼请求")) {
                            qsygscd = qsygscd + qssld + " ";
                            exindex.add(i);
                            break;
                        }
                    }
                }

                if (qsygscd != "") {
                    wsajjbqkModel.setQsygscd(qsygscd);
                }

                qsfsscd = "";

                boolean b;
                int j;
                for(int i = 0; i < qspjdpre; ++i) {
                    String ajnr = (String)ajjbqk.get(i);
                    List<String> nrtoken = FcUtil.getWholeToken(ajnr);
                    b = false;
                    if (nrtoken.size() < 30) {
                        index = nrtoken.size();
                    } else {
                        index = 30;
                    }

                    for(j = 0; j < index; ++j) {
                        String content = (String)nrtoken.get(j);
                        if (content.equals("反诉")) {
                            qsfsscd = qsfsscd + ajnr + " ";
                            exindex.add(i);
                            break;
                        }
                    }
                }

                if (qsfsscd != "") {
                    wsajjbqkModel.setQsfsscd(qsfsscd);
                }

                qssld = "";
                List<String> qssldlist = new ArrayList();

                for(i = 0; i < qspjdpre; ++i) {
                    b = true;

                    for(j = 0; j < exindex.size(); ++j) {
                        if (i == ((Integer)exindex.get(j)).intValue()) {
                            b = false;
                            break;
                        }
                    }

                    if (b) {
                        qssld = qssld + (String)ajjbqk.get(i) + " ";
                    } else if (!qssld.equals("")) {
                        qssldlist.add(qssld);
                        qssld = "";
                    }
                }

                for(i = 0; i < qspjindex; ++i) {
                    qssld = qssld + qsdllast[i] + "。";
                }

                if (!qssld.equals("")) {
                    qssldlist.add(qssld);
                }

                wsajjbqkModel.setQssld(qssldlist);
            } else {
                qsdl = "";

                for(i = 0; i < ajjbqk.size() - 1; ++i) {
                    if (i != ajjbqk.size() - 1) {
                        qsdl = qsdl + (String)ajjbqk.get(i) + " ";
                    } else {
                        qsdl = qsdl + (String)ajjbqk.get(i);
                    }
                }

                wsajjbqkModel.setBsdl(qsdl);
            }
        }

        return wsajjbqkModel;
    }
}
