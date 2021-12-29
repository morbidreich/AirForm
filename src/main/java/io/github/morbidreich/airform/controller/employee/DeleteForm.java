package io.github.morbidreich.airform.controller.employee;

import io.github.morbidreich.airform.repository.BaseFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class DeleteForm {
	@Autowired
	BaseFormRepo baseFormRepo;

	/**
	 * Delete form given it's id
	 * @param id id of form to delete
	 * @return
	 */
	@GetMapping("/delete-form/{id}")
	public String deleteForm(@PathVariable long id) {
		baseFormRepo.deleteById(id);
		return "employee/home";
	}

}
