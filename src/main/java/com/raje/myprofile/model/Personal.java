
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
@JsonPropertyOrder({ "name", "visa", "location", "email", "contactNo", "pitch", "title" })
public class Personal {

	@JsonProperty("name")
	private String name;
	@JsonProperty("visa")
	private String visa;
	@JsonProperty("location")
	private String location;
	@JsonProperty("email")
	private String email;
	@JsonProperty("contactNo")
	private String contactNo;
	@JsonProperty("pitch")
	private List<String> pitch = null;
	@JsonProperty("title")
	private String title;
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

	@JsonProperty("visa")
	public String getVisa() {
		return visa;
	}

	@JsonProperty("visa")
	public void setVisa(String visa) {
		this.visa = visa;
	}

	@JsonProperty("location")
	public String getLocation() {
		return location;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

	@JsonProperty("contactNo")
	public String getContactNo() {
		return contactNo;
	}

	@JsonProperty("contactNo")
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@JsonProperty("pitch")
	public List<String> getPitch() {
		return pitch;
	}

	@JsonProperty("pitch")
	public void setPitch(List<String> pitch) {
		this.pitch = pitch;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
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
		return "Personal [name=" + name + ", visa=" + visa + ", location=" + location + ", email=" + email
				+ ", contactNo=" + contactNo + ", pitch=" + pitch + ", title=" + title + "]";
	}

	
}
