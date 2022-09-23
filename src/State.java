
/**
 * This State class possesses attributes
 * in which we can create state objects from.
 * 
 * @author Brian Gerkens
 * @version 12/10/2021
 */

//Class State
public class State {
	private String name;
	private String capitol;
	private String region;
	private int usHouseSeats;
	private long population;
	private long covidCases;
	private long covidDeaths;
	private int income;
	private double crimeRate;	
	private long CFR;
	private long caseRate;
	private long deathRate;
	/**
	 * This is the default constructor 
	 */
	public State() {
		this.name = "";
		this.capitol = "";
		this.region = "";
		this.usHouseSeats = 0;
		this.population = 0;
		this.covidCases = 0;
		this.covidDeaths = 0;
		this.income = 0;
		this.crimeRate = 0;
		this.CFR = 0;
		this.caseRate = 0;
		this.deathRate = 0;
	}
	/**
	 * This is the State constructor with all attributes.
	 * 
	 * @param name, capitol, region, usHouseSeats,population, covidCases, covidDeaths, income, crimeRate, CFR, caseRate, deathRate 
	 */
	public State(String name,  String capitol, String region, int usHouseSeats, long population, long covidCases, long covidDeaths, int income, double crimeRate, long CFR, long caseRate, long deathRate) {
		this.name = name;
		this.capitol = capitol;
		this.region = region;
		this.usHouseSeats = usHouseSeats;
		this.population = population;
		this.covidCases = covidCases;
		this.covidDeaths = covidDeaths;
		this.income = income;
		this.crimeRate = crimeRate;
		this.CFR = covidCases / covidDeaths;
		this.caseRate = covidCases / population * 100000;
		this.deathRate = covidDeaths / population * 100000;
		
	}
	
	/**
	 * main method 
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		
		
		
	}
	
	/**
	 * getName() returns the name of the state object.
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * setName() sets the name of the state object from the csv file
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * getCapitol()
	 * 
	 * @return capitol
	 */
	public String getCapitol() {
		return capitol;
	}
	/**
	 * setCapitol() sets the capitol of the state object from the csv file
	 * 
	 * @param capitol
	 */
	public void setCapitol(String capitol) {
		this.capitol = capitol;
	}
	/**
	 * getRegion() 
	 * 
	 * @return region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * setRegion() sets the region of the state object from the csv file
	 * 
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * getUSHouseSeats()
	 * 
	 * @return usHouseSeats
	 */
	public int getUsHouseSeats() {
		return usHouseSeats;
	}
	/**
	 * setUsHouseSeats() sets the house seats of the state object from the csv file
	 * 
	 * @param usHouseSeats
	 */
	public void setUsHouseSeats(int usHouseSeats) {
		this.usHouseSeats = usHouseSeats;
	}
	/**
	 * getPopulation()
	 * 
	 * @return population
	 */
	public long getPopulation() {
		return population;
	}
	/**
	 * setPopulation() sets the population of the state object from the csv file
	 * 
	 * @param population
	 */
	public void setPopulation(long population) {
		this.population = population;
	}
	/**
	 * getCovidCases()
	 * 
	 * @return covidCases
	 */
	public long getCovidCases() {
		return covidCases;
	}
	/**
	 * setCovidCases() sets the covid cases of the state object from the csv file
	 * 
	 * @param covidCases
	 */
	public void setCovidCases(long covidCases) {
		this.covidCases = covidCases;
	}
	/**
	 * getCovidDeaths()
	 * 
	 * @return covidDeaths
	 */
	public long getCovidDeaths() {
		return covidDeaths;
	}
	/**
	 * setCovidDeaths() sets the covid deaths of the state object from the csv file
	 * 
	 * @param covidDeaths
	 */
	public void setCovidDeaths(long covidDeaths) {
		this.covidDeaths = covidDeaths;
	}
	/**
	 * getInccome()
	 * 
	 * @return income
	 */
	public long getIncome() {
		return income;
	}
	/**
	 * setIncome() sets the income of the state object from the csv file
	 * 
	 * @param income
	 */
	public void setIncome(int income) {
		this.income = income;
	}
	/**
	 * getCrimeRate()
	 * 
	 * @return crimeRate
	 */
	public double getCrimeRate() {
		return crimeRate;
	}
	/**
	 * setCrimeRate() sets the crime rate of the state object from the csv file
	 * 
	 * @param crimeRate
	 */
	public void setCrimeRate(double crimeRate) {
		this.crimeRate = crimeRate;
	}
	/**
	 * getCFR()
	 * 
	 * @return CFR
	 */
	public long getCFR() {
		return CFR;
	}
	/**
	 * setCFR() sets the CFR of the state object from our defined CFR variable
	 * 
	 * @param CFR
	 */
	public void setCFR(long CFR) {
		this.CFR = CFR;
	}
	/**
	 * getCaseRate()
	 * 
	 * @return caseRate
	 */
	public long getCaseRate() {
		return caseRate;
	}
	/**
	 * setCaseRate() sets the case rate of the state object from our defined caseRate variable
	 * 
	 * @param caseRate
	 */
	public void setCaseRate(long caseRate) {
		this.caseRate = caseRate;
	}
	/**
	 * getDeathRate()
	 * 
	 * @return deathRate
	 */
	public long getDeathRate() {
		return deathRate;
	}
	/**
	 * setDeathRate() sets the death rate of the state object from our defined deathRate variable
	 * 
	 * @param deathRate
	 */
	public void setDeathRate(long deathRate) {
		this.deathRate = deathRate;
	}
	/**
	 * compareTo() method compares our state objects to a sample state we pass through the method.
	 * 
	 * @param state1
	 * @return value either <0, >0, or =0.
	 */
	public int compareTo(State sampleState) {
			return this.getName().compareTo(sampleState.getName());
	}
	/**
	 * toString() method returns a visual representation of our state object
	 * 
	 * @return name + capitol + region + usHouseSeats + population + covidCases + covidDeaths + income + crimeRate + CFR + caseRate + deathRate
	 */
	@Override
	public String toString() {
		return name + " " + capitol + " " + region + " " + usHouseSeats + " " + population + " " + covidCases + " " + covidDeaths + " " + income + " " + crimeRate + " " + CFR + " " + caseRate + " " + deathRate;
	}
}