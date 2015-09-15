package rmsscripts.dataimport.xmlmodel;

import java.util.ArrayList;
import java.util.List;

public class Resources {
	private List<Resource> resources = new ArrayList<Resource>();
	private long categoryId;

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Resources [resources=" + resources + ", categoryId="
				+ categoryId + "]";
	}

}
