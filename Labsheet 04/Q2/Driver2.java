public class Driver2 {
    public static void main(String[] args) {

        Stackstr stack = new Stackstr();

        String string = "ab+cd+*";
        String infix = "";

        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'A')) {

                stack.push(Character.toString(c));

            } else {

                char operator = c;

                String st1 = stack.pop();
                String st2 = stack.pop();

                infix = "(" + st2 + operator + st1 + ")";

                stack.push(infix);

            }
        }
        System.out.println(infix);
    }
}