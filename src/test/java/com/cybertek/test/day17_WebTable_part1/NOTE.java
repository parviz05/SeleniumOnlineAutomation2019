package com.cybertek.test.day17_WebTable_part1;

public class NOTE {
    /*
    Today is 7/23/2019

Topic: Web tables.


	Agenda:
		What is web table?
		What kind of tags used for web tables.
		Locators for tables
		How to print entire table, specific row, column.


while(true){
	turnOffCamera();
	try{
		Thread.sleep(3000)
	}catch(Exception e){

	}
	turnOnCamera();
}


In the HTML, people use <table> tag to create a web table.
Table can have 3 components:
	<thead> - for header, column names
	<tbody> - for main content
	<tfoot> - for footer, for example total price


then we have <tr> - for table row
and <td> - for table data.
	<th> - for header cells.


	<table>
		<thead>
			<tr>
				<th>Monday</th>
				<th>Tuesday</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>8 am - Doctors appointment</td>
				<td></td>
			</tr>
		</tbody>
	</table>


driver.findElement(By.id("table1")).findElement(By.tagName("thead"));

chaining of findElement method. Basically, once we found some webelment, we can find out of that element some other element.


" " (space) in css means any child. In xpath we use '//'.
"> means direct child. In xpath we use '/'.
. means class for css

#table2 tr - means find any <tr> (row), that is a child of element with id table2.


// - for relative
/ - for absolute

It's a absolute xpath if we start from root element:
<html>

Other than that - all relative xpath.

//table[@id='table1']//th




//table[1]/thead/tr/th[2] - in this case / means direct child. // - means any child/grand child.



//table[1]//tr//td[3] - means find all elements from 3rd column, regardless of row number. Without specifying index [index] it will pick all elements.

indexes in xpath starts from 1.



//table[1]//tr//td[3]

tr - row, is horizontal.
td - cell, is inside a row.







     */
}
