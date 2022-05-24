package util.tests;

public enum Users {
    VALID_USER("camilo.alberto.ramirez","6G2cv4eZU4qiL9."),
    INVALID_USER("invalid.user", "1234g6th6"),
    ADMIN_USER("camilo.alberto.ramirez","6G2cv4eZU4qiL9"),
    ROOT_USER("","");

    private final String username;
    private final String password;

    Users (String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
