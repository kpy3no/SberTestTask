package org.example.json_objects;

import org.example.domain.Rights;

import javax.validation.constraints.NotNull;

/**
 * Created by Kuzmin Evgeny on 31.05.2017.
 */
public class JsonUserWithoutPassword {
    @NotNull
    private String name;
    @NotNull
    private Rights rights;

    public JsonUserWithoutPassword (String name, String password, String rights) {
        this.name = name;
        this.rights = Rights.valueOf(rights);
    }

    public JsonUserWithoutPassword () {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }


}
