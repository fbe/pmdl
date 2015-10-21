package name.felixbecker.pmdl.testassets;

/**
 * Created by becker on 10/21/15.
 */
public class SimpleSwitchClass {

    final String testString = "test";

    public void testMethod(){

        switch(testString){
            case "test":
                System.out.println("switch test hit");
                break;

            case "test2":
                System.out.println("switch test2 hit");
                break;

            default:
                System.out.println("default case");
                break;
        }

    }
}
