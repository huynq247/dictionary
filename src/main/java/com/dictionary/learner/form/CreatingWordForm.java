package com.dictionary.learner.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
public class CreatingWordForm {

    @NotBlank(message = "The word mustn't be null value")
    @Length(max = 50, message = "The word's length is max 50 characters")
    private String word;

    @NotBlank(message = "The wordClass mustn't be null value")
    @Length(max = 30, message = "The wordClass's length is max 30 characters")
    private String wordClass;

    @NotBlank(message = "The word mustn't be null value")
    @Length(max = 500, message = "The word's length is max 50 characters")
    private String definition;
}
