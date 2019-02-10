
package com.raje.myprofile.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "from", "to", "role", "responsibilities", "project" })
public class Company {

	@JsonProperty("name")
	private String name;
	@JsonProperty("from")
	private String from;
	@JsonProperty("to")
	private String to;
	@JsonProperty("role")
	private List<Role> role = null;
	@JsonProperty("responsibilities")
	private String responsibilities;
	@JsonProperty("project")
	private List<Project> project = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("from")
	public String getFrom() {
		return from;
	}

	@JsonProperty("from")
	public void setFrom(String from) {
		this.from = from;
	}

	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	@JsonProperty("to")
	public void setTo(String to) {
		this.to = to;
	}

	@JsonProperty("role")
	public List<Role> getRole() {
		return role;
	}

	@JsonProperty("role")
	public void setRole(List<Role> role) {
		this.role = role;
	}

	@JsonProperty("responsibilities")
	public String getResponsibilities() {
		return responsibilities;
	}

	@JsonProperty("responsibilities")
	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	@JsonProperty("project")
	public List<Project> getProject() {
		return project;
	}

	@JsonProperty("project")
	public void setProject(List<Project> project) {
		this.project = project;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [name=" + name + ", from=" + from + ", to=" + to + ", role=" + role + ", responsibilities="
				+ responsibilities + ", project=" + project + "]";
	}
	
	public String getDesignation() {
		String designation = "";
		if (this.role != null && this.role.size()>0) {
			designation = this.role.get(this.role.size()-1).getName();
		}
		return designation;
	}

	
	
}
