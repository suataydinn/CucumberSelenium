package com.project.pages_api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.project.utilities.ConfigurationReader;
import com.project.utilities.Driver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;


public class ApiPage{


    WebDriver driver = Driver.get();
    public ApiPage() {
        PageFactory.initElements(driver, this);
    }

    private List<Users> posts;
    JsonPath jsonPath;

        public void getPosts() {
            // Get api url
            RestAssured.baseURI= ConfigurationReader.get("api_url");

            Response response=RestAssured.given()
                    .when().get("/posts") ;
            Assert.assertEquals(200, response.statusCode());

            jsonPath = response.jsonPath();

             //Deserialize the JSON response into a List of Post objects
            posts = jsonPath.getList("", Users.class);

        }

        public long getCountPosts(int userId) {

            long count = posts.stream().filter(post -> post.getUserId() == userId).count();
            return count;
        }

        public void numPosts(int userId, int numPosts){
            // Count the posts for the given userId
            long count = getCountPosts(userId);

            assertEquals(numPosts, count);
        }

    public void verifyUniquePost() {
            //Get all id
        List<Integer> postIds = jsonPath.getList("id");

        // HashSet is unique
        Set<Integer> uniquePostIds = new HashSet<>(postIds);

        // If the number of unique IDs is equal to the number of posts, the test is successful.
        assertEquals("There are duplicate IDs in the blog posts", postIds.size(), uniquePostIds.size());
    }



}
