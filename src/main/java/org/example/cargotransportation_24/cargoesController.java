package org.example.cargotransportation_24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class cargoesController {
    @Autowired
    private cargoesService service;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping("/create_user")
    public String saveUser(@ModelAttribute("user") User user) {
        service.registerUser(user);
        return "redirect:/login";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        model.addAttribute("username", username);
        List<Cargoes> listCargoes = service.listAll(keyword);
        model.addAttribute("listCargoes", listCargoes);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @RequestMapping (value = "/sorted/{direction}", method = RequestMethod.GET)
    public String getSorted(@PathVariable(name = "direction") String direction, Model model, @Param("keyword") String keyword) {
        Sort sort = Sort.by("sendingDate");
        if (direction.equals("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        List<Cargoes> listCargoes = service.getAllCargoesSorted(sort);
        model.addAttribute("listCargoes", listCargoes);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("/new")
    public String showNewForm(Model model) {
        Cargoes cargo = new Cargoes();
        model.addAttribute("cargo", cargo);
        return "new";
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("cargo") Cargoes cargo) {
        service.save(cargo);
        return "redirect:/";
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit");
        Cargoes cargo = service.get(id);
        mav.addObject("cargo", cargo);
        return mav;
    }
    @Secured("ROLE_ADMIN")
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }
}
