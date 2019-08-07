package com.app.tests;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class HamcrestMatchersDemo {

    // Hamcrest library provides matchers(assertion)
   // Rest Assured uses hamcrest assertions (matchers)
   // works with both junit and testng

    @Test
    public void test(){

        //verify if first argument is equal to the second
        assertThat(1, equalTo(1));

        String str1="Kunkka";
        String str2="Kunkka";
        String str3=null;
        assertThat(str1, is("Kunkka"));
        assertThat(str1, is(str2));

        // verify if first argument is NOT equal to the second
        assertThat(str1, is(not("tidehunter")));

        //compare ignoring case
        assertThat(str1, equalToIgnoringCase("kunkka"));

        //compare ignoring space before and after
        assertThat(str1, equalToIgnoringWhiteSpace(" Kunkka  "));

        // compare numbers
        assertThat(10, greaterThan(9));
        assertThat(10, lessThan(11));
        assertThat(10,lessThanOrEqualTo(12));

        //CMD+D duplicate line
        //CTRL+D duplicate line

        // verify not null value
        assertThat(str1, notNullValue());

        //verify null valiue
        assertThat(str3, nullValue());

        List<String> list= Arrays.asList("one", "two", "three");

        assertThat(list, hasSize(3));

        assertThat(list, containsInAnyOrder("two","one","three"));

        assertThat(list, hasItems("one","three"));


        List<Integer> numbers=Arrays.asList(11,12,13);

        assertThat(numbers, everyItem(greaterThan(10)));












    }
}
