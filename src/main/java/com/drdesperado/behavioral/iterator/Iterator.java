package com.drdesperado.behavioral.iterator;

public interface Iterator {
    public boolean hasNext();
    public Object next();
}

interface Container {
    public Iterator getIterator();
}

class NameRepository implements Container{
    public String names[] = {"Robert", "John", "Julie", "Lora"};
    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator{
        private int index;
        @Override
        public boolean hasNext() {
            if (index < names.length) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

class Test {
    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();

        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext();) {
            String name = (String) iterator.next();
            System.out.println("Name: " + name);
        }
    }
}

