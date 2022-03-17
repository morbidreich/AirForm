package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.enums.FormType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormDisplayPathResolverServiceTest {
	public static final FormType PROBING_FORM = FormType.PROBING;
	public static final FormType RECREATIONAL_FORM = FormType.RECREATION_BALOONS;
	public static final FormType EXERCISE_COMPETITION_FORM = FormType.EXERCISE_COMPETITION;
	public FormDisplayPathResolver formDisplayPathResolver;

	@BeforeEach
	public void setup() {
		formDisplayPathResolver = new FormDisplayPathResolverService();
	}

	@Test
	public void getViewPathForStratosphericProbingFormTest() {
		//given
		String expectedPath = "asm-forms/stratospheric-baloon-form";

		//when
		String actualPath = formDisplayPathResolver.getPath(PROBING_FORM);

		//then
		assertEquals(expectedPath, actualPath);
	}

	@Test
	public void getViewPathForRecreationalBaloonFormTest() {
		//given
		String expectedPath = "asm-forms/recreation-baloon-form";

		//when
		String actualPath = formDisplayPathResolver.getPath(RECREATIONAL_FORM);

		//then
		assertEquals(expectedPath, actualPath);
	}

	@Test
	public void getViewPathForExerciseCompetitionFormTest() {
		//given
		String expectedPath = "asm-forms/exercise-competition-form";

		//when
		String actualPath = formDisplayPathResolver.getPath(EXERCISE_COMPETITION_FORM);

		//then
		assertEquals(expectedPath, actualPath);
	}
}