package model;




import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "performer")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Performer implements Serializable{
	@Id
	 @JsonProperty("id")
	 private long id;
	 @JsonProperty("name")
	 private String name;
	 @JsonProperty("type")
	 private String type;
	 @JsonProperty("url")
	 private String url;
	 @JsonProperty("image")
	 private String image;
	 
	 
	 public Performer() {}
	 
	 
	 public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@Override
	    public String toString() {
	        return String.format(
	                "Venue[id=%s, name='%s', type='%s']",
	                id, name, type);
	    }
	 
}
