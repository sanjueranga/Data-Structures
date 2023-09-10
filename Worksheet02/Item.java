public class Item {
    private String userId;
    private String itemName;
    private int itemUnitPrice;
    private int quantitiy;

    public Item(String uid, String itemName, int itemUnitPrice) {
        this.userId = uid;
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.quantitiy = 1;

    }

    public Item(String uid, String itemName, int itemUnitPrice, int quantitiy) {
        this.userId = uid;
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.quantitiy = quantitiy;

    }

    public void upQuantity() {

        this.quantitiy += 1;

    }

    public void downQuantitiy() {
        this.quantitiy--;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getItemName() {
        return this.itemName;
    }

    public int getItemUnitPrice() {
        return itemUnitPrice;
    }

    public int getQuantitiy() {
        return quantitiy;
    }
}
