package com.elgendy.periodictable2020.Search;

public class SearchHolder {
    private Integer id;
    private String name;
    private String category;
    private String atomic;
    private int image;
    private int back;

    public SearchHolder(int id, String name, String category, String atomic, int image, int back) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.atomic = atomic;
        this.image = image;
        this.back = back;
    }

    public int getBack() {
        return back;
    }

    public String getAtomic() {
        return atomic;
    }

    public void setAtomic(String atomic) {
        this.atomic = atomic;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
