package com.my.articles.service;

import com.my.articles.entity.Article;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QueryService {
    @Autowired
    EntityManager em;

    public List<Article> showAll() {
        String jpql = "SELECT a FROM Article a";
        Query query = em.createQuery(jpql, Article.class);
        return query.getResultList();
    }
}
