package com.almod.rest;

import com.almod.entity.Article;
import com.almod.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    /*------------- GET ARTICLE -----------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Article> getArticle(
            @PathVariable("id") Long id)
    {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Article article = articleService.getById(id);

        if(article == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    /*------------- FILTER ------------ */
    @RequestMapping(value = "/filter", method= RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticleFilter(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "product", required = false) String product){

        List<Article> articles;
        if(name == null || name.isEmpty()){
            if(product == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else articles = articleService.findAllByProductProductName(product);
        }
        else articles = articleService.findAllByArticleName(name);

        if(articles == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    /*------------------------------*/

    /*------------- SORT ------------ */
    @RequestMapping(value = "/sort", method= RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticleFilter(
            @RequestParam(value = "param", required = false) String param)
    {
        if(param == null || param.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Article> articles = null;
        if(param.toLowerCase().equals("name")){
            articles  = articleService.findAllByArticleNameAsc();
        }
        else if(param.toLowerCase().equals("date")){
            articles = articleService.findAllByDateAsc();
        }

        if(articles == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    /*------------------------------*/


    /*-------------- SAVE ----------------*/
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Article> saveArticle(@RequestBody Article article){
        HttpHeaders headers = new HttpHeaders();

        if(article == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.articleService.save(article);

        return new ResponseEntity<>(article, headers, HttpStatus.CREATED);
    }
    /*------------------------------*/

    /*-------------- UDPATE ----------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Article> updateArticle(@RequestBody Article article, @PathVariable("id") Long id){
        HttpHeaders headers = new HttpHeaders();

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Article oldArticle = this.articleService.getById(id);

        oldArticle.setArticleName(article.getArticleName());
        oldArticle.setContent(article.getContent());
        oldArticle.setDate(article.getDate());
        oldArticle.setProduct(article.getProduct());

        this.articleService.save(oldArticle);

        return new ResponseEntity<>(article, headers, HttpStatus.OK);
    }
    /*------------------------------*/


    /*-------------- DELETE ----------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Article> deleteArticle(@PathVariable("id") Long id) {
        Article article = this.articleService.getById(id);

        if (article == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.articleService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*------------------------------*/


    /*-------------- GET ALL ----------------*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = this.articleService.findAll();

        if (articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }
    /*------------------------------*/
}
