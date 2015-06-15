package model;



import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "stat")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Stats implements Serializable{
	 @Id
	 private ObjectId  _id;
	 @JsonProperty("lowest_price")
	 private long lowest_price;
	 @JsonProperty("highest_price")
	 private long highest_price;


	 
	public ObjectId getId() {
		return _id;
	}


	public void setId(ObjectId id) {
		this._id = id;
	}


	public long getLowest_price() {
		return lowest_price;
	}


	public void setLowest_price(long lowest_price) {
		this.lowest_price = lowest_price;
	}


	public long getHighest_price() {
		return highest_price;
	}


	public void setHighest_price(long highest_price) {
		this.highest_price = highest_price;
	}


	public Stats() {
		this._id = ObjectId.get();
	}
	 	

	@Override
	    public String toString() {
	        return String.format(
	                "Venue[ lowest_price='%s', highest_price='%s']",
	                lowest_price, highest_price);
	    }
	 

}
