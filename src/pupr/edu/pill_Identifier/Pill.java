package pupr.edu.pill_Identifier;

/*
 * This class is meant for the purpose of 
 * creating objects of the type Pill.
 * Has private members that describe Pill characteristics
 */

public class Pill {
	/*
	 * 7 private members
	 */
	private String pillImprint;
	private String pillShape;
	private String pillColor;
	private String drugName;
	private String drugStrngth;
	private String pillImgName;
	private String entryDate;
	
	
	/*
	 * Default Constructor
	 */
	public Pill(){
		
	}
	
	/*
	 * parameter Constructor
	 * parameters:
	 * pillImprint
	 * pillShape
	 * pillColor
	 * drugName
	 * drugStrngth
	 * pillImgName
	 * entryDate
	 */
	
	public Pill(String pillImprint, String pillShape, String pillColor,
				String drugName, String drugStrngth, String pillImgName, String entryDate) {
		super();
		this.pillImprint = pillImprint;
		this.pillShape = pillShape;
		this.pillColor = pillColor;
		this.drugName = drugName;
		this.drugStrngth = drugStrngth;
		this.pillImgName = pillImgName;
		this.entryDate = entryDate;
	}
	
	/*
	 * SETTERS
	 */
	
	public void setPillImp(String pillImp) {
		this.pillImprint = pillImp;
	}
	
	public void setPillShape(String pillShp) {
		this.pillShape = pillShp;
	}
	
	public void setPillColor(String pillClr) {
		this.pillColor = pillClr;
	}
	
	public void setDrugName(String drugNm) {
		this.drugName = drugNm;
	}
	
	public void setDrugStrngth(String drgStrngth) {
		this.drugStrngth = drgStrngth;
	}
	
	public void setPillImg(String pillImage) {
		this.pillImgName = pillImage;
	}
	
	public void setEntryDate(String entryDte) {
		this.entryDate = entryDte;
	}
	
	/*
	 * GETTERS
	 */
	
	public String getPillImp() {
		return pillImprint;
	}
	
	public String getPillShp() {
		return pillShape;
	}
	
	public String getPillClr() {
		return pillColor;
	}
	
	public String getDrugNm() {
		return drugName;
	}
	
	public String getDrugStrngth() {
		return drugStrngth;
	}
	
	public String getPillImg() {
		return pillImgName;
	}
	
	public String getEntryDate() {
		return entryDate;
	}
	
	/*
	 * Sets all pill private members 
	 */
	public void setPillInfo(String pillImprint, String pillShape, String pillColor,
					String drugName, String drugStrngth, String pillImgName, String entryDate) {
		setPillImp(pillImprint);
		setPillShape(pillShape);
		setPillColor(pillColor);
		setDrugName(drugName);
		setDrugStrngth(drugStrngth);
		setPillImg(pillImgName);
		setEntryDate(entryDate);
	}
}
