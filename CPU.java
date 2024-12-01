public class CPU implements Component { //cpu class that implements the component interface
    private String details;

    public CPU(String details) {
        this.details = details; //set the details of the processor
    }

    @Override
    public String getDetails() {
        return "Processor: " + details;
    }
}
