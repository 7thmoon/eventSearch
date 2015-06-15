package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "event")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Event implements Serializable{
	 @Id
	 @JsonProperty("id")
	 private Long id;
	 @JsonProperty("title")
	 private String title;
	 @JsonProperty("type")
	 private String type;
	 @JsonProperty("url")
	 private String url;
	 @JsonProperty("venue")
	 @DBRef
	 private Venue venue;
	 @JsonProperty("performers")
	 @DBRef
	 private List<Performer> performers;
	 @JsonProperty("datetime_local")
	 private Date datetime_local;
	 @JsonProperty("stats")
	 @DBRef
	 private Stats stats;
	 
	 
	 public Event() {}
	 
	 
	 public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}


	public List<Performer> getPerformers() {
		return performers;
	}


	public void setPerformers(List<Performer> performers) {
		this.performers = performers;
	}


	public Date getDatetime_local() {
		return datetime_local;
	}


	public void setDatetime_local(Date datetime_local) {
		this.datetime_local = datetime_local;
	}


	@Override
	    public String toString() {
	        return String.format(
	                "Event[id=%s, title='%s', type='%s']",
	                id, title, type);
	    }
	 
	 
}
