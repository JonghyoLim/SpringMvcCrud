/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.validation.Valid;
import javax.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author hyoku
 */
@RestController
@RequestMapping("/agent")
public class agentController {
    
    @Autowired
    AgentService service;
    
    @RequestMapping("/displayAll")
    public ModelAndView diplayAllAgents() {
        return new ModelAndView("/allAgents", "agentList", service.getAllAgents());
    }
    
     @GetMapping("/add")
    public ModelAndView displayAgentAddForm() {
        return new ModelAndView("/addAgent", "agent", new Agents());
    }

    @PostMapping("/addAgent")
    public ModelAndView addAnAgent(@Valid @ModelAttribute("agent") Agents agent, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return new ModelAndView("/addAgent");
        }
        service.addAnAgent(agent);
        return new ModelAndView("redirect:/agent/displayAll");
    }
 
    @RequestMapping("/edit")
    public ModelAndView editAgentForm(@QueryParam("id") int id) {
        return new ModelAndView("/editAgent", "agent", service.getAgentById(id));
    }
    
    @PostMapping("/editAgent")
    public ModelAndView editAgent(@Valid @ModelAttribute("agent") Agents agent, BindingResult result, ModelMap model) {
        System.out.println("agent:  " + agent);
        if (result.hasErrors()) {
            return new ModelAndView("/editAgent");
        }
        service.editAgent(agent);
        return new ModelAndView("redirect:/agent/displayAll");
    }

    @GetMapping("/delete")
    public ModelAndView deleteAnAgent(@QueryParam("id") int id) {
        service.deleteAnAgent(id);
        return new ModelAndView("redirect:/agent/displayAll");
    }
    
}
