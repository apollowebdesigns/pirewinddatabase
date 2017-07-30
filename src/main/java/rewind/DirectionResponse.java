package rewind;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DirectionResponse {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String time;

    @JsonProperty
    private String direction;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


}