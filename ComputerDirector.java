public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer constructGamingPC() {
        builder.addCPU("Intel i9"); //add powerful processor
        builder.addGPU("NVIDIA RTX 4080");   //add vieo card
        return builder.build();
    }
}
