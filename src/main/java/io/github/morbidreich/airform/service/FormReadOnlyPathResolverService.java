package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.enums.FormType;
import org.springframework.stereotype.Service;

@Service
public class FormReadOnlyPathResolverService implements FormReadOnlyPathResolver {
	@Override
	public String getPath(FormType formType) {
		switch (formType) {
			case PROBING -> {
				return "asm-forms/stratospheric-baloon-form-readonly";
			}
			case RECREATION_BALOONS -> {
				return "asm-forms/recreation-baloon-form-readonly";
			}
//				case EXERCISE_COMPETITION -> {}
//				case FIREWORKS -> {}
//				case LASERS_LIGHTS -> {}
			default -> {
				return "";
			}
		}
	}
}
