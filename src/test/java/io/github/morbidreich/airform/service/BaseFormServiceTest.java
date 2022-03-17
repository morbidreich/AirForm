package io.github.morbidreich.airform.service;

import io.github.morbidreich.airform.entity.User;
import io.github.morbidreich.airform.entity.UserDetails;
import io.github.morbidreich.airform.entity.enums.FormStatus;
import io.github.morbidreich.airform.entity.forms.BaseForm;
import io.github.morbidreich.airform.repository.BaseFormRepo;
import io.github.morbidreich.airform.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BaseFormServiceTest {

	public static final long DUMMY_FORM_ID = 234121L;
	public static final String DUMMY_USERNAME = "dummy";
	public static final String DUMMY_NAME = "Bartek";
	public static final String DUMMY_SURNAME = "Kujda";
	public static final String DUMMY_PHONE = "1234";
	public static final String DUMMY_ADDRESS = "Warszawa";
	public static final String DUMMY_EMAIL = "email@x.com";

	@Mock BaseFormRepo baseFormRepo;
	@Mock	UserRepo userRepo;

	@InjectMocks
	BaseFormService baseFormService;

	@Captor
	ArgumentCaptor<String> stringArgumentCaptor;

	@Test
	public void setFormStatus_formFound_statusSetToFiledTest() {
		//given
		Optional<BaseForm> baseFormOptional = Optional.of(new BaseForm());
		given(baseFormRepo.findById(DUMMY_FORM_ID)).willReturn(baseFormOptional);

		//when
		boolean isFormStatusSet = baseFormService.setFormStatus(DUMMY_FORM_ID, FormStatus.FILED);

		//then
		assertTrue(isFormStatusSet);
		verify(baseFormRepo).findById(DUMMY_FORM_ID);
		assertEquals(FormStatus.FILED, baseFormOptional.get().getFormStatus());
	}

	@Test
	public void setFormStatus_formNotFound_shouldReturnFalseTest(){
		boolean result = baseFormService.setFormStatus(DUMMY_FORM_ID, FormStatus.FILED);
		verify(baseFormRepo).findById(DUMMY_FORM_ID);
		assertFalse(result);
	}

	@Test
	public void findById_shouldReturnOkTest() {
		BaseForm baseForm = new BaseForm();
		Optional<BaseForm> expectedOptional = Optional.of(baseForm);

		when(baseFormRepo.findById(anyLong())).thenReturn(Optional.of(baseForm));
		assertEquals(expectedOptional, baseFormService.findById(DUMMY_FORM_ID));
	}

	@Test
	public void findById_shouldReturnEmptyOptionalTest() {
		Optional<BaseForm> expectedOptional = Optional.empty();

		when(baseFormRepo.findById(anyLong())).thenReturn(Optional.empty());
		assertEquals(expectedOptional, baseFormService.findById(DUMMY_FORM_ID));
	}

	@Test
	public void prepopulateForm_userNotFound_ShouldReturnUnchangedFormTest() {
		//given
		BaseForm baseForm = new BaseForm();
		given(userRepo.findByUsername(DUMMY_USERNAME)).willReturn(Optional.empty());

		//when
		BaseForm actual = baseFormService.prepopulateForm(baseForm, DUMMY_USERNAME);

		//then
		verify(userRepo).findByUsername(DUMMY_USERNAME);
		verify(userRepo).findByUsername(stringArgumentCaptor.capture());
		assertEquals(baseForm, actual);
		assertEquals(DUMMY_USERNAME, stringArgumentCaptor.getValue());
	}

	@Test
	public void deleteByIdAndUsername_shouldDeleteTest() {
		//given
		BaseForm baseForm = new BaseForm();
		baseForm.setFormStatus(FormStatus.FILED);
		given(baseFormRepo.findByIdAndApplicantUsername(1L, DUMMY_USERNAME)).willReturn(Optional.of(baseForm));

		//when
		boolean isDeleted = baseFormService.deleteByIdAndUsername(1L, DUMMY_USERNAME);

		//then
		verify(baseFormRepo).delete(baseForm);
		assertTrue(isDeleted);
	}

	@Test
	public void deleteByIdAndUsername_shouldNotDeleteBecauseFormStatusOtherThanFiledTest() {
		//given
		BaseForm baseForm = new BaseForm();
		baseForm.setFormStatus(FormStatus.PROCESSING);
		given(baseFormRepo.findByIdAndApplicantUsername(1L, DUMMY_USERNAME)).willReturn(Optional.of(baseForm));

		//when
		boolean isDeleted = baseFormService.deleteByIdAndUsername(1L, DUMMY_USERNAME);

		//then
		verify(baseFormRepo, never()).delete(baseForm);
		assertFalse(isDeleted);
	}

	@Test
	public void deleteByIdAndUsername_shouldNotDeleteNoFormForUsernameFoundTest() {
		given(baseFormRepo.findByIdAndApplicantUsername(1L, DUMMY_USERNAME)).willReturn(Optional.empty());

		//when
		boolean isDeleted = baseFormService.deleteByIdAndUsername(1L, DUMMY_USERNAME);

		//then
		verify(baseFormRepo, never()).delete(new BaseForm());
		assertFalse(isDeleted);
	}

	@Test
	public void prepopulateForm_userFoundWithDetails_shouldReturnPrepopulatedFormTest() {
		//given
		BaseForm baseForm = new BaseForm();
		User userMock = mock(User.class);
		UserDetails userDetails = new UserDetails(DUMMY_NAME, DUMMY_SURNAME, DUMMY_ADDRESS, DUMMY_PHONE);
		given(userMock.getUsername()).willReturn(DUMMY_USERNAME);
		given(userMock.getEmail()).willReturn(DUMMY_EMAIL);
		given(userMock.getUserDetails()).willReturn(userDetails);
		given(userRepo.findByUsername(DUMMY_USERNAME)).willReturn(Optional.of(userMock));

		//when
		BaseForm actualForm = baseFormService.prepopulateForm(baseForm, DUMMY_USERNAME);

		//then
		assertEquals(DUMMY_USERNAME, actualForm.getApplicantUsername());
		assertEquals(DUMMY_NAME + " " + DUMMY_SURNAME, actualForm.getName());
		assertEquals(DUMMY_PHONE, actualForm.getPhone());
		assertEquals(DUMMY_EMAIL, actualForm.getEmail());
	}

	@Test
	public void prepopulateForm_userFoundWithoutDetails_shouldReturnPrepopulatedFormTest() {
		//given
		BaseForm baseForm = new BaseForm();
		User userMock = mock(User.class);

		given(userMock.getUsername()).willReturn(DUMMY_USERNAME);
		given(userMock.getUserDetails()).willReturn(null);
		given(userRepo.findByUsername(DUMMY_USERNAME)).willReturn(Optional.of(userMock));

		//when
		BaseForm actualForm = baseFormService.prepopulateForm(baseForm, DUMMY_USERNAME);

		//then
		assertEquals(DUMMY_USERNAME, actualForm.getApplicantUsername());
		assertNull(actualForm.getName());
		assertNull(actualForm.getPhone());
		assertNull(actualForm.getEmail());
	}



}