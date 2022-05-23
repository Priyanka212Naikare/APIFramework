package resources;
import java.util.ArrayList;
import java.util.List;
import pojo.AddLoaction;
import pojo.location;
import pojo.DeleteLocation;

public class TestDataBuilder {
	public AddLoaction addPlace(String name,String address,String language)
	{
		
		AddLoaction a=new  AddLoaction();
		a.setAccuracy("50");
		a.setName(name);
		a.setPhone_number("(+91) 983 893 3937");
		a.setAddress(address);
		a.setWebsite("http://google.com");
		a.setLanguage(language);
		List<String> myList=new ArrayList<String>();
		myList.add("shoe park");
		myList.add("shop");
		a.setTypes(myList);
		location l=new location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		a.setLocation(l);
		return a;
	}
	
	public DeleteLocation DeleteLocation(String place_id)
	{
		DeleteLocation d=new DeleteLocation();
		d.setPlace_id(place_id);
		return d;
	}

}
