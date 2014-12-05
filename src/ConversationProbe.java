import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;


public class ConversationProbe {
static double totalDuration=0;
	public void storeConversation(String details)
	{
		JSONObject obj = new JSONObject(details);
		String startTime=String.valueOf(obj.getLong("CONVERSATION_START"));
		String endTime=String.valueOf(obj.getLong("CONVERSATION_END"));
		
		Date startDate = new Date(Long.parseLong(startTime));
		Date endDate = new Date(Long.parseLong(endTime));
		long duration  = endDate.getTime() - startDate.getTime();
		long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
//		System.out.println("\n Minutes : "+diffInMinutes+"\n");
		totalDuration+=diffInMinutes;
	}
	
	public double getDuration()
	{
		return totalDuration;
	}
}
