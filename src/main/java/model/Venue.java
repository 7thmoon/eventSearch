package model;



import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "venue")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Venue implements Serializable{
	@Id
	 @JsonProperty("id")
	 private long id;
	 @JsonProperty("city")
	 private String city;
	 @JsonProperty("name")
	 private String name;
	 @JsonProperty("address")
	 private String address;
	 @JsonProperty("country")
	 private String country;
	 @JsonProperty("postal_code")
	 private String postal_code;
	 
	 public String getPostal_code() {
		return postal_code;
	}


	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}


	@JsonProperty("url")
	 private String url;
	 
	 
	 public Venue() {}
	 
	 
	 public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	@Override
	    public String toString() {
	        return String.format(
	                "Venue[id=%s, name='%s', address='%s']",
	                id, name, address);
	    }
	 

}
