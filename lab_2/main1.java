import java.util.Scanner;

abstract class Document {
    protected String title;

    public Document(String title) {
        this.title = title;
    }

    public abstract void open();
    public abstract void edit();
    public abstract void save();
}

class TextDocument extends Document {
    public TextDocument(String title) {
        super(title);
    }

    @Override
    public void open() {
        System.out.println("Opening text document: " + title);
    }

    @Override
    public void edit() {
        System.out.println("Editing text document: " + title);
    }

    @Override
    public void save() {
        System.out.println("Saving text document: " + title);
    }
}

class SpreadsheetDocument extends Document {
    public SpreadsheetDocument(String title) {
        super(title);
    }

    @Override
    public void open() {
        System.out.println("Opening spreadsheet document: " + title);
    }

    @Override
    public void edit() {
        System.out.println("Editing spreadsheet document: " + title);
    }

    @Override
    public void save() {
        System.out.println("Saving spreadsheet document: " + title);
    }
}

class PresentationDocument extends Document {
    public PresentationDocument(String title) {
        super(title);
    }

    @Override
    public void open() {
        System.out.println("Opening presentation document: " + title);
    }

    @Override
    public void edit() {
        System.out.println("Editing presentation document: " + title);
    }

    @Override
    public void save() {
        System.out.println("Saving presentation document: " + title);
    }
}

public class main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect the type of document to create:");
            System.out.println("1 - Text Document");
            System.out.println("2 - Spreadsheet Document");
            System.out.println("3 - Presentation Document");
            System.out.println("0 - Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 0) {
                exit = true; 
                System.out.println("Exiting the program.");
            } else {
                System.out.print("Enter the title of the document: ");
                String title = scanner.nextLine();

                Document document = null;

                switch (choice) {
                    case 1:
                        document = new TextDocument(title);
                        break;
                    case 2:
                        document = new SpreadsheetDocument(title);
                        break;
                    case 3:
                        document = new PresentationDocument(title);
                        break;
                    default:
                        System.out.println("Invalid choice. Please select 1, 2, or 3.");
                        continue; 
                }

                if (document != null) {
                    document.open();
                    document.edit();
                    document.save();
                }
            }
        }

        scanner.close();
    }
}
