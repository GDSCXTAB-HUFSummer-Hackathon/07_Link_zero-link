package hello.hellospring.repository;

import hello.hellospring.domain.DiaryList;
import hello.hellospring.domain.MenuList;
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
        List<MenuList> menuLists = jdbcTemplate.query("select M.menuIdx, M.menuImg, M.menuName, M.menuQuantity, M.menuOriginalPrice, M.menuDiscountPrice, M.status as menuStatus,\n" +
                "       R.restaurantIdx, R.closeTime, R.restaurantPhone, R.restaurantName, R.status as restaurantStatus,\n" +
                "       concat(round(6371*acos(cos(radians(?))\n" +
                "                                  *cos(radians(R.lattitude))*cos(radians(R.longitude)\n" +
                "               -radians(?))+sin(radians(?))*sin(radians(R.lattitude))), 1), 'km') AS distance\n" +
                "from Restaurant R LEFT JOIN Menu M ON R.restaurantIdx = M.restaurantIdx\n" +
                "WHERE R.restaurantIdx=?\n" +
                "HAVING distance <= 10;", getHomeListMapper());

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


}
