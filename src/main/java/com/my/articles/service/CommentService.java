package com.my.articles.service;


import com.my.articles.dao.CommentDAO;
import com.my.articles.dto.CommentDTO;
import com.my.articles.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDAO dao;

    public void insertComment(CommentDTO dto) {
        dao.insertComment(CommentDTO.fromDto(dto));
    }

    public CommentDTO findAllCommentById(Long id) {
        Comment comment = dao.findAllCommentById(id);
        return CommentDTO.fromComment(comment);
    }

    public List<CommentDTO> getAllComment() {
        List<Comment> comments = dao.getAllComment();
        if (ObjectUtils.isEmpty(comments)) {
            return Collections.emptyList();
        }
        List<CommentDTO> dtoList = comments
                .stream().map(x -> CommentDTO.fromComment(x))
                .toList();
        return dtoList;
    }
}

