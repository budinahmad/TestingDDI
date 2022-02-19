package com.example.tesDDI.testing.Controller;

import com.example.tesDDI.testing.Entity.Item;
import com.example.tesDDI.testing.Model.RequestParam;
import com.example.tesDDI.testing.Model.ResponseParam;
import com.example.tesDDI.testing.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    @Autowired
    private ItemService service;

    @PostMapping(value = "/create")
    public ResponseEntity<ResponseParam<Item>> tambahProduct(@RequestBody Item item){
        ResponseParam<Item> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.saveItem(item));
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    @GetMapping(value = "/getall")
    public ResponseEntity<ResponseParam<Iterable<Item>>> getAllDataItem(){
        ResponseParam<Iterable<Item>> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.getAllItem());
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping(value = "/findbyid")
    public ResponseEntity<ResponseParam<Item>>  findById(@RequestBody RequestParam request){
        ResponseParam<Item> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.getItemById(Integer.parseInt(request.getValue())));
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
    @PostMapping(value = "/getitembycategoryId")
    public ResponseEntity<ResponseParam<Iterable<Item>>> searchByParam(@RequestBody RequestParam request){
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getKeysort()).ascending());
        if(request.getSort().equalsIgnoreCase("desc")) {

            pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(request.getKeysort()).descending());
        }
        ResponseParam<Iterable<Item>> response = new ResponseParam<>();
        try {
            response.setStatus(true);
            response.setData(service.findItemByCategory(Integer.parseInt(request.getValue()),pageable));
            response.setMessage("");
        }
        catch (Exception e){
            response.setStatus(false);
            response.setData(null);
            response.setMessage(e.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
