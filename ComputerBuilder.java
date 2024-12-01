public interface ComputerBuilder {
    void addCPU(String cpu); //add processor
    void addGPU(String gpu); //add video card
    Computer build();        //finishing to build computer
}
