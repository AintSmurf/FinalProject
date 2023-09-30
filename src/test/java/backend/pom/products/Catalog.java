package backend.pom.products;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Catalog {
        @SerializedName("q")
        private Object q;
        @SerializedName("status")
        private Integer status;
        @SerializedName("total")
        private Integer total;
        @SerializedName("data")
        private List<Datum> data;

        public Object getQ() {
            return q;
        }

        public void setQ(Object q) {
            this.q = q;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public List<Datum> getData() {
            return data;
        }

        public void setData(List<Datum> data) {
            this.data = data;
        }


}
