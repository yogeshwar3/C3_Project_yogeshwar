import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        //return true;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        LocalTime timeNow = getCurrentTime();
        if ((timeNow.compareTo(openingTime) >= 0) && (timeNow.compareTo(closingTime) < 0)){
            return true;
        } else {
            return false;
        }
    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //return null;
        //DELETE ABOVE RETURN STATEMENT AND WRITE CODE HERE
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());
    }

    public String getName() {
        return name;
    }

    public Item getMenuItem(String itemName) throws itemNotFoundException {
        Item itemToBeSearched = findItemByName(itemName);
        if (itemToBeSearched == null)
            throw new itemNotFoundException(itemName);
        return itemToBeSearched;
    }

    public int calculate_cost(String[] strings) throws itemNotFoundException {
        int totalCost = 0;
        Item itemFound;
        for (int i=0; i < strings.length; i++){
            itemFound = getMenuItem(strings[i]);
            totalCost = totalCost + itemFound.getPrice();
        }
        return totalCost;
    }
}
