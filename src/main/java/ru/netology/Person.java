package ru.netology;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return age == 0 ? false : true;
    }

    public boolean hasAddress() {
        return address == null ? false : true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        if (hasAddress()) {
            child.setAddress(this.address);
        }
        child.setAge(0);
        return child;
    }

    @Override
    public String toString() {
        StringBuilder personInfo = new StringBuilder("Имя: " + name + "\n" + "Фамилия:" + surname + "\n");
        if (hasAge()) {
            personInfo.append("Возраст: " + age + "\n");
        }
        if (hasAddress()) {
            personInfo.append("Адрес: " + address + "\n");
        }
        return personInfo.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

}
