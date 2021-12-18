package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.RecreationBaloonForm;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.RecreationBaloonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/applicant")
public class RecreationBaloonFormController {

    private final BaseFormService baseFormService;
    private final RecreationBaloonService recreationBaloonService;

    public RecreationBaloonFormController(BaseFormService baseFormService,
                                          RecreationBaloonService recreationBaloonService) {
        this.baseFormService = baseFormService;
        this.recreationBaloonService = recreationBaloonService;
    }

    @GetMapping("/recreation-baloon-form")
    public String recreationBaloonForm(Model model, Principal principal) {
        RecreationBaloonForm form = new RecreationBaloonForm();
        form = (RecreationBaloonForm) baseFormService.prepopulateForm(form, principal.getName());
        model.addAttribute("form", form);

        return "asm-forms/recreation-baloon-form";
    }

    @PostMapping("/baloon-form-save")
    public String saveBaloonForm(@Valid @ModelAttribute("form") RecreationBaloonForm form,
                                 BindingResult bindingResult,
                                 Principal principal) {

        if (bindingResult.hasErrors()) {
            return "asm-forms/recreation-baloon-form";
        }
        else {
            form.setApplicantUsername(principal.getName());
            recreationBaloonService.saveNew(form);
            return "redirect:/applicant";
        }
    }
}
