package io.github.morbidreich.airform.repository;

import io.github.morbidreich.airform.entity.forms.RecreationBaloonForm;
import io.github.morbidreich.airform.service.RecreationBaloonService;
import org.springframework.data.repository.CrudRepository;

public interface RecreationBaloonRepo extends CrudRepository<RecreationBaloonForm, Long> {
}
