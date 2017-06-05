package org.example.domain;

import javax.persistence.Entity;

/**
 * Created by Kuzmin Evgeny on 22.05.2017.
 */
@Entity
public class Administrator extends User {
    public Administrator() {
    }

    public Administrator(String name, String password) {
        super(name, password);
    }
}
