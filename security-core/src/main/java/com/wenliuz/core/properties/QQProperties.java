package com.wenliuz.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author wenliuz
 */
@Data
public class QQProperties extends SocialProperties {
    private String providerId = "qq";
}
