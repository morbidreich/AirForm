package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.enums.FormType;

@FunctionalInterface
public interface FormEditPathResolver {
	public String getPath(FormType formType);
}
