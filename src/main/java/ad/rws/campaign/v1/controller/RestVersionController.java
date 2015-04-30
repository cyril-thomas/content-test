package ad.rws.campaign.v1.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by cyril on 2/23/15.
 */
@RestController
@RequestMapping("/v1/api")
public class RestVersionController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public
    //@ResponseBody
    ApiVersion getVersion() {
        return new ApiVersion(1);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    //@XmlRootElement
    public static class ApiVersion {
        int version;
        String currentVersion = "Current version is ";

        public ApiVersion() {
        }

        public ApiVersion(int version) {
            this.version = version;
            this.currentVersion = this.currentVersion + version;
        }

        public ApiVersion(int version, String currentVersion) {
            this.version = version;
            this.currentVersion = currentVersion;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }

        public String getCurrentVersion() {
            return currentVersion;
        }

        public void setCurrentVersion(String currentVersion) {
            this.currentVersion = currentVersion;
        }
    }
}
