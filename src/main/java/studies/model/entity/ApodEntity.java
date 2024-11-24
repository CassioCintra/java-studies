package studies.model.entity;

public class ApodEntity {
    private Integer id;
    private String date;
    private String explanation;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public ApodEntity(Integer id, String date, String explanation, String mediaType,
                      String serviceVersion, String title, String url) {
        this.id = id;
        this.date = date;
        this.explanation = explanation;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public ApodEntity(String date, String explanation, String mediaType,
                      String serviceVersion, String title, String url) {
        this.date = date;
        this.explanation = explanation;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ApodEntity{\n" +
                "id=" + id + '\n' +
                "date='" + date + '\n' +
                "explanation='" + explanation + '\n' +
                "mediaType='" + mediaType + '\n' +
                "serviceVersion='" + serviceVersion + '\n' +
                "title='" + title + '\n' +
                "url='" + url + '\n' +
                '}';
    }
}
