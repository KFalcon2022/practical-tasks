package Lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class Car {
    private String owner = null;
    private String StateAndRegion = "";
    private String lastLetter = "";
    private String fullNumber = null;
    private int digitNumber = 0;
    private int hashnumber = 0;
    public Car()
    {
        getCarValues();
    }
    public Car (String owner, String number)
    {
        if (owner != null && (number.trim().length() > 5))
        {
            this.owner = owner.trim().toLowerCase();
            parseNumber(number.trim().toUpperCase(Locale.ROOT));
        }
    }
    protected void setDigitNum(int hash)
    {
        this.digitNumber = Integer.toString(hash).length() > 3 ? hash : 0;
    }

    protected void parseNumber (String number)
    {
        this.fullNumber = number;
        String fullCarNum = number;
        String replacement = "";
        setDigitNum(Integer.parseInt(fullCarNum.replaceAll("([A-Z])",replacement)));
        number = number.replaceAll("([0-9])"," ");
        String[] numArray = number.split("\\s+");
        for (int i = 0; numArray.length > 0 && i < numArray.length; i++)
        {
            if (numArray[0] != null)
                this.StateAndRegion =  numArray[0];
            if (i > 0)
                this.lastLetter = numArray[1];
        }
        hashCode();
    }
    protected void getCarValues()
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter car number: ");
        try {
                parseNumber(reader.readLine().trim().toUpperCase(Locale.ROOT));
        } catch (IOException e) {
            System.out.println("Wrong car number, try again");
            getCarValues();
            throw new RuntimeException(e);
        }
        getCarOwner(reader);
    }

    protected void getCarOwner(BufferedReader reader)
    {
        System.out.print("Enter car owner: ");
        try {
            owner = reader.readLine().toLowerCase();
            if (owner.isEmpty() || owner == null)
                getCarOwner(reader);
        } catch (IOException e) {
            System.out.println("Wrong car owner, try again");
            getCarOwner(reader);
            throw new RuntimeException(e);
        }
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!getClass().equals(obj.getClass()))
            return false;
        Car car = (Car) obj;

        return hashnumber == car.hashnumber && Objects.equals(owner, car.owner) && Objects.equals(fullNumber, car.fullNumber);
    }

    public int hashCode()
    {
        if (hashnumber == 0)
        {
            hashnumber = fullNumber.hashCode();
            hashnumber += 31 * digitNumber;
        }
        return hashnumber;
    }

    public String toString() {
        String parsedNumber = "Car number: " + fullNumber + "\n"
                + "State and region :[" + StateAndRegion + "]\n"
                + "Last letter :[" + lastLetter + "]\n"
                + "Hash :{" + hashnumber + "}\n";
        String owner = "Owner : " + this.owner + "\n";
        return owner + parsedNumber;
    }
}
