package com.example.tesDDI.testing.Service;

import com.example.tesDDI.testing.Entity.Item;
import com.example.tesDDI.testing.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository repository;


    public Item saveItem(Item item){
        return repository.save(item);
    }

    public Iterable<Item> saveItem(Iterable<Item> items){
        return repository.saveAll(items);
    }

    public Iterable<Item> getAllItem(){
        return repository.findAll();
    }

    public Item getItemById(int id){
        return repository.findById(id).orElse(null);
    }
    public String deleteItem(int id){
        repository.deleteById(id);
        return "Item was deleted";
    }
    public Item updateItem(Item item){
        Item existingItem = repository.findById(item.getId()).orElse(null);
        existingItem.setName(item.getName());
        existingItem.setGambar(item.getGambar());
        existingItem.setDescription(item.getDescription());
        return repository.save(existingItem);
    }
    public Iterable<Item> findItemByCategory(int categoryId){
        return repository.findByCategoryId(categoryId);
    }
    public Iterable<Item> findItemByCategory(int categoryId, Pageable pageable){
        return repository.findByCategoryId(categoryId, pageable);
    }

    public Iterable<Item>findByName(String name, Pageable pageable){
        return repository.findByName(name,pageable);
    }
    public Iterable<Item>findByName(String name){
        return repository.findByName(name);
    }
}
