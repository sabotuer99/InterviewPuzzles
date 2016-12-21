package spec.cracking.moderate;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import puzzles.cracking.moderate.EncodeXml;

public class EncodeXmlTests {

	@Test
	public void BookTestCase(){
		Element xml = getSut();
		Map<String, String> encoding = new HashMap<>();
		encoding.put("family", "1");
		encoding.put("person", "2");
		encoding.put("firstName", "3");
		encoding.put("lastName", "4");
		encoding.put("state", "5");
		
		String result = EncodeXml.encodeXml(xml, encoding);
		
		assertEquals("1 4 McDowell 5 CA 0 2 3 Gayle 0 Some Message 0 0", result);
	}
	
	

	private Element getSut(){
		DocumentBuilderFactory dbFactory =
		         DocumentBuilderFactory.newInstance();
		         DocumentBuilder dBuilder;
				try {
					dBuilder = dbFactory.newDocumentBuilder();
				
		         Document doc = dBuilder.newDocument();
		         // root element
		         
		         Element root = doc.createElement("family");
		         Attr lastattr = doc.createAttribute("lastName");
		         lastattr.setValue("McDowell");
		         root.setAttributeNode(lastattr);
		         Attr state = doc.createAttribute("state");
		         state.setValue("CA");
		         root.setAttributeNode(state);
		         
		         Element child = doc.createElement("person");
		         child.setTextContent("Some Message");
		         Attr firstattr = doc.createAttribute("firstName");
		         firstattr.setValue("Gayle");
		         child.setAttributeNode(firstattr);
		         
		         root.appendChild(child);
		         
		         return root;
		         
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	}
}
