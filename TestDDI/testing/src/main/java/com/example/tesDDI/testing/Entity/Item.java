package com.example.tesDDI.testing.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    @Column(length = 65535, columnDefinition = "text")
    private String description;
    @Column(length = 65535, columnDefinition = "text")
    private String gambar;
    @ManyToOne
    private Category category;
}
