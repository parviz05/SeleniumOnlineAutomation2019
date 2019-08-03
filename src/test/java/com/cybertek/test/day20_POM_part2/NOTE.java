package com.cybertek.test.day20_POM_part2;

public class NOTE {
    /*
    Morning Spartans!

Today is 7/28/2019

Today is POM or Page Object Model.

@FindAll - means or
@FindBys - means and


@FindAll({
        @FindBy(id = "_submit"),
        @FindBy(name = "_submit")
        })

@CacheLookUp - handy for static elements.
How it works? It stores webelemnt in cache, that means "find element once and use it as many times as you need".

org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?

Tests case:

Go to the Activities -> Calendar events
Click on the grid settings
Unselect title
Verify that title column is not visible
Then click refresh
And verify that title column is visible again
//td//label[text()='Title']/../following-sibling::td/input

<td class="title-cell">
    <label for="column-c3099">Title</label>
</td>

//td//label[text()='Title'] - will find label with a text Title
/.. - will go to the parent element, which is <td>
/following-sibling::td - brother/sister of <td> that has tag name <td> and and located after.

	<tr>
		<td>Milk</td>
		<td><input type="checkbox" name=""></td>
	</tr>
//*[text()='Milk']/following-sibling::td/input



	<tr>
		<td>
			<input type="checkbox" name="">
		</td>
		<td>Milk</td>
	</tr>
//*[text()='Milk']/preceding-sibling::td/input



<tr class="renderable">
	<td class="title-cell">
    	<label for="column-c350">Title</label>
	</td>
	<td class="sort-cell">
	    <span title="Move column"><i class="fa-arrows-v handle ui-sortable-handle"></i></span>
	</td>
	<td class="visibility-cell">
	    <input id="column-c350" type="checkbox" data-role="renderable" checked="">
	</td>
</tr>





     */
}
