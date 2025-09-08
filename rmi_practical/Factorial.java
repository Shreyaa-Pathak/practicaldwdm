package rmi_practical;

import java.rmi.*;

public interface Factorial extends Remote {
    long getFactorial(int n) throws RemoteException;
}

