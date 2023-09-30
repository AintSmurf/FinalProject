package backend.pom.products;

import com.google.gson.annotations.SerializedName;

public class Department {

    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private Integer id;
    @SerializedName("sort")
    private Integer sort;
    @SerializedName("slug")
    private String slug;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
