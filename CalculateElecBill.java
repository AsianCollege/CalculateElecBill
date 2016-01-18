package com.example.apptwo;

public class CalculateElecBill {
	
	private int unitConsumed;
	private String capacityType;	
	private double chargedBill;	
	
	private double min5;
	private double min15;
	private double min30;
	private double min60;
	
	private double charge20;
	private double charge50;
	private double charge150;
	private double charge250;
	private double above250;
	
	private double min3P;
	private double above400;
	
	public CalculateElecBill(int unit,String type){
		this.unitConsumed = unit;
		this.capacityType = type;
		
		this.min5 = 80.00;
		this.min15 = 365.00;
		this.min30 = 795.00;
		this.min60 = 1765.00;
		
		this.charge20 = 4.00;
		this.charge50 = 7.30;
		this.charge150 = 8.60;
		this.charge250 = 9.50;
		this.above250 = 11.00;		
		
		//only for 3P
		this.above400 = 12.00;
		this.min3P = 4400.00;			
	}
	
	public double getChargedBill(){	
		this.calculateBill();
		return this.chargedBill;
	}
	
	public void calculateBill(){
		switch(this.capacityType){
		case "5A":
			if(this.unitConsumed<21){
				this.chargedBill = this.min5;
			}else{
				normalTarrif(this.unitConsumed);
			}
			break;
		case "15A":
			if(this.unitConsumed<51){
				this.chargedBill = this.min15;
			}else{
				normalTarrif(this.unitConsumed);
			}
			break;
		case "30A":
			if(this.unitConsumed<101){
				this.chargedBill = this.min30;
			}else{
				normalTarrif(this.unitConsumed);
			}			
			break;
		case "60A":
			if(this.unitConsumed<201){
				this.chargedBill = this.min60;
			}else{
				normalTarrif(this.unitConsumed);
			}
			break;
		case "3P":
			if(this.unitConsumed<401){
				this.chargedBill = this.min3P;
			}else{
				threePTarrif(this.unitConsumed);
			}
			break;
				
		}
	}
	
	public void normalTarrif(int unit){		
		double price=0.00;
		if(unit>250){			
			price = 250*this.charge250 + (unit-250)*this.above250;
		}else if(unit>150 && unit<251){
			price = 150*this.charge150 + (unit-150)*this.charge250;
		}else if(unit>50 && unit<151){
			price = 50*this.charge50 + (unit-50)*this.charge150;
		}else if(unit>30 && unit<51){
			price = unit * this.charge50;
		}else if(unit>20 && unit<31){
			price = 20*this.charge20 + (unit - 20)*this.charge50;
		}else{
			price= this.charge20;
		}
		this.chargedBill = price;		
	}
	public void threePTarrif(int unit){
		this.chargedBill  = this.min3P + (unit-400)*this.above400;		
	}

}
