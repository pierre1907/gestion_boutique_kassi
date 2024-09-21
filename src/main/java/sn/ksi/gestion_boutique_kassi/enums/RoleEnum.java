package sn.ksi.gestion_boutique_kassi.enums;

public enum RoleEnum {
    ROLE_BOUTIQUIER(1),
    ROLE_CLIENT(2);

    private final int id;

    RoleEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static RoleEnum fromId(int id) {
        for (RoleEnum role : values()) {
            if (role.getId() == id) {
                return role;
            }
        }
        throw new IllegalArgumentException("No role found for id: " + id);
    }
}
