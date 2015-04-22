package org.mum.asd.client.model;

public class Bronze extends CreditCardAccount {

    public double mi=0.10,mp=0.14;   
    
    @Override
    public String getType() {
        return "Bronze";
    }

    @Override
    public double getInterestAmount() {
        return 3;
    }

    public double getMi() {
        return mi;
    }

    public void setMi(double mi) {
        this.mi = mi;
    }

    public double getMp() {
        return mp;
    }

    public void setMp(double mp) {
        this.mp = mp;
    }

	@Override
	public Double getInterest() {
		// TODO Auto-generated method stub
		return null;
	}

    
}
