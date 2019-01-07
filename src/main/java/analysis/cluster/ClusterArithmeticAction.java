package analysis.cluster;

import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.io.File;

/**
 * description:
 * Created by gaoyw on 2018/12/27.
 */
public class ClusterArithmeticAction {
    Instances insdata = null;
    Instances insdataClusterer = null;
    String path = "";
    int NumCluster = 0;

    public ClusterArithmeticAction(String filename) {
        try {
            //获取相对路径--------------------------------------
            File directory = new File(".");
            path = directory.getCanonicalPath();
            //(1)读入样本----------------------------------------
            DataSource source = new DataSource(path + "\\AnswerData\\05" + filename + ".arff");
            insdata = source.getDataSet();
            if (insdata.classIndex() == -1)
                insdata.setClassIndex(insdata.numAttributes() - 1);
            //generate data for clusterer (w/o class)
            Remove filter = new Remove();
            filter.setAttributeIndices("" + (insdata.classIndex() + 1));
            filter.setInputFormat(insdata);
            insdataClusterer = Filter.useFilter(insdata, filter);
            NumCluster = Integer.parseInt(filename.substring(filename.indexOf("_") + 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

