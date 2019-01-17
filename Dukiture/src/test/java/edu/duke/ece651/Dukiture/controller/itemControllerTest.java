//package edu.duke.ece651.Dukiture.controller;
//
//import edu.duke.ece651.Dukiture.service.ItemServiceImpl;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(ItemController.class)
//public class itemControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private ItemServiceImpl itemService;
//
//    @InjectMocks
//    private ItemController itemController;
//
//    @Before
//    public void setup(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testGetAllItems() throws Exception {
//        mockMvc
//                .perform(get("/items"))
//                .andExpect(status().isOk()).andReturn();
//    }
//}
