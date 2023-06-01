package assignment;

import java.util.*;

public class Main {
    // 메인 메뉴판
    private static final ArrayList<String> mainName = new ArrayList<>(Arrays.asList("Burger", "Forzen Custard", "Drinks", "Beer", "Order", "Cancel"));
    private static final ArrayList<String> mainDesc = new ArrayList<>(
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
    private static final ArrayList<String> burgerName = new ArrayList<>(Arrays.asList("ShackBurger", "SmokeShack", "Shroom Burger", "Cheeseburger", "Hamburger"));
    private static final ArrayList<String> burgerDesc = new ArrayList<>(
            Arrays.asList(
                    "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                    "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                    "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거",
                    "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                    "비프패티를 기반으로 야채가 들어간 기본버거"
            )
    );
    private static final ArrayList<Double> burgerPrice = new ArrayList<>(Arrays.asList(6.9, 8.9, 9.4, 6.9, 5.4));

    // 아이스크림
    private static final ArrayList<String> iceName = new ArrayList<>(Arrays.asList("Apple Mango", "Banana Strawberry", "Chocolate", "Green Tea", "Milk"));
    private static final ArrayList<String> iceDesc = new ArrayList<>(
            Arrays.asList(
                    "애플망고 맛의 아이스크림",
                    "바나나와 딸기가 섞인 아이스크림",
                    "클래식한 초콜릿 아이스크림",
                    "담백한 녹차 맛 아이스크림",
                    "가게 전통 비법이 들어간 기본 아이스크림"
            )
    );
    private static final ArrayList<Double> icePrice = new ArrayList<>(Arrays.asList(3.9, 3.9, 3.7, 3.7, 3.5));

    // 음료
    private static final ArrayList<String> drinkName = new ArrayList<>(Arrays.asList("CocaCola", "CocaCola-Zero", "Sprite", "Sprite-Zero", "MilkShake"));
    private static final ArrayList<String> drinkDesc = new ArrayList<>(
            Arrays.asList(
                    "코카콜라",
                    "코카콜라 제로",
                    "스프라이트",
                    "스프라이트 제로",
                    "가게 전통 비법이 들어간 밀크쉐이크"
            )
    );
    private static final ArrayList<Double> drinkPrice = new ArrayList<>(Arrays.asList(2.0, 2.0, 2.0, 2.0, 3.5));
    
    // 맥주
    private static final ArrayList<String> beerName = new ArrayList<>(Arrays.asList("Majestic Pigeon", "Pierhopper IPA", "Rasplatei", "Black is beautiful", "Brooklyn Capataz"));
    private static final ArrayList<String> beerDesc = new ArrayList<>(
            Arrays.asList(
                    "Smooth & silky hazy IPA with notes of fresh strawberry & juicy melon",
                    "Vibrant IPA with fuity Citra and bright, breezy Trident hops",
                    "Powerful imperial stout brewed with playful raspberries",
                    "Stout brewed as part of the Black is Beautiful Intiative",
                    "Remarkable & complex barleywine-style ale aged in Pedro Ximenez & amontillado sherry"
            )
    );
    private static final ArrayList<Double> beerPrice = new ArrayList<>(Arrays.asList(7.0, 8.0, 12.0, 7.0, 12.0));

    public static void main(String[] args) {

        ArrayList<ArrayList<Food>> allFood = new ArrayList<>();

        // Menu 6개 선언 및 초기화
        Menu[] menuMain = new Menu[mainName.size()];
        for (int i = 0; i < menuMain.length; i++) {
            menuMain[i] = new Menu(mainName.get(i), mainDesc.get(i));
        }

//        버거 5개 선언 및 초기화
        ArrayList<Food> menuBurger = new ArrayList<>();
        for (int i = 0; i < burgerName.size(); i++) {
            menuBurger.add(new Food(burgerName.get(i), burgerDesc.get(i), burgerPrice.get(i)));
        }
        allFood.add(menuBurger);

        // 아이스크림 5개 선언 및 초기화
        ArrayList<Food> menuIce = new ArrayList<>();
        for (int i = 0; i < iceName.size(); i++) {
            menuIce.add(new Food(iceName.get(i), iceDesc.get(i), icePrice.get(i)));
        }
        allFood.add(menuIce);


        // 음료 5개 선언 및 초기화
        ArrayList<Food> menuDrink = new ArrayList<>();
        for (int i = 0; i < drinkName.size(); i++) {
            menuDrink.add(new Food(drinkName.get(i), drinkDesc.get(i), drinkPrice.get(i)));
        }
        allFood.add(menuDrink);

        //맥주 5개 선언 및 초기화
        ArrayList<Food> menuBeer = new ArrayList<>();
        for (int i = 0; i < beerName.size(); i++) {
            menuBeer.add(new Food(beerName.get(i), beerDesc.get(i), beerPrice.get(i)));
        }
        allFood.add(menuBeer);

        // 장바구니
        Order basket = new Order();

        // 0번 옵션을 위한 변수
        double totalCharge = 0.0;
        ArrayList<String> totalFoodName = new ArrayList<>();
        ArrayList<Double> totalFoodPrice = new ArrayList<>();

        // 반복문 -> 나가는 기능이 없다. (키오스크는 원래 나가는게 없으니 괜춘할듯)
        while(true) {
            // 메뉴 출력
            for (int i = 0; i < menuMain.length; i++)
                menuMain[i].printMenu(i);
            // 메뉴 선택
            int optionChoice;
            Scanner sc = new Scanner(System.in);
            optionChoice = sc.nextInt();
            // 어느 음식을 고를 건지 선택하는 변수
            int choice = 0;

            System.out.println("\n\"SHAKESHACK BURGER\" 에 오신걸 환영합니다.");
            System.out.println("아래 상품메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            // 확인 or 취소
            int flag = 0;
            // single 인지 double 인지
            int option = 0;
            // 더블일 때 가격 더하기 위한 변수
            double plusDouble = 0.0;
            // 더블일 때를 위한 Food 객체
            Food foodChange = new Food("", "");
            // 옵션 선택 후 실행
            switch (optionChoice) {
                case 1: // 버거
                    System.out.println("[ Burgers MENU ]");
                    // 버거 전체 출력
                    casePrint(optionChoice, choice, flag, option, plusDouble, foodChange, allFood, basket);
                    break;
                case 2: // 아이스크림
                    System.out.println("[ Forzen Custard MENU ]");
                    casePrint(optionChoice, choice, flag, option, plusDouble, foodChange, allFood, basket);
                    break;
                case 3: // 음료
                    System.out.println("[ Drinks MENU ]");
                    casePrint(optionChoice, choice, flag, option, plusDouble, foodChange, allFood, basket);
                    break;
                case 4: // 맥주
                    casePrint(optionChoice, choice, flag, option, plusDouble, foodChange, allFood, basket);
                    break;
                case 5: // 주문
                    System.out.println("아래와 같이 주문 하시겠습니까?\n");
                    double temp;
                    temp = basket.takeOrder();
                    System.out.println("1. 주문      2. 메뉴판");
                    flag = sc.nextInt();
                    if (flag == 1) {
                        System.out.println("주문이 완료되었습니다!\n");
                        System.out.printf("대기번호는 [ %d ] 번 입니다.", basket.getWaitNumber());
                        // 주문 번호 증가
                        basket.upWaitNumber();
                        // 총 판매 메뉴
                        for (int i = 0; i < basket.getFood().size(); i++) {
                            totalFoodName.add(basket.getFood().get(i).getFoodName());
                            totalFoodPrice.add(basket.getFood().get(i).getFoodPrice());
                        }
                        // 장바구니 비우기
                        basket.orderCancel();
                        // 3초 sleep
                        try {
                            System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
                            totalCharge += temp;
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
                    for (int i = 0; i < totalFoodName.size(); i++) {
                        System.out.printf("- %-18s" + " | W %.1f", totalFoodName.get(i), totalFoodPrice.get(i));
                        System.out.println();
                    }
                    //총 판매 금액
                    System.out.println("\n[ 총 판매금액 현황 ]");
                    System.out.printf("현재까지 총 판매된 금액은 [ W %.1f ] 입니다.\n", totalCharge);
                    System.out.println();
                    System.out.println("돌아가기 1.");
                    flag = Integer.parseInt(sc.next());
                    break;
                default:
                    break;
            }
        }
    }
    public static void casePrint(int optionChoice, int choice, int flag, int option, double plusDouble, Food foodChange, ArrayList<ArrayList<Food>> allFood, Order basket) {
        for (int i = 0; i < allFood.get(optionChoice - 1).size(); i++) {
            allFood.get(optionChoice - 1).get(i).printMenu(i);
        }
        System.out.print("선택 메뉴 : ");
        // 몇 번째 음식을 고를 것인가
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        // 고른 음식 출력
        allFood.get(optionChoice - 1).get(choice - 1).printMenu(choice - 1);
        // 싱글인지 더블인지
        System.out.println("\n위 메뉴의 어떤 옵션으로 추가하시겠습니까?");
        plusDouble = 3.6;
        System.out.printf("1. Single(W %.1f)        2. Double(W %.1f)\n",  allFood.get(optionChoice - 1).get(choice - 1).getFoodPrice(),  allFood.get(optionChoice - 1).get(choice - 1).getFoodPrice() + plusDouble);
        System.out.print("선택 옵션 : ");
        option = sc.nextInt();
        // 임시로 사용할 새로운 Food 객체 하나 생성
        foodChange = new Food(allFood.get(optionChoice - 1).get(choice - 1).getFoodName(), allFood.get(optionChoice - 1).get(choice - 1).getFoodDesc(), allFood.get(optionChoice - 1).get(choice - 1).getFoodPrice());
        if (option == 2) {
            foodChange.setFoodName(allFood.get(optionChoice - 1).get(choice - 1).getFoodName() + "(Double)");
            foodChange.setFoodDesc(allFood.get(optionChoice - 1).get(choice - 1).getFoodDesc() + "-> 사이즈 업");
            foodChange.setFoodPrice(allFood.get(optionChoice - 1).get(choice - 1).getFoodPrice() + plusDouble);
        }
        // 장바구니에 추가할지
        boolean takeOption = true;
        while(takeOption) {
            System.out.println("\n위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            System.out.print("선택 : ");
            flag = sc.nextInt();
            System.out.println();
            if (flag == 1) {
                if (option == 1) {
                    // 기본 일때
                    basket.addFood(allFood.get(optionChoice - 1).get(choice - 1));
                    System.out.print(allFood.get(optionChoice - 1).get(choice - 1).getFoodName());
                    System.out.println("가 장바구니에 추가되었습니다.");
                    takeOption = false;
                } else if (option == 2) {
                    // 더블 같은 옵션이 추가 되었을 때
                    basket.addFood(foodChange);
                    System.out.print(foodChange.getFoodName());
                    System.out.println("가 장바구니에 추가되었습니다.");
                    takeOption = false;
                }
            } else if (flag == 2) {
                System.out.println("\n메뉴판으로 돌아갑니다.");
                System.out.println();
                takeOption = false;
            } else {
                System.out.println("\n잘 못 누르셨습니다. 1번이나 2번을 중 하나를 선택해주세요.");
                System.out.println();
            }
        }
    }
}
