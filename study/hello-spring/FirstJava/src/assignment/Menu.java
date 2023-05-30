package assignment;
public class Menu {
    private String menuName;
    private String menuDesc;

    // 생성자
    public Menu (String menuName, String menuDesc) {
        this.menuName = menuName;
        this.menuDesc = menuDesc;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    // 가지고 있는 메뉴들을 가지고 메뉴판 출력
    public void printMenu(int i) {
        if (i == 0) {
            System.out.println("\"SHAKESHACK BURGER\" 에 오신걸 환영합니다.");
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
            System.out.println("[ SHAKESHACK MENU ]");
            System.out.printf( (i + 1) + ". " + "%-16s" + " | " + this.menuDesc, this.menuName);
            System.out.println();
        }
        else if (i < 4) {
            System.out.printf( (i + 1) + ". " + "%-16s" + " | " + this.menuDesc, this.menuName);
            System.out.println();
        }
        else {
            if (i == 4) {
                System.out.println("\n[ ORDER MENU ]");
            }
            System.out.printf( (i + 1) + ". " + "%-12s" + " | " + this.menuDesc, this.menuName);
            System.out.println();
        }
    }
}
