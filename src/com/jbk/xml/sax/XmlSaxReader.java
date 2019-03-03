package com.jbk.xml.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XmlSaxReader {

	public static void main(String argv[]) {

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean to = false;

				boolean from = false;

				boolean heading = false;

				boolean body = false;

				public void startElement(String uri, String localName,
						String qName, Attributes attributes)
						throws SAXException {

					System.out.println("Start Element :" + qName);

					if (qName.equalsIgnoreCase("to")) {
						to = true;
					}

					if (qName.equalsIgnoreCase("from")) {
						from = true;
					}

					if (qName.equalsIgnoreCase("heading")) {
						heading = true;
					}

					if (qName.equalsIgnoreCase("body")) {
						body = true;
					}

				}

				public void endElement(String uri, String localName,
						String qName) throws SAXException {

					System.out.println("End Element :" + qName);

				}

				public void characters(char ch[], int start, int length)
						throws SAXException {

					if (to) {
						System.out.println("TO: "
								+ new String(ch, start, length));
						to = false;
					}

					if (from) {
						System.out.println("FROM : "
								+ new String(ch, start, length));
						from = false;
					}

					if (heading) {
						System.out.println("HEADING : "
								+ new String(ch, start, length));
						heading = false;
					}

					if (body) {
						System.out.println("HEADING : "
								+ new String(ch, start, length));
						body = false;
					}

				}

			};

			saxParser.parse("myfirst.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}