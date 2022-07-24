package hello.hellospring.domain;

public class Restaurant {
    private int restaurantIdx;
    private String restaurantName;
    private String distance = null;
    private int closeTime;
    private String restaurantPhone;
    private String restaurantStatus;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(int closeTime) {
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
