import java.util.Scanner;

public class SafeInput {
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";     // Set this to zero length. Loop runs until it isn’t

        do
        {
            System.out.print("\n" + prompt + ": ");     // show prompt and adds space
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        // declarations
        int intVal = 0;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextInt()) // Check if input is an integer
            {
                intVal = pipe.nextInt(); // Reads the integer value
                return intVal;  // Return the valid integer input
            } else
            {
                System.out.println("Your input is not valid! Please enter an integer.");
                pipe.nextLine(); // Clear the input after reading the value
            }
        } while (true);  // Continue looping until valid input is received
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        //declarations
        double doubleVal = 0.0;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if (pipe.hasNextDouble())
            {
                doubleVal = pipe.nextDouble();
                return doubleVal;
            }
            else
            {
                System.out.println("Your input is not valid! Please enter a double value.");
                pipe.nextLine();
            }
        } while (true);
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        //declarations
        int intRangeVal = 0;

        do
        {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");

            if (pipe.hasNextInt())
            {
                intRangeVal = pipe.nextInt();
                if (intRangeVal >= low && intRangeVal <= high)
                {
                    return intRangeVal;
                } else
                {
                    System.out.println("Your input is out of the specified range.");
                    pipe.nextLine();
                }
            } else
            {
                System.out.println("Your input is not valid! Please enter an integer value.");
                pipe.nextLine();
            }
        } while (true);
    }
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
       //declarations
        double doubleRangeVal = 0.0;

        do
        {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");

            if (pipe.hasNextDouble())
            {
                doubleRangeVal = pipe.nextDouble();
                if (doubleRangeVal >= low && doubleRangeVal <= high)
                {
                    return doubleRangeVal;
                } else
                {
                    System.out.println("Your input is out of the specified range.");
                    pipe.nextLine();
                }
            }
            else
            {
                System.out.println("Your input is not valid! Please enter a double value.");
                pipe.nextLine();
            }
        } while (true);
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        //declarations
        String YesNoInput = "";

        do
        {
            System.out.print("\n" + prompt + " Yes or No [Y/N]: ");
            YesNoInput = pipe.next();

            if (YesNoInput.equalsIgnoreCase("y") || YesNoInput.equalsIgnoreCase("Yes"))
            {
                return true;
            }
            else if (YesNoInput.equalsIgnoreCase("n") || YesNoInput.equalsIgnoreCase("No"))
            {
                return false;
            } else
            {
                System.out.println("Your input is not valid! Please enter Yes or No [Y/N].");
                pipe.nextLine();
            }
        } while (true);
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String regExInput = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            regExInput = pipe.nextLine();

            if (regExInput.matches(regEx))
            {
                return regExInput;
            } else
            {
                System.out.println("Your input does not match the specified pattern.");
            }
        } while (true);

    }

}