//import java.util.HashMap;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//

public class BluetoothProbe {

public HashMap<String,Integer> devices = new HashMap<String, Integer>();	
	public void storeDevice(String deviceDetails)
	{
		JSONObject obj = new JSONObject(deviceDetails);
		
		JSONArray arr = obj.getJSONArray("DEVICES");
				
		for (int i = 0; i < arr.length(); i++)
		{
		    String mAddress= arr.getJSONObject(i).getJSONObject("android.bluetooth.device.extra.DEVICE").getString("mAddress");
		    if(devices.containsKey(mAddress))
		    {
		    	int count=devices.get(mAddress);
		    	devices.put(mAddress, count++);
		    }
		    else
		    {
		    	devices.put(mAddress, 1);
		    }

		}
	}
	
	public HashMap<String,Integer> getDevices()
	{
		return devices;
	}
}
