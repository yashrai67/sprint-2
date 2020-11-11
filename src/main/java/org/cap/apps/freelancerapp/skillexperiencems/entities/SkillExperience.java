package org.cap.apps.freelancerapp.skillexperiencems.entities;

import org.cap.apps.freelancerapp.freelancerms.entities.Freelancer;
import org.cap.apps.freelancerapp.skillms.entities.Skill;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "skillexperience")
public class SkillExperience {
    @GeneratedValue
    @Id
    private Long id;

    private Integer years;

    @ManyToOne
    private Freelancer freelancer;

    @OneToOne
    private Skill skill;

    public SkillExperience() {

    }

    public SkillExperience(Long id, Integer years, Freelancer freelancer, Skill skill){
        this.id=id;
        this.years=years;
        this.freelancer=freelancer;
        this.skill=skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getYears() {
        return years;
    }

    public void setYears(Integer years) {
        this.years = years;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }

    public Skill getSkill() {
        return skill;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillExperience that = (SkillExperience) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
