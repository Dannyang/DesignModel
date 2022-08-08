package com.example.springbootstrategy.entity;


public class User {
    private String name;
    private String password;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.password = userBuilder.password;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        String name;
        String password;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    @Override
    public String toString() {
        return "name: " + this.name + "," + "password: " + this.password;
    }
}
