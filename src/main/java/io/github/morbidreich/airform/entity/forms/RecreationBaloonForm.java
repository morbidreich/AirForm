package io.github.morbidreich.airform.entity.forms;

import io.github.morbidreich.airform.entity.enums.RecreationBaloonType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class RecreationBaloonForm extends IntermediateForm {

    //call super constructor to set applicationDateTime
    public RecreationBaloonForm() { super(); }

    private RecreationBaloonType recreationBaloonType;
    private String color;
    private String diameter;
    private Integer baloonCount;
}
