package puzzles.cracking.moderate;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class EncodeXml {

	public static String encodeXml(Element xml, Map<String, String> encoding){
		
		StringBuilder sb = new StringBuilder();
		
		String tagname = xml.getTagName();
		String enctag = encoding.containsKey(tagname) ? encoding.get(tagname) : tagname;
		sb.append(enctag);
		
		NamedNodeMap attrs = xml.getAttributes();
		
		for(int i = 0; i < attrs.getLength(); i++ ){
			Node attr = attrs.item(i);
			String attrname = attr.getNodeName();
			String value = attr.getNodeValue();
			String encattr = encoding.containsKey(attrname) ? encoding.get(attrname) : attrname;
			sb.append(" ").append(encattr).append(" ").append(value);
		}
		sb.append(" ").append("0");
		
		
		NodeList children = xml.getChildNodes();
		
		for(int i = 0; i < children.getLength(); i++ ){
			Node child = children.item(i);
			if(child instanceof Element){
				sb.append(" ").append(encodeXml((Element) child, encoding));
			} else {
				//System.out.println(child.getClass().getSimpleName());
				sb.append(" ").append(xml.getTextContent());
			}
			
		}
		
		sb.append(" ").append("0");
		
		return sb.toString();
	}
}
