/**
 * Created by jli on 6/13/15.
 */
public class ImpressionPixel {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImpressionPixel that = (ImpressionPixel) o;

        if (js != null ? !js.equals(that.js) : that.js != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (js != null ? js.hashCode() : 0);
        return result;
    }

    private String url;

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    private String js;

    public String getUnrelated() {
        return unrelated;
    }

    public void setUnrelated(String unrelated) {
        this.unrelated = unrelated;
    }

    private String unrelated;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
