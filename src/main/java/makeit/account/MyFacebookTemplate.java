package makeit.account;

import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

/**
 * Created by jinhyung on 2015. 12. 9..
 */
public class MyFacebookTemplate extends FacebookTemplate {
    // This doesnot contain: video_upload_limits which was causing the issue
    static final String[] MY_PROFILE_FIELDS = {
            "id", "about", "age_range", "bio", "birthday", "context", "cover", "currency", "devices", "education", "email",
            "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown", "inspirational_people", "installed", "install_type",
            "is_verified", "languages", "last_name", "link", "locale", "location", "meeting_for", "middle_name", "name", "name_format",
            "political", "quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings", "significant_other",
            "sports", "test_group", "timezone", "third_party_id", "updated_time", "verified", "viewer_can_send_gift",
            "website", "work"
    };

    public MyFacebookTemplate(String accessToken) {
        super(accessToken);
    }

    //New method, not in the original interface
    public User getUserProfile() {
        return this.fetchObject("me", User.class, MY_PROFILE_FIELDS);
    }
}
