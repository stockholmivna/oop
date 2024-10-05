import java.util.Scanner;

abstract class Document {
    protected String title;

    public Document(String title) {
        this.title = title;
    }


    public void processDocument() {
        open();
        edit();
        save();
    }

    protected void open() {
        System.out.println("Opening document: " + title);
    }

    protected void edit() {
        System.out.println("Editing document: " + title);
    }

    protected void save() {
        System.out.println("Saving document: " + title);
    }
}

class TextDocument extends Document {
    public TextDocument(String title) {
        super(title);
    }
}

class SpreadsheetDocument extends Document {
    public SpreadsheetDocument(String title) {
        super(title);
    }
}

class PresentationDocument extends Document {
    public PresentationDocument(String title) {
        super(title);
    }
}

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            printMenu();

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 0) {
                exit = true;
                System.out.println("Exiting the program.");
            } else {
                Document document = createDocument(choice, scanner);
                if (document != null) {
                    document.processDocument();
                } else {
                    System.out.println("Invalid choice. Please select a valid document type.");
                }
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nSelect the type of document to create:");
        System.out.println("1 - Text Document");
        System.out.println("2 - Spreadsheet Document");
        System.out.println("3 - Presentation Document");
        System.out.println("0 - Exit");
    }

    // Метод для створення документа в залежності від вибору користувача
    private static Document createDocument(int choice, Scanner scanner) {
        System.out.print("Enter the title of the document: ");
        String title = scanner.nextLine();

        switch (choice) {
            case 1:
                return new TextDocument(title);
            case 2:
                return new SpreadsheetDocument(title);
            case 3:
                return new PresentationDocument(title);
            default:
                return null;
        }
    }
}
