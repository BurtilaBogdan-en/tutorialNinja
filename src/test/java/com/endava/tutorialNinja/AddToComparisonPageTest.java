package com.endava.tutorialNinja;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import com.endava.tutorialNinja.pageObject.ProductCameraPage;
import com.endava.tutorialNinja.pageObject.ProductComparePage;

public class AddToComparisonPageTest extends TestBaseClass {


	@Test
	public void shouldAddProductToComparison(){

		//GIVEN
		ProductCameraPage productCameraPage = new ProductCameraPage( driver );
		ProductComparePage productComparePage = new ProductComparePage( driver );
		productCameraPage.load();

		//WHEN
		Set<String> toBeAddedProducts = new TreeSet<>(  );
		toBeAddedProducts.add("Nikon D300"  );
		toBeAddedProducts.add( "Canon EOS 5D" );

		productCameraPage.addToCompare(toBeAddedProducts.toString());
		productCameraPage.accessProductComparePage();

		//THEN
		assertThat(toBeAddedProducts.equals( productComparePage.getProductNameInComparison() ));

	}
}
