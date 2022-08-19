package model;

import interfaces.ManagerDuty;

import java.util.List;

public class Manager extends Person implements ManagerDuty {
    private static Manager MANAGER = new Manager();

//    private Manager() {
//    }

    public static Manager getInstance() {

        return MANAGER;
    }
    @Override
    public boolean canHireACashier(Cashier cashier) {
        if (!cashier.isHired(true) && (cashier.getYearsOfExperience() > 3)) {
           cashier.setHired(true);
            System.out.println(" Congratulations!! You have been hired.");
            return true;
        } else {
            System.out.println(" Recruitment not yet in progress.");
        }
        return false;
    }


}

