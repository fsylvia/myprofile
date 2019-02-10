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
@JsonPropertyOrder({ "name", "client", "from", "to", "skill", "responsibilities" })
public class Project {

	@JsonProperty("name")
	private String name;
	@JsonProperty("client")
	private String client;
	@JsonProperty("from")
	private String from;
	@JsonProperty("to")
	private String to;
	@JsonProperty("skill")
	private List<Skill> skill = null;
	@JsonProperty("responsibilities")
	private List<String> responsibilities = null;
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

	@JsonProperty("client")
	public String getClient() {
		return client;
	}

	@JsonProperty("client")
	public void setClient(String client) {
		this.client = client;
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

	@JsonProperty("skill")
	public List<Skill> getSkill() {
		return skill;
	}

	@JsonProperty("skill")
	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	@JsonProperty("responsibilities")
	public List<String> getResponsibilities() {
		return responsibilities;
	}

	@JsonProperty("responsibilities")
	public void setResponsibilities(List<String> responsibilities) {
		this.responsibilities = responsibilities;
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
		return "Project [name=" + name + ", client=" + client + ", from=" + from + ", to=" + to + ", skill=" + skill
				+ ", responsibilities=" + responsibilities + "]";
	}
	
	
}
