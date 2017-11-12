package fashionable.model.user;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * This is a class that represents a user of the system.
 * Right now it's just a name and an ID.
 * This class will be expanded later, and for now, it's recommended to just use the test user.
 */
@Data @AllArgsConstructor
public class ForumUser {
	UUID userId;
	String username;
	
	public static final ForumUser TEST_USER = new ForumUser(UUID.fromString("00000000-0000-0000-0000-000000000000"), "Test User");
}
