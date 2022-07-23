package hello.hellospring.domain;

public class MenuList {
    private int menuIdx;
    private String menuImg;
    private String menuName;
    private int menuQuantity;
    private int menuOriginalPrice;
    private int menuDiscountPrice;
    private String menuStatus;
    private int restaurantIdx;
    private String restaurantName;
    private double distance;
    private String closeTime;
    private String restaurantPhone;
    private String restaurantStatus;

    public int getMenuIdx() {
        return menuIdx;
    }

    public void setMenuIdx(int menuIdx) {
        this.menuIdx = menuIdx;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public void setMenuImg(String menuImg) {
        this.menuImg = menuImg;
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

    public int getRestaurantIdx() {
        return restaurantIdx;
    }

    public void setRestaurantIdx(int restaurantIdx) {
        this.restaurantIdx = restaurantIdx;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public String getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(String restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public String getRestaurantStatus() {
        return restaurantStatus;
    }

    public void setRestaurantStatus(String restaurantStatus) {
        this.restaurantStatus = restaurantStatus;
    }
}
