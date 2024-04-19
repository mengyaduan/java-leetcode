package designpatterns;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLUtil {

    public static Object getBean(String tagName) {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            Document doc;
            doc = builder.parse(new File("src/designpatterns/config.xml"));

            NodeList nl = doc.getElementsByTagName(tagName);
            Node classNode = nl.item(0).getFirstChild();
            String cName = classNode.getNodeValue();

            Class c = Class.forName(cName);
            return c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
