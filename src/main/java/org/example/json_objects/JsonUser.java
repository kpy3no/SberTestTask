package org.example.json_objects;

import org.example.domain.Rights;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 */
public class JsonUser {
    @NotNull
    private String name;
    @NotNull

    @Size(min = 3)
    private String password;

    private Rights rights;

    public JsonUser(String name, String password, String rights) {
        this.name = name;
        this.password = password;
        this.rights = Rights.valueOf(rights);
    }

    public JsonUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }
}
