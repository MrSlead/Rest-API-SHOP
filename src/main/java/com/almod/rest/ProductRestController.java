package com.almod.rest;

import com.almod.entity.Article;
import com.almod.entity.Product;
import com.almod.service.ArticleService;
import com.almod.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/product")
public class ProductRestController {
    private ProductService productService;
    private ArticleService articleService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setArticleService(ArticleService articleService){ this.articleService = articleService; }

    /*------------- GET ALL ARTICLES BY PRODUCT -----------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Set<Article>> getArticlesByProduct(
            @PathVariable("id") Long id)
    {
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productService.getById(id);

        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Set<Article> articles = articleService.findAllByProductId(id);

        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    /*------------- FILTER ------------ */
    @RequestMapping(value = "/filter", method= RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductFilter(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "salary", required = false) Integer salary){

        List<Product> products;
        if(name == null || name.isEmpty()){
            if(salary == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else products = productService.findAllBySalary(salary);
        }
        else products = productService.findAllByProductName(name);

        if(products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /*------------------------------*/

    /*------------- SORT ------------ */
    @RequestMapping(value = "/sort", method= RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductFilter(
            @RequestParam(value = "param", required = false) String param)
    {
        if(param == null || param.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Product> products = null;
        if(param.toLowerCase().equals("name")){
            products = productService.findAllByProductNameAsc();
        }
        else if(param.toLowerCase().equals("salary")){
            products = productService.findAllBySalaryAsc();
        }

        if(products == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /*------------------------------*/


    /*-------------- SAVE ----------------*/
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        HttpHeaders headers = new HttpHeaders();

        if(product == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.productService.save(product);

        return new ResponseEntity<>(product, headers, HttpStatus.CREATED);
    }
    /*------------------------------*/

    /*-------------- UDPATE ----------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        HttpHeaders headers = new HttpHeaders();

        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Product oldProduct = this.productService.getById(id);

        oldProduct.setDescription(product.getDescription());
        oldProduct.setProductName(product.getProductName());
        oldProduct.setSalary(product.getSalary());

        this.productService.save(oldProduct);

        return new ResponseEntity<>(product, headers, HttpStatus.OK);
    }
    /*------------------------------*/


    /*-------------- DELETE ----------------*/
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
        Product product = this.productService.getById(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        this.productService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /*------------------------------*/


    /*-------------- GET ALL ----------------*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = this.productService.findAll();

        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    /*------------------------------*/
}
