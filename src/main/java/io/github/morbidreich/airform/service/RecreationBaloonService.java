package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.forms.RecreationBaloonForm;
import io.github.morbidreich.airform.repository.RecreationBaloonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecreationBaloonService {

    @Autowired
    RecreationBaloonRepo baloonRepo;

    public void saveNew(RecreationBaloonForm form) {
        form.setFormStatus(FormStatus.FILED);
        baloonRepo.save(form);
    }
}
