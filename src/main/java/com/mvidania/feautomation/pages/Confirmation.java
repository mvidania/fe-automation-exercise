package com.mvidania.feautomation.pages;

import com.mvidania.feautomation.utils.BrowserUtils;
import com.mvidania.feautomation.utils.Selectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Confirmation {

    @Autowired
    BrowserUtils browserUtils;
    Map<String, String> mapData;

    private static final Logger LOG = LoggerFactory.getLogger(Confirmation.class);

    public Confirmation(){
        mapData= new HashMap<>();
    }

    public void logOrderDataFromConfirmationPopup(String[] fields) throws InterruptedException {
        LOG.info("****** Getting data from order confirmation");
        WebElement element = this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.CONFIRMATION_POPUP_DATA));
        this.createMapFromConfirmationData(element.getText());
        LOG.info("****** Logging requested values");
        this.logValues(fields);
        this.browserUtils.waitIfElementIsPresent(By.xpath(Selectors.OK_BUTTON)).click();
    }

    public String retrieveFieldValue(String field){
        return this.mapData.get(field);
    }

    public void logValues(String [] fields){
        for(String field : fields){
            LOG.info("****** {}: {}",field,mapData.get(field));

        }
    }

    public void createMapFromConfirmationData(String data){
        List<String> listData = Arrays.stream(data.split("\n")).map(String::trim).collect(Collectors.toList());
        for(String param : listData){
            String [] keyvalues = Arrays.stream(param.split(": ")).map(String::trim).toArray(String[]::new);
            mapData.put(keyvalues[0],keyvalues[1]);
        }
    }

}
