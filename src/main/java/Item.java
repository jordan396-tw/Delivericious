public class Item {
    public String name;
    public int price;
    private String category;

    public Item(String name, String category){
        this.name = name;
    }

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }
}
