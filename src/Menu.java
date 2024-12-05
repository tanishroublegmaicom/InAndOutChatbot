public class Menu{
    private String name;
    private String[] ingredients;
    private String[] tag;
    private int price;
    public Menu(String name, int price, String[] ingredients, String[] tag){
        this.name =name;
        this.ingredients=ingredients;
        this.tag=tag;
        this.price=price;
    }


    public String getName(){
        return name;
    }
    public String[] getIngredients(){
        return ingredients;
    }
    public String[] getTag(){
        return tag;
    }
    public int getPrice(){
        return price;
    }
   
   
}

