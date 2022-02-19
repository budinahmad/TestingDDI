package com.example.tesDDI.testing.Repository;

import com.example.tesDDI.testing.Entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.websocket.server.PathParam;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    Page<Item> findByName(String name, Pageable pageable);
    List<Item> findByName(String name);

    @Query("SELECT p From Item p Where p.category.id = :categoryId")
    public List<Item>findByCategoryId(@PathParam("categoryId") int categoryId);

    @Query("SELECT i From Item i Where i.category.id = :categoryId")
    Page<Item> findByCategoryId(@PathParam("categoryId") int categoryId, Pageable pageable);

}
