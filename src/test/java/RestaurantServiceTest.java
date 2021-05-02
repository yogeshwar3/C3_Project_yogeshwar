import org.junit.jupiter.api.*;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


class RestaurantServiceTest {

    RestaurantService service = new RestaurantService();
    Restaurant restaurant;
    //REFACTOR ALL THE REPEATED LINES OF CODE
    LocalTime openingTime;
    LocalTime closingTime;

    @BeforeEach
    public void beforeEachTestCaseExecution(){
        openingTime = LocalTime.parse("10:30:00");
        closingTime = LocalTime.parse("22:00:00");
        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
        restaurant.addToMenu("Sweet corn soup",119);
        restaurant.addToMenu("Vegetable lasagne", 269);
        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
        service.addRestaurant("Saravana Bhavan","Chennai",LocalTime.parse("08:00:00"),LocalTime.parse("21:00:00"));

    }

    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() throws restaurantNotFoundException {
        //WRITE UNIT TEST CASE HERE
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);
//        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
//        service.addRestaurant("Saravana Bhavan","Chennai",LocalTime.parse("08:00:00"),LocalTime.parse("21:00:00"));

        Restaurant foundRestaurant = service.findRestaurantByName("Saravana Bhavan");
        assertEquals(foundRestaurant.getName(),"Saravana Bhavan");

    }

    //You may watch the video by Muthukumaran on how to write exceptions in Course 3: Testing and Version control: Optional content
    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() {
        //WRITE UNIT TEST CASE HERE
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);
//        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
//        service.addRestaurant("Saravana Bhavan","Chennai",LocalTime.parse("08:00:00"),LocalTime.parse("21:00:00"));

        String restaurantToSearch = "Muniyandi Vilas";
        assertThrows(restaurantNotFoundException.class,()->service.findRestaurantByName(restaurantToSearch));

    }
    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>




    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1() throws restaurantNotFoundException {
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.removeRestaurant("Amelie's cafe");
        assertEquals(initialNumberOfRestaurants-1, service.getRestaurants().size());
    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception(){
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(restaurantNotFoundException.class,()->service.removeRestaurant("Pantry d'or"));
    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){
//        LocalTime openingTime = LocalTime.parse("10:30:00");
//        LocalTime closingTime = LocalTime.parse("22:00:00");
//        restaurant = service.addRestaurant("Amelie's cafe","Chennai",openingTime,closingTime);
//        restaurant.addToMenu("Sweet corn soup",119);
//        restaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();
        service.addRestaurant("Pumpkin Tales","Chennai",LocalTime.parse("12:00:00"),LocalTime.parse("23:00:00"));
        assertEquals(initialNumberOfRestaurants + 1,service.getRestaurants().size());
    }
    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>
}