package io.github.morbidreich.airform.entity.forms;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LasersForm extends IntermediateForm {

    //call super constructor to set applicationDateTime
    public LasersForm() { super(); }

    private Integer lightRange;
    private Integer lightAngle;
    private String numberOfSourcesAndColor;
}
