
public class Driver {
    public static void main(String[] args) {

        int value = 4;
        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            if (i + 1 == array.length) {
                System.out.print("array is full");
            } else {
                if (array[i] == 0) {
                    array[i] = value;

                    return;

                }
            }
        }

        for (int j = 0; j < array.length; j++) {
            System.out.println(array[j]);
        }
    }

}
