package Q2;

public class Driver {

    public static void main(String[] args) {

        HashTable hashtable = new HashTable();
        hashtable.Insert(new Book("B01", "Harry Potter", "Rowling", 652, 2095690));
        hashtable.Insert(new Book("B02", "The Lost Continent", "Bryson", 299, 45712));
        hashtable.Insert(new Book("B03", "The Lord of the Rings", "Tolkein", 1184, 1710));
        hashtable.Insert(new Book("B04", "Notes from a Small Island", "Bryson", 324, 80609));
        hashtable.Insert(new Book("B05", "The Changeling Sea ", "Patricia", 137, 4454));
        hashtable.Insert(new Book("B06", "Heirs of General Practice", "McPhee", 128, 268));
        hashtable.Insert(new Book("B07", "Salmon of Doubt", "Douglas", 336, 5));
        hashtable.Insert(new Book("B08", "For the New Intellectual", "Rand", 224, 2750));
        hashtable.Insert(new Book("B09", "City of Glass", "Auster", 203, 12410));
        hashtable.Insert(new Book("B10", "A War Like No Other", "Davis", 397, 1693));

        hashtable.Display();

        hashtable.retrive("Tolkein");
        System.out.println("******************************");

        hashtable.Display();

    }
}
