package com.example.tesDDI.testing.Model;

public class RequestParam {
    private String value;
    private int size;
    private int page;

    public int getPage() {
        return page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getKeysort() {
        return keysort;
    }

    public void setKeysort(String keysort) {
        this.keysort = keysort;
    }

    public void setPage(int page) {
        this.page = page;
    }

    private String keysort;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private String sort;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
