package inventory.and.order.management.system;

import java.util.*;

//************************************************** INVENTORY CLASS **************************************************//
class inventory {

    public ArrayList<item> inventoryItemAL = new ArrayList<>();
    public ArrayList<order> inventoryOrderAL = new ArrayList<>();

    public void addInventory(item addedItem) {
        inventoryItemAL.add(addedItem);
    }

    public void addOrders(order addedOrder) {
        inventoryOrderAL.add(addedOrder);
    }

    public String getInventory() {
        return toString();
    }

    public String getOrders() {
        return inventoryOrderAL.toString();
    }

    @Override
    public String toString() {
        return inventoryItemAL.toString();
    }
}

//************************************************** ORDER CLASS **************************************************//
class order {

    public ArrayList<item> orderItemAL = new ArrayList<>();
    public static double orderTotal;
    public ArrayList<Double> orderSumAL = new ArrayList<>();

    public order() {
    }

    public order(double price, int quantity) {
        orderTotal = orderTotal + (price * quantity);
    }

    public void orderSum() {
        orderSumAL.add(orderTotal);
    }

    public void addItem(item item) {
        orderItemAL.add(item);
    }

    @Override
    public String toString() {
        return orderItemAL.toString();
    }
}

//************************************************** ITEM CLASS **************************************************//
class item {

    public String name;
    public double price;
    public int quantity;

    public item() {
    }

    public item(String name, double price, int quantity) {
        this.name = name;
        setQuantity(quantity);
        setPrice(price);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Name : " + name + ", " + " Price is : " + getPrice() + ", " + " Quantity is : " + getQuantity();

    }
}

//************************************************** CLOTHES CLASS **************************************************//
class clothes extends item {

    public clothes(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return "\nType : Clothes, " + super.toString();
    }
}

//************************************************** COSMETICS CLASS **************************************************//
class cosmetics extends item {

    public cosmetics(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return "\nType : Cosmetics, " + super.toString();
    }
}

//************************************************** ELECTRONICS CLASS **************************************************//
class electronics extends item {

    public electronics(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public String toString() {
        return "\nType : Electronics, " + super.toString();
    }
}

//************************************************** OBJECT CLASS **************************************************//
public class InventoryAndOrderManagementSystem {

    public static int menu1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------------------");
        System.out.println("Welcome to Inventory System");
        System.out.println("---------------------------");
        System.out.println("Please make your selection");
        System.out.println("");
        System.out.println("1. Add Inventory");
        System.out.println("2. Add Order");
        System.out.println("3. Show Inventory");
        System.out.println("4. Show Orders");
        System.out.println("5. Show All details");
        System.out.println("6. Exit System");
        System.out.println("");
        System.out.print("> ");
        int main1Selection = sc.nextInt();
        return main1Selection;
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("You can add items from the following list");
        System.out.println("1. Clothes");
        System.out.println("2. Cosmetics");
        System.out.println("3. Electronics");
        System.out.println("");
        System.out.print("> ");
        int menu2Selection = sc.nextInt();
        return menu2Selection;
    }

//************************************************** MAIN STRING ARGS **************************************************//
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nameAL = new ArrayList<>();
        ArrayList<Double> priceAL = new ArrayList<>();
        ArrayList<Integer> quantityAL = new ArrayList<>();
        ArrayList<String> typeAL = new ArrayList<>();
        ArrayList<Integer> intAL = new ArrayList<>();
        inventory inventoryObj = new inventory();
        order orderObj = new order();
        order orderVariable;
        int a = 0;
        int b = 0;
        int mainMenu = 0;

        while (mainMenu >= 0) {
            if (mainMenu > 0) {
                System.out.println("");
            }
            mainMenu = menu1();
            if (mainMenu == 1) {
                int subMenu = menu2();
                if (subMenu == 1) {
                    System.out.println("-------- Clothes --------");
                    typeAL.add("Clothes");
                    System.out.print("Enter Name: ");
                    String name1 = sc.next();
                    System.out.print("Enter Quantity: ");
                    int quantity1 = sc.nextInt();
                    System.out.print("Enter price per unit: ");
                    double price1 = sc.nextDouble();
                    for (int i = 0; i < nameAL.size(); i++) {
                        if (name1.equals(nameAL.get(i)) && price1 == priceAL.get(i)) {
                            quantity1 = quantityAL.get(i) + quantity1;
                            quantityAL.remove(i);
                            nameAL.remove(i);
                            priceAL.remove(i);
                            inventoryObj.inventoryItemAL.remove(i);
                        }
                    }
                    nameAL.add(name1);
                    priceAL.add(price1);
                    quantityAL.add(quantity1);
                    clothes clothesObj = new clothes(name1, price1, quantity1);
                    inventoryObj.addInventory(clothesObj);
                } else if (subMenu == 2) {
                    System.out.println("--- Cosmetics ---");
                    typeAL.add("Cosmetics");
                    System.out.print("Enter Name: ");
                    String name1 = sc.next();
                    System.out.print("Enter Quantity: ");
                    int quantity1 = sc.nextInt();
                    System.out.print("Enter price per unit: ");
                    double price1 = sc.nextDouble();
                    for (int i = 0; i < nameAL.size(); i++) {
                        if (name1.equals(nameAL.get(i)) && price1 == priceAL.get(i)) {
                            quantity1 = quantityAL.get(i) + quantity1;
                            quantityAL.remove(i);
                            nameAL.remove(i);
                            priceAL.remove(i);
                            inventoryObj.inventoryItemAL.remove(i);
                        }
                    }
                    nameAL.add(name1);
                    priceAL.add(price1);
                    quantityAL.add(quantity1);
                    cosmetics cosmeticsObj = new cosmetics(name1, price1, quantity1);
                    inventoryObj.addInventory(cosmeticsObj);
                } else if (subMenu == 3) {
                    System.out.println("--- Electronics ---");
                    typeAL.add("Electronics");
                    System.out.print("Enter Name: ");
                    String name1 = sc.next();
                    System.out.print("Enter Quantity: ");
                    int quantity1 = sc.nextInt();
                    System.out.print("Enter price per unit: ");
                    double price1 = sc.nextDouble();
                    for (int i = 0; i < nameAL.size(); i++) {
                        if (name1.equals(nameAL.get(i)) && price1 == priceAL.get(i)) {
                            quantity1 = quantityAL.get(i) + quantity1;
                            quantityAL.remove(i);
                            nameAL.remove(i);
                            priceAL.remove(i);
                            inventoryObj.inventoryItemAL.remove(i);
                        }
                    }
                    nameAL.add(name1);
                    priceAL.add(price1);
                    quantityAL.add(quantity1);
                    electronics electronicsObj = new electronics(name1, price1, quantity1);
                    inventoryObj.addInventory(electronicsObj);
                }
            } else if (mainMenu == 2) {
                if (inventoryObj.inventoryItemAL.size() == 0) {
                    System.out.println("we are out of inventory");

                } else {
                    int count = 1;

                    while (count == 1) {
                        System.out.println("");
                        System.out.println("You can add to your cart from following items");
                        System.out.println("");
                        System.out.println(inventoryObj.getInventory());
                        System.out.println("");
                        System.out.print("Enter Name: ");
                        String name1 = sc.next();
                        for (int i = 0; i < nameAL.size(); i++) {
                            if (nameAL.get(i).equals(name1)) {
                                System.out.print("Enter Quantity: ");
                                int quantity1 = sc.nextInt();
                                if (quantity1 <= quantityAL.get(i)) {
                                    int quant = quantityAL.get(i) - quantity1;
                                    quantityAL.remove(i);
                                    quantityAL.add(i, quant);
                                    inventoryObj.inventoryItemAL.remove(i);

                                    if (typeAL.get(i).equals("Clothes")) {
                                        clothes clothesObj = new clothes(name1, priceAL.get(i), quantityAL.get(i));
                                        inventoryObj.inventoryItemAL.add(i, clothesObj);
                                        clothes clothesObj2 = new clothes(name1, priceAL.get(i), quantity1);
                                        orderObj.addItem(clothesObj2);
                                        a++;

                                    } else if (typeAL.get(i).equals("Cosmetics")) {
                                        cosmetics cosmeticsObj = new cosmetics(name1, priceAL.get(i), quantityAL.get(i));
                                        inventoryObj.inventoryItemAL.add(i, cosmeticsObj);
                                        cosmetics cosmeticsObj2 = new cosmetics(name1, priceAL.get(i), quantity1);
                                        orderObj.addItem(cosmeticsObj2);
                                        a++;
                                    } else if (typeAL.get(i).equals("Electronics")) {
                                        electronics electronicsObj = new electronics(name1, priceAL.get(i), quantityAL.get(i));
                                        inventoryObj.inventoryItemAL.add(i, electronicsObj);
                                        electronics electronicsObj2 = new electronics(name1, priceAL.get(i), quantity1);
                                        orderObj.addItem(electronicsObj2);
                                        a++;
                                    }
                                    System.out.println("Your Order Details");
                                    System.out.println("------------------");
                                    orderVariable = new order(priceAL.get(i), quantity1);
                                    System.out.println("Order total : " + order.orderTotal);
                                    for (int j = b; j < orderObj.orderItemAL.size(); j++) {
                                        System.out.println("Items : " + orderObj.orderItemAL.get(j));
                                    }

                                } else {
                                    System.out.println("Sorry! We are out of stocks");
                                }
                                break;
                            } else if (i == nameAL.size() - 1) {
                                System.out.println("Sorry! This item is not in our stocks");
                            }
                        }
                        System.out.println("Enter");
                        System.out.println("1. For adding more items");
                        System.out.println("2. For completing order");
                        count = sc.nextInt();
                    }
                    if (count == 2) {
                        System.out.println("Your Order Details");
                        System.out.println("------------------");
                        System.out.println("Order total : " + order.orderTotal);
                        System.out.println("Items : " + orderObj.toString());
                        System.out.println("");
                        System.out.println("Order Added");

                        orderObj.orderSum();
                        b = a;
                        intAL.add(b);
                        a = 0;
                        order.orderTotal = 0;
                    }
                }
            } else if (mainMenu == 3) {
                System.out.println("");
                System.out.println(inventoryObj.getInventory());

            } else if (mainMenu == 4) {
                System.out.println("Your Order Details");
                System.out.println("------------------");
                System.out.println("");
                int k = 0;
                for (int i = 0; i < orderObj.orderSumAL.size(); i++) {
                    int j;
                    System.out.println("Order Total : " + orderObj.orderSumAL.get(i));
                    for (j = 0; j < intAL.get(i) + k; j++) {
                        if (i != 0 && j == 0) {
                            j = intAL.get(i - 1);
                        }
                        System.out.println(orderObj.orderItemAL.get(j));
                    }
                    k = j;
                }

            } else if (mainMenu == 5) {
                System.out.println("Items : ");
                System.out.println(inventoryObj.toString());
                System.out.println("Orders : ");
                System.out.println(orderObj.toString());
            } else if (mainMenu == 6) {
                System.out.println("----------------------");
                System.out.println("Hope to see you again!");
                System.out.println("       Good Bye");
                System.exit(0);
            }
        }
    }
}
