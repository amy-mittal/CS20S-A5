/******************************************
 *  Name:    Amy Mittal
 * 
 * Class:   CS20s-002
 *
 * Assignment:  A5
 * 
 * Description: The program will calculate
 *              the total bill for a cruise
 *              based on the services and
 *              extras chosen by the user.
 * 
 * Input:       The input will be a letter
 *              that is to be entered from
 *              the keyboard representing
 *              different char constants
 *              based on the services and
 *              extras offered.
 * 
 * Output:      The cost of each of the
 *              services and extras that
 *              were chosen, as well as
 *              the total bill.
 *****************************************/
import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class A5 {
    public static void main(String[] args){
    // ***** Declaration of Constants *****
    
        final char CALYPSO = 'C';   // Calypso Cruise Type
        final char NEPTUNE = 'N';   // Neptune Cruise Type
        
        final int CALYPSO_DAYS = 14;    // Calypso Cruise Type Days
        final int NEPTUNE_DAYS = 7;     // Neptune Cruise Type Days
        
        final char PREMIUM = 'P';   // Premium Stateroom
        final char DELUXE = 'D';    // Deluxe Stateroom
        final char STANDARD = 'S';  // Standard Stateroom
        
        final int PREMIUM_COST = 350;   // Premium Stateroom Cost Per Day
        final int DELUXE_COST = 315;    // Deluxe Stateroom Cost Per Day
        final int STANDARD_COST = 295;  // Standard Stateroom Cost Per Day
        
        final char CAPTAIN_MEAL_PLAN = 'A';             // Captain's table meal plan
        final char CHEF_MEAL_PLAN = 'H';                // Chef's table meal plan
        
        final int CAPTAIN_MEAL_PLAN_COST = 125;     // Captain Meal Plan Cost
        final int CHEF_MEAL_PLAN_COST = 100;        // Chef Meal Plan Cost
        
        final char ON_BOARD_ACTIVITIES_PACKAGE = 'B';   // On Board Activities Package
        
        final int ON_BOARD_ACTIVITIES_PACKAGE_COST = 90;    // On Board Activities Package Cost
        
        final char TOURS =  'T';                        // Tours
        
        final int TOURS_COST = 150;                         // Tours Cost
        
        final char NO_COST_ACTIVITIES = 'X';                // Activities with no cost
        
        final int NO_COST = 0;                              // No cost
    
    // ***** Declaration of Varibles *****
    
        String strin;           // string data input from keyboard
        String strout;          // formatted output for use wuth pop-up windows
        String bannerOut;       // string for on-demand output banner
        
        String prompt;          // prompt for user input
        
        String delim = "[ ]+";  // deilimiter for splitting input string
        String nl = System.lineSeparator();     // universal new line character
        
        char cruiseType = 'I';              // code for cruise type
        char stateroom = 'E';               // code for stateroom
        char mealPlan = 'F';                // code for meal plan
        char onBoardActivities = 'G';       // code for on board activities
        char toursActivity = 'H';           // code for tours activity
        
        double stateroomCost = 0;           // variable for stateroom cost
        double mealPlanCost = 0;            // variable for meal plan cost
        double onBoardActivitiesCost = 0;   // variable for on board activity cost
        double toursActivityCost = 0;       // variable for tours cost
        
        double totalCost = 0;               // variable for total cost
        
        int DAYS = 0;                       // variable for number of days on cruise type
    
    // ***** Object Creation *****
    
        //ConsoleReader console = new ConosleReader (System.in);
        //Scanner sc = new Scanner (System.in);
        //DecimalFormat dfl = new DecimalFormat("####.##");
    
    // ***** Output Banners *****
    
        System.out.println("************************");
        System.out.println("Name: A. Mittal");
        System.out.println("Class: CS20S-002");
        System.out.println("Assignment: A5");
        System.out.println("************************");
        
        bannerOut = ("************************" + nl);
        bannerOut += ("Name: A. Mittal\n");
        bannerOut += ("Class: CS20S-002\n");
        bannerOut += ("Assignment: A5\n");
        bannerOut += ("************************\n\n");
    
    // ***** Get Input *****
    
        prompt = "Enter Cruise Type. C for Calypso or N for Neptune.\n";
        prompt += "Enter Stateroom Type. P for Premium or D for Deluxe or S for Standard.\n";
        prompt += "Enter Meal Plan. A for Captain's Table Meal Plan or H for Chef's Table Meal Plan or X for No Special Meal Plan.\n";
        prompt += "Enter the Type Of Activities. B for On Board Activities Package or X for No On Board Activitiess.\n";
        prompt += "Enter the Type Of Tours. T for Tours or X for No Tours.\n";
        strin = JOptionPane.showInputDialog(bannerOut + prompt);
        JOptionPane.showMessageDialog(null, "You entered " + strin);
        System.out.println("You entered: " + strin);
        
        String[] tokens = strin.split(delim);   // split input record
        
        // Parse Input into variables
        try{
        cruiseType = tokens[0].charAt(0);           // split variable 'cruiseType' into tokens
        stateroom = tokens[1].charAt(0);            // split variable 'stateroom' into tokens
        mealPlan = tokens[2].charAt(0);             // split variable 'mealPlan' into tokens
        onBoardActivities = tokens[3].charAt(0);    // split variable 'onBoardActivities' into tokens
        toursActivity = tokens[4].charAt(0);        // split variable 'toursActivity' into tokens
        } // end of try
        catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "To proceed further, please enter five values!", "Input Error!", JOptionPane.WARNING_MESSAGE);
        } // end of array
        
    // ***** Processing *****
    
        if (cruiseType == CALYPSO){
            DAYS = CALYPSO_DAYS;            // calc numb of days if (cruise type == calypso)
        } // end if (cruiseType == calypso)
        else {
            DAYS = NEPTUNE_DAYS;            // calc numb of days if (cruise type == neptune)
        } // end else (cruiseType == neptune)
        
        if (stateroom == PREMIUM){
            stateroomCost = PREMIUM_COST * DAYS;    // calc cost for stateroom if (stateroom == premium)
            onBoardActivitiesCost = NO_COST;        // calc cost for on board activities if (stateroom == premium)
            toursActivityCost = NO_COST;            // calc cost for tours if (stateroom == premium)
            if (mealPlan == NO_COST_ACTIVITIES) {
                    mealPlanCost = NO_COST;         // cost of meal plan if (mealPlan == 'X') if (stateroom == premium)
                } // end else (mealPlan == no special meal plan)
                else {
                    if (mealPlan == CHEF_MEAL_PLAN) {
                        mealPlanCost = CHEF_MEAL_PLAN_COST * DAYS;      // calc cost for meal plan if (mealPlan == 'H') if (stateroom == premium)
                    } // end if (mealPlan == chef's table meal plan)
                    else {
                        mealPlanCost = CAPTAIN_MEAL_PLAN * DAYS;        // calc cost for meal plan if (mealPlan == 'A') if (stateroom == premium)
                    } // end if (mealPlan == captain's table meal plan)
                } // end else (mealPlan == captain's table meal plan
        } // end if (stateroom == premium)
        else {
            if (stateroom == DELUXE) {
                stateroomCost = DELUXE_COST * DAYS;     // calc cost for stateroom if (stateroom == deluxe)
            } // end if (stateroom == deluxe)
            else {
                stateroomCost = STANDARD_COST * DAYS;   // calc cost for stateroom if (stateroom == standard)
            } // end else (stateroom == standard)
            mealPlanCost = NO_COST;                     // calc cost for meal plan if (stateroom == deluxe || standard)
            if (onBoardActivities == ON_BOARD_ACTIVITIES_PACKAGE) {
                    onBoardActivitiesCost = ON_BOARD_ACTIVITIES_PACKAGE_COST * DAYS;    // calc cost for on board activities if (onBoardActivities == 'B') if (stateroom == deluxe || standard)
                } // end if (onBoardActivities == on board activities package)
                else {
                    onBoardActivitiesCost = NO_COST;    // calc cost for on board activities if (onBoardActivities == 'X') if (stateroom == deluxe || standard)
                } // end else (onBoardActivities == no on board activities)
                if (toursActivity == TOURS) {           
                    toursActivityCost = TOURS_COST * DAYS;   // calc cost for tours if (toursActivity == 'T') if (stateroom == deluxe || standard)
                } // end if (toursActivity == tours)
                else {
                    toursActivityCost = NO_COST;        // calc cost for tours if (toursActivity == 'X') if (stateroom == deluxe || standard)
                } // end else (toursActivity == no tours)
        } // end else (stateroom == premium)
    
        totalCost = stateroomCost + mealPlanCost + onBoardActivitiesCost + toursActivityCost;   // calc for total bill for cruise
    
    // ***** Output *****
        
        if (cruiseType == CALYPSO) {
            System.out.println("Cruise Type: Calypso");
        } // end if (cruiseType == calypso)
        else {
            System.out.println("Cruise Type: Neptune");
        } // end else (cruiseType == neptune)
        System.out.println("Number of Days: " + DAYS);
        System.out.println(String.format("Stateroom Cost: " + "$" + "%.2f", stateroomCost));
        System.out.println(String.format("Meal Plan Cost: " + "$" + "%.2f", mealPlanCost));
        System.out.println(String.format("On Board Activities Cost: " + "$" + "%.2f", onBoardActivitiesCost));
        System.out.println(String.format("Tours Activity Cost: " + "$" + "%.2f", toursActivityCost));
        System.out.println(String.format("Total Bill: " + "$" + "%.2f", totalCost));
        
    // ***** Closing Message *****
    
        System.out.println("end of processing");
        
    } // end of main
} // end class
