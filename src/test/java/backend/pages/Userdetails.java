package backend.pages;

import com.google.gson.annotations.SerializedName;

public class Userdetails {
    @SerializedName("id")
    private int id;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("token")
    private String token;
    @SerializedName("user_id")
    private String userID;

    public Userdetails() {
    }

    public String getUserID() {
        return userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Userdetails{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", userID='" + userID + '\'' +
                '}';
    }
}
