package com.metin.medium.contractbasedtesting.provider.model;

public class Course {

    private Long id;
    private String name;
    private boolean must;

    public Course(Long id, String name, boolean must) {
        this.id = id;
        this.name = name;
        this.must = must;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMust() {
        return must;
    }

    public void setMust(boolean must) {
        this.must = must;
    }
}
