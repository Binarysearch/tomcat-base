package com.example.controllers;

import org.piros.db.Column;
import org.piros.db.Table;

@Table("example_table")
public class ExampleEntity {

    @Column("field1")
    private String field1;

    @Column("field2")
    private Integer field2;

    public ExampleEntity() {
    }

    public ExampleEntity(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }

    
}