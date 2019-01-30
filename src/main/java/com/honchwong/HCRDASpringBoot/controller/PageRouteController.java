package com.honchwong.HCRDASpringBoot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageRouteController {

    @Value("classpath:static/index.html")
    private Resource indexPath;

    @RequestMapping(value="/userlogmanager/fetuserlog")
    public Object fetuserlog(){
        return indexPath;
    }

    @RequestMapping(value="/userlogmanager/loglist")
    public Object loglist(){
        return indexPath;
    }

    @RequestMapping(value="/debugassistant/apimanager")
    public Object apimanager(){
        return indexPath;
    }

    @RequestMapping(value="/debugassistant/remotelog")
    public Object remotelog(){
        return indexPath;
    }

    @RequestMapping(value="/user/login")
    public Object login(){
        return indexPath;
    }

    @RequestMapping(value="/exception/500")
    public Object page500(){
        return indexPath;
    }

    @RequestMapping(value="/exception/403")
    public Object page403(){
        return indexPath;
    }

    @RequestMapping(value="/exception/404")
    public Object page404(){
        return indexPath;
    }
}
