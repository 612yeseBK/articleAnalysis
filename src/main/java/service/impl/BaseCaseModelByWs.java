package service.impl;

import model.WsfdModel;

import java.util.List;

/**
 * description:
 * Created by gaoyw on 2018/12/13.
 */
public class BaseCaseModelByWs {
    public BaseCaseModelByWs() {
    }

    public boolean isWzws() {
        return false;
    }

    public WsfdModel jxWsfdModel(String wsnr, List<String> ws, List<String> sscyr, String ssjl, List<String> ajjbqk, List<String> cpfxgc, List<String> cpjg, List<String> ww, List<String> fl) {
        WsfdModel wsfdModel = new WsfdModel();
        String ful;
        int i;
        if (ws != null) {
            ful = "";

            for(i = 0; i < ws.size(); ++i) {
                if (i == ws.size() - 1) {
                    ful = ful + (String)ws.get(i);
                } else {
                    ful = ful + (String)ws.get(i) + " ";
                }
            }

            wsfdModel.setWs(ful);
        }

        if (sscyr != null) {
            ful = "";

            for(i = 0; i < sscyr.size(); ++i) {
                if (i == sscyr.size() - 1) {
                    ful = ful + (String)sscyr.get(i);
                } else {
                    ful = ful + (String)sscyr.get(i) + " ";
                }
            }

            wsfdModel.setSscyr(ful);
        }

        if (ssjl != null) {
            wsfdModel.setSsjl(ssjl);
        }

        if (ajjbqk != null) {
            ful = "";

            for(i = 0; i < ajjbqk.size(); ++i) {
                if (i == ajjbqk.size() - 1) {
                    ful = ful + (String)ajjbqk.get(i);
                } else {
                    ful = ful + (String)ajjbqk.get(i) + " ";
                }
            }

            wsfdModel.setAjjbqk(ful);
        }

        if (cpfxgc != null) {
            ful = "";

            for(i = 0; i < cpfxgc.size(); ++i) {
                if (i == cpfxgc.size() - 1) {
                    ful = ful + (String)cpfxgc.get(i);
                } else {
                    ful = ful + (String)cpfxgc.get(i) + " ";
                }
            }

            wsfdModel.setCpfxgc(ful);
        }

        if (cpjg != null) {
            ful = "";

            for(i = 0; i < cpjg.size(); ++i) {
                if (i == cpjg.size() - 1) {
                    ful = ful + (String)cpjg.get(i);
                } else {
                    ful = ful + (String)cpjg.get(i) + " ";
                }
            }

            wsfdModel.setCpjg(ful);
        }

        if (ww != null) {
            ful = "";

            for(i = 0; i < ww.size(); ++i) {
                if (i == ww.size() - 1) {
                    ful = ful + (String)ww.get(i);
                } else {
                    ful = ful + (String)ww.get(i) + " ";
                }
            }

            wsfdModel.setWw(ful);
        }

        if (fl != null) {
            ful = "";

            for(i = 0; i < fl.size(); ++i) {
                ful = ful + (String)fl.get(i) + " ";
            }

            ful = ful + (String)fl.get(fl.size() - 1);
            wsfdModel.setFl(ful);
        }

        wsfdModel.setQw(wsnr);
        return wsfdModel;
    }

}
