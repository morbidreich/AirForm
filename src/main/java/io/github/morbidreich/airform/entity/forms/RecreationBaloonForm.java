package io.github.morbidreich.airform.entity.forms;

import io.github.morbidreich.airform.entity.enums.FormType;
import io.github.morbidreich.airform.entity.enums.RecreationBaloonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RecreationBaloonForm extends IntermediateForm {

    //call super constructor to set applicationDateTime
    public RecreationBaloonForm() {
        super();
        super.setFormType(FormType.RECREATION_BALOONS);
    }

    @Enumerated(EnumType.STRING)
    private RecreationBaloonType recreationBaloonType;

    @NotNull
    private String color;

    @NotNull
    @Min(1)
    private Integer diameter;

    @NotNull
    @Min(1)
    private Integer baloonCount;
}
