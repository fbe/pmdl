package name.felixbecker.jbcp.testassets;

import java.util.Random;

@TestAnnotation
public abstract class TestClass implements TestInterface, SecondTestInterface {

    static {
        System.out.println("Static Initializer here");
    }

    public double testDouble = 42d;
    public float testFloat = 5f;
    public int testInt = 23;
    public short testShort = 7;
    public boolean testBoolean = false;
    public byte testByte = 0x09;

    private final SecondTestInterface secondTestInterface;

    public TestClass(SecondTestInterface secondTestInterface){
        this.secondTestInterface = secondTestInterface;
    }

    @Override
    public void foo() {
        System.out.println("Bar");
        secondTestInterface.secondTestIfMethod();
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "testDouble=" + testDouble +
                ", testFloat=" + testFloat +
                ", testInt=" + testInt +
                ", testShort=" + testShort +
                ", testBoolean=" + testBoolean +
                ", testByte=" + testByte +
                '}';
    }

    @Override
    public void secondTestIfMethod() {
        if(new Random().nextInt() % 2 == 0) {
            System.out.println("Simply do nothing");
        } else {
            System.out.println("Do even more nothing!");
        }
    }
}
