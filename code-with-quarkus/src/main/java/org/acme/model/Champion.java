package org.acme.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Champion {
    @Id
    int id;

    String name;
    float health;
    float armor;
    float mana;
    float attackdamage;
    String img_url;
    String big_img_url;

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getBig_img_url() {
        return big_img_url;
    }

    public void setBig_img_url(String big_img_url) {
        this.big_img_url = big_img_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public float getArmor() {
        return armor;
    }

    public void setArmor(float armor) {
        this.armor = armor;
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public float getAttackdamage() {
        return attackdamage;
    }

    public void setAttackdamage(float attackdamage) {
        this.attackdamage = attackdamage;
    }


}
