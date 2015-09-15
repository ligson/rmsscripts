package rmsscripts.dataimport.xmlmodel;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;

public class GeneralXml {
	private static Logger logger = Logger.getLogger(GeneralXml.class);

	public static void generalDir(String dir, String destFile) throws Exception {
		Document document = DocumentHelper.createDocument();
		document.setXMLEncoding("UTF-8");
		Element root = document.addElement("resources");
		root.addAttribute("category_id", "-1");

		File file = new File(dir);
		for (File file2 : file.listFiles()) {
			Element resource = root.addElement("resource");
			Element nameElement = resource.addElement("name");
			nameElement.setText(file2.getName());
			Element filesElement = resource.addElement("files");
			if (file2.isDirectory()) {
				for (File file3 : file2.listFiles()) {
					Element fileElement = filesElement.addElement("file");
					fileElement.setText(file3.getAbsolutePath());
				}
			}
		}

		XMLWriter writer = new XMLWriter(new FileOutputStream(destFile));
		writer.write(document);
		writer.close();
	}

	public static void main(String[] args) throws Exception {
		generalDir(args[0], args[1]);
	}
}
