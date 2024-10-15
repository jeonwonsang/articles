package com.my.articles.service;


import com.my.articles.dao.ArticleDAO;
import com.my.articles.dto.ArticleDTO;
import com.my.articles.entity.Article;
import com.my.articles.repositroy.ArticleRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class ArticleService {

    @Autowired
    EntityManager em;
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    QueryService queryService;
    @Autowired
    ArticleDAO dao;


    public void save(ArticleDTO dto) {
        articleRepository.save(ArticleDTO.fromDTO(dto));
    }

    public List<ArticleDTO> getAllArticle() {
        List<Article> articles = dao.getAllArticle();
        if(ObjectUtils.isEmpty(articles)){
            return Collection.emptyList();
        }
        List<ArticleDTO> dtoList = articles
                .stream().map(x-> System.out.println(x))
                .toList();
        return dtoList;

    }

    public ArticleDTO getOneArticle(Long id) {
        Article article = dao.getOneArticle(id);
        if(ObjectUtils.isEmpty(article)) {
            return ArticleDTO.fromArticle(article);
        }
    }

    public void deleteArticle(Long id) {
        dao.deleteArticle(id);
    }

    public void updateArticle(ArticleDTO dto) {
        dao.updateArticle(dto);
    }

    public void insertArticle(ArticleDTO dto){
        dao.insertArticle(article);
    }

}
