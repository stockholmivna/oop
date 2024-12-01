import java.util.ArrayList; //import ArrayList to use ArrayList
import java.util.List;

public class Computer {
    private List<Component> components = new ArrayList<>(); //list of components

    public void addComponent(Component component) {
        components.add(component);
    }

    public void showConfiguration() {
        components.forEach(component -> System.out.println(component.getDetails())); //print details of each component
    }
}
