package com.company;

public class SayHello {
    public static void main(String[] args) {
        PolitePerson jane = new PolitePerson("Jane");
        PolitePerson john = new PolitePerson("John");

        jane.SayHello(john);
        john.SayHello(jane);
    }

    private static class PolitePerson{
        private final String name;

        public PolitePerson(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public synchronized void SayHello(PolitePerson person) {
            System.out.format("%s: %s has said Hello to me%n", this.name, person.getName());
            person.SayHelloBack(this);
        }

        public synchronized void SayHelloBack(PolitePerson person) {
            System.out.format("%s: %s has said Hello back to me%n", this.name, person.getName());
        }
    }
}
