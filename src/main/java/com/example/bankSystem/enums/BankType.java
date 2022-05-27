package com.example.bankSystem.enums;

public enum BankType {
    CENTRAL_BANK("centralbank"),
    SPECIALIZED_BANK("specializedbank"),
    COOPERATIVE_BANK("cooperativebank");

    private String type;

    private BankType(String type) {this.type=type;}

    public static BankType getBankTypeByString(String bankType){
        bankType = bankType.toLowerCase();
        for (BankType x:values()){
            if (bankType.equals(x.getType())){
                return x;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }

}
