public class GamingPCBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingPCBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void addCPU(String cpu) {
        computer.addComponent(new CPU(cpu));
    }

    @Override
    public void addGPU(String gpu) {
        computer.addComponent(new GPU(gpu));
    }

    @Override
    public Computer build() {
        return computer;
    }
}
