package analysis.classifier;

import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.*;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * description:
 * Created by gaoyw on 2018/12/28.
 */
public class TemplateClassifier  implements Serializable {
    /**
     * for serialization.
     */
    private static final long serialVersionUID = -123455813150452885L;
    /**
     * The training data gathered so far.
     */
    private Instances m_Data = null;
    /**
     * The filter used to generate the word counts.
     */
    private StringToWordVector m_Filter = new StringToWordVector();
    /**
     * The actual classifier.
     */
    private Classifier m_Classifier = new J48();
    /**
     * Whether the model is up to date.
     */
    private boolean m_UpToDate;

    /**
     * Constructs empty training dataset.
     */
    public TemplateClassifier( ArrayList<String> classValues) {
        String nameOfDataset = "MessageClassificationProblem";
        // Create vector of attributes.
        ArrayList<Attribute> attributes = new ArrayList<Attribute>(2);
        // Add attribute for holding messages.
        attributes.add(new Attribute("Message", (ArrayList<String>) null));
        // Add class attribute.
        attributes.add(new Attribute("Class", classValues));
        // Create dataset with initial capacity of 100, and set index of class.
        m_Data = new Instances(nameOfDataset, attributes, 100);
        m_Data.setClassIndex(m_Data.numAttributes() - 1);
    }

    /**
     * Classifies a given message.
     *
     * @param message the message content
     * @throws Exception if classification fails
     */
    public void classifyMessage(String message) throws Exception {
        // Check whether classifier has been built.
        if (m_Data.numInstances() == 0)
            throw new Exception("No classifier available.");
        // Check whether classifier and filter are up to date.
        if (!m_UpToDate) {
            // Initialize filter and tell it about the input format.
            m_Filter.setInputFormat(m_Data);
            // Generate word counts from the training data.
            Instances filteredData = Filter.useFilter(m_Data, m_Filter);
            // Rebuild classifier.
            m_Classifier.buildClassifier(filteredData);
            m_UpToDate = true;
        }
        // Make separate little test set so that message
        // does not get added to string attribute in m_Data.
        Instances testset = m_Data.stringFreeStructure();
        // Make message into test instance.
        Instance instance = makeInstance(message, testset);
        // Filter instance.
        m_Filter.input(instance);
        Instance filteredInstance = m_Filter.output();
        // Get index of predicted class value.
        double predicted = m_Classifier.classifyInstance(filteredInstance);
        // Output class value.
        System.err.println("Message classified as : " +
                m_Data.classAttribute().value((int) predicted));
    }

    /**
     * Updates model using the given training message.
     *
     * @param message    the message content
     * @param classValue the class label
     */
    public void updateData(String message, String classValue) {
        // Make message into instance.
        Instance instance = makeInstance(message, m_Data);
        // Set class value for instance.
        instance.setClassValue(classValue);
        // Add instance to training data.
        m_Data.add(instance);
        m_UpToDate = false;
    }

    /**
     * Method that converts a text message into an instance.
     *
     * @param text the message content to convert
     * @param data the header information
     * @returnthe generated Instance
     */
    private Instance makeInstance(String text, Instances data) {
        // Create instance of length two.
        Instance instance = new DenseInstance(2);
        // Set value for message attribute
        Attribute messageAtt = data.attribute("Message");
        instance.setValue(messageAtt, messageAtt.addStringValue(text));
        // Give instance access to attribute information from the dataset.
        instance.setDataset(data);
        return instance;
    }

    public static void main(String[] args) {
        try {
            ArrayList<String> classValues = new ArrayList<>(Arrays.asList("hit","miss"));
            // Read message file into string.
            String message = "this is a new training data item";
            String classValue = "hit";  //the label of training date

            String modelName = "E:\\myspace\\毕业设计\\工程部分\\model\\model";

            TemplateClassifier templateClassifier;
//            try {
//                templateClassifier = (TemplateClassifier) SerializationHelper.read(modelName);
//            } catch (FileNotFoundException e) {
                templateClassifier = new TemplateClassifier(classValues);
//            }

            if (classValue.length() != 0) //如果classValue存在，则表示是更新训练数据，之后要保存这个模型
                templateClassifier.updateData(message, classValue);
            else
                templateClassifier.classifyMessage(message); //如果输入的数据没有类标签，则表示这是一个分类任务
            // Save message classifier object only if it was updated.
            if (classValue.length() != 0) //如果不是预测而是更新数据，就保存模型
                SerializationHelper.write(modelName, templateClassifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
