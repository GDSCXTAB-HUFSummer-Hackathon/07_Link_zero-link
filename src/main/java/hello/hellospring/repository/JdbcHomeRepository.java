package hello.hellospring.repository;

import hello.hellospring.domain.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcHomeRepository implements HomeRepository{
    private final JdbcTemplate jdbcTemplate;
    public JdbcHomeRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MenuList> getMenuList(){
        List<MenuList> menuLists = jdbcTemplate.query("select M.menuIdx, M.menuImg, M.menuName, M.menuQuantity, " +
                "M.menuOriginalPrice, M.menuDiscountPrice, M.status as menuStatus, R.restaurantIdx, R.closeTime, " +
                "R.restaurantPhone, R.restaurantName, R.status as restaurantStatus, " +
                "round(6371*acos(cos(radians(37.5974476))*cos(radians(R.lattitude))*cos(radians(R.longitude)" +
                "-radians(127.058748))+sin(radians(37.5974476))*sin(radians(R.lattitude))), 1) AS distance " +
                "from Restaurant R LEFT JOIN Menu M ON R.restaurantIdx = M.restaurantIdx ;", getHomeListMapper());

        return menuLists;
    }

    private RowMapper<MenuList> getHomeListMapper() {
        return (rs, rowNum) -> {
            MenuList menuList = new MenuList();
            menuList.setMenuIdx(rs.getInt("menuIdx"));
            menuList.setMenuImg(rs.getString("menuImg"));
            menuList.setMenuName(rs.getString("menuName"));
            menuList.setMenuQuantity(rs.getInt("menuQuantity"));
            menuList.setMenuOriginalPrice(rs.getInt("menuOriginalPrice"));
            menuList.setMenuDiscountPrice(rs.getInt("menuDiscountPrice"));
            menuList.setMenuStatus(rs.getString("menuStatus"));
            menuList.setRestaurantIdx(rs.getInt("restaurantIdx"));
            menuList.setRestaurantName(rs.getString("restaurantName"));
            menuList.setDistance(rs.getDouble("distance"));
            menuList.setCloseTime(rs.getString("closeTime"));
            menuList.setRestaurantPhone(rs.getString("restaurantPhone"));
            menuList.setRestaurantStatus(rs.getString("restaurantStatus"));

            return menuList;
        };
    }

    @Override
    public List<HomeChallenge> getHomeChallengeList(int userIdx){
        List<HomeChallenge> homeChallenges = jdbcTemplate.query("SELECT challengeName, progress from UserChallenge UC LEFT JOIN Challenge C ON C.challengeIdx = UC.challengeIdx WHERE userIdx = ?;"
                , getHomeChallengeListMapper(), userIdx);

        return homeChallenges;
    }

    @Override
    public Menu getMenu(int menuIdx) {

        // 메뉴
        String getMenuQuery2 = "select M.menuIdx, M.menuImg, M.menuName, M.menuQuantity, M.menuOriginalPrice, M.menuDiscountPrice, M.status as menuStatus, R.restaurantIdx\n" +
                "from Restaurant R LEFT JOIN Menu M ON R.restaurantIdx = M.restaurantIdx\n" +
                "where M.menuIdx=?;";

        Menu menu = jdbcTemplate.queryForObject(getMenuQuery2, getMenuMapper(), menuIdx);
        return menu;
    }

    @Override
    public Restaurant getRestaurant(int menuIdx) {
        String findIdx = "SELECT restaurantIdx FROM Menu WHERE menuIdx=?;";
        // 식당
        String getUsersQuery1 = "select R.restaurantIdx, R.closeTime, R.restaurantPhone, R.restaurantName, R.status as restaurantStatus\n" +
                "from Restaurant R\n" +
                "WHERE R.restaurantIdx=?;";
        int restaurantIdx = jdbcTemplate.queryForObject(findIdx, int.class, menuIdx);
        Restaurant restaurant = jdbcTemplate.queryForObject(getUsersQuery1, getRestaurantMapper(), restaurantIdx);
        return restaurant;
    }

    private RowMapper<Menu> getMenuMapper() {
        // 식당
        String getUsersQuery1 = "select R.restaurantIdx, R.closeTime, R.restaurantPhone, R.restaurantName, R.status as restaurantStatus\n" +
                "from Restaurant R\n" +
                "WHERE R.restaurantIdx=?;";

        return (rs, rowNum) -> {
            Menu menu = new Menu();
            menu.setMenuIdx(rs.getInt("menuIdx"));
            menu.setMenuImg(rs.getString("menuImg"));
            menu.setMenuName(rs.getString("menuName"));
            menu.setMenuQuantity(rs.getInt("menuQuantity"));
            menu.setMenuOriginalPrice(rs.getInt("menuOriginalPrice"));
            menu.setMenuDiscountPrice(rs.getInt("menuDiscountPrice"));
            menu.setMenuStatus(rs.getString("menuStatus"));
            return menu;
        };
    }

    private RowMapper<Restaurant> getRestaurantMapper() {
        return (rs, rowNum) -> {
            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantIdx(rs.getInt("restaurantIdx"));
            restaurant.setRestaurantName(rs.getString("restaurantName"));
            restaurant.setCloseTime(rs.getInt("closeTime"));
            restaurant.setRestaurantPhone(rs.getString("restaurantPhone"));
            restaurant.setRestaurantStatus(rs.getString("restaurantStatus"));
            return restaurant;
        };
    }
    private RowMapper<HomeChallenge> getHomeChallengeListMapper() {
        return (rs, rowNum) -> {
            HomeChallenge homeChallenges = new HomeChallenge();
            homeChallenges.setChallengeName(rs.getString("challengeName"));
            homeChallenges.setProgress(rs.getInt("progress"));

            return homeChallenges;
        };
    }


}
