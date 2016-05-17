package bean;

import java.io.Serializable;

/**
 *
 * @author thoma
 */
public class SessionBean implements Serializable {

    String username = "bean";

    public SessionBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
