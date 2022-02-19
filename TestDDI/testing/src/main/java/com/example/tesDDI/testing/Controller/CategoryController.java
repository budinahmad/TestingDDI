package com.example.tesDDI.testing.Controller;

import com.example.tesDDI.testing.Entity.Category;
import com.example.tesDDI.testing.Model.RequestParam;
import com.example.tesDDI.testing.Model.ResponseParam;
import com.example.tesDDI.testing.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/create")
    public ResponseEntity<ResponseParam<Category>> createCategory(@RequestBody Category category){
        ResponseParam<Category> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.saveCategory(category));
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping("/getall")
    public ResponseEntity<ResponseParam<Iterable<Category>>>getAll(){
        ResponseParam<Iterable<Category>> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.findCategoryAll());
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage("");
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping("/findbyid")
    public ResponseEntity<ResponseParam<Category>>findById(@RequestBody RequestParam request){
        ResponseParam<Category> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.findCategoryById(Integer.parseInt(request.getValue())));
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage("");
        }
        return ResponseEntity.ok(response);
    }
}
