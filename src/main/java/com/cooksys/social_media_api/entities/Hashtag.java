package com.cooksys.social_media_api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Hashtag {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String label;

    @CreationTimestamp
    private Timestamp firstUsed;

    @UpdateTimestamp
    private Timestamp lastUsed;

    @ManyToMany(mappedBy = "hashtags", cascade = CascadeType.ALL)
    private List<Tweet> tweets = new ArrayList<>();

    public Hashtag(String newLabel) {
        label = newLabel;
    }
}
