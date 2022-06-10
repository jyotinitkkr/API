package RestassuredTest;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	
	public static String getName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Name" + generatedString);
	}
	
	public static String getJob() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Job" + generatedString);
	}
	
	
	

}
