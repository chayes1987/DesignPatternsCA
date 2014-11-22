package decorator;

public class ModifiedGun extends Gun {
    private String description;

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getTotalAmmo() {
        return 10;
    }
}
