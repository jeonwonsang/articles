package com.my.articles.dao;


import com.my.articles.entity.Comment;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Transactional
public class ommentDAO {
    @Autowired
    EntityManager em;

    public void insertComment(Comment comment) {
        em.persist(comment);
    }

    public Comment findAllCommentById(Long id) {
        return em.find(Comment.class, id);
    }

    public List<Comment> getAllComment() {
        String sql = "SELECT c FROM Comment c " +
                "ORDER BY c.id DESC";

        return em.createQuery(sql).getResultList();
    }
}

