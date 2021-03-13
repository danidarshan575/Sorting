public class Data {


    static int NoOfNumbers;
    static String sort = new String();
    static int[] Input = new int[NoOfNumbers];
    static int[] Output = new int[NoOfNumbers];
    static long timeofExecution;

    // Getters and Setters for timeofExecution
    public long getTimeofExecution() {
        return timeofExecution;
    }

    public void setTimeofExecution(long timeofExecution) {
        this.timeofExecution = timeofExecution;
    }

    // Getters and Setters for getOutput
    public int[] getOutput() {
        return Output;
    }

    public void setOutput(int[] output) {
        Output = output;
    }

    // Getters and Setters for variable sort

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    // Getters and Setters for NoofNumbers

    public int getNoOfNumbers() {
        return NoOfNumbers;
    }

    public void setNoOfNumbers(int noOfNumbers) {
        NoOfNumbers = noOfNumbers;
    }


    // Getters and Setters for Input
    public int[] getInput() {
        return Input;
    }

    public void setInput(int[] input) {
        Input = input;
    }

}
