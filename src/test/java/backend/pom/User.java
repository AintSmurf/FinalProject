package backend.pom;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("user")
    private Userdetails user;

    public Userdetails getUser() {
        return user;
    }

    public void setUser(Userdetails user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "User{" +
                "user=" + user +
                '}';
    }
}
