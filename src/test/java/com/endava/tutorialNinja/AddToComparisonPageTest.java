package com.endava.tutorialNinja;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

import com.endava.tutorialNinja.pageObject.ProductCameraPage;
import com.endava.tutorialNinja.pageObject.ProductComparePage;
import com.endava.tutorialNinja.pageObject.ProductLaptopsPage;

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

	@Test
	public void shoulNotdAddMoreThenFourProductsToComparison(){

		//GIVEN
		ProductLaptopsPage productLaptopsPage = new ProductLaptopsPage( driver );
		ProductComparePage productComparePage = new ProductComparePage( driver );
		productLaptopsPage.load();


		//WHEN
		List<String> toBeAddedProducts = new ArrayList<>(  );
		toBeAddedProducts.add("HP LP3065"  );
		toBeAddedProducts.add( "MacBook" );
		toBeAddedProducts.add( "MacBook Air" );
		toBeAddedProducts.add( "MacBook Pro" );
		toBeAddedProducts.add( "Sony VAIO" );

		try {
			Thread.sleep( 3000 );
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}

		productLaptopsPage.addToCompare(toBeAddedProducts.toString());
		productLaptopsPage.accessProductComparePage();

		//THEN
		assertThat (productComparePage.getNumberOfProductsInComparison()).isLessThan( toBeAddedProducts.size() );
	}
}
