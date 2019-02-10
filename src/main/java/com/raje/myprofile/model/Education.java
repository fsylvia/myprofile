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
@JsonPropertyOrder({ "name", "from", "to", "degree", "stream", "grade" })
public class Education {

	@JsonProperty("name")
	private String name;
	@JsonProperty("from")
	private String from;
	@JsonProperty("to")
	private String to;
	@JsonProperty("degree")
	private String degree;
	@JsonProperty("stream")
	private String stream;
	@JsonProperty("grade")
	private String grade;
	
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

	/**
	 * @return the degree
	 */
	@JsonProperty("degree")
	public String getDegree() {
		return degree;
	}

	/**
	 * @param degree the degree to set
	 */
	@JsonProperty("degree")
	public void setDegree(String degree) {
		this.degree = degree;
	}

	/**
	 * @return the stream
	 */
	@JsonProperty("stream")
	public String getStream() {
		return stream;
	}

	/**
	 * @param stream the stream to set
	 */
	@JsonProperty("stream")
	public void setStream(String stream) {
		this.stream = stream;
	}

	/**
	 * @return the grade
	 */
	@JsonProperty("grade")
	public String getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	@JsonProperty("grade")
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the additionalProperties
	 */
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	/**
	 * @param additionalProperties the additionalProperties to set
	 */
	@JsonAnySetter
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Education [name=" + name + ", from=" + from + ", to=" + to + ", degree=" + degree + ", stream=" + stream
				+ ", grade=" + grade + ", additionalProperties=" + additionalProperties + "]";
	}

	
}
