package template.util;

import java.util.UUID;

/**
 * Uuid工具�?
 * @author wzq
 *
 */
public class UuidUtil {

	public synchronized static String generateUuid(){
		UUID uuid = UUID.randomUUID();
		return uuid.toString().toUpperCase();
	}

}
