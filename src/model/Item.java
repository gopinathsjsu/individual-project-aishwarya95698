package model;

public class Item {
    private String category;
    private String itemName;
    private double price;
    private int quantity;

    private Item(ItemBuilder item){
        this.category = item.category;
        this.itemName = item.itemName;
        this.price = item.price;
        this.quantity =item.quantity;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    public int setQuantity(int quantity) {
        return quantity;
    }
    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return "category: "+this.category+", itemName: "+this.itemName+", quantity: "+this.quantity
                + ", price: "+this.price;
    }
// Implementing Builder Design Pattern
    public static class ItemBuilder{
        private String category;
        private String itemName;
        private double price;
        private int quantity;
        public ItemBuilder category(String category) {
            this.category = category;
            return this;
        }

        public ItemBuilder itemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public ItemBuilder price(double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }
        public Item build(){
            validateItem();
            return new Item(this);
        }
        private void validateItem(){
            if(this.category == null || this.itemName == null){
                throw new RuntimeException("Values can not be null");
            }
        }
    }
}
