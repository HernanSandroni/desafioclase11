package com.coderhouse.desafio.model;


// creo un DTO para poder devolver la edad de client
public class ClientDTO {
    private String name;

    private String lastName;

    private int years;

    public ClientDTO(String name, String lastName, int years) {
        this.name = name;
        this.lastName = lastName;
        this.years = years;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", years=" + years +
                '}';
    }
}
