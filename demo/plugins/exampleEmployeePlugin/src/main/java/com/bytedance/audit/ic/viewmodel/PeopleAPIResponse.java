package com.bytedance.audit.ic.viewmodel;

import java.util.List;

public class PeopleAPIResponse {

    private boolean success;
    private List<People> employees;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<People> getEmployees() {
        return employees;
    }

    public void setEmployees(List<People> employees) {
        this.employees = employees;
    }

    public static class People {
        private Integer id;
        private String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
