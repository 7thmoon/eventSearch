package model;

import java.io.Serializable;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * A user who can book hotels.
 */

@Document(collection = "user")
public class User implements Serializable {
	
	@Id
	private ObjectId  _id;
	
    private String username;

    private String password;


    public User() {
    }

    public User(String username, String password) {
	this.username = username;
	this.password = password;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String toString() {
	return "User(" + username + ")";
    }
}
