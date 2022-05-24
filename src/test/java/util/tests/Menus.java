package util.tests;

public enum Menus {
    VISTA_GENERAL("Vista General"),
    DISCUSIONES("Discusiones"),
    LISTAS("Listas");

    private final String menu;

    Menus(String menu){
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

}
