import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;


/**
 * if the count for any region is above a threshold, only then will we consider
 * that he/she has spent a considerable amount of time in that location.
 * @author Arvind
 *
 */
public class LocationProbe {

	public double EXTRA3_LATITUDE=43.7067453;
	public double EXTRA3_LONGITUDE=-72.2868622;
	
	public double VISITED_THRESHOLD=1.0;
	public double SUDIKOFF_LATITUDE=43.70736143;
	public double SUDIKOFF_LONGITUDE=-72.28816732;
	public double HOME_ARVIND_LATITUDE=43.699776;
	public double HOME_ARVIND_LONGITUDE=-72.281698;
	public double SOUTH_MAIN_STREET_LATITUDE=43.701291;
	public double SOUTH_MAIN_STREET_LONGITUDE=-72.289106;
	public double HOME_AARON_LATITUDE=43.683154;
	public double HOME_AARON_LONGITUDE= -72.284822;
	public double EXTRA_LATITUDE=43.6642598;
	public double EXTRA_LONGITUDE=-72.2554526;
	public double SUDIKOFF_ALTITUDE=337.0;
	public double EXTRA_2_LATITUDE=43.7067596;
	public double EXTRA_2_LONGITUDE=-72.2868511;
	public static HashMap<String,Integer> regions=new HashMap<String,Integer>();
	public static HashMap<String,Integer> time_regions=new HashMap<String,Integer>();
	public static ArrayList<String> visited = new ArrayList<String>();
	public static HashMap<String,Date> lastVisited = new HashMap<String,Date>();

	public LocationProbe()
	{
		regions.put("SUDIKOFF",0);
		regions.put("HOME_ARVIND",0);
		regions.put("SOUTH_MAIN_STREET",0);
		regions.put("HOME_AARON",0);
		regions.put("EXTRA",0);
		regions.put("EXTRA_2",0);
		regions.put("EXTRA_3",0);

	}
	public void storeLocation(String location_details)
	{
		JSONObject obj = new JSONObject(location_details);
		double latitude= obj.getDouble("LATITUDE");
		double longitude = obj.getDouble("LONGITUDE");
		String latestTime=String.valueOf(obj.getLong("TIMESTAMP"));
		Date latestDate = new Date(Long.parseLong(latestTime));
		if(distance(latitude,longitude,SUDIKOFF_LATITUDE,SUDIKOFF_LONGITUDE,'K') <= 0.5)
		{
			System.out.println("\nSUDIKOFF");
			if(lastVisited.containsKey("SUDIKOFF")==true)
			{
				Date previousDate=lastVisited.get("SUDIKOFF");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("SUDIKOFF");
					if(count==null){
					time_regions.put("SUDIKOFF", 1);
					}
					else
						time_regions.put("SUDIKOFF", count+1);
					
				}
			}
			else
			{
				lastVisited.put("SUDIKOFF", latestDate);
			}

			Integer count=regions.get("SUDIKOFF");
			regions.put("SUDIKOFF", count+1);

		}
		else if(distance(latitude,longitude,HOME_ARVIND_LATITUDE,HOME_ARVIND_LONGITUDE,'M') <= 0.1)
		{
			System.out.println("\nHOME_ARVIND");
			if(lastVisited.containsKey("HOME_ARVIND")==true)
			{
				Date previousDate=lastVisited.get("HOME_ARVIND");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("HOME_ARVIND");
					if(count==null){
					time_regions.put("HOME_ARVIND", 1);
					}
					else
						time_regions.put("HOME_ARVIND", count+1);
					
				}
			}
			else
			{
				lastVisited.put("HOME_ARVIND", latestDate);
			}

			Integer count=regions.get("HOME_ARVIND");
			regions.put("HOME_ARVIND", count+1);	
		}
		else if(distance(latitude,longitude,SOUTH_MAIN_STREET_LATITUDE,SOUTH_MAIN_STREET_LONGITUDE,'M') <= 0.1)
		{
			System.out.println("\nSOUTH_MAIN_STREET");

			if(lastVisited.containsKey("SOUTH_MAIN_STREET")==true)
			{
				Date previousDate=lastVisited.get("SOUTH_MAIN_STREET");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("SOUTH_MAIN_STREET");
					if(count==null){
					time_regions.put("SOUTH_MAIN_STREET", 1);
					}
					else
						time_regions.put("SOUTH_MAIN_STREET", count+1);
					
				}
			}
			else
			{
				lastVisited.put("SOUTH_MAIN_STREET", latestDate);
			}

			Integer count=regions.get("SOUTH_MAIN_STREET");
			regions.put("SOUTH_MAIN_STREET", count+1);
		}
		else if(distance(latitude,longitude,HOME_AARON_LATITUDE,HOME_AARON_LONGITUDE,'M') <= 0.1)
		{
			System.out.println("\n HOME_AARON");
			if(lastVisited.containsKey("HOME_AARON")==true)
			{
				Date previousDate=lastVisited.get("HOME_AARON");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("HOME_AARON");
					if(count==null){
					time_regions.put("HOME_AARON", 1);
					}
					else
						time_regions.put("HOME_AARON", count+1);
					
				}
			}
			else
			{
				lastVisited.put("HOME_AARON", latestDate);
			}

			Integer count=regions.get("HOME_AARON");
			regions.put("HOME_AARON", count+1);	
		}
		else if(distance(latitude,longitude,EXTRA_LATITUDE,EXTRA_LONGITUDE,'M') <= 0.1)
		{
			System.out.println("\nEXTRA");
			if(lastVisited.containsKey("EXTRA")==true)
			{
				Date previousDate=lastVisited.get("EXTRA");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("EXTRA");
					if(count==null){
					time_regions.put("EXTRA", 1);
					}
					else
						time_regions.put("EXTRA", count+1);
					
				}
			}
			else
			{
				lastVisited.put("EXTRA", latestDate);
			}

			Integer count=regions.get("EXTRA");
			regions.put("EXTRA", count+1);	
		}
		else if(distance(latitude,longitude,EXTRA_2_LATITUDE,EXTRA_2_LONGITUDE,'M') <= 0.1)
		{
			System.out.println("\nEXTRA_2");
			if(lastVisited.containsKey("EXTRA_2")==true)
			{
				Date previousDate=lastVisited.get("EXTRA_2");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("EXTRA_2");
					if(count==null){
					time_regions.put("EXTRA_2", 1);
					}
					else
						time_regions.put("EXTRA_2", count+1);
					
				}
			}
			else
			{
				lastVisited.put("EXTRA_2", latestDate);
			}

			Integer count=regions.get("EXTRA_2");
			regions.put("EXTRA_2", count+1);	
		}
		else if(distance(latitude,longitude,EXTRA3_LATITUDE,EXTRA3_LONGITUDE,'M') <= 0.1)
		{
			System.out.println("\nEXTRA_3");
			if(lastVisited.containsKey("EXTRA_3")==true)
			{
				Date previousDate=lastVisited.get("EXTRA_3");
				long duration  = previousDate.getTime() - latestDate.getTime();
				long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
				if(diffInMinutes > 12)
				{
					Integer count=time_regions.get("EXTRA_3");
					if(count==null){
					time_regions.put("EXTRA_3", 1);
					}
					else
						time_regions.put("EXTRA_3", count+1);
					
				}
			}
			else
			{
				lastVisited.put("EXTRA_3", latestDate);
			}

			Integer count=regions.get("EXTRA_3");
			regions.put("EXTRA_3", count+1);	
		}


		Set<String> keys=regions.keySet();
		for(String key:keys)
		{
			if(regions.get(key) >= VISITED_THRESHOLD)
				visited.add(key);
		}
	}

	private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		if (unit == 'K') {
			dist = dist * 1.609344;
		} else if (unit == 'N') {
			dist = dist * 0.8684;
		}
		return (dist);
	}

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}


	public double getScore()
	{

		double num=0;
		Set<String> keys=regions.keySet();
//		System.out.println("size of keyset : "+keys.size());
		for(String key:keys)
		{
//			System.out.println(key+"\n"+regions.get(key));
			if(regions.get(key) >= VISITED_THRESHOLD)
				num+=1; 
		}
		
		double time_counter = 0;
		Set<String> tkeys=time_regions.keySet();
		for(String key:tkeys)
		{
			Integer temp=time_regions.get(key);
			if(temp!=null)
			{
				time_counter+=temp;
			}
		}
		
//		System.out.println("\n count : "+num+"\t time counter : "+time_counter);
		
		System.out.println("\n num "+num);
		System.out.println("\n time "+time_counter);
		return ((num*0.60)+(time_counter*0.40))/2;
		
		
	}
	public ArrayList<String> getLocations()
	{
		return visited;
	}
}
