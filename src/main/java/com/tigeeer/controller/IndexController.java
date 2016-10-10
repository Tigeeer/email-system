package com.tigeeer.controller;

import com.tigeeer.pojo.Config;
import com.tigeeer.pojo.Receive;
import com.tigeeer.pojo.ResponseBody;
import com.tigeeer.util.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;

/**
 * Created by tigeeer on 2016/10/9.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    private Config config;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseBody index(@Valid Receive receive, BindingResult result,ResponseBody responseBody) {
        if(result.hasErrors()) {
            responseBody.setCode(10001);
            responseBody.setBody("Params is error.");
        } else {
            try {
                Mail.send(receive);
                responseBody.setCode(0);
                responseBody.setBody("Success!");
            } catch (MessagingException e) {
                e.printStackTrace();
                responseBody.setCode(10002);
                responseBody.setBody("MessagingException :\n" + e.toString());
            }
        }
        return responseBody;
    }
}
