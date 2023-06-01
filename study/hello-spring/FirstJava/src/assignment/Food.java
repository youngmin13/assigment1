package assignment;

public class Food extends Menu {

    private String foodName;
    private String foodDesc;
    private Double foodPrice;

    public Food (String foodName, String foodDesc) {
        super(foodName, foodDesc);
    };

    // 생성자, 제대로 한건지는 모르겠지만 Menu를 extends 하여서 거기에 있는 값 들을 super로 받아옴
    public Food (String foodName, String foodDesc, Double foodPrice) {
        // 이렇게 해서 일단 부모 클래스를 생성함
        super(foodName, foodDesc);
        // 부모 클래스의 값을 가져와서 할당 -> 없으면 null 값이 나옴 -> Main에 부모를 만들지 않고 해서 그런가?
        this.foodName = super.getMenuName();
        this.foodDesc = super.getMenuDesc();
        this.foodPrice = foodPrice;
    }

    // Menu의 printMenu를 가져와서 오버라이딩 함
    @Override
    public void printMenu(int number) {
        System.out.printf( (number + 1) + ". " + "%-18s" + " | W " + this.foodPrice + " | " + this.foodDesc, this.foodName);
        System.out.println();
    }

    public String getFoodName() {
        return this.foodName;
    }

    public String getFoodDesc() {
        return this.foodDesc;
    }

    public Double getFoodPrice() {
        return this.foodPrice;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }
}
