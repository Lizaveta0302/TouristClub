package com.lizoon.touristclub.mvc;

import com.lizoon.touristclub.entity.Hike;
import com.lizoon.touristclub.repositories.HikeRepository;
import com.lizoon.touristclub.service.SectionService;
import com.lizoon.touristclub.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class HelloController {

    @Autowired
    private HikeRepository hikeRepository;

    private SectionService sectionService;

    @Autowired
    public HelloController(SectionService sectionService) {
        this.sectionService = sectionService;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    String addNewHike(@RequestParam String name) {
        Hike n = new Hike();
        n.setHike_name(name);
        hikeRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<Hike> getAllHikes() {
        // This returns a JSON or XML with the users
        return hikeRepository.findAll();
    }

    @RequestMapping(value = "/info")
    public String infoPage() {
        return "info";
    }


    @RequestMapping(value = "/signIn")
    public String signIn() {
        return "signIn";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);

        model.addAttribute("section", sectionService.findAll());
        model.addAttribute("userInfo", userInfo);

        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "loginPage";
    }

   /*
   @RequestMapping(value = "/another", method = RequestMethod.GET)
    public  String anotherStyle(){
        return "another";
    }
    */

    /*
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public  String cart(){
        return "cart";
    }
    */

    /*
    @RequestMapping(value = "/category", method = RequestMethod.GET)
     public  String category(){
         return "category";
     }
     */
    /*
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public  String product(){
        return "product";
    }
    */
    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // After user login successfully.
        String userName = principal.getName();

        System.out.println("Имя пользователя: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Извините  " + principal.getName() //
                    + "<br> у вас нет доступа к данной странице!";
            model.addAttribute("message", message);
        }
        return "403Page";
    }


}
