package com.java.memory;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Gts {
	public void query() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		// Standard of reading a XML file
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder;
		Document doc = null;

		// Expression variables to check xml parameters
		XPathExpression bookexp = null; // Expression to parse global parameters
										// names

		XPathFactory xFactory = XPathFactory.newInstance();

		// Create a XPath object
		XPath xpath = xFactory.newXPath();

		// Compile the XPath expression
		builder = factory.newDocumentBuilder();
		doc = builder.parse(new File("c:/xml.txt"));
		// bookexp =
		// xpath.compile("Envelope/Body/upsertAccount/account/custManagerLastName");
//		bookexp = xpath.compile(
//				"Envelope/Body/upsertAccount/account/custManagerLastName[translate(custManagerLastName,'abcdefghijklmnopqrstuvwxyz','ABCDEFGHIJKLMNOPQRSTUVWXYZ')]");
		bookexp = xpath.compile(
				"Envelope/Body/upsertAccount/account/*[translate(name(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz') = 'custmanagerfirstname']");
		Object obj = bookexp.evaluate(doc, XPathConstants.NODESET);
		NodeList n = (NodeList) obj;

		for (int i = 0; i < n.getLength(); i++) {
			System.out.println(n.item(i).getTextContent());
		}
	}

	public static void main(String[] args)
			throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		Gts g = new Gts();
		g.query();
	}

}
