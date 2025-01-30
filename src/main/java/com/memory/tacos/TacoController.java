package com.memory.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TacoController {
    @GetMapping("/tacos/{id}")
    public String viewTaco(@PathVariable String id,
                           @SessionAttribute("tacoOrder") TacoOrder tacoOrder,
                           Model model) {
        Taco taco = tacoOrder.getTacos().stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (taco == null) {
            return "redirect:/orders/current";
        }

        model.addAttribute("taco", taco);
        return "taco";
    }
}
