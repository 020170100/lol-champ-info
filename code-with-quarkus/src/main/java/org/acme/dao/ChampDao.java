package org.acme.dao;

import org.acme.model.Champion;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

@Named
@Dependent
public class ChampDao {
    @Inject
    EntityManager em;

    public List<Champion> getAll(){
        return em.createQuery("select c from Champion c order by c.name", Champion.class).getResultList();
    }

    public Champion getById(int id){
        return em.find(Champion.class, id);
    }

    public Champion createChampion(Champion c){
        em.persist(c);
        return c;
    }

    public Champion updateChampion(Champion c){
        return em.merge(c);
    }

    public Champion deleteChampion(int id){
        Champion c = getById(id);
        em.remove(c);
        return c;
    }
}
