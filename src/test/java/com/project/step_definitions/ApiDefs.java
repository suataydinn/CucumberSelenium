package com.project.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.project.pages_api.ApiPage;

public class ApiDefs {


    ApiPage apiPage = new ApiPage();

    @Then("user {int} should have {int} posts")
    public void userShouldHavePosts(int userId, int countPosts) {
        apiPage.numPosts(userId, countPosts);
    }

    @Then("each blog post should have a unique ID")
    public void eachBlogPostShouldHaveAUniqueID() {
        apiPage.verifyUniquePost();
    }

    @Given("send get request and save response")
    public void sendGetRequestAndSaveResponse() {
        apiPage.getPosts();
    }
}
