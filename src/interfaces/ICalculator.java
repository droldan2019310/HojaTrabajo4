package interfaces;

public interface ICalculator {
       /**
     * numbers to add
     * @param a
     * @param b
     * @return
     */
    public float add(float a, float b);
	 
    /***
        * @param numbers to subtract. 
        * @return result
        */
    float subtraction(float a, float b);
    
    /***
        * @param numbers to multiply
        * @return result
        */
    float multiplication(float a, float b);
    
    /***
        * @param numbers to divide.
        * @return result
        */
    float division(float a, float b);
    
    /***
          * 
        */
    void getNextImput();

}
