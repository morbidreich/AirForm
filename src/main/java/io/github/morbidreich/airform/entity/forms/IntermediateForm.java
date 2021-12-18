package io.github.morbidreich.airform.entity.forms;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.*;
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

    @NotNull
    @Min(value = 49, message = "To nie w Polsce!")
    @Max(value = 55, message = "To nie w Polsce!")
    private int latitudeDegrees;

    @NotNull
    @Min(0)
    @Max(59)
    private int latitudeMinutes;

    @NotNull
    @Min(0)
    @Max(59)
    private int latitudeSeconds;

    @NotNull
    @Min(value = 13, message = "To nie w Polsce!")
    @Max(value = 25, message = "To nie w Polsce!")// range of polish longitudes
    private int longitudeDegrees;

    @NotNull
    @Min(0)
    @Max(59)
    private int longitudeMinutes;

    @NotNull
    @Min(0)
    @Max(59)
    private int longitudeSeconds;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    @Future
    private LocalDateTime startDateTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @NotNull
    @Future
    private LocalDateTime endDateTime;

    @NotEmpty
    private String ventureName;

    @NotEmpty
    private String ventureOrganiserName;

    @NotEmpty
    private String ventureOrganiserPhone;


    public IntermediateForm() {
        // call super constructor to set applicationDateTime
        super();
    }

}
