public class Stackstr {
    

        NodeStr top;
    
        Stackstr() {
            this.top = null;
        }
    
        void push(String data) {
            NodeStr new_node = new NodeStr(data);
            if (top == null) {
                this.top = new_node;
                new_node.next = null;
            } else {
                new_node.next = this.top;
                this.top = new_node;
            }
    
        }
    
        String pop() {
            String temp = this.top.data;
            this.top = this.top.next;
            return temp;
        }
    
        boolean isEmpty() {
            if (this.top == null) {
                return true;
            } else {
                return false;
            }
        }
    
        void peek() {
            if (this.isEmpty() == false) {
                System.out.println(top.data);
            }
        }
    
        void Display() {
            NodeStr temp = this.top;
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    
    }
    

