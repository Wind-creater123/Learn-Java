package List;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> queue=new LinkedList<String>();

        queue.addLast("a");
        queue.addLast("b");
        queue.addLast("c");
        queue.addLast("d");
        System.out.println(queue);

        queue.removeFirst();
        queue.removeFirst();
        System.out.println(queue);

        //
        LinkedList<String> stack=new LinkedList<>();
        //push
        stack.addFirst("A");
        stack.addFirst("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
        //pop
        stack.removeFirst();
        stack.pop();
        System.out.println(stack);
    }
}
