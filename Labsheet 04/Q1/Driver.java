public class Driver {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(1);
        stack.push(5);
        stack.push(6);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(10);
        stack.push(38);

        stack.pop();

        stack.push(58);
        stack.push(43);

        stack.pop();

        stack.push(100);
        stack.push(378);

        stack.Display();

    }
}
