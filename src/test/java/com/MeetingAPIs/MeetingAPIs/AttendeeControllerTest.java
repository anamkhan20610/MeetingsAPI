package com.MeetingAPIs.MeetingAPIs;

import com.MeetingAPIs.MeetingAPIs.Models.ConferenceAttendee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

public class AttendeeControllerTest extends MeetingApIsApplicationTests {
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext webApplicationContext;
    @Before
    public void init(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void registerToConferenceTest() throws Exception {
        String json = "{\"attendee\":\"John\",\"company\":\"demo\",\"conferenceTitle\":\"Learn Maven\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/register/conference")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void registerPresenterTest() throws Exception{
        String json = "{\"talkPresenter\":\"Doe\",\"talkTitle\":\"java\",\"talkDate\":\"2020-02-02\",\"location\":{\"h-number\":\"23\",\"street\":\"old ab road\",\"city\":\"NewYork\"}}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/register/presenter")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void registerSpecificTalkTest() throws Exception{
        String json = "{\"attendeeName\":\"John\",\"talk\":\"Python\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/register/specificTalk")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getAttendeeByTalkTest() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/attendee/Python")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getScheduleTest() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/schedule/John")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assertions.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}

