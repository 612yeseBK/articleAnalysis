package template;

import template.handler.baseModelHandler.BaseWSModelHandler;
import template.model.BaseModel.BaseWSModel;
import template.service.WsManager;
import template.service.impl.BaseWsAnalyseImpl;
import template.util.FcUtil;
import template.util.FileUtil;
import template.util.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * description:
 * Created by gaoyw on 2018/12/10.
 */
public class WsjxMain {
    public WsjxMain() {
    }

    public static String format(String qw) {
        char[] ws = qw.toCharArray();
        int index = 0;

        for(int i = 0; i < ws.length; ++i) {
            int temp = ws[i];
            if (temp == ' ') {
                if (i - index > 5) {
                    ws[i] = '\n';
                }

                index = i;
            }
        }

        return String.valueOf(ws);
    }

    public static String getWsnr(String path, String filename) {
        String wsnr = "";
        new ArrayList();
        ArrayList<String> wsnrlist = new ArrayList();
        FileUtil fileUtil = new FileUtil();
        new FcUtil();
        fileUtil.setS(path + "\\" + filename);
        ArrayList<String> content = fileUtil.readFromFile();

        int i;
        for(i = 0; i < content.size(); ++i) {
            ArrayList<String> str = (ArrayList) FcUtil.getWholeToken((String)content.get(i));
            if (str.size() > 0) {
                wsnrlist.add(content.get(i));
            }
        }

        for(i = 0; i < wsnrlist.size() - 1; ++i) {
            wsnr = wsnr + (String)wsnrlist.get(i) + "\n";
        }

        wsnr = wsnr + (String)wsnrlist.get(wsnrlist.size() - 1);
        return wsnr;
    }

//    public static String fileSelection(String path, String filename) throws Exception {
//        String wsnr = null;
//        String str = filename.substring(filename.lastIndexOf(".") + 1);
//        if (str.contains("txt")) {
//            wsnr = getWsnr(path, filename);
//        } else if (!str.contains("doc") && !str.contains("docx") && !str.contains("DOC")) {
//            if (!str.contains("RTF") && !str.contains("rtf")) {
//                System.out.println("文件名为：" + filename + "\n无效文件");
//            } else {
//                wsnr = FileUtil.readRtf(path, filename);
//            }
//        } else {
//            wsnr = FileUtil.readDoc(path, filename);
//        }
//
//        return wsnr;
//    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文书路径（Windows环境下，如C:\\\\User\\\\LXY\\\\input，Mac环境下如/Users/zhx/Desktop/wsduty/input）：");
        String inputpath = scanner.nextLine();
        File f = new File(inputpath);
        String outputpath = f.getParent() + File.separator + "out";
        File fout = new File(outputpath);
        if (!fout.exists() && !fout.isDirectory()) {
            fout.mkdir();
        }

        File file = new File(inputpath);
        String[] filename = file.list();
        WsManager wsManager = new WsManager();

        for(int j = 0; j < filename.length; ++j) {
            try {
                System.out.println(filename[j]);
                BaseWsAnalyseImpl baseWsAnalyseImpl = new BaseWsAnalyseImpl(FileUtil.getContent(inputpath),filename[j]);
                BaseWSModel baseWSModel = new BaseWSModel();
                if (baseWsAnalyseImpl.getWs() != null) {
                    baseWSModel = (new BaseWSModelHandler()).jxWswsModel(baseWsAnalyseImpl.getWs());
                }

                String wszl = baseWSModel.getWszl(); //获取文书种类，解析的文书需要为判决书，其余的不做处理

                //当文书的种类是判决书是，使用通用模板进行解析。
                if(StringUtil.equals(wszl,"判决书")){
                    wsManager.dealBase(baseWsAnalyseImpl, baseWsAnalyseImpl.getWsnr(), inputpath, outputpath, filename[j]);
                }




//                String ajlx = wswsModel.getAjlx();
//                if (StringUtil.contains(ajlx, "民事二审")) {
//                    wsManager.jxMses(baseWsAnalyseImpl, wsnr, inputpath, outputpath, filename[j]);
//                } else if (StringUtil.contains(ajlx, "民事一审")) {
//                    wsManager.jxMsys(wsAnalyseImpl, wsnr, inputpath, outputpath, filename[j]);
//                } else if (StringUtil.contains(ajlx, "行政一审")) {
//                    wsManager.jxXzys(wsAnalyseImpl, wsnr, inputpath, outputpath, filename[j]);
//                } else if (StringUtil.contains(ajlx, "刑事一审")) {
//                    wsManager.jxXsys(wsAnalyseImpl, wsnr, inputpath, outputpath, filename[j]);
//                } else if (StringUtil.contains(ajlx, "行政二审")) {
//                    wsManager.jxXzes(wsAnalyseImpl, wsnr, inputpath, outputpath, filename[j]);
//                } else if (StringUtil.contains(ajlx, "刑事二审")) {
//                    wsManager.jxXses(wsAnalyseImpl, wsnr, inputpath, outputpath, filename[j]);
//                }
            } catch (Exception var14) {
                System.out.println("无法解析" + filename[j]);
                var14.printStackTrace();
            }
        }

    }



}

