package ad.rws.campaign.v1.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.stereotype.Component;

/**
 * Created by cyril on 3/27/15.
 */
@Component
//http://magicmonster.com/kb/prg/java/spring/webmvc/jackson_custom.html
public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper() {
        this.setPropertyNamingStrategy(
                PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES
        );
    }
}
