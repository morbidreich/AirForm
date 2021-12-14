package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.forms.RecreationBaloonForm;
import io.github.morbidreich.airform.repository.RecreationBaloonRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class RecreationBaloonService {

    @Autowired
    RecreationBaloonRepo baloonRepo;

    public void save(RecreationBaloonForm form) {
        baloonRepo.save(form);
    }
}
