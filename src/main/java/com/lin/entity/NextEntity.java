package com.lin.entity;

public class NextEntity extends AbstractEntity {
    private String name;
    private Integer block = 0;
    private Integer value = 0;
    private Integer type = 0;
    private Integer priority = 0;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
