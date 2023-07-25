package com.solvd.carina.demo;

import com.solvd.carina.demo.api.GetFeaturedTopics;
import com.solvd.carina.demo.api.GetInvalidCredentialsMethod;
import com.solvd.carina.demo.api.GetPhotosMethod;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SearchAPITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test
    public void testSearchPhotosMethod() {
        LOGGER.info("Running test: testSearchPhotosMethod");
        GetPhotosMethod search = new GetPhotosMethod("eagle", 20);
        Response response = search.callAPIExpectSuccess();
        search.validateResponseAgainstSchema("api/users/_get/schemaa");
        LOGGER.info("Test complete: testSearchPhotosMethod");
    }

    @Test
    public void testGetFeaturedTopics() {
        LOGGER.info("Running test: testGetFeaturedTopics");
        Set<String> titles = new HashSet<>();
        for (int pageNum = 1; pageNum <= 3; pageNum++) {
            GetFeaturedTopics getFeaturedTopics = new GetFeaturedTopics(pageNum);
            Response response = getFeaturedTopics.callAPIExpectSuccess();

            List<String> pageTitles = response.jsonPath().getList("title");
            for (String title : pageTitles) {
                Assert.assertFalse(titles.contains(title), "Found duplicate title" + title);
                titles.add(title);
            }
        }
        LOGGER.info("Test complete: testGetFeaturedTopics");
    }

    @Test
    public void testInvalidCredentialsMethod() {
        LOGGER.info("Running test: testInvalidCredentialsMethod");
        GetInvalidCredentialsMethod getInvalidCredentialsMethod = new GetInvalidCredentialsMethod(2);
        Response response = getInvalidCredentialsMethod.callAPIExpectSuccess();
        LOGGER.info("Test complete: testInvalidCredentialsMethod");
    }
}