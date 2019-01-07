package analysis.preprocessing;

import org.apache.log4j.Logger;
import org.junit.Test;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.TextDirectoryLoader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * description:
 * Created by gaoyw on 2018/12/27.
 */
public class PreProcessing {
    private static Logger log = org.apache.log4j.Logger.getLogger(PreProcessing.class);

    public PreProcessing() {
    }

    public Instances getInstancesFromDir() throws IOException {
        TextDirectoryLoader loader = new TextDirectoryLoader();
        loader.setDirectory(new File("E:\\myspace\\毕业设计\\工程部分\\sourcetext"));
        Instances dataRaw = loader.getDataSet();
        return dataRaw;
    }

    public static Instances initEmptyDataSet(ArrayList<String> classValues){
        Instances m_Data = null;
        String nameOfDataset = "MessageClassificationProblem";  //数据集的名称
        // Create vector of attributes.
        ArrayList<Attribute> attributes = new ArrayList<Attribute>(2);
        // Add attribute for holding messages.
        attributes.add(new Attribute("Message", (ArrayList<String>) null));
        attributes.add(new Attribute("Class", classValues));
        // Create dataset with initial capacity of 100, and set index of class.
        m_Data = new Instances(nameOfDataset, attributes, 100);
        m_Data.setClassIndex(m_Data.numAttributes() - 1);
        return m_Data;
    }

    /**
     *
     * @param message  一个训练数据
     * @param classValue  该数据的标签
     * @param m_Data  已经建立好的数据集
     * @return
     */
    public Instances addInstance(String message, String classValue, Instances m_Data) {
        Instance instance = new DenseInstance(2);
        // Set value for message attribute
        Attribute messageAtt = m_Data.attribute("Message");
        instance.setValue(messageAtt, messageAtt.addStringValue(message));
        // Give instance access to attribute information from the dataset.
        instance.setDataset(m_Data);
        instance.setClassValue(classValue);
        m_Data.add(instance); //在训练数据集里面增加了一个训练数据
        return m_Data;
    }

    public List getStopWordList() throws IOException {
        List stopWordList = new ArrayList();
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("E:\\myspace\\毕业设计\\工程部分\\stopWord.txt"), "UTF-8"));
        String str;
        while ((str = in.readLine()) != null) {
            stopWordList.add(str);
        }
        return stopWordList;
    }


    @Test
    public void testGetInstanceFromDir() {
        try {
            Instances instances = getInstancesFromDir();
            log.info(instances.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetDirect(){
        ArrayList<String> classValues = new ArrayList<>(Arrays.asList("hit","miss"));
        Instances instances = initEmptyDataSet(classValues);
        String newMessage = "this is the training data";
        String classValueOfNewMessage = "hit";//the label of training date
        addInstance(newMessage, classValueOfNewMessage, instances);
        log.info(instances.toString());
    }
}
