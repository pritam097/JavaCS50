import java.util.*;

interface Converter {
   Object convert(Object obj);
}


abstract class TemperatureConverter implements Converter {
    protected abstract boolean isHot(double d);   
}

abstract class SpeedConverter implements Converter {
    protected abstract boolean isFast(double a);
}

class Tharmometer extends TemperatureConverter{
    protected boolean isHot(double d) {
        return d > 27;
    }
        
    @Override
    public Object convert(Object obj) {
        double celsius = (double) obj;
        double fahrenheit;
        fahrenheit = (9.0 / 5.0) * celsius + 32;
        // System.out.println("Temperature in Fahrenheit is : " + fahrenheit);
        return fahrenheit;
    }
}

class Tharmocouple extends TemperatureConverter{
    public boolean isHot(final double d) {
        return d > 27;
    }

    @Override
    public Object convert(Object obj) {
        double celsius = (double) obj;
        double Kelvin;
        Kelvin = celsius + 273.15;
        // System.out.println("Temperature in Kelvin ( K ) = " + Kelvin);
        return Kelvin;
    }
}

class PilotTube extends SpeedConverter {
    protected boolean isFast(double a){
        return a > 50;
    }
    @Override
    public Object convert(Object obj){
        double kms = (double) obj;
        return (0.6213711 * kms);
    }
}

class ShaftLog extends SpeedConverter {
    protected boolean isFast(double a){
        return a > 50;
    }

    @Override
    public Object convert(Object obj){
        double kmh = (double) obj;
        return 0.6214 * kmh; 
    }
}


public class main {
    public static void main(String[] args) {
        int input;
        Scanner scanner = new Scanner(System.in);
        do
        {
            System.out.println("1. Tharmometer Object");
            System.out.println("2. Tharmocouple Object");
            System.out.println("3. PilotTube Object");
            System.out.println("4. ShaftLog Object");
            System.out.println("5. Quit");

            System.out.println("Please enter either 1 to 4: "); 
            input =(scanner.nextInt());
            if(input == 1){
                Converter converter = new Tharmometer();
                System.out.println("Temperature in Fahrenheit: "+converter.convert(60.00));
                //convert.isHot(25.00); // It can not be run
                Tharmometer tharmo = (Tharmometer) converter; // type casting converter to Tharmometer
                System.out.println("Is is it hot: "+tharmo.isHot(25.0)); // it will run because it converting converter to tharmometer(subclass) 
                                                        // Tharmometer so the object is of tharmometer type
            
            }
            else if (input == 2){
                Converter converter = new Tharmocouple();
                System.out.println("Temperature in Kelvin (K): "+converter.convert(7.00));
                Tharmocouple tharmo = (Tharmocouple) converter;
                System.out.println("Is it hot: "+tharmo.isHot(25.0));
            }

            else if(input == 3){        
                Converter converter = new PilotTube();
                System.out.println("Spped in mach: "+converter.convert(7.00));
                PilotTube speed = (PilotTube) converter;
                System.out.print("Is it fast: "+speed.isFast(60.0));
                
            }
            else if(input == 4){
                Converter converter = new ShaftLog();
                System.out.println("TSpeed in mph: "+converter.convert(7.00));
                ShaftLog speed = (ShaftLog) converter;
                System.out.println("Is first: "+speed.isFast(30));
            }
        }
        while (input==1 || input==2 || input==3 || input == 4);

        

            // Converter converter = new Tharmometer();
            // converter.convert(22.3);

            // Tharmometer pp = (Tharmometer) converter;

        //    // converter.isHot(16.0);
        //     pp.isHot(12.3d);

    }
}
