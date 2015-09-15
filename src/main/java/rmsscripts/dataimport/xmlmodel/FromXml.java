package rmsscripts.dataimport.xmlmodel;

import java.io.File;

import rmsscripts.dataimport.DataTools;

public class FromXml {
	public static void main(String[] args) throws Exception {
		File file = new File(args[0]);
		Resources resources = DealResourcesXml.deal(file);
		DataTools.insert(resources, Long.parseLong(args[1]),
				Long.parseLong(args[2]), Long.parseLong(args[3]));
	}
}
