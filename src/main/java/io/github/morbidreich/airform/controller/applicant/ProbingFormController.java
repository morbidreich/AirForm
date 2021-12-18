package io.github.morbidreich.airform.controller.applicant;

import io.github.morbidreich.airform.entity.forms.ProbingForm;
import io.github.morbidreich.airform.service.BaseFormService;
import io.github.morbidreich.airform.service.ProbingFormService;
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
public class ProbingFormController {

    private final BaseFormService baseFormService;
    private final ProbingFormService probingFormService;

    public ProbingFormController(BaseFormService baseFormService,
                                 ProbingFormService probingFormService) {
        this.baseFormService = baseFormService;
        this.probingFormService = probingFormService;
    }

    @GetMapping("/probing-form")
    public String getProbingForm(Model model, Principal principal) {
        ProbingForm probingForm = new ProbingForm();
        probingForm = (ProbingForm) baseFormService.prepopulateForm(probingForm, principal.getName());
        model.addAttribute("form", probingForm);

        return "asm-forms/stratospheric-baloon-form";
    }

    @PostMapping("/probing-form-save")
    public String saveProbingForm(@Valid @ModelAttribute("form") ProbingForm form,
                                  BindingResult bindingResult,
                                  Principal principal) {

        if (bindingResult.hasErrors()) {
            return "asm-forms/stratospheric-baloon-form";
        }
        else {
            form.setApplicantUsername(principal.getName());
            probingFormService.saveNew(form);
            return "redirect:/applicant";
        }
    }
}
