import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import com.opencsv.CSVReader;
public class Parse {

	public static LocationProbe lprobe;
	public static BluetoothProbe bprobe;
	public static ConversationProbe cprobe;
	public static BufferedWriter owriter;
	
	public static void main(String args[]) throws IOException
	{

		lprobe=new LocationProbe();
		bprobe=new BluetoothProbe();
		cprobe=new ConversationProbe();
	    File input_file = new File("/Users/Arvind/Documents/DALI/arvind/ABL-6-15-10/Untitled.csv");
	    File location_file = new File("location_file.txt");
	    File bluetooth_file = new File("bluetooth_file.txt");
	    File conversation_file=new File("conversation_file.txt");
	    
	    File output_file=new File("ABL-6-15-10");
	    
	    BufferedWriter lwriter = new BufferedWriter(new FileWriter(location_file));
	    BufferedWriter bwriter = new BufferedWriter(new FileWriter(bluetooth_file ));
	    BufferedWriter cwriter = new BufferedWriter(new FileWriter(conversation_file));
	    owriter = new BufferedWriter(new FileWriter(output_file));

	    CSVReader reader = new CSVReader(new FileReader(input_file));
	    String [] nextLine;
	    int probeNumber;
	    while ((nextLine = reader.readNext()) != null) {
	    	probeNumber=whichProbe(nextLine[2]);	    	
	    	if(probeNumber==1)
	    	{	     
	    		lwriter.append(nextLine[2]+"\n"+nextLine[4]+"\n");
	    		lprobe.storeLocation(nextLine[4]);
	    	}
	    	else if(probeNumber==2)
	    	{
	    		bwriter.append(nextLine[2]+"\n"+nextLine[4]+"\n");
	    		bprobe.storeDevice(nextLine[4]);
	    	}
	    	else if(probeNumber==3)
	    	{
	    		cwriter.append(nextLine[2]+"\n"+nextLine[4]+"\n");
	    		cprobe.storeConversation(nextLine[4]);

	    	}
	    }

	    
	    	storeResults();
	    	reader.close();
			lwriter.close();
			bwriter.close();
			cwriter.close();
	}
	
	
	public static void storeResults() throws IOException
	{
		HashMap<String,Integer> devices = bprobe.getDevices();
		double total_duration=cprobe.getDuration();

		
		owriter.append("\nLOCATIONS\n--------------------\n");
		owriter.append("score is "+lprobe.getScore());

		owriter.append("\n\n\nBLUTEOOTH\n--------------------\n");
		Set<String> keys=devices.keySet();

		owriter.append("\nnumber of devices : "+keys.size());
		owriter.append("\n\nCONVERSATION\n--------------------\n");
		owriter.append(total_duration+"\n");
		owriter.close();
	}
	
	
	public static int whichProbe(String probeName)
	{
		if(probeName.equals("edu.dartmouth.cs.funf.probe.LocationProbe"))
			return 1;
		else if(probeName.equals("edu.mit.media.funf.probe.builtin.BluetoothProbe"))
			return 2;
		else if(probeName.equals("edu.dartmouth.cs.libbewell.probe.BeWellAudioFeatureProbe"))
			return 3;
		return 0;
	}
	
}
