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
public class FireworksForm extends IntermediateForm {

    // call super constructor to set applicationDateTime
    public FireworksForm() { super(); }

    private Integer fireworksMaxAltitudeAGL;
    private String color;
}
