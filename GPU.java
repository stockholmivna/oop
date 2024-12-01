public class GPU implements Component { //gpu class that implements the component interface
    private String details;

    public GPU(String details) {
        this.details = details;
    }

    @Override
    public String getDetails() {
        return "Video card: " + details; //return the video card details
    }
}
