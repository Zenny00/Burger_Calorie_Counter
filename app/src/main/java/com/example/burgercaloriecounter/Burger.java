package com.example.burgercaloriecounter;

public class Burger {
    //BURGER CONSTANTS
    static final int BEEF = 100;
    static final int LAMB = 170;
    static final int OSTRICH = 150;
    static final int ASIAGO = 90;
    static final int CREME_FRAICHE = 120;
    static final int PROSCIUTTO = 115;

    //PRIVATE DATA MEMBERS
    private int mPattyCal;
    private int mCheeseCal;
    private int mProsciuttoCal;
    private int mSauceCal;

    //CONSTRUCTOR
    public Burger()
    {
        //Init to constants
        mPattyCal = BEEF;
        mCheeseCal = CREME_FRAICHE;
        //Init to 0
        mProsciuttoCal = 0;
        mSauceCal = 0;
    }

    //Public setters
    public void setPattyCalories(int calories)
    {
        mPattyCal = calories;
    }

    public void setCheeseCalories(int calories)
    {
        mCheeseCal = calories;
    }

    public void setProsciuttoCalories(int calories)
    {
        mProsciuttoCal = calories;
    }

    public void setSauceCalories(int calories)
    {
        mSauceCal = calories;
    }

    //Clear function for prosciutto
    public void clearProsciuttoCalories()
    {
        mProsciuttoCal = 0;
    }

    //Return the sum of all calorie components
    public int getTotalCalories()
    {
        return mPattyCal + mCheeseCal + mProsciuttoCal + mSauceCal;
    }
}
