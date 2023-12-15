package imd.web2.projeto3.petcare.model;

public enum UserRole {
    ADMIN("admin"),
    USER("user");

    public String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
