package cn.msosm.shop.pojo;

public class SysButton {
    private Integer id;

    private String name;

    private String buttom;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getButtom() {
        return buttom;
    }

    public void setButtom(String buttom) {
        this.buttom = buttom == null ? null : buttom.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}