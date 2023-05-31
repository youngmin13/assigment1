package assignment;

import java.util.*;

public class Order {

    private ArrayList<Food> food;
    private int waitNumber;

    public Order () {
        this.food = new ArrayList<>();
        this.waitNumber = 1;
    }

    public void addFood (Food product) {
        this.food.add(product);
    }

    public int getWaitNumber() {
        return waitNumber;
    }

    public void setWaitNumber(int waitNumber) {
        this.waitNumber = waitNumber;
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
        LinkedHashMap<String, Integer> nameCount = new LinkedHashMap<>();
        LinkedHashMap<String, Double> descPrice = new LinkedHashMap<>();
        // 맵에 넣어서 중복 제거하고 기존에 있으면 갯수 + 1
        for (Food product : this.food) {
            if (nameCount.containsKey(product.getFoodName())) {
                nameCount.replace(product.getFoodName(), (nameCount.get(product.getFoodName()) + 1));
                descPrice.replace(product.getFoodDesc(), product.getFoodPrice());
                flag = true;
                continue;
            }
            else {
                nameCount.put(product.getFoodName(), 1);
                descPrice.put(product.getFoodDesc(), product.getFoodPrice());
            }
        }

        System.out.println(nameCount.size() + " " + descPrice.size());

        // 가격 총합
        double sum = 0.0;
        // 출력
        // 중복된 값이 있으면
        if (flag) {
            int first = 0;
            for (String key : nameCount.keySet()) {
                int second = 0;
                for (String desc : descPrice.keySet()) {
                    if (first == second) {
                        System.out.printf("%-18s" + " | W " + descPrice.get(desc) + " | " + "%s개" + " | " + desc, key, nameCount.get(key));
                        System.out.println();
                        // 가격 더하기 (중복 주문한 것은 곱하기 갯수)
                        sum += descPrice.get(desc) * nameCount.get(key);
                        ++first;
                        break;
                    }
                    else if (first != second) {
                        ++second;
                    }
                }
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
