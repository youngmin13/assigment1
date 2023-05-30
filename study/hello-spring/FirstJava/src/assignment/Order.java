package assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {

    public void setWaitNumber(int waitNumber) {
        this.waitNumber = waitNumber;
    }

    private ArrayList<Food> food;
    private int waitNumber;

    public Order () {
        this.food = new ArrayList<>();
        this.waitNumber = 1;
    }

    public void addFood (Food food) {
        this.food.add(food);
    }

    public int getWaitNumber() {
        return waitNumber;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public void setFood(ArrayList<Food> food) {
        this.food = food;
    }

    public void upWaitNumber () {
        this.waitNumber++;
    }
    // 주문하기
    public double takeOrder() {
        System.out.println("[ Orders ]");

        // 중복 값 세기
        // 중복 된 값이 있는가?
        boolean flag = false;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (Food product : this.food) {
            Integer count = map.get(product.getFoodName());
            if (count == null)
                map.put(product.getFoodName(), 1);
            else {
                map.put(product.getFoodName(), count + 1);
                flag = true;
            }
        }
        // 가격 총합
        double sum = 0.0;
        // 출력
        // 중복된 값이 있으면
        if (flag) {
            int k = 0;
            for (String key : map.keySet()) {
                System.out.printf("%-18s" + " | W " + this.food.get(k).getFoodPrice() + " | " + "%s개" + " | " + this.food.get(k).getFoodDesc(), key, map.get(key));
                System.out.println();
                // 가격 더하기 (중복 주문한 것은 곱하기 갯수)
                sum += this.food.get(k).getFoodPrice() * map.get(key);
                k++;
            }
        }
        else {  // 중복 주문한 메뉴가 없으면
            for (int i = 0; i < this.food.size(); i++) {
                System.out.printf("%-18s" + " | W " + this.food.get(i).getFoodPrice() + " | " + this.food.get(i).getFoodDesc(), this.food.get(i).getFoodName());
                System.out.println();
                // 가격 더하기
                sum += this.food.get(i).getFoodPrice();
            }
        }
        System.out.println();

        // 총 가격
        System.out.println("[ Total ]");
        System.out.printf("W %.1f\n", sum);
        System.out.println();

        return sum;
    }

    // 주문 취소하기
    public void orderCancel() {
        this.food.clear();
        System.out.println();
    }

}
