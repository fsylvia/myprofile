package com.raje.myprofile.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class D3Skills {
	private String name;
	private Float size;
	private Integer rank;
	private List<D3Skills> children = new ArrayList<>();

	public D3Skills(String name, Float size, Integer rank) {
		this.name = name;
		this.size = size;
		this.rank = rank;		
	}

	public D3Skills(String name, Float size) {
		this.name = name;
		this.size = size;
		this.rank = null;
	}

	public void addChild(D3Skills child) {
		/*boolean found = false;
		D3Skills leafNode = null;
		for (D3Skills d3Skills : children) {
			if(child.getName().equals(d3Skills.getName())) {
				found = true;
				leafNode = d3Skills;
				break;
			}
		}
		if(!found)
			this.children.add(child);
		else {
			//leafNode.children.add(child);
		}*/
		this.children.add(child);
			
	}

	public void addChild(String name, Float size, Integer rank) {
		D3Skills newSkill = new D3Skills(name, size, rank);
		this.children.add(newSkill);
	}

	public void addChildren(List<D3Skills> children) {
		this.children.addAll(children);
	}

	public List<D3Skills> getChildren() {
		return children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}
	
	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
	
	public D3Skills findNode(String name) {
		D3Skills result = null;
		if (this.getName().equals(name)) {
			return this;
		} else {
			List<D3Skills> childNodes = this.getChildren();
			for (D3Skills d3Skills : childNodes) {
				result = d3Skills.findNode(name);
				if (result != null) {
					return result;
				}
			}
		}
		return result;

	}

	public void addSize(Float size) {
		this.size +=size;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "D3Skills [name=" + name + ", size=" + size + ", rank=" + rank + ", children=" + children + "]";
	}

}
