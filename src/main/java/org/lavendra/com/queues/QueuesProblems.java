package org.lavendra.com.queues;

import java.util.PriorityQueue;

public class QueuesProblems {

    public static void main(String[] args) {
        QueuesProblems problems = new QueuesProblems();
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(problems.findKthSmallestNumber(intArray, 6));
    }

    public int findKthSmallestNumber(int[] inputArray, int kthElement) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : inputArray) {
            queue.add(num);
        }

        for (int i = 0; i < kthElement - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

}
