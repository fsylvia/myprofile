package com.raje.myprofile.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "from", "to" })
public class Role {
	@JsonProperty("name")
	private String name;
	@JsonProperty("from")
	private String from;
	@JsonProperty("to")
	private String to;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	/**
	 * @return the name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the from
	 */
	@JsonProperty("from")
	public String getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	@JsonProperty("from")
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * @return the to
	 */
	@JsonProperty("to")
	public String getTo() {
		return to;
	}

	/**
	 * @param to the to to set
	 */
	@JsonProperty("to")
	public void setTo(String to) {
		this.to = to;
	}
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [name=" + name + ", from=" + from + ", to=" + to + "]";
	}
	
	
}
