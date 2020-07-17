package com.endava.tutorialNinja;

import org.junit.jupiter.api.Test;

import com.endava.tutorialNinja.pageObject.ProductCameraPage;

public class AddToComparisonPageTest extends TestBaseClass {


	@Test
	public void shouldAddProductToComparison(){

		//GIVEN
		ProductCameraPage productCameraPage = new ProductCameraPage( driver );
		productCameraPage.load();

		//WHEN
		productCameraPage.addToCompare(  "Nikon D300" ,"Canon EOS 5D");
		productCameraPage.accessProductComparePage();

		//THEN


	}
}
