
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
@JsonPropertyOrder({ "personal", "education", "skills", "company", "strengths" })
public class Profile {

	@JsonProperty("personal")
	private Personal personal;
	@JsonProperty("skills")
	private List<Skill> skills = null;
	@JsonProperty("company")
	private List<Company> company = null;
	@JsonProperty("strengths")
	private List<Strength> strengths = null;
	@JsonProperty("education")
	private List<Education> education = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("personal")
	public Personal getPersonal() {
		return personal;
	}

	@JsonProperty("personal")
	public void setPersonal(Personal personal) {
		this.personal = personal;
	}
	
	@JsonProperty("education")
	public List<Education> getEducation() {
		return education;
	}

	@JsonProperty("education")
	public void setEducation(List<Education> education) {
		this.education = education;
	}

	@JsonProperty("skills")
	public List<Skill> getSkills() {
		return skills;
	}

	@JsonProperty("skills")
	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@JsonProperty("company")
	public List<Company> getCompany() {
		return company;
	}

	@JsonProperty("company")
	public void setCompany(List<Company> company) {
		this.company = company;
	}

	@JsonProperty("strengths")
	public List<Strength> getStrengths() {
		return strengths;
	}

	@JsonProperty("strengths")
	public void setStrengths(List<Strength> strengths) {
		this.strengths = strengths;
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
		return "Profile [personal=" + personal + ", education=" + education + ", skills=" + skills + ", company="
				+ company + ", strengths=" + strengths + ", additionalProperties=" + additionalProperties + "]";
	}

}
