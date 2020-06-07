package org.talentboost.networkforgiving.model;

import javax.persistence.*;

@Entity
@Table(name = "charities")
public class Charity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @Column(name = "amountRequired")
    private int amountRequired;

    @Column(name = "amountCollected")
    private int amountCollected;

    @Column(name = "ownerid")
    private int ownerId;

    public Charity() {
    }

    public Charity(int id, String title, String image, String description, int amountRequired, int amountCollected, int ownerId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.amountRequired = amountRequired;
        this.amountCollected = amountCollected;
        this.ownerId = ownerId;
    }

    public int getId() {
        return this.id;
    }

    public int getOwnerId() { return ownerId; }

    public String getTitle() {
        return this.title;
    }

    public String getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public int getAmountRequired() {
        return this.amountRequired;
    }

    public int getAmountCollected() {
        return this.amountCollected;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerId(int ownerId) { this.ownerId = ownerId; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmountRequired(int amountRequired) {
        this.amountRequired = amountRequired;
    }

    public void setAmountCollected(int amountCollected) {
        this.amountCollected = amountCollected;
    }

}