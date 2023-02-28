package com.drdesperado.behavioral.strategy;

import java.util.Arrays;

public interface Strategy {
    void operation(int[] array);
}

class StrategyClient {
    private Strategy strategy;
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performOperation(int[] array) {
        strategy.operation(array);
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}

//Bubble sort
class ConcreteStrategyA implements Strategy{
    @Override
    public void operation(int[] array) {
        System.out.println("Bubble sort: ");
        for (int i = 0 ; i < array.length - 1; i++) {
            for (int j = 0 ; j < array.length - i - 1 ; j++) {
                if (array[j+1] <= array[j]) {
                    StrategyClient.swap(array, j + 1, j);
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

//Selection sort
class ConcreteStrategyB implements Strategy {
    @Override
    public void operation(int[] array) {
        System.out.println("Selection: ");
        for (int i = 0 ; i < array.length - 1 ; i++) {
            int min = i;
            for (int j = i + 1 ; j < array.length ; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            StrategyClient.swap(array, i, min);
        }
        System.out.println(Arrays.toString(array));
    }
}

//Inserting sort
class ConcreteStrategyC implements Strategy {
    @Override
    public void operation(int[] array) {
        System.out.println("Insert sort: ");
        for (int i = 1 ; i < array.length ; i++) {
            int index = i;
            while (index - 1 > 0 && array[index] < array[index - 1]) {
                StrategyClient.swap(array, index, index - 1);
                index--;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}

class Test {
    public static void main(String[] args) {
        StrategyClient client = new StrategyClient();

        int[] firstArray = {1,3,2,1};
        int[] secondArray = {11,4,2,7,8,54};
        int[] thirdArray = {3, -8, 2, 0, 33, 1, 3, 2};

        client.setStrategy(new ConcreteStrategyB());
        client.performOperation(secondArray);
        client.setStrategy(new ConcreteStrategyA());
        client.performOperation(thirdArray);
        client.setStrategy(new ConcreteStrategyC());
        client.performOperation(firstArray);

    }
}

