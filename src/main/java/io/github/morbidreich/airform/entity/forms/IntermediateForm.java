package io.github.morbidreich.airform.entity.forms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

/**
 * common base form for 4 activities with very similar forms:
 * - lanterns
 * - lasers
 * - helium baloons
 * - fireworks
 */
public class IntermediateForm extends BaseForm{

    private int latitudeDegrees;
    private int latitudeMinutes;
    private int latitudeSeconds;
    private int longitudeDegrees;
    private int longitudeMinutes;
    private int longitudeSeconds;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime startDateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime endDateTime;
    private String ventureName;
    private String ventureOrganiserName;
    private String ventureOrganiserPhone;


    public IntermediateForm() {
        // call super constructor to set applicationDateTime
        super();
    }

}
