public class main {
    public static void Main(String[] args) {
        ComputerBuilder builder = new GamingPCBuilder(); //to create a PC we need a GamingPCBuilder
        ComputerDirector director = new ComputerDirector(builder); // Передаємо його директору

        Computer gamingPC = director.constructGamingPC(); //pc is created
        System.out.println("Configuration of Gaming PC:");
        gamingPC.showConfiguration(); //show configuration of the PC
    }
}
