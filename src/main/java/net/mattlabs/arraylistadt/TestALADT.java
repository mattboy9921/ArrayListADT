package net.mattlabs.arraylistadt;

import java.util.Random;

public class TestALADT {

    public static void main(String[] args) {

        ArrayListADT list = new ArrayListADT();
        Random random = new Random();
        int num;

        // Add 20 items to the list
        System.out.println("Adding 20 elements to the list:");
        for (int i = 0; i < 20; i++) {
            num = random.nextInt(100) + 1;
            list.addLast(num);
            System.out.println(num + " was added to the list.");
        }

        // Remove the first item from the list
        System.out.println(list.removeFirst() + " was removed from the list.");

        // Removes the last item from the list
        System.out.println(list.removeLast() + " was removed from the list.");

        // State number of elements in the list
        System.out.println("The list has " + list.size() + " elements.");

        // Add an element to the front
        num = random.nextInt(100) + 1;
        list.addFirst(num);
        System.out.println(num + " was added to the front of the list");

        // Add an element to the back of the list
        num = random.nextInt(100) + 1;
        list.addLast(num);
        System.out.println(num + " was added to the back of the list");

        // State number of elements in the list
        System.out.println("The list has " + list.size() + " elements.");
    }
}
