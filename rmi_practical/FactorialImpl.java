package rmi_practical;

import java.rmi.server.*;
import java.rmi.*;

public class FactorialImpl extends UnicastRemoteObject implements Factorial {
    public FactorialImpl() throws RemoteException {
        super();
    }

    public long getFactorial(int n) throws RemoteException {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}

