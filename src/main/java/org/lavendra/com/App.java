package org.lavendra.com;

import org.lavendra.com.maps.MapProblems;
import org.lavendra.com.oops.Creta;
import org.lavendra.com.oops.ICar;
import org.lavendra.com.strings.StringProblems;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        StringProblems problems = new StringProblems();
//        System.out.println(problems.fabonaciSeries(6));
//        problems.extractNumSpecialChar("Aman1234Maithani@125ABCD!*/A");
//
//        MapProblems mapProblems = new MapProblems();
//        System.out.println(mapProblems.findOccurance("Lavendra"));
        ICar car = new Creta();
        car.defaultMethod();
        ICar.staticMethod();
        car.carName("Hyndai Creta");
    }
    //InputString = "Aman1234Maithani@125ABCD!*/A"
    //OUTPUT = 1234125
    //@!*/
    //AmanMaithaniABCDA"
    //"Mahendra Singh Dhoni"
    //MS Dhoni
    //array[0].char(0)+"."+array[1].char(1)+" "+array[2]
    //
}
