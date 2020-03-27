package vkami.menuprinter;

public class MenuPrinter {
    public static void main(String[] args) {

        MenuItem menu = new MenuItem(
                "File",
                new MenuItem("New",
                        new MenuItem("Project"),
                        new MenuItem("Project from Existing sources"),
                        new MenuItem("Project from Version Control")
                ),
                new MenuItem("Open"),
                new MenuItem("Open URL"),
                new MenuItem("Open recent"),
                new MenuItem("Close project")
        );

        menu.write();

    }
}
