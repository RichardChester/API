package com.cd.start;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class artist {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    
    private String artist1;

    public String getId() {
        return id;
    }

    public void setId(String Id) {
        this.id = Id;
    }

    public String getArtisttName() {
        return artist1;
    }

    public void setArtisttName(String firstName) {
        this.artist1 = firstName;
    }
}