package backend.pom.products;

import com.google.gson.annotations.SerializedName;

public class Datum {

    public Datum(){
    }

    @SerializedName("kosher_type")
    private Object kosherType;

    @SerializedName("id")

    private Integer id;
    @SerializedName("multiplication")

    private Integer multiplication;
    @SerializedName("department")

    private Department department;
    @SerializedName("barcode")

    private Long barcode;
    @SerializedName("brand")

    private Integer brand;


    @SerializedName("department_id")

    private Integer departmentId;


    @SerializedName("mainImage")

    private Integer mainImage;
    @SerializedName("group_id")

    private Integer groupId;
    @SerializedName("name")

    private String name;
    @SerializedName("site_id")

    private Integer siteId;
    @SerializedName("sub_group_id")

    private Integer subGroupId;
    @SerializedName("is360")

    private Integer is360;
    @SerializedName("has_coupon")

    private Boolean hasCoupon;

    public Object getKosherType() {
        return kosherType;
    }

    public void setKosherType(Object kosherType) {
        this.kosherType = kosherType;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(Integer multiplication) {
        this.multiplication = multiplication;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getBarcode() {
        return barcode;
    }

    public void setBarcode(Long barcode) {
        this.barcode = barcode;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }


    public Integer getMainImage() {
        return mainImage;
    }

    public void setMainImage(Integer mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getSubGroupId() {
        return subGroupId;
    }

    public void setSubGroupId(Integer subGroupId) {
        this.subGroupId = subGroupId;
    }


    public Integer getIs360() {
        return is360;
    }

    public void setIs360(Integer is360) {
        this.is360 = is360;
    }

    public Boolean getHasCoupon() {
        return hasCoupon;
    }

    public void setHasCoupon(Boolean hasCoupon) {
        this.hasCoupon = hasCoupon;
    }

    @Override
    public String toString() {
        return "Datum{" +
                "id=" + id +
                ", name='" + name + '\'' +
                "}\n";
    }
}
