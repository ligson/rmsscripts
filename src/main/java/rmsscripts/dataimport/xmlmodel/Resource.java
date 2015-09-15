package rmsscripts.dataimport.xmlmodel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Resource {
	private String name;
	private List<File> files = new ArrayList<File>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<File> getFiles() {
		return files;
	}

	public void setFiles(List<File> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "Resource [name=" + name + ", files=" + files + "]";
	}

}
