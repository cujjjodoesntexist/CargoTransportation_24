package org.example.barbershop_23;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class barbershopController {
    @Autowired
    private barbershopService service;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword){
        List<Clients> listClients = service.listAll(keyword);
        model.addAttribute("listClients", listClients);
        model.addAttribute("keyword", keyword);
        return "index";
    }

    @RequestMapping("/new")
    public String showNewClientForm(Model model) {
        Clients client = new Clients();
        model.addAttribute("client", client);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("client") Clients client) {
        service.save(client);
        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditClientForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_client");
        Clients client = service.get(id);
        mav.addObject("client", client);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClient(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

    @RequestMapping (value = "/sorted/{direction}", method = RequestMethod.GET)
    public String getClientsSorted(@PathVariable(name = "direction") String direction, Model model, @Param("keyword") String keyword) {
        Sort sort = Sort.by("date");
        if (direction.equals("desc")) {
            sort = sort.descending();
        } else {
            sort = sort.ascending();
        }
        List<Clients> listClients = service.getAllClientsSorted(sort);
        model.addAttribute("listClients", listClients);
        model.addAttribute("keyword", keyword);
        return "index";
    }
}
