package rmsscripts.dataimport.xmlmodel;

import java.io.File;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class DealResourcesXml {
	private static Logger logger = Logger.getLogger(DealResourcesXml.class);

	public static Resources deal(File file) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element rootElement = document.getRootElement();
		Resources resources = new Resources();
		long categoryId = Long.parseLong(rootElement
				.attributeValue("category_id"));
		resources.setCategoryId(categoryId);
		Iterator<Element> iterator = rootElement.elementIterator();
		while (iterator.hasNext()) {
			Element element = iterator.next();
			Iterator<Element> iterator1 = element.elementIterator();
			Resource resource = new Resource();
			while (iterator1.hasNext()) {
				Element node = iterator1.next();
				if (node.getName().equals("name")) {
					resource.setName(node.getTextTrim());
				} else if (node.getName().equals("files")) {
					Iterator<Element> iterator2 = node.elementIterator();
					while (iterator2.hasNext()) {
						Element node2 = iterator2.next();
						if (node2.getName().equals("file")) {
							File file2 = new File(node2.getTextTrim());
							if (file2.exists()) {
								resource.getFiles().add(file2);
							} else {
								logger.error("文件不存在,忽略:" + node2.getTextTrim());
							}
						}
					}
				}
			}

			resources.getResources().add(resource);
		}
		logger.debug("解析资源列表:");
		logger.debug(resources);
		return resources;
	}

	public static void main(String[] args) throws Exception {
		File file = new File(
				"E:/workspace/rmsscripts/src/main/resources/resources.xml");
		deal(file);
	}
}
