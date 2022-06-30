package me.inginer.cabit.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Root {

    @Column(unique = true)
    private final String pass;
    @Id
    private final String user;

    public Root() {
        this.pass = "ROOT";
        this.user = "ROOT";
    }
}
