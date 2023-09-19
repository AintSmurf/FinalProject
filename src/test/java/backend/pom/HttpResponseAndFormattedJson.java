package backend.pom;

import java.net.http.HttpResponse;
public class HttpResponseAndFormattedJson<T> {
        private HttpResponse<String> httpResponse;
        private String formattedJsonResponse;

        private T data;

        public HttpResponseAndFormattedJson(HttpResponse<String> httpResponse, String formattedJsonResponse, T result) {
            this.httpResponse = httpResponse;
            this.formattedJsonResponse = formattedJsonResponse;
            this.data = result;
        }

    public T getData() {
        return data;
    }

    public HttpResponse<String> getHttpResponse() {
            return httpResponse;
        }

        public String getFormattedJsonResponse() {
            return formattedJsonResponse;
        }
    }


