package com.honchwong.HCRDASpringBoot.pageRoute;

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
}
