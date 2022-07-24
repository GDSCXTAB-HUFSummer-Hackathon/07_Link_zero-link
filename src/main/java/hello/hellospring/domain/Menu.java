package hello.hellospring.domain;

public class Menu {
    private int menuIdx;
    private String menuImg;
    private String menuName;
    private int menuQuantity;
    private int menuOriginalPrice;
    private int menuDiscountPrice;
    private String menuStatus;

    public int getMenuIdx() {
        return menuIdx;
    }

    public void setMenuIdx(int menuIdx) {
        this.menuIdx = menuIdx;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuQuantity() {
        return menuQuantity;
    }

    public void setMenuQuantity(int menuQuantity) {
        this.menuQuantity = menuQuantity;
    }

    public int getMenuOriginalPrice() {
        return menuOriginalPrice;
    }

    public void setMenuOriginalPrice(int menuOriginalPrice) {
        this.menuOriginalPrice = menuOriginalPrice;
    }

    public int getMenuDiscountPrice() {
        return menuDiscountPrice;
    }

    public void setMenuDiscountPrice(int menuDiscountPrice) {
        this.menuDiscountPrice = menuDiscountPrice;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus;
    }

}
