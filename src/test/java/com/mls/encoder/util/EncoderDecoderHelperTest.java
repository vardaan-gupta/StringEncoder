package com.mls.encoder.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EncoderDecoderHelperTest {

	@Test
	public void test_When_thisisfirsttrial_When_Offset_1_Then_ExpectedString() {
		assertTrue("uijtjtgjstuusjbm".equalsIgnoreCase(EncoderDecoderHelper.encrypt("thisisfirsttrial", "1")));
	}

	@Test
	public void test_When_StringHasASpecialCharacter_When_Offset_1_Then_ExpectedString() {
		assertTrue(
				"uijt_jt_tfdpoe_usjbm_$".equalsIgnoreCase(EncoderDecoderHelper.encrypt("this_is_second_trial_$", "1")));
	}

	@Test
	public void test_When_StringHasASecialCharacter_When_Offset_minus1_Then_ExpectedString_passes() {
		assertTrue("zabcde$".equalsIgnoreCase(EncoderDecoderHelper.encrypt("abcdef$", "-1")));
	}

	@Test
	public void test_When_StringHasASpecialCharacter_When_Offset_minus1_Then_ExpectedString_passes() {
		assertTrue("sqhbj".equalsIgnoreCase(EncoderDecoderHelper.encrypt("trick", "-1")));
	}

}
