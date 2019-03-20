package com.sumset.controllerTest;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import com.sumset.controller.InventoryController;
import com.sumset.model.Product;
import com.sumset.repository.InMemoryProductDao;
import com.sumset.service.ProductManagerImplement;




public class InventoryControllerTests {

    @Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        ProductManagerImplement pmi = new ProductManagerImplement();
        pmi.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
        controller.setProductManager(pmi);
        //controller.setProductManager(new ProductManagerImplement());
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
        Map modelMap = (Map) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);
    }
}