package data;

import java.util.ArrayList;
/**
 * 
 * @author trainee
 * Class for informationData, containing list of Trainee
 */
public class InformationData {
	private ArrayList<Trainee> Data;
	private String Message;
	/**
	 * constructor of InformationData
	 * @param tr
	 * @param info
	 */
	public InformationData(ArrayList<Trainee> tr,String info){
		this.Data=tr;
		this.Message=info;
	}
}
