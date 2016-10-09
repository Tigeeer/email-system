package com.tigeeer.controller;

import com.tigeeer.pojo.Receive;
import com.tigeeer.util.Mail;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;
import javax.xml.validation.ValidatorHandler;

/**
 * Created by tigeeer on 2016/10/9.
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(method = RequestMethod.POST)
    public void index(@Valid Receive receive, BindingResult result) {
        if(result.hasErrors()) {

        } else {
            try {
                Mail.send(receive);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}
