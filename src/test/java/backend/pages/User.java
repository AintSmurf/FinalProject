package backend.pages;

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

}
