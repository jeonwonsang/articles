package com.my.articles.controller;

import com.my.articles.dto.ArticleDTO;
import com.my.articles.service.ArticleService;
import com.my.articles.service.QueryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("articles")
@Slf4j
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @Autowired
    QueryService queryService;


    @GetMapping("")
    public String showAllArticles(Model model) {
        List<ArticleDTO> dtoList = articleService.getAllArticle();
        model.addAttribute("articles", dtoList);
        return "/articles/show_all";
    }


    @GetMapping("new")
    public String newArticle(Model model) {
        model.addAttribute("dto", new ArticleDTO());
        return "/articles/new";
    }

    @PostMapping("create")
    private String createArticle(@Valid @ModelAttribute("dto") ArticleDTO dto) {
        articleService.save(dto);
        return "redirect:";
    }

    @GetMapping("{id}")
    public String showOneArticle(@PathVariable("id") Long id, Model model) {
        ArticleDTO dto = articleService.getOneArticle(id);
        model.addAttribute(dto);

        return "/articles/show";
    }

    @GetMapping("{id}/update")
    public String viewUpdateArticle(@PathVariable("id") Long id, Model model) {
        model.addAttribute("dto", articleService.getOneArticle(id));
        return "/articles/update";
    }

    @PostMapping("update")
    public String updateArticle(ArticleDTO dto) {
        String url = "redirect:/"+dto.getId();
        articleService.updateArticle(dto);
        return url;
    }

    @GetMapping("{id}/delete")
    public String deleteArticle(@PathVariable("id") Long id,
                                RedirectAttributes redirectAttributes) {
        articleService.deleteArticle(id);
        redirectAttributes.addFlashAttribute("msg", "정상삭제 되었습니다");
        return "redirect:";
    }
}