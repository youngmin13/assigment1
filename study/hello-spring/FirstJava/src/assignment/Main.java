package assignment;

import java.util.*;

public class Main {
    // 메인 메뉴판
    public static final ArrayList<String> mainName = new ArrayList<>(Arrays.asList("Burger", "Forzen Custard", "Drinks", "Beer", "Order", "Cancel"));
    public static final ArrayList<String> mainDesc = new ArrayList<>(
            Arrays.asList(
                    "앵거스 비프 통살을 다져만든 버거",
                    "매장에서 신선하게 만드는 아이스크림",
                    "버거와 잘 어울리는 음료",
                    "뉴욕 브루클린 브루어리에서 양조한 맥주",
                    "장바구니를 확인 후 주문합니다.",
                    "진행중인 주문을 취소합니다."
            )
    );
    
    // 버거
    public static final ArrayList<String> burgerName = new ArrayList<>(Arrays.asList("ShackBurger", "SmokeShack", "Shroom Burger", "Cheeseburger", "Hamburger"));
    public static final ArrayList<String> burgerDesc = new ArrayList<>(
            Arrays.asList(
                    "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                    "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                    "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
                    "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                    "비프패티를 기반으로 야채가 들어간 기본버거"
            )
    );
    public static final ArrayList<Double> burgerPrice = new ArrayList<>(Arrays.asList(6.9, 8.9, 9.4, 6.9, 5.4));

    // 아이스크림
    public static final ArrayList<String> iceName = new ArrayList<>(Arrays.asList("Apple Mango", "Banana Strawberry", "Chocolate", "Green Tea", "Milk"));
    public static final ArrayList<String> iceDesc = new ArrayList<>(
            Arrays.asList(
                    "애플망고 맛의 아이스크림",
                    "바나나와 딸기가 섞인 아이스크림",
                    "클래식한 초콜릿 아이스크림",
                    "담백한 녹차 맛 아이스크림",
                    "가게 전통 비법이 들어간 기본 아이스크림"
            )
    );
    public static final ArrayList<Double> icePrice = new ArrayList<>(Arrays.asList(3.9, 3.9, 3.7, 3.7, 3.5));

    // 음료
    public static final ArrayList<String> drinkName = new ArrayList<>(Arrays.asList("CocaCola", "CocaCola-Zero", "Sprite", "Sprite-Zero", "MilkShake"));
    public static final ArrayList<String> drinkDesc = new ArrayList<>(
            Arrays.asList(
                    "코카콜라",
                    "코카콜라 제로",
                    "스프라이트",
                    "스프라이트 제로",
                    "가게 전통 비법이 들어간 밀크쉐이크"
            )
    );
    public static final ArrayList<Double> drinkPrice = new ArrayList<>(Arrays.asList(7.0, 0.9, 0.7, 0.7, 0.5));
    
    // 맥주
    public static final ArrayList<String> beerName = new ArrayList<>(Arrays.asList("Majestic Pigeon", "Pierhopper IPA", "Rasplatei", "Black is beautiful", "Brooklyn Capataz"));
    public static final ArrayList<String> beerDesc = new ArrayList<>(
            Arrays.asList(
                    "Smooth & silky hazy IPA with notes of fresh strawberry & juicy melon",
                    "Vibrant IPA with fuity Citra and bright, breezy Trident hops",
                    "Powerful imperial stout brewed with playful raspberries",
                    "Stout brewed as part of the Black is Beautiful Intiative",
                    "Remarkable & complex barleywine-style ale aged in Pedro Ximenez & amontillado sherry"
            )
    );
    public static final ArrayList<Double> beerPrice = new ArrayList<>(Arrays.asList(7.0, 8.0, 12.0, 7.0, 12.0));

    public static void main(String[] args) {

        // Menu 6개 선언 및 초기화
        Menu[] menuMain = new Menu[6];
        for (int i = 0; i < 6; i++) {
            menuMain[i] = new Menu(mainName.get(i), mainDesc.get(i));
        }

        // 버거 5개 초기화
        Food[] menuBurger = new Food[5];
        for (int i = 0; i < 5; i++) {
            menuBurger[i] = new Food(burgerName.get(i), burgerDesc.get(i), burgerPrice.get(i));
        }

        // 아이스크림 5개 초기화
        Food[] menuIce = new Food[5];
        for (int i = 0; i < 5; i++) {
            menuIce[i] = new Food(iceName.get(i), iceDesc.get(i), icePrice.get(i));
        }

        // 음료 5개 초기화
        Food[] menuDrink = new Food[5];
        for (int i = 0; i < 5; i++) {
            menuDrink[i] = new Food(drinkName.get(i), drinkDesc.get(i), drinkPrice.get(i));
        }

        //맥주 5개 초기화
        Food[] menuBeer = new Food[5];
        for (int i = 0; i < 5; i++) {
            menuBeer[i] = new Food(beerName.get(i), beerDesc.get(i), beerPrice.get(i));
        }

        Order basket = new Order();

        // 0번 옵션
        double totalCharge = 0.0;
        Map<String, Double> totalFood = new HashMap<>();

        // 반복문
        while(true) {
            // 메뉴 출력
            for (int i = 0; i < menuMain.length; i++)
                menuMain[i].printMenu(i);
            // 메뉴 선택
            int optionChoice;
            Scanner sc = new Scanner(System.in);
            optionChoice = sc.nextInt();
            // 어느 음식을 고를 건지 선택하는 변수
            int choice;

            System.out.println("\"SHAKESHACK BURGER\" 에 오신걸 환영합니다.");
            System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            // 확인 or 취소
            int flag;
            int option;
            double plusDouble;
            Food foodChange;
            // 옵션 선택 후 실행
            switch (optionChoice) {
                case 1: // 버거
                    System.out.println("[ Burgers MENU ]");
                    // 버거 전체 출력
                    for (int i =  0; i < menuBurger.length; i++) {
                        menuBurger[i].printMenu(i);
                    }
                    // 몇 번째 음식을 고를 것인가
                    choice = sc.nextInt();
                    // 고른 음식 출력
                    menuBurger[choice - 1].printMenu(choice - 1);
                    // 싱글인지 더블인지
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                    plusDouble = 3.6;
                    System.out.printf("1. Single(W %.1f)        2. Double(W %.1f)\n",  menuBurger[choice - 1].getFoodPrice(),  menuBurger[choice - 1].getFoodPrice() + plusDouble);
                    option = sc.nextInt();
                    // 임시로 사용할 새로운 Food 객체 하나 생성
                    foodChange = new Food(burgerName.get(choice - 1), burgerDesc.get(choice - 1), burgerPrice.get(choice - 1));
                    if (option == 1) {
                        foodChange.setFoodName(burgerName.get(choice - 1) + "(Single)");
                    }
                    else if (option == 2) {
                        foodChange.setFoodName(burgerName.get(choice - 1) + "(Double)");
                        foodChange.setFoodPrice(burgerPrice.get(choice - 1) + plusDouble);
                    }
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        if (option == 1) {
                            basket.addFood(menuBurger[choice - 1]);
                            System.out.print(menuBurger[choice - 1].getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                        else if (option == 2) {
                            basket.addFood(foodChange);
                            System.out.print(foodChange.getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                    }
                    else if (flag == 2) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        System.out.println();
                    }
                    else {
                        System.out.println("잘 못 누르셨습니다. 1번이나 2번을 중 하나를 선택해주세요.");
                    }
                    break;
                case 2: // 아이스크림
                    System.out.println("[ Forzen Custard MENU ]");
                    for (int i =  0; i < menuIce.length; i++) {
                        menuIce[i].printMenu(i);
                    }
                    choice = sc.nextInt();
                    menuIce[choice - 1].printMenu(choice - 1);
                    // 싱글인지 더블인지
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                    plusDouble = 1.9;
                    System.out.printf("1. Single(W %.1f)        2. Double(W %.1f)\n",  menuIce[choice - 1].getFoodPrice(),  menuIce[choice - 1].getFoodPrice() + plusDouble);
                    option = sc.nextInt();
                    foodChange = new Food(iceName.get(choice - 1), iceDesc.get(choice - 1), icePrice.get(choice - 1));
                    if (option == 1) {
                        foodChange.setFoodName(iceName.get(choice - 1) + "(Single)");
                    }
                    else if (option == 2) {
                        foodChange.setFoodName(iceName.get(choice - 1) + "(Double)");
                        foodChange.setFoodPrice(icePrice.get(choice - 1) + plusDouble);
                    }
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        if (option == 1) {
                            basket.addFood(menuIce[choice - 1]);
                            System.out.print(menuIce[choice - 1].getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                        else if (option == 2) {
                            basket.addFood(foodChange);
                            System.out.print(foodChange.getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                    }
                    else if (flag == 2) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        System.out.println();
                    }
                    else {
                        System.out.println("잘 못 누르셨습니다. 1번이나 2번을 중 하나를 선택해주세요.");
                    }
                    break;
                case 3: // 음료
                    System.out.println("[ Drinks MENU ]");
                    for (int i =  0; i < menuDrink.length; i++) {
                        menuDrink[i].printMenu(i);
                    }
                    choice = sc.nextInt();
                    menuDrink[choice - 1].printMenu(choice - 1);
                    // 싱글인지 더블인지
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                    plusDouble = 0.9;
                    System.out.printf("1. Single(W %.1f)        2. Double(W %.1f)\n",  menuDrink[choice - 1].getFoodPrice(),  menuDrink[choice - 1].getFoodPrice() + plusDouble);
                    option = sc.nextInt();
                    foodChange = new Food(drinkName.get(choice - 1), drinkDesc.get(choice - 1), drinkPrice.get(choice - 1));
                    if (option == 1) {
                        foodChange.setFoodName(drinkName.get(choice - 1) + "(Single)");
                    }
                    else if (option == 2) {
                        foodChange.setFoodName(drinkName.get(choice - 1) + "(Double)");
                        foodChange.setFoodPrice(drinkPrice.get(choice - 1) + plusDouble);
                    }
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        if (option == 1) {
                            basket.addFood(menuDrink[choice - 1]);
                            System.out.print(menuDrink[choice - 1].getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                        else if (option == 2) {
                            basket.addFood(foodChange);
                            System.out.print(foodChange.getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                    }
                    else if (flag == 2) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        System.out.println();
                    }
                    else {
                        System.out.println("잘 못 누르셨습니다. 1번이나 2번을 중 하나를 선택해주세요.");
                    }
                    break;
                case 4: // 맥주
                    System.out.println("[ Beers MENU ]");
                    for (int i =  0; i < menuBeer.length; i++) {
                        menuBeer[i].printMenu(i);
                    }
                    choice = sc.nextInt();
                    menuBeer[choice - 1].printMenu(choice - 1);
                    // 싱글인지 더블인지
                    System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
                    plusDouble = 2.9;
                    System.out.printf("1. Single(W %.1f)        2. Double(W %.1f)\n",  menuBeer[choice - 1].getFoodPrice(),  menuBeer[choice - 1].getFoodPrice() + plusDouble);
                    option = sc.nextInt();
                    foodChange = new Food(beerName.get(choice - 1), beerDesc.get(choice - 1), beerPrice.get(choice - 1));
                    if (option == 1) {
                        foodChange.setFoodName(beerName.get(choice - 1) + "(Single)");
                    }
                    else if (option == 2) {
                        foodChange.setFoodName(beerName.get(choice - 1) + "(Double)");
                        foodChange.setFoodPrice(beerPrice.get(choice - 1) + plusDouble);
                    }
                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        if (option == 1) {
                            basket.addFood(menuBeer[choice - 1]);
                            System.out.print(menuBeer[choice - 1].getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                        else if (option == 2) {
                            basket.addFood(foodChange);
                            System.out.print(foodChange.getFoodName());
                            System.out.println("가 장바구니에 추가되었습니다.");
                        }
                    }
                    else if (flag == 2) {
                        System.out.println("메뉴판으로 돌아갑니다.");
                        System.out.println();
                    }
                    else {
                        System.out.println("잘 못 누르셨습니다. 1번이나 2번을 중 하나를 선택해주세요.");
                    }
                    break;
                case 5: // 주문
                    System.out.println("아래와 같이 주문 하시겠습니까?\n");
                    totalCharge += basket.takeOrder();
                    System.out.println("1. 주문      2. 메뉴판");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        System.out.println("주문이 완료되었습니다!\n");
                        System.out.printf("대기번호는 [ %d ] 번 입니다.", basket.getWaitNumber());
                        // 주문 번호 증가
                        basket.upWaitNumber();
                        // 총 판매 메뉴
                        for (int i = 0; i < basket.getFood().size(); i++) {
                            totalFood.put(basket.getFood().get(i).getFoodName(), basket.getFood().get(i).getFoodPrice());
                        }
                        // 장바구니 비우기
                        basket.orderCancel();
                        // 3초 sleep
                        try {
                            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 6: // 취소
                    System.out.println("진행하던 주문을 취소하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        basket.orderCancel();
                        System.out.println("진행하던 주문이 취소되었습니다.");
                    }
                    break;
                case 0:
                    // 총 판매 상품
                    System.out.println("[ 총 판매상품 목록 현황 ]");
                    System.out.println("현재까지 총 판매된 상품 목록은 아래와 같습니다.\n");
                    for (String key : totalFood.keySet()) {
                        System.out.printf("- %-18s" + " | W %.1f", key, totalFood.get(key));
                        System.out.println();
                    }
                    //총 판매 금액
                    System.out.println("\n[ 총 판매금액 현황 ]");
                    System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n", totalCharge);
                    System.out.println();
                    System.out.println("돌아가기 (화면을 클릭해주세요).");
                    flag = sc.nextInt();
                    break;
            }
        }
    }
}
